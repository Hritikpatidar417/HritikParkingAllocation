<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parking Slots</title>
   <style>
           body {
               font-family: 'Arial', sans-serif;
               margin: 0;
               padding: 0;
               background-color: #f8f9fa; /* Light gray background */
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

             h4 {
                color: #343a40;
                margin-bottom: 10px;
                margin-top:15px;

             }


           h2 {
               color: #343a40;
               margin-bottom: 10px;
               margin-top:15px;
               text-align: center;
           }
           .heading{
           text-align:center;
           font-weight:bold;
           }



           .parking-container {
               display: grid;
               grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
               gap: 20px;
               margin-top: 20px;
           }


           .parking-slot {
               text-align: center;
               padding: 15px;
               border-radius: 10px;
               border: 1px solid #ccc;
               font-size: 1rem;
               cursor: pointer;
               transition: transform 0.3s, box-shadow 0.3s;
               background-color: white;
               box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
           }


           .parking-slot:hover {
               transform: scale(1.05);
               box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
           }


           .free {
               background-color: #eaffea; /* Light green */
               border-color: #c3e6cb;
           }


           .occupied {
               background-color: #ffe6e6; /* Light red */
               border-color: #f5c6cb;
           }


           .parking-slot div {
               margin: 5px 0;
           }


           button {
               padding: 8px 15px;
               background-color: #007bff;
               border: none;
               color: white;
               border-radius: 5px;
               cursor: pointer;
               transition: background-color 0.3s ease;
           }


           button:hover {
               background-color: #0056b3;
           }



           .modal {
               display: none;
               position: fixed;
               z-index: 1000;
               left: 0;
               top: 0;
               width: 100%;
               height: 100%;
               background: rgba(0, 0, 0, 0.5);
               align-items: center;
               justify-content: center;
           }


           .modal-content {
               background: white;
               padding: 20px;
               border-radius: 10px;
               width: 400px;
               text-align: center;
               box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
           }


           .modal-content h4 {
               margin-bottom: 15px;
           }


           .modal-content input {
               width: 100%;
               padding: 10px;
               margin: 10px 0;
               border: 1px solid #ccc;
               border-radius: 5px;
           }


           .close {
               position: absolute;
               top: 10px;
               right: 15px;
               font-size: 1.5rem;
               color: #aaa;
               cursor: pointer;
           }


           .close:hover {
               color: #333;
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
       </style>
</head>
<body>
<div class="sidebar">

 <img src="../YashLogo.png" alt="Logo">
    <h3>Parking System</h3>
    <a href="/admin/dashboard">Dashboard</a>
     <a href="/admin/AddParkingSlot.jsp">Add Parking Slots</a>

    <a href="/admin/ViewRemoveParkingSlot">Remove Parking Slots</a>
    <a href="/admin/ViewParkingHistory">View Parking History</a>
    <a href="/logout">Logout</a>
</div>


<div class="main-content">

    <div class="navbar">
        <h4>Welcome, ${sessionScope.user.name} (${sessionScope.user.userId}) (Admin)</h4>
    </div>



    <h2 class="section-title">All Parking Status</h2>



    <h4>Two Wheeler</h4>
    <div class="parking-container">
        <c:forEach var="parking" items="${parking}">
            <c:if test="${parking.parkingType == 'Bike'}">
                <c:choose>
                    <c:when test="${parking.status == 'Free'}">
                        <div class="parking-slot free">
                            <div>Slot: ${parking.parkingId}</div>
                            <div>Status: ${parking.status}</div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="parking-slot occupied">
                            <div>Slot: ${parking.parkingId}</div>
                            <div>Status: ${parking.status}</div>
                            <div>Employee ID: ${parking.userId}</div>
                            <div>Employee Name: ${parking.userName}</div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </c:forEach>
    </div>



    <h4>Four Wheeler</h4>
    <div class="parking-container">
        <c:forEach var="parking" items="${parking}">
            <c:if test="${parking.parkingType == 'Car'}">
                <c:choose>
                    <c:when test="${parking.status == 'Free'}">
                        <div class="parking-slot free">
                            <div>Slot: ${parking.parkingId}</div>
                            <div>Status: ${parking.status}</div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="parking-slot occupied">
                            <div>Slot: ${parking.parkingId}</div>
                            <div>Status: ${parking.status}</div>
                            <div>Employee ID: ${parking.userId}</div>
                            <div>Employee Name: ${parking.userName}</div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </c:forEach>
    </div>
</div>
</body>
</html>






