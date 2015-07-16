<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MOVIE LIBRARY</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/start" method="get">
    <div>
        <p><input type="radio" name="group1" value="findbyid" checked title="Find by id"/>Find by id</p>
        <p><input type="radio" name="group1" value="insert" title="inset"/>Insert movie</p>
        <p><input type="radio" name="group1" value="remove" title="remove"/>Remove movie</p>
    </div>
    <div>
        <button type="submit">OK</button>
    </div>
</form>
</body>
</html>
