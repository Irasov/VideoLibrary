<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MOVIE LIBRARY</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/start" method="get">
    <div>
        <p><input type="radio" name="request" value="find by id" checked title="Find movie by id"/>Find movie by id. Enter id <textarea name="id" id="id" cols="2" rows="1" title="Enter id">1</textarea></p>
        <p><input type="radio" name="request" value="remove" title="remove"/>Remove movie. Enter release movie <textarea name="date" id="date" cols="8" rows="1" title="Enter Date">2014-07-23</textarea></p>
        <p><input type="radio" name="request" value="count" title="count"/>Find actor by count movie. Enter count movie <textarea name="count" id="count" cols="2" rows="1" title="Enter count">2</textarea></p>
    </div>
    <div>
        <button type="submit">OK</button>
    </div>
</form>
</body>
</html>
