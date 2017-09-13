<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="account_enter">
    <div class="menu-login">
        <ul class="menu-login-ul">
            <li class="menu-login-li"><a class="menu-login-a" href="#sign-in" id="sign-in">Вход</a></li>
            <li class="menu-login-li"><a class="menu-login-a" href="#sign-up"
                                         id="sign-up">Регистрация</a></li>
        </ul>
    </div>
    <div class="sign-in">
        <form id="submit-in" action="/ferrovia/user/sing_in" method="post">
            <div class="form-header">
                <input type="email" class="form-input" name="email_in" id="email_in"
                       placeholder="Электронная почта"/><br>
                <input type="password" class="form-input" name="password_in" id="password_in"
                       placeholder="Пароль"/>
            </div>
            <input type="submit" class="form-submit" value="Войти">
        </form>
    </div>
    <div class="sign-up">
        <form id="submit-up" action="/ferrovia/user/sing_up" method="post">
            <div class="form-header">
                <input type="text" class="form-input" name="first_name_up" id="first_name_up" placeholder="Имя"/>
                <input type="text" class="form-input" name="last_name_up" id="last_name_up" placeholder="Фамилия"/>
                <input type="email" class="form-input" name="email_up" id="email_up"
                       placeholder="Электронная почта"/>
                <input type="text" class="form-input" name="date_up" id="date_up"
                       placeholder="День Рождения"/>
                <input type="password" class="form-input" name="password_up" id="password_up"
                       placeholder="Пароль"/>
                <input type="password" class="form-input" name="repeat_password_up"
                       id="repeat_password_up" placeholder="Повторите пароль"/>
            </div>
            <input type="submit" class="form-submit" value="Зарегистрироваться">
        </form>
    </div>
    <div class="message">
    </div>
</div>
<script>
    $("#sign-up").click(function () {
        $(".sign-in").fadeOut(0);
        $(".sign-up").fadeIn(1000);
    });
    $("#sign-in").click(function () {
        $(".sign-up").fadeOut(0);
        $(".sign-in").fadeIn(1000);
    });
    var dates = $("#date_up").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: 0,
    });
    <%@include file="../../resources/js/history/send_in.js"%>
    <%@include file="../../resources/js/history/send_up.js"%>
</script>
