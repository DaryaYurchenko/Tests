<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="tests">
    <input type="hidden" name="command" value="SHOW_ALL_USERS">
    <input type="hidden" name="act" value="JUST_SHOW">
    <input type="hidden" name="currentPage" value="1">
    <input type="submit" value="SHOW">
</form>
<form method="get" action="tests">
    <input type="hidden" name="command" value="SHOW_ALL_USERS">
    <input type="hidden" name="act" value="DELETE_USER_BY_ID">
    <input type="hidden" name="currentPage" value="1">
    <input type="submit" value="DELETE by id">
</form>
<form method="get" action="tests">
    <input type="hidden" name="command" value="SHOW_ALL_USERS">
    <input type="hidden" name="act" value="DELETE_ALL_USERS">
    <input type="hidden" name="currentPage" value="1">
    <input type="submit" value="DELETE all">
</form>

<form method="get" action="tests">
    <input type="hidden" name="command" value="SHOW_ALL_USERS">
    <input type="hidden" name="act" value="SHOW_USER_RESULTS">
    <input type="hidden" name="currentPage" value="1">
    <input type="submit" value="SHOWRESULTS">
</form>

<form method="get" action="tests">
    <input type="hidden" name="currentPage" value="1">
    <input type="hidden" name="command" value="SHOW_ALL_USERS">
    <input type="hidden" name="act" value="REGISTER_ADMIN">
    <input type="submit" value="REGISTER ADMIN">
</form>


</body>
</html>
