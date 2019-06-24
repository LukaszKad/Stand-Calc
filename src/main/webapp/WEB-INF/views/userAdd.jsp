<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 04.06.19
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="patterns/header.jsp"%>


<div class="container">

    <form:form method="post" modelAttribute="userAddNew">

        <header>
            <h2>Utwórz konto</h2>
        </header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="usernameId">Username:</label>
                    <form:input type="text" path="username" id="usernameId" class="form-control"/>
                    <form:errors path="username" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password" id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <form:input type="text" path="email" id="emailId" class="form-control"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                    <span>${emailMessage}</span>
                </div>

                <div class="form-group">
                    <label><input type="radio" name="chosenData" id="userInfo">Osoba fizyczna</label>
                    <label><input type="radio" name="chosenData" id="companyInfo">Firma</label>
                </div>


                <div class="form-group" id="userData">
                    <div class="form-group">
                        <label for="firstNameId">Imię:</label>
                        <form:input type="text" path="firstName" id="firstNameId" class="form-control"/>
                        <form:errors path="firstName" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="lastNameId">Nazwisko:</label>
                        <form:input type="text" path="lastName" id="lastNameId" class="form-control"/>
                        <form:errors path="lastName" element="div" cssClass="error"/>
                    </div>
                </div>

                <div class="form-group" id="companyData">
                    <div class="form-group">
                        <label for="companyId">Nazwa firmy:</label>
                        <form:input type="text" path="companyName" id="companyId" class="form-control"/>
                        <form:errors path="companyName" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="phoneId">Telefon:</label>
                        <form:input type="text" path="phone" id="phoneId" class="form-control"/>
                        <form:errors path="phone" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <label for="nipId">NIP:</label>
                        <form:input type="text" path="nip" id="nipId" class="form-control"/>
                        <form:errors path="nip" element="div" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label for="descriptionId">Description:</label>
                        <form:input type="text" path="description" id="descriptionId" class="form-control"/>
                        <form:errors path="description" element="div" cssClass="error"/>
                    </div>
                </div>

                <input type="submit" value="Zarejestruj się" class="btn btn-dark">

            </div>
            <div class="card-body">
                <a href="/login" class="btn btn-outline-dark">Zaloguj się</a>
                <a href="/home" class="btn btn-outline-dark">Powrót</a>
            </div>

        </div>

    </form:form>

</div>

<script type="text/javascript" src="/resources/js/user.js"></script>

<%@ include file="patterns/footer.jsp"%>
