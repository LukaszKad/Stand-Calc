<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="patterns/header.jsp"%>


<div class="container">
    <div class="card">
        <div class="card-body">
            <h4 class="font-weight-bold">Twoja Wycena Stoiska</h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">L.P.</th>
                    <th scope="col">Element</th>
                    <th scope="col">Ilość</th>
                    <th scope="col">Jednostka</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${standCartService}" varStatus="counter">
                    <tr>
                        <td><c:out value="${counter.count}"/></td>
                        <td>${element.standElements.element}</td>
                        <td>${element.quantity}</td>
                        <td>${element.standElements.type}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div>
                Ilość elementów stoiska: <strong> ${items} </strong>
                <br>
                Wycena projektu:
                <span><h3><strong>${total} zł</strong></h3></span>
            </div>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <a href="/user/panel" class="btn btn-dark">Cofnij</a>
            <a href="/user/panel/details/email" class="btn btn-dark">Wyślij na e-mail</a>
        </div>
    </div>
</div>

<%@ include file="patterns/footer.jsp"%>
