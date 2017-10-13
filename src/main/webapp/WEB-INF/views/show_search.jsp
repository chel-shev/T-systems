<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:forEach items="${searchList}" var="call" varStatus="i">
    <div class="result_search">
        <div class="cols col-7 result_from">
            <div class="station_from">
                    ${call.from}
            </div>
            <div class="dep_time">
                <calendar:formatDate value="${call.date_from}" pattern="dd.MM.yyyy HH:mm"/>
            </div>
        </div>
        <div class="cols col-7 result_to">
            <div class="station_to">
                    ${call.to}
            </div>
            <div class="arr_time">
                <calendar:formatDate value="${call.date_to}" pattern="dd.MM.yyyy HH:mm"/>
            </div>
        </div>
        <div class="col-14 route_info">
            Маршрут: ${call.atomicTravel}.<br>
            Поезд: ${call.train}.
        </div>
        <div class="cols col-2 buy">
            <div class="bay_info" id="${call.id}">

                ВЫБОР
            </div>
            <script>
                $(".bay_info").click(function () {
                    $.ajax({
                        url: "ticket/list",
                        type: "post",
                        data: {"id": this.id},
                        success: function (response) {
                            $('.content').html(response)
                        }
                    });
                });
            </script>
        </div>
    </div>
</c:forEach>

