<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="patterns/header.jsp"%>

<div class="container">
    <h1>Dodaj element stoiska</h1>
    <form:form method="post" modelAttribute="standElement">
        <div class="row">
            <div class="form-group col-md-3">
                <label for="standElementId">Element stoiska:</label>
                <form:input type="text" path="element" id="standElementId"/>
                <form:errors path="element" cssClass="error"/>
            </div>
            <div class="form-group col-md-3">
                <label for="priceId">Cena jednostkowa za element:</label>
                <form:input type="number" path="price" id="priceId" min="0"/>
                <form:errors path="price" cssClass="error"/>
            </div>
            <div class="form-group col-md-3 text-center" style= "text-align: center">
                <label for="typeId">Jednostki:</label>
                <form:select path="type" id="typeId">
                    <form:option value="-" label="--Wybierz--"/>
                    <form:option value="sztuki"/>
                    <form:option value="mkw."/>
                    <form:option value="metry"/>
                </form:select>
                <form:errors path="type" cssClass="error"/>
            </div>
            <div class="form-group col-md-3">
                <label for="descriptionId">Opis elementu:</label>
                <form:input type="text" path="description" id="descriptionId"/>
                <form:errors path="description" cssClass="error"/>
            </div>
        </div>
        <button type="submit" class="btn btn-dark">Zapisz</button>
        <a href="/admin/stand/list" class="btn btn-outline-dark">Cofnij</a>
    </form:form>
</div>

<%@ include file="patterns/footer.jsp"%>
