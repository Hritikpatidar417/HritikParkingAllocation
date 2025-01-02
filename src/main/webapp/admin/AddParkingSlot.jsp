<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <title>Add Multiple Parking</title>
   <style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f8f9fa;
           margin: 0;
           padding: 0;
       }



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
           box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
           border-radius: 8px;
       }
       h2 {
           text-align: center;
           margin-bottom: 20px;
           font-size: 24px;
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
           color: #ffffff;
       }
       select {
           width: 100%;
           padding: 8px;
           border: 1px solid #ccc;
           border-radius: 4px;
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
       .btn-success {
           background-color: #28a745;
       }
       .btn-success:hover {
           background-color: #218838;
       }
       .btn-danger {
           background-color: #dc3545;
       }
       .btn-danger:hover {
           background-color: #c82333;
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
       .text-center {
           text-align: center;
       }
       .mb-3 {
           margin-bottom: 16px;
       }
   </style>
</head>
<body>
<div class="sidebar">

 <img src="../YashLogo.png" alt="Logo">
    <h3>Parking System</h3>
     <a href="/admin/dashboard">Dashboard</a>
    <a href="/admin/AddParkingSlot.jsp">Add Parking Slots</a>
    <a href="/admin/ViewRemoveParkingSlot">Remove Parking Slots</a>
    <a href="/admin/ParkingHistory.jsp">View Parking History</a>
    <a href="/logout">Logout</a>
</div>


<div class="main-content">

    <div class="navbar">
        <h4>Welcome, ${sessionScope.user.name} (${sessionScope.user.userId}) (Admin)</h4>
    </div>



   <div class="container">
       <h2>Add Multiple Parking Types</h2>
       <form action="/admin/addParking" method="post">
           <table>
               <thead>
                   <tr>
                       <th>Parking Type</th>
                       <th>Action</th>
                   </tr>
               </thead>
               <tbody id="parkingTable">
                   <tr>
                       <td>
                           <select name="parkingTypeList" required>
                               <option value="" disabled selected>Select Parking Type</option>
                               <option value="Car">Car</option>
                               <option value="Bike">Bike</option>
                           </select>
                       </td>
                       <td>
                           <button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button>
                       </td>
                   </tr>
               </tbody>
           </table>
           <div class="mb-3">
               <button type="button" class="btn btn-success" onclick="addRow()">Add Row</button>
           </div>
           <div class="text-center">
               <button type="submit" class="btn btn-primary">Submit</button>
           </div>
       </form>
       <a href="/admin/dashboard" class="btn btn-secondary">Go Back</a>
   </div>
</div>

   <script>

       // Function to add a new row to the table

       function addRow() {
           const tableBody = document.getElementById("parkingTable");
           const newRow = document.createElement("tr");
           newRow.innerHTML = `
               <td>
                   <select name="parkingTypeList" required>
                       <option value="" disabled selected>Select Parking Type</option>
                       <option value="Car">Car</option>
                       <option value="Bike">Bike</option>
                   </select>
               </td>
               <td>
                   <button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button>
               </td>
           `;
           tableBody.appendChild(newRow);
       }


       // Function to remove a row from the table
       function removeRow(button) {
           const row = button.parentElement.parentElement;
           row.remove();
       }
   </script>
</body>
</html>
