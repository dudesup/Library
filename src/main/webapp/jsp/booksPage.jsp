<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Books Page</title>
    <a href="/welcome">Main Page</a>
    <a href="/addbooks">Add book</a>
    <br>
</head>
<body>
<c:forEach items="${books}" var="book">
    Title: ${book.title} <br>
    Author: ${book.author} <br>
    Price: ${book.price} <br>
    <br>
</c:forEach>
</body>
</html>