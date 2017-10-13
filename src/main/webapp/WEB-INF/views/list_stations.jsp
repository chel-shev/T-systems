<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table>
    <thead>
    <tr>
        <th class="th-th-number">&#8470</th>
        <th class="th-station">Название</th>
        <th class="th-station">Широта</th>
        <th class="th-station">Долгота</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${statList}" var="call" varStatus="i">
        <tr class="tr-data">
            <th class="th-number">${i.count}</th>
            <td class="td-station-name">${call.name}</td>
            <td class="td-station-data">${call.latitude}</td>
            <td class="td-station-data">${call.longitude}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>