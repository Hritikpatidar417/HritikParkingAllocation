<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>

        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: white; /* Body background color */
            color: black; /* Default text color */
            text-align: center;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }



        .welcome-container {
            background: white; /* Container background color */
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            border: 1px solid #ddd;
        }



        .logo img {
            width: 200px;
            margin-bottom: 20px;
        }



        h1 {
            font-size: 1.2em;
            margin-bottom: 20px;
            color: black; /* Title text color */
        }
        h2 {
             font-size: 1.2em;
             margin-bottom: 20px
             color: black; /* Title text color */
                }



        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 20px;
        }



        .btn {
            text-decoration: none;
            color: white;
            background-color: #007bff; /* Button background color */
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }


        .btn:hover {
            background-color: #0056b3; /* Button hover color */
        }
    </style>
</head>
<body>
    <div class="welcome-container">

        <div class="logo">
            <img src="./YashLogo.png" alt="Company Logo">
        </div>



        <h1>Welcome</hi>
        <h2>Yash Technologies Parking Allocation System</h2>



        <div class="button-container">
            <a href="/Register.jsp" class="btn">Register</a>
            <a href="/Login.jsp" class="btn">Login</a>
        </div>
    </div>
</body>
</html>
