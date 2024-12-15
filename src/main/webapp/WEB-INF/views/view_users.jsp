<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <style>

        h1 {
            text-align: center;
        }

        table {
            margin: 20px auto; 
            border-collapse: collapse; 
            width: 80%;
        }

        table th, table td {
            padding: 8px;
            text-align: center;
            border: 1px solid #ddd; 
        }

        .form-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 5px;
        }

        .form-container label,
        .form-container input {
            margin-right: 2px;
        }

        .form-container input[type="submit"] {
            margin-left: 2px;
        }
    </style>
</head>
    <body>
        <h1>${title}</h1>
        <table border="1">
            <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>User E-mail</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form action="users" method="post">
            <input type="hidden" name="action" value="addUser">

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>

            <label for="email">E-mail:</label>
            <input type="text" id="email" name="email" required><br><br>

            <input type="submit" value="Add User">
        </form>

        <div style="margin-top: 20px;">
            <a href="books">Books</a> | 
            <a href="transactions">Transactions</a>
        </div>
    </body>
</html>
