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

    <form action="books" method="get">
        <label for="availability">Filter by Availability:</label>
        <select id="availability" name="availability">
            <option value="all">All</option>
            <option value="available">Available</option>
            <option value="unavailable">Unavailable</option>
        </select>
        <input type="submit" value="Filter">
    </form>

    <table border="1">
        <thead>
        <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Availability</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.available}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form action="users" method="post">
        <input type="hidden" name="action" value="addUser">

        <div class="form-container">

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required><br><br>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required><br><br>

            <label for="isAvailable">Available?:</label>
            <input type="checkbox" id="isAvailable" name="isAvailable" checked><br><br>

            <input type="submit" value="Add Book">
        </div>
    </form>

    <div style="margin-top: 20px;">
        <a href="users">Users</a> | 
        <a href="transactions">Transactions</a>
    </div>
</body>
</html>
