<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="patterns/header.jsp"%>

<div class="container">
    <h1>Elementy stoiska</h1>

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

    <table class="table table-bordered">
        <thead class="thead-dark" style="background-color:wheat">
        <tr>
            <th>Id elementu</th>
            <th>Nazwa Elementu</th>
            <th>Cena elementu</th>
            <th>Jednostka</th>
            <th>Opis elementu</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="stand" items="${standElements}">
            <tr>
                <td>${stand.id}</td>
                <td>${stand.element}</td>
                <td>${stand.price}</td>
                <td>${stand.type}</td>
                <td>${stand.description}</td>
                <td>
                    <a href="/admin/stand/update/${stand.id}" class="btn btn-outline-dark btn-sm">Edycja</a>
                    <a href="#" onclick= "confirmDeleteElement(${stand.id}, '${stand.element}')" class="btn btn-outline-dark btn-sm">Usuń</a>
            </tr>
        </c:forEach>
    </table>
        <span><a href="/admin/stand/add" class="btn btn-dark btn-sm">Dodaj nowy element</a></span>
        <span><a href="/admin/user/list" class="btn btn-dark btn-sm">Lista użytkowników</a></span>
</div>

<script type="text/javascript" src="/resources/js/element.js"></script>
<%@include file="patterns/footer.jsp"%>