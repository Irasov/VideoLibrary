<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="movie" type="com.epam.irasov.parser.entity.Movie"--%>
<html>
<head>
    <title>result</title>
</head>
<body>
<a href="index.jsp">Вернуться на страницу запросов</a>
<div>
    <p>Найденный фильм:</p>
    <div style="padding-left: 5%">
    <p>ID фильма: ${movie.id}</p>
    <p>Название фильма: ${movie.name}</p>
    <p>Страна: ${movie.country}</p>
    <p>Год выпуска: ${movie.release}</p>
    </div>
    <p>Участники фильма:</p>
    <c:forEach items="${movie.members}" var="member">
        <div style="padding: 0 0 1% 5%">
            <p>ID участника: ${member.id}</p>
            <p>Год рожденья: ${member.date}</p>
            <p>Должность в фильме: ${member.memberRole}</p>
            <p>Имя: ${member.name}</p>
            <p>Отчество: ${member.patronymic}</p>
            <p>Фамилиия: ${member.secondName}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
