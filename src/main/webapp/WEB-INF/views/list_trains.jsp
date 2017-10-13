<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <thead>
    <tr>
        <th class="th-th-number">&#8470</th>
        <th>Название</th>
        <th>Количество Вагонов</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${trainList}" var="call" varStatus="i">
        <tr class="tr-data">
            <th class="th-number">${i.count}</th>
            <td class="td-train-name">${call.name}</td>
            <td class="td-train-data">${call.sits_count}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>