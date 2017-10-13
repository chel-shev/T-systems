<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table>


    <c:forEach items="${lineList}" var="call" varStatus="i">
        <thead>
        <tr>
            <th class="th-th-number">${i.count}</th>
            <th class="th-line">${call.name}</th>
        </tr>
        </thead>
        <tbody>
        <tr class="tr-data">
            <td class="td-line-name" colspan="2">
                <c:forEach items="${call.trips}" var="call_1" varStatus="i">
                    <c:choose>
                        <c:when test="${i.count == 1}">
                            <div class="first_station">${call_1}</div>
                            <div class="dash"> —</div>
                        </c:when>
                        <c:when test="${i.last}">
                            <div class="last_station">${call_1}</div>
                        </c:when>
                        <c:otherwise>
                            <div class="next_station">${call_1}</div>
                            <div class="dash"> —</div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
        </tbody>
    </c:forEach>
</table>

