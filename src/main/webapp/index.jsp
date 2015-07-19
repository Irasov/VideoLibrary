<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MOVIE LIBRARY</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/start" method="get">
    <div>
        <p><input type="radio" name="request" value="find by id" checked title="Find by id"/>Find by id. Enter id <textarea name="id" id="id" cols="2" rows="1">1</textarea></p>
        <p><input type="radio" name="request" value="insert" title="inset"/>Insert movie</p>
        <p><input type="radio" name="request" value="remove" title="remove"/>Remove movie</p>
    </div>
    <div>
        <button type="submit">OK</button>
    </div>
</form>
</body>
</html>
