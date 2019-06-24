<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Admin</h2>

            <p class="list-group">Witaj w panelu admina</p>
        </div>
        <h3><a href="/admin/stand/list" class="btn btn-dark btn-lg"/>Lista elementów</a></h3>
        <h3><a href="/admin/user/list" class="btn btn-dark btn-lg"/>Użytkownicy</a></h3>
    </div>
</div>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>
