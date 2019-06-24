<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/patterns/header.jsp"%>

<form method="post">

    <div class="container">

        <header>
            <h2>Zaloguj się</h2>
        </header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="usernameId">Username:</label>
                    <input type="text" name="username" id="usernameId" class="form-control">
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <input type="password" name="password" id="passwordId" class="form-control">
                </div>

                <c:if test="${isLogged == false}">
                    <div class="error">Login failed</div><br><br>
                </c:if>

                <input type="submit" value="Login" class="btn btn-dark">

                <a href="/add" class="btn btn-dark">Rejestracja</a>
                <br><br>
                <a href="/home" class="btn btn-outline-dark">Powrót</a>

            </div>
        </div>

    </div>

</form>

<%@ include file="/WEB-INF/views/patterns/footer.jsp"%>