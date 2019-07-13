<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="patterns/header.jsp"%>


<div class="container">
    <div class="card">
        <div class="card-body">
            <h4 class="font-weight-bold">Historia twoich wycen</h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">L.P.</th>
                    <th scope="col">Data</th>
                    <th scope="col">Cena projektu</th>
                    <th scope="col">Szczegóły</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="stand" items="${standCartService}" varStatus="counter">
                    <tr>
                        <td><c:out value="${counter.count}"/></td>
                        <td>${stand.date}</td>
                        <td><strong>${stand.totalSum} zł</strong></td>
                        <td><a href="/user/panel/details/${stand.id}" class="btn btn-dark btn-sm">Szczegóły</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <a href="/user/advanced" class="btn btn-dark">Nowa wycena</a>
        </div>
    </div>
</div>

<%@ include file="patterns/footer.jsp"%>
