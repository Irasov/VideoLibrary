<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="members" type="com.epam.irasov.videolibrary.entity.Movie.Member"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>members</title>
</head>
<body>
<div>
  <a href="index.jsp">Вернуться на страницу запросов</a>
  <p>Найденные актеры:</p>
  <c:forEach items="${members}" var="members">
    <div style="padding: 0 0 1% 5%">
      <p>ID участника: ${members.id}</p>
      <p>Год рожденья: ${members.date}</p>
      <p>Должность в фильме: ${members.memberRole}</p>
      <p>Имя: ${members.name}</p>
      <p>Отчество: ${members.patronymic}</p>
      <p>Фамилиия: ${members.secondName}</p>
    </div>
  </c:forEach>
</div>
</body>
</html>
