package com.yash.parkingallocation.daoImpl;


import com.yash.parkingallocation.jdbcutils.JdbcUtils;
import com.yash.parkingallocation.dao.ParkingDao;
import com.yash.parkingallocation.entity.ParkingHistory;
import com.yash.parkingallocation.entity.ParkingModel;
import com.yash.parkingallocation.entity.User;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {

    private JdbcUtils jdbcUtils;
    private UserDaoImpl userDao;

    public ParkingDaoImpl() {
        this.jdbcUtils = new JdbcUtils();
        this.userDao = new UserDaoImpl();
    }

    public String addParking(String[] parkingTypeList)
    {
        try{
            Connection con=jdbcUtils.establishConnection();
           for(String parkingType:parkingTypeList) {
               int maxParkingId = 1;
               Statement statement = con.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT MAX(parkingId) FROM Parking");
               if (resultSet.next()) {
                   maxParkingId = resultSet.getInt(1) + 1;
               }

               String query = "INSERT INTO Parking (parkingId, parkingType, status) " +
                       "VALUES (?, ?, ?)";
               PreparedStatement preparedStatement = con.prepareStatement(query);
               preparedStatement.setInt(1, maxParkingId);
               preparedStatement.setString(2, parkingType);
               preparedStatement.setString(3, "Free");
               preparedStatement.executeUpdate();
           }
            con.close();
            return "Success";
        }catch (Exception e)
        {
            e.printStackTrace();
            return "Failed";
        }

    }

    public String removeParking(int slotId)
    {
        Connection con=jdbcUtils.establishConnection();
        try{

                Statement statement = con.createStatement();
                String query = "DELETE FROM parking WHERE parkingId = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1,(slotId));
                preparedStatement.executeUpdate();
                con.close();
                return "Success";

        }catch (Exception e)
        {
            e.printStackTrace();
            return "Failed";
        }

    }

    public ParkingModel getParkingInformation(int parkingId){
        try{
       ParkingModel parkingModel=new ParkingModel();
       Connection con=jdbcUtils.establishConnection();
       PreparedStatement statement = con.prepareStatement("SELECT * FROM Parking WHERE parkingId = ?");
       statement.setInt(1, parkingId);
       ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            parkingModel.setParkingId(resultSet.getInt("parkingId"));
            parkingModel.setStatus(resultSet.getString("status"));
            parkingModel.setParkingHistoryId(resultSet.getInt("parkingHistoryId"));
            parkingModel.setUserId(resultSet.getInt("userId"));
        }
       return parkingModel;
    } catch (Exception e) {
        e.printStackTrace();
        return  null;
    }
    }


    public String checkIn(int userId,int parkingSlot,String vehicleNo) {
      try {
          System.out.println("Check In");
          ParkingModel parkingModel = getParkingInformation(parkingSlot);
          User user = userDao.getUserInformation(userId);

         // Checking if parking slot is free or not
          if (parkingModel.getStatus().equals("Free")) {
              parkingModel.setUserId(userId);
              parkingModel.setVehicleNo(vehicleNo);
              Connection con = jdbcUtils.establishConnection();
              PreparedStatement updateStatement;
              int maxParkingHistoryId = 0;
              Statement statement = con.createStatement();
              ResultSet resultSet = statement.executeQuery("SELECT MAX(sno) FROM ParkingHistory");
              if (resultSet.next()) {
                  maxParkingHistoryId = resultSet.getInt(1) + 1;
              }

              // Creating parking history log for admin
              ParkingHistory parkingHistory = new ParkingHistory();
              parkingHistory.setSno(maxParkingHistoryId);
              parkingHistory.setParkingSlot(parkingSlot);
              parkingHistory.setDate(new Date());
              parkingHistory.setEmployeeId(userId);
              parkingHistory.setEmployeeName(user.getName());
              parkingHistory.setStartTime(LocalTime.now());
              parkingHistory.setParkingSlot(parkingSlot);

              String sql = "INSERT INTO ParkingHistory (sno, parkingSlot, employeeId, employeeName, date, startTime, vehicleNo, mobileNo) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

              updateStatement = con.prepareStatement(sql);
              updateStatement.setInt(1, maxParkingHistoryId);
              updateStatement.setInt(2, parkingHistory.getParkingSlot());
              updateStatement.setInt(3, parkingHistory.getEmployeeId());
              updateStatement.setString(4, parkingHistory.getEmployeeName());
              updateStatement.setDate(5, new java.sql.Date(parkingHistory.getDate().getTime()));
              updateStatement.setTime(6, java.sql.Time.valueOf(parkingHistory.getStartTime()));
              updateStatement.setString(7, vehicleNo);
              updateStatement.setString(8,user.getMobileNo());
              updateStatement.executeUpdate();

              // It is setting parking status as occupied so other cannot able to book same slot
              updateStatement = con.prepareStatement("UPDATE Parking SET userId = ?, status = 'Occupied', userName=?, parkingHistoryId=?, vehicleNo=? WHERE parkingId = ?");
              updateStatement.setInt(1, userId);
              updateStatement.setString(2, user.getName());
              updateStatement.setInt(3, maxParkingHistoryId);
              updateStatement.setString(4, vehicleNo);
              updateStatement.setInt(5, parkingSlot);
              updateStatement.executeUpdate();

              return "success";
          } else {
            // If parking slot is not free then returning message failed
              return "failed";
          }
      }catch (Exception e)
      {
          e.printStackTrace();
          return "failed";
      }
    }

    public String checkOut(int parkingId)  {
       try{
           Connection con=jdbcUtils.establishConnection();
            ParkingModel parkingModel=getParkingInformation(parkingId);

           PreparedStatement updateParkingStatement = con.prepareStatement("UPDATE Parking SET  status = 'Free', userId = NULL, userName = NULL, parkingHistoryId=NULL, vehicleNo=NULL WHERE parkingId = ?");
           updateParkingStatement.setInt(1, parkingId);
           updateParkingStatement.executeUpdate();

           PreparedStatement updateHistoryStatement = con.prepareStatement("UPDATE ParkingHistory SET endTime = ? WHERE sno = ?");
           updateHistoryStatement.setTime(1, java.sql.Time.valueOf(LocalTime.now()));
           updateHistoryStatement.setInt(2, parkingModel.getParkingHistoryId());
           updateHistoryStatement.executeUpdate();
           con.close();
               return "success";
       }catch (Exception e)
       {
           e.printStackTrace();
           return "Failed";
       }

        }
    public List<ParkingHistory> viewParkingHistory(Date startDate,Date endDate)
    {
        List<ParkingHistory> parkingHistoryList=new ArrayList<>();
        try {
            Connection conn=jdbcUtils.establishConnection();

            String query = "SELECT * FROM parkingHistory WHERE date BETWEEN ? AND ?";

         PreparedStatement preparedStatement = conn.prepareStatement(query);
         preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
         preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));

             ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ParkingHistory parkingHistory = new ParkingHistory();

                    parkingHistory.setSno(resultSet.getInt("sno"));
                    parkingHistory.setParkingSlot(resultSet.getInt("parkingSlot"));
                    parkingHistory.setEmployeeId(resultSet.getInt("employeeId"));
                    parkingHistory.setEmployeeName(resultSet.getString("employeeName"));
                    parkingHistory.setDate(resultSet.getDate("date"));
                    parkingHistory.setMobileNo(resultSet.getString("mobileNo"));
                    Timestamp startTimeTimestamp = resultSet.getTimestamp("startTime");
                    Timestamp endTimeTimestamp = resultSet.getTimestamp("endTime");
                    if(startTimeTimestamp!=null)
                    {
                        parkingHistory.setStartTime(resultSet.getTime("startTime").toLocalTime());
                    }
                    if(endTimeTimestamp!=null)
                    {
                        parkingHistory.setEndTime(resultSet.getTime("endTime").toLocalTime());
                    }

                    parkingHistoryList.add(parkingHistory);
                }
                    return parkingHistoryList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ParkingHistory> viewAllParkingHistory()
    {
        List<ParkingHistory> parkingHistoryList=new ArrayList<>();
        try {
            Connection conn=jdbcUtils.establishConnection();

            String query = "SELECT * FROM parkingHistory";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ParkingHistory parkingHistory = new ParkingHistory();

                parkingHistory.setSno(resultSet.getInt("sno"));
                parkingHistory.setParkingSlot(resultSet.getInt("parkingSlot"));
                parkingHistory.setEmployeeId(resultSet.getInt("employeeId"));
                parkingHistory.setEmployeeName(resultSet.getString("employeeName"));
                parkingHistory.setDate(resultSet.getDate("date"));
                parkingHistory.setMobileNo(resultSet.getString("mobileNo"));
                Timestamp startTimeTimestamp = resultSet.getTimestamp("startTime");
                Timestamp endTimeTimestamp = resultSet.getTimestamp("endTime");
                if(startTimeTimestamp!=null)
                {
                    parkingHistory.setStartTime(resultSet.getTime("startTime").toLocalTime());
                }
                if(endTimeTimestamp!=null)
                {
                    parkingHistory.setEndTime(resultSet.getTime("endTime").toLocalTime());
                }

                parkingHistoryList.add(parkingHistory);
            }
            return parkingHistoryList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ParkingHistory> viewAllUserParkingHistory(int employeeId)
    {
        List<ParkingHistory> parkingHistoryList=new ArrayList<>();
        try {
            Connection conn=jdbcUtils.establishConnection();

            String query = "SELECT * FROM parkingHistory WHERE employeeId=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ParkingHistory parkingHistory = new ParkingHistory();

                parkingHistory.setSno(resultSet.getInt("sno"));
                parkingHistory.setParkingSlot(resultSet.getInt("parkingSlot"));
                parkingHistory.setEmployeeId(resultSet.getInt("employeeId"));
                parkingHistory.setEmployeeName(resultSet.getString("employeeName"));
                parkingHistory.setDate(resultSet.getDate("date"));
                parkingHistory.setMobileNo(resultSet.getString("mobileNo"));
                Timestamp startTimeTimestamp = resultSet.getTimestamp("startTime");
                Timestamp endTimeTimestamp = resultSet.getTimestamp("endTime");
                if(startTimeTimestamp!=null)
                {
                    parkingHistory.setStartTime(resultSet.getTime("startTime").toLocalTime());
                }
                if(endTimeTimestamp!=null)
                {
                    parkingHistory.setEndTime(resultSet.getTime("endTime").toLocalTime());
                }

                parkingHistoryList.add(parkingHistory);
            }
            return parkingHistoryList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<ParkingModel> getAllParkingSlot() {
        List<ParkingModel> parkingList = new ArrayList<>();


        try{
             Connection con=jdbcUtils.establishConnection();
             String query = "SELECT parkingId, userId, parkingHistoryId, userName, status, parkingType FROM Parking";
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ParkingModel parking = new ParkingModel();
                parking.setParkingId(resultSet.getInt("parkingId"));
                parking.setUserId(resultSet.getInt("userId"));
                parking.setParkingHistoryId(resultSet.getInt("parkingHistoryId"));
                parking.setUserName(resultSet.getString("userName"));
                parking.setStatus(resultSet.getString("status"));
                parking.setParkingType(resultSet.getString("parkingType"));
                parkingList.add(parking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parkingList;
    }

    public ParkingHistory getParkingHistory(int parkingHistoryId) {
        ParkingHistory parkingHistory = null;



            try{
                Connection con=jdbcUtils.establishConnection();
                String sql = "SELECT * FROM ParkingHistory WHERE sno = ?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, parkingHistoryId);

          ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    parkingHistory = new ParkingHistory();
                    parkingHistory.setSno(rs.getInt("sno"));
                    parkingHistory.setParkingSlot(rs.getInt("parkingSlot"));
                    parkingHistory.setEmployeeId(rs.getInt("employeeId"));
                    parkingHistory.setEmployeeName(rs.getString("employeeName"));
                    parkingHistory.setDate(rs.getDate("date"));
                    parkingHistory.setVehicleNo(rs.getString("vehicleNo"));
                }

            } catch (SQLException e) {
            e.printStackTrace();
        }

        return parkingHistory;
    }
}






