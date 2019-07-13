<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="patterns/header.jsp"%>
<div style="text-align: center; padding-top: 5vh; padding-bottom: 5vh">
    <h2>Wyceń swój projekt</h2>
</div>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th class="py-3">L.P.</th>
        <th class="py-3">Nazwa Elementu</th>
        <th class="py-3">Opis elementu</th>
        <th class="py-3">Action</th>
    </tr>
    </thead>
    <form:form method="get" modelAttribute="standElements">
        <c:forEach var="stand" items="${standElements}" varStatus="counter">
            <tr>
                <td>
                    <input name="id" type="hidden" value="${stand.id}">
                    <c:out value="${counter.count}"/>
                </td>
                <td>${stand.element}</td>
                <td>${stand.description}</td>
                <td>
                    <a href="/user/advanced/addtostand/${stand.id}" class="btn btn-dark">Dodaj do wyceny</a>
                </td>
            </tr>
        </c:forEach>
    </form:form>
</table>
<span><a href="/user/advanced/stand" class="btn btn-dark btn-lg">Wycena</a></span>
</div>

<%@include file="patterns/footer.jsp"%>
