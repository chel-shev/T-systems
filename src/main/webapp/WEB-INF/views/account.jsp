<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="account">
    <div class="account_title">ЛИЧНЫЙ КАБИНЕТ</div>
    <br>
    Имя:
    <div class="account_first_name">${userJSP.first_name}<br></div>
    Фамилия:
    <div class="account_last_name">${userJSP.last_name}<br></div>
    День рождения:
    <div class="account_birthday"><calendar:formatDate value="${userJSP.birthday}" pattern="dd.MM.yyyy"/><br></div>
    Почта:
    <div class="account_email">${userJSP.email}<br></div>
    <div class="account_ticket">Билеты:</div>
    <!--Список билетов-->
    <c:choose>
        <c:when test="${userJSP.role == 'USER'}">

        </c:when>
        <c:otherwise>
            <div class="admin">Администрирование:</div>
        </c:otherwise>
    </c:choose>


    <div class="menu-account">
        <ul class="menu-login-ul">
            <li class="menu-login-li"><a id="up" class="menu-login-a" href="#">НАЗАД</a></li>
            <li class="menu-login-li"><a id="logout" class="menu-login-a" href="#">ВЫЙТИ</a></li>
        </ul>
    </div>
</div>

<script>
    $("#logout").click(function () {
        $.ajax({
            url: 'user/logout',
            type: 'post',
            success: function (response) {
                $('.account_page').html(response).show();
                $('.user_name').text("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F\u0020\u007C\u0020\u0412\u0445\u043E\u0434");
                $(".resp_info").text("\u0412\u044B\u0020\u0432\u044B\u0448\u043B\u0438\u0020\u0438\u0437\u0020\u043B\u0438\u0447\u043D\u043E\u0433\u043E\u0020\u043A\u0430\u0431\u0438\u043D\u0435\u0442\u0430\u0021")
                    .fadeIn(1000);
                setTimeout(function () {
                    $(".resp_info").fadeOut(1000);
                }, 4000);
            }
        });
    });

    $("#up").click(function () {
        $(".account_page").toggle("slide", {
            direction: "left"
        }, 500);
    });

    $(".account_ticket").click(function () {
        $.ajax({
            url: 'ticket/get',
            type: 'post',
            success: function (response) {
                $('.content').html(response)
                    .show();
            }
        });
    });

    $(".admin").click(function () {
        $.ajax({
            url: 'user/menu',
            type: 'post',
            success: function (response) {
                $(".admin_menu").html(response).fadeToggle(1100);
            }
        });
    });
</script>