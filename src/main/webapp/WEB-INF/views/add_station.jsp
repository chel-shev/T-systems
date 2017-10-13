<%@ page contentType="text/html;charset=UTF-8" %>

<div class="account_enter">
    <div class="account_title">ДОБАВИТЬ СТАНЦИЮ</div>
    <div class="sing-in">
        <form id="form-station" action="station/add" method="post">
            <div class="form-header">
                <input class="form-input" name="name_station" id="name_station" required
                       placeholder="Название"/>
                <input class="form-input" name="latitude" id="latitude" required
                       placeholder="Широта 00,000000&deg"/>
                <input class="form-input" name="longitude" id="longitude" required
                       placeholder="Долгота 00,000000&deg"/>
            </div>
            <input class="form-submit" id="station-submit" type="submit" value="Добавить">
            <div id="response-station"></div>
        </form>
    </div>
</div>
<script>
    $("#form-station").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: 'station/add',
            type: 'post',
            data: form.serialize(),
            success: function (response) {
                if (response === '') {
                    $(".resp_info").text("\u041E\u0448\u0438\u0431\u043A\u0430\u0020\u0434\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u044F\u0020\u003A\u0028")
                        .fadeIn(1000);
                    setTimeout(function () {
                        $(".resp_info").fadeOut(1000);
                    }, 4000);
                } else {
                    $(".resp_info").text("\u0421\u0442\u0430\u043D\u0446\u0438\u044F\u0020\u0443\u0441\u043F\u0435\u0448\u043D\u043E\u0020\u0434\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0430\u0020\u003A\u0029")
                        .fadeIn(1000);
                    setTimeout(function () {
                        $(".resp_info").fadeOut(1000);
                    }, 4000);
                    $('.content').html(response)
                }
                form.trigger('reset');
            }
        });
    });
</script>