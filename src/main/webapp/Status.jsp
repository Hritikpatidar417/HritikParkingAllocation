<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
   <title>Success</title>
   <style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f8f9fa;
           margin: 0;
           padding: 0;
       }
       .container {
           max-width: 600px;
           margin: 50px auto;
           padding: 20px;
           background-color: #ffffff;
           box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
           border-radius: 8px;
           text-align: center;
       }
       .alert {
           color: #155724;
           background-color: #d4edda;
           border: 1px solid #c3e6cb;
           border-radius: 4px;
           padding: 20px;
       }
       .alert h4 {
           margin-bottom: 10px;
           font-size: 24px;
       }
       .alert p {
           margin: 0;
           font-size: 16px;
       }
       .alert hr {
           margin: 20px 0;
           border: none;
           border-top: 1px solid #c3e6cb;
       }
       .btn {
           display: inline-block;
           padding: 10px 20px;
           font-size: 16px;
           color: #fff;
           background-color: #007bff;
           text-decoration: none;
           border-radius: 4px;
           border: none;
           cursor: pointer;
       }
       .btn:hover {
           background-color: #0056b3;
       }
   </style>
</head>
<body>
   <div class="container">
       <div class="alert" role="alert">
           <h4 class="alert-heading">Success!</h4>
           <p>Parking Slot Added successfully.</p>
           <hr>
           <a href="/admin/dashboard" class="btn">Go Back to Dashboard</a>
       </div>
   </div>
</body>
</html>
