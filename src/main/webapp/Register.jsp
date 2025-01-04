<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: #fff;
            color: black;
        }


        .container {
            width: 60%;
            max-width: 1000px;
            background: #e3e3e3;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            display: flex;
            overflow: hidden;
        }


        .logo-container {
            flex: 1;
            background: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            color: black;
            padding: 20px;
        }


        .logo-container img {
            max-width: 270px;
            margin-bottom: 20px;
        }


        .form-container {
            flex: 2;
            padding: 40px;
        }


        h1 {
            margin-bottom: 20px;
            font-size: 2rem;
            color: #333;
        }


        form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }


        form input, form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }


        form button {
            width: 100%;
            padding: 12px;
            background-color: #2575fc;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }


        form button:hover {
            background-color: #6a11cb;
        }
    </style>
</head>
<body>


<div class="container">
    <div class="logo-container">
        <img src="./YashLogo.png" alt="Logo">

    </div>
    <div class="form-container">
        <h1>Register</h1>
        <form action="/register" method="post">
            <label for="userId">UserId:</label>
            <input type="text" id="userId" name="userId" placeholder="Enter your User ID"required>

            <label for="phoneNo">PhoneNo:</label>
            <input type="text" id="phoneNo" name="phoneNo" placeholder="Enter your PhoneNo."required>


            <label for="userName">Username:</label>
            <input type="text" id="userName" name="userName" placeholder="Enter your Name"required>


            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your New Password"required>


            <button type="submit">Register</button>
        </form>
         <p>Already registered ? <a href="/Login.jsp">Login</a></p>
    </div>
</div>


</body>
</html>




