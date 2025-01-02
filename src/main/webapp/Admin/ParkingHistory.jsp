<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <title>Parking History</title>
   <style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f8f9fa;
           margin: 0;
           padding: 0;
       }
           /* Sidebar Styles */
                  .sidebar {
                      height: 100vh;
                      width: 250px;
                      background-color: #343a40;
                      color: white;
                      position: fixed;
                      padding-top: 20px;
                      box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
                  }


                  .sidebar h3 {
                      text-align: center;
                      margin-bottom: 20px;
                      font-size: 1.5rem;
                  }


                  .sidebar a {
                      color: white;
                      padding: 15px 20px;
                      text-decoration: none;
                      display: block;
                      border-radius: 5px;
                      transition: background-color 0.3s ease;
                      margin: 5px 0;
                  }


                  .sidebar a:hover {
                      background-color: #01106d;
                  }


                  /* Main Content Styles */
                  .main-content {
                      margin-left: 270px;
                      padding: 20px;
                  }


                  .navbar {
                      background-color: #343a40;
                      padding: 15px 5px;
                      border-bottom: 1px solid #ddd;
                      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                      display:flex;
                      justify-content:center;

                  }
                   .navbar h4 {
                                 margin: 0;
                                 color: white;
                             }


  img {
                       max-width: 250px;
                       margin-bottom: 20px;
                      background-color:white;

                   }


           @media (max-width: 768px) {
               .sidebar {
                   width: 200px;
               }


               .main-content {
                   margin-left: 220px;
               }


               .parking-slot {
                   font-size: 0.9rem;
                   padding: 10px;
               }
           }


       .container {
           max-width: 800px;
           margin: 50px auto;
           padding: 20px;
           background-color: #ffffff;
           border-radius: 8px;
           box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
       }
       h2 {
           text-align: center;
           margin-bottom: 20px;
           font-size: 24px;
           color: #333;
       }
       form {
           margin-bottom: 20px;
       }
       form .form-row {
           display: flex;
           justify-content: space-between;
           align-items: flex-end;
           gap: 10px;
           margin-bottom: 20px;
       }
       form label {
           font-weight: bold;
           margin-bottom: 5px;
           display: block;
       }
       input[type="date"] {
           width: 100%;
           padding: 8px;
           border: 1px solid #ccc;
           border-radius: 4px;
           box-sizing: border-box;
       }
       button {
           padding: 10px 15px;
           border: none;
           border-radius: 4px;
           color: #fff;
           font-size: 14px;
           cursor: pointer;
       }
       .btn {
                  display: inline-block;
                  padding: 10px 20px;
                  font-size: 14px;
                  color: #ffffff;
                  text-align: center;
                  text-decoration: none;
                  border-radius: 4px;
                  border: none;
                  cursor: pointer;
              }
       .btn-primary {
           background-color: #007bff;
       }
       .btn-primary:hover {
           background-color: #0056b3;
       }
       .btn-secondary {
           background-color: #6c757d;
       }
       .btn-secondary:hover {
           background-color: #5a6268;
       }
       table {
           width: 100%;
           border-collapse: collapse;
           margin-bottom: 20px;
       }
       table th, table td {
           border: 1px solid #ddd;
           padding: 8px;
           text-align: left;
       }
       table th {
           background-color: #343a40;
           color: #fff;
           text-align: center;
       }
       table tr:nth-child(even) {
           background-color: #f2f2f2;
       }
       table tr:hover {
           background-color: #e9ecef;
       }
       .text-center {
           text-align: center;
       }
   </style>
</head>
<body>
<div class="sidebar">

 <img src="../YashLogo.png" alt="Logo">
    <h3>Parking System</h3>
     <a href="/admin/dashboard">Dashboard</a>
    <a href="/Admin/AddParkingSlot.jsp">Add Parking Slots</a>
    <a href="/admin/ViewRemoveParkingSlot">Remove Parking Slots</a>
    <a href="/Admin/ParkingHistory.jsp">View Parking History</a>
    <a href="/logout">Logout</a>
</div>


<div class="main-content">

    <div class="navbar">
        <h4>Welcome, ${sessionScope.user.name} (${sessionScope.user.userId}) (Admin)</h4>
    </div>
   <div class="container">

       <h2>Parking History</h2>



       <form action="/admin/ViewParkingHistory" method="get">
           <div class="form-row">
               <div class="col-md-5">
                   <label for="startDate">Start Date</label>
                   <input type="date" id="startDate" name="startDate" required>
               </div>
               <div class="col-md-5">
                   <label for="endDate">End Date</label>
                   <input type="date" id="endDate" name="endDate" required>
               </div>
               <div class="col-md-2">
                   <button type="submit" class="btn btn-primary">Fetch Data</button>
               </div>
           </div>
       </form>



       <table>
           <thead>
               <tr>
                   <th>S.No</th>
                   <th>Parking Slot</th>
                   <th>Employee ID</th>
                   <th>Employee Name</th>
                   <th>Date</th>
                   <th>Start Time</th>
                   <th>End Time</th>
               </tr>
           </thead>
           <tbody>
               <c:forEach var="history" items="${parkingHistory}">
                   <tr>
                       <td>${history.sno}</td>
                       <td>${history.parkingSlot}</td>
                       <td>${history.employeeId}</td>
                       <td>${history.employeeName}</td>
                       <td>${history.date}</td>
                       <td>${history.startTime}</td>
                       <td>${history.endTime}</td>
                   </tr>
               </c:forEach>
               <c:if test="${empty parkingHistory}">
                   <tr>
                       <td colspan="7" class="text-center">No parking history found for the selected dates.</td>
                   </tr>
               </c:if>
           </tbody>
       </table>


       <a href="/admin/dashboard" class="btn btn-secondary">Go Back</a>
   </div>
</body>
</html>
