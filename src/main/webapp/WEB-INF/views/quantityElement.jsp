<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="patterns/header.jsp" %>

<table class="table table-bordered">

    <thead class="thead-dark" style="background-color:wheat">
    <tr>
        <th>Nazwa Elementu</th>
        <th>Wybierz wielkość lub ilość elementu</th>
        <th>Jednostka elementu</th>
        <th>Action</th>
    </tr>
    </thead>
    <form:form method="get" modelAttribute="standElement" action="/user/advanced/addtostand">
        <tr>
            <td>
                <input name="id" type="hidden" value="${standElement.id}"> ${standElement.element}
            <td>
                <input name='quantity' type="number" min="1">
            </td>
            <td>
                ${standElement.type}
            </td>
            <td>
                <button type="submit" class="btn btn-dark">Dodaj</button>
            </td>
        </tr>
    </form:form>
</table>
<span><a href="/user/advanced" class="btn btn-dark">Cofnij</a></span>

<%@include file="patterns/footer.jsp" %>