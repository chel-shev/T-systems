<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="account">
    <div class="account_title">ЛИЧНЫЙ КАБИНЕТ</div>
    <br><br>
    Имя:
    <div class="account_first_name">${userJSP.first_name}<br></div>
    Фамилия:
    <div class="account_last_name">${userJSP.last_name}<br></div>
    День рождения:
    <div class="account_birthday"><calendar:formatDate value="${userJSP.birthday}" pattern="dd.MM.yyyy"/><br></div>
    Почта:
    <div class="account_email">${userJSP.email}<br></div>
    Билеты:
    <!--Список билетов-->
    <div class="account_ticket">

    </div>

    <div class="menu-account">
        <ul class="menu-login-ul">
            <li class="menu-login-li"><a id="up" class="menu-login-a" href="#">НАЗАД</a></li>
            <li class="menu-login-li"><a id="logout" class="menu-login-a" href="#">ВЫЙТИ</a></li>
        </ul>
    </div>
</div>

<script>
    <%@include file="../../resources/js/account.js"%>
</script>