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
                <th>Transaction ID</th>
                <th>User ID</th>
                <th>Book ID</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${transactions}" var="transaction">
                <tr>
                    <td>${transaction.transactionId}</td>
                    <td>${transaction.userId}</td>
                    <td>${transaction.bookId}</td>
                    <td>${transaction.date}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form action="transactions" method="post">
            <input type="hidden" name="action" value="addTransaction">

            <div class="form-container">

                <%-- This is pretty cool no? --%>

                <label for="userId">User:</label>
                <select id="userId" name="userId" required>
                    <c:forEach items="${users}" var="user">
                        <option value="${user.userId}">${user.name}</option>
                    </c:forEach>
                </select><br><br>

                <label for="bookId">Book:</label>
                <select id="bookId" name="bookId" required>
                    <c:forEach items="${books}" var="book">
                        <option value="${book.bookId}">${book.title}</option>
                    </c:forEach>
                </select><br><br>

                <label for="date">Date:</label>
                <input type="date" id="date" name="date" required><br><br>

                <input type="submit" value="Add Transaction">
            </div>
        </form>

        <hr>

        <div style="margin-top: 20px;">
            <a href="books">Books</a> | 
            <a href="users">Users</a>
        </div>
    </body>
</html>
