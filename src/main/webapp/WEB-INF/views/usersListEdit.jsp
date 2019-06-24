<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="patterns/header.jsp"%>

<div class="container">
    <h1>Edycja użytkownika</h1>

    <form method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label for="username">Nazwa użytkownika:</label>
            <input class="form-control" id="username" name="username" value="${user.username}" required>
        </div>
        <%--<div class="form-group">--%>
            <%--<label for="email">Email:</label>--%>
            <%--<input class="form-control" id="email" name="email" value="${user.email}" required>--%>
        <%--</div>--%>
        <div class="form-group">
            <label for="firstName">Imię:</label>
            <input class="form-control" id="firstName" name="firstName" value="${user.firstName}">
        </div>
        <div class="form-group">
            <label for="lastName">Nazwisko:</label>
            <input class="form-control" id="lastName" name="lastName" value="${user.lastName}">
        </div>
        <div class="form-group">
            <label for="companyName">Nazwa Firmy:</label>
            <input class="form-control" id="companyName" name="companyName" value="${user.companyName}">
        </div>

        <div class="form-group">
            <label for="nip">NIP:</label>
            <input class="form-control" id="nip" name="nip" value="${user.nip}">
        </div>
        <div class="form-group">
            <label for="phone">Telefon:</label>
            <input class="form-control" id="phone" name="phone" value="${user.phone}">
        </div>

        <button type="submit" class="btn btn-dark">Zapisz edycje</button>
        <a href="/admin/user/list/" class="btn btn-outline-dark">Anuluj edycję</a>
    </form>
</div>

<%@include file="patterns/footer.jsp"%>
