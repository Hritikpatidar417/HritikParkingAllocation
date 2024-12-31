<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Multiple Parking</title>


    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Add Multiple Parking Types</h2>
        <form action="/admin/addParking" method="post">
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Parking Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="parkingTable">
                    <tr>
                        <td>
                            <select class="form-select" name="parkingTypeList" required>
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
                <button type="button" class="btn btn-success" onclick="addRow()">Add Parking</button>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
         <a href="/admin/dashboard" class="btn btn-secondary">Go Back</a>
    </div>



    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Function to add a new row to the table
        function addRow() {
            const tableBody = document.getElementById("parkingTable");
            const newRow = document.createElement("tr");
            newRow.innerHTML = `
                <td>
                    <select class="form-select" name="parkingTypeList" required>
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
