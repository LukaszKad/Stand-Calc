<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="patterns/header.jsp"%>

<div class="container">
    <h1>Edycja elementu</h1>

    <form method="post">
        <input type="hidden" name="id" value="${standElement.id}"/>
        <div class="form-group col-md-6">
            <label for="element">Nazwa elementu:</label>
            <input class="form-control" id="element" name="element" value="${standElement.element}" required>
        </div>
        <div class="form-group col-md-6">
            <label for="price">Cena elementu:</label>
            <input class="form-control" id="price" name="price" value="${standElement.price}" required>
        </div>
        <div class="form-group col-md-6">
            <label for="type">Jednostki:</label>
            <select path="type" id="type" name="type">
                <option value="${standElement.type}">--${standElement.type}--</option>
                <option value="sztuki">sztuki</option>
                <option value="mkw.">mkv.</option>
                <option value="metry">metry</option>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="description">Opis elementu:</label>
            <input class="form-control" id="description" name="description" value="${standElement.description}" required>
        </div>
        <button type="submit" class="btn btn-dark">Zapisz edycje</button>
        <a href="/admin/stand/list" class="btn btn-outline-dark">Anuluj edycję</a>
    </form>
</div>

<%@include file="patterns/footer.jsp"%>
