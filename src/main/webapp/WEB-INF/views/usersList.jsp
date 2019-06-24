<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="patterns/header.jsp"%>

<div class="container">
    <h1>Użytkownicy</h1>

    <form class="form-inline" action="/admin/menu" autocomplete="off">
        <label class="sr-only" for="keyword">Keyword</label>
        <input type="text" value="${param.keyword}" class="form-control mb-2 mr-sm-2" id="keyword" name="keyword" placeholder="Keyword">

        <label class="sr-only" for="category">Category</label>
        <select class="form-control mb-2 mr-sm-2" id="category" name="category">
            <option value="">Category</option>
            <c:forEach items="${ categories }" var="cat">
                <option <c:if test="${ cat eq param.category }">selected</c:if>>${ cat }</option>
            </c:forEach>
        </select>

        <button type="submit">Search</button>
        <c:if test="${not empty param.keyword or not empty param.category}">
            <a href="/admin/menu">Clear</a>
        </c:if>
    </form>

    <table class="table table-striped" style="text-align: center">
        <thead class="thead-dark">
        <tr>
            <th class="py-4">Id Usera</th>
            <th class="py-4">Login</th>
            <th class="py-4">E-mail</th>
            <th class="py-4">Imię</th>
            <th class="py-4">Nazwisko</th>
            <th class="py-4">Nazwa Firmy</th>
            <th class="py-4">NIP firmy</th>
            <th class="py-4">Telefon</th>
            <th class="py-4">Opis dodatkowy</th>
            <th class="py-4">Action</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td class="py-4">${user.id}</td>
                <td class="py-4">${user.username}</td>
                <td class="py-4">${user.email}</td>
                <td class="py-4">${user.firstName}</td>
                <td class="py-4">${user.lastName}</td>
                <td class="py-4">${user.companyName}</td>
                <td class="py-4">${user.nip}</td>
                <td class="py-4">${user.phone}</td>
                <td class="py-4">${user.description}</td>
                <td>
                    <a href="/admin/user/update/${user.id}" class="btn btn-outline-dark btn-sm">Edycja danych</a>
                    <a href="#" onclick= "confirmDeleteUser(${user.id}, '${user.username}')" class="btn btn-outline-dark btn-sm">Usuń</a>
            </tr>
        </c:forEach>
    </table>
    <span><a href="/admin/stand/list" class="btn btn-dark btn-sm">Lista elementów</a></span>
</div>

<script type="text/javascript" src="/resources/js/userRemove.js"></script>

<%@include file="patterns/footer.jsp"%>
