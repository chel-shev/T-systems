<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${searchList != null}">

        <c:forEach items="${searchList}" var="call" varStatus="i">
            <div class="result_search">
                <div class="cols col-7 result_from">
                    <div class="station_from">
                            ${call.from}
                    </div>
                    <div class="dep_time">
                            ${call.to}
                    </div>
                </div>
                <div class="cols col-7 result_to">
                    <div class="station_to">
                        <calendar:formatDate value="${call.date}" pattern="dd.MM.yyyy HH:mm"/>
                    </div>
                    <div class="arr_time">
                        <calendar:formatDate value="${call.date}" pattern="dd.MM.yyyy HH:mm"/>
                    </div>
                </div>
                <div class="col-14 route_info">
                        ${call.atomicTravel}, ${call.train};
                </div>
                <div class="cols col-2 bay">
                    <div class="bay_info">

                        КУПИТЬ
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        На данное время поездов по этому направлению нет.
    </c:otherwise>
</c:choose>

<script>
    function send(obj) {
        $.ajax({
            url: '/ferrovia/ticket/buy',
            type: 'post',
            data: {"id": obj.id},
            success: function (response) {
                $('.content').html(response)
            }
        });
    }
</script>