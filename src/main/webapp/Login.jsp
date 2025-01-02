<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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
            background: #fff;
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
            max-width: 240px;
            margin-bottom: 20px;
        }


        .form-container {
            flex: 2;
            background-color: #E2E4E3;
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


        form input {
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


        .error-message {
            color: red;
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>


<div class="container">
    <div class="logo-container">
        <img src="./YashLogo.png" alt="Logo">

    </div>
    <div class="form-container">
        <h1>Login</h1>




            <c:if test="${not empty registrationStatus}">
                <p style="color: green;">${registrationStatus}</p>
            </c:if>



        <form action="LoginValidationServlet" method="post">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" placeholder="Enter your User ID" required>


            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>


            <button type="submit">Login</button>
        </form>


        <p>Not registered? <a href="/Register.jsp">Register Here</a></p>
    </div>
</div>


</body>
</html>






