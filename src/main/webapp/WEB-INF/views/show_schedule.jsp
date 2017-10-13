<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${scheduleList != null}">
        <c:forEach items="${scheduleList}" var="call" varStatus="i">
            <div class="result_search">
                <div class="cols col-8 result_from">
                    <div class="station_from">
                        ${call.station_from}
                    </div>
                    <div class="dep_time">
                        <calendar:formatDate value="${call.dateDep}" pattern="dd.MM.yyyy HH:mm"/>
                    </div>
                </div>
                <div class="cols col-8 result_to result_to_schedule">
                    <div class="station_to">
                        ${call.station_to}
                    </div>
                    <div class="arr_time">
                        <calendar:formatDate value="${call.dateIn}" pattern="dd.MM.yyyy HH:mm"/>
                    </div>
                </div>
                <div class="col-16 route_info route_info_schedule">
                    Направление: ${call.name}.<br>
                    Поезд: ${call.train}.
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        Рейсов нет!
    </c:otherwise>
</c:choose>

