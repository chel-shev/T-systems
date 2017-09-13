<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="account_enter">
    <div class="menu-login">
        <ul class="menu-login-ul">
            <li class="menu-login-li"><a class="menu-login-a" href="#sign-in" id="sign-in">Вход</a></li>
            <li class="menu-login-li"><a class="menu-login-a" href="#sign-up" id="sign-up">Регистрация</a></li>
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

    $("#date_up").datepicker({
        dateFormat: "yy-mm-dd",
        maxDate: 0
    });

    $('#email_in, #password_in').unbind().blur(function () {
        var id = $(this).attr('id');
        var val = $(this).val();
        switch (id) {
            case 'password_in':
                if (val.length > 5) {
                    $(this).addClass('form-input--noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input--noterror').addClass('form-input--error');
                }
                break;
            case 'email_in':
                var rv_email = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
                if (val !== '' && rv_email.test(val)) {
                    $(this).addClass('form-input--noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input--noterror').addClass('form-input--error');
                }
                break;
        }
    });

    $('#submit-in').submit(function (e) {
        e.preventDefault();
        if ($('.form-input--noterror').length == 2) {
            $.ajax({
                url: '/ferrovia/user/sing_in',
                type: 'post',
                data: $(this).serialize(),
                success: function (response) {
                    if (response === "") {
                        $('.message').text('Check the correctness')
                            .show()
                            .removeClass('message--success')
                            .addClass('message--error')
                            .slideUp(5000);
                    }
                    else {
                        $('.account_page').html(response)
                            .show()
                            .removeClass('message--error')
                        var fn = $(".account_first_name").text();
                        var ln = $(".account_last_name").text();
                        $('.user_name').text(fn + " " + ln.charAt(0) + ".");
                    }
                }
            });
        }
        else {
            return false;
        }
    });

    $('#first_name_up,#last_name_up,#email_up,#password_up,#repeat_password_up').unbind().blur(function () {
        var id = $(this).attr('id');
        var val = $(this).val();
        switch (id) {
            case 'first_name_up':
                var rv_name = /^[a-zA-Zа-яА-Я]+$/;
                if (val.length > 2 && rv_name.test(val)) {
                    $(this).addClass('form-input-noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input-noterror').addClass('form-input--error');
                }
                break;
            case 'last_name_up':
                var rv_name = /^[a-zA-Zа-яА-Я]+$/;
                if (val.length > 2 && rv_name.test(val)) {
                    $(this).addClass('form-input-noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input-noterror').addClass('form-input--error');
                }
                break;
            case 'email_up':
                var rv_email = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
                var div = $(this);
                $.ajax({
                    url: '/ferrovia/user/check_email',
                    type: 'post',
                    data: {"email_up": val},
                    success: function (response) {
                        if (response === "yes") {
                            if (val !== '' && rv_email.test(val)) {
                                div.addClass('form-input-noterror').removeClass('form-input--error');
                                $('.message').html("Email is correct!")
                                    .show()
                                    .removeClass('message--error')
                                    .addClass('message--success')
                                    .slideUp(5000);
                            }
                            else {
                                div.removeClass('form-input-noterror').addClass('form-input--error');
                                $('.message').html("Email is not correct!")
                                    .show()
                                    .removeClass('message--success')
                                    .addClass('message--error');
                            }
                        } else {
                            div.removeClass('form-input-noterror').addClass('form-input--error');
                            $('.message').html("Email used!")
                                .show()
                                .removeClass('message--success')
                                .addClass('message--error');
                        }

                    }
                });
                break;
            case 'password_up':
                if (val.length > 5) {
                    $(this).addClass('form-input-noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input-noterror').addClass('form-input--error');
                }
                if (val == $('#repeat_password_up').val()) {
                    $('#repeat_password_up').addClass('form-input-noterror').removeClass('form-input--error');
                }
                else {
                    $('#repeat_password_up').removeClass('form-input-noterror').addClass('form-input--error');
                }
                break;
            case 'repeat_password_up':
                if (val == $('#password_up').val()) {
                    $(this).addClass('form-input-noterror').removeClass('form-input--error');
                }
                else {
                    $(this).removeClass('form-input-noterror').addClass('form-input--error');
                }
                break;
        }
    });

    $('#submit-up').submit(function (e) {
        e.preventDefault();
        if ($('.form-input-noterror').length == 5) {
            $.ajax({
                url: '/ferrovia/user/sing_up',
                type: 'post',
                data: $(this).serialize(),
                success: function (response) {
                    $('.account_page').html(response)
                        .show()
                        .removeClass('message--error')
                    var fn = $(".account_first_name").text();
                    var ln = $(".account_last_name").text();
                    $('.user_name').text(fn + " " + ln.charAt(0) + ".");
                }
            });
        }
        else {
            return false;
        }
    });
</script>
