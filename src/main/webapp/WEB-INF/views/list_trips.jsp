<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<table>
    <tr>
        <th class="th-th-number">&#8470</th>
        <th>Направление</th>
        <th>Поезд</th>
        <th>Дата</th>
    </tr>
    <c:forEach items="${tripList}" var="call" varStatus="i">
        <tr class="tr-data" id="${call.id}">
            <th>${i.count}</th>
            <td class="td-station-name">${call.name}</td>
            <td class="td-station-data">${call.train}</td>
            <td class="td-station-data"><calendar:formatDate value="${call.date}" pattern="dd.MM.yyyy HH:mm"/></td>
        </tr>
        <tr>
            <td colspan="4" class="car_info ${call.id}"></td>
        </tr>
    </c:forEach>
</table>
<script>
    $(".tr-data").click(function () {
        var i = $(this).attr('id');
        $(".car_info").hide();
        $.ajax({
            url: "ticket/get/ticket_info",
            type: "post",
            data: {"id": i},
            success: function (response) {
                $('.' + i).html(response).show();
            }
        });

    })
</script>
