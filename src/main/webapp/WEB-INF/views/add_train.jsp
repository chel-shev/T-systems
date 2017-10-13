<%@ page contentType="text/html;charset=UTF-8" %>

<div class="account_enter">
    <div class="account_title">ДОБАВИТЬ ПОЕЗД</div>
    <div class="sing-in">
        <form id="form-train" action="train/add" method="post">
            <div class="form-station-header">
                <input class="form-input" name="name" id="name" required
                       placeholder="Название"/><br>
                <input class="form-input" type="number" name="seats" id="seats" required
                       placeholder="Количество вагонов" max="24" min="1"/>
            </div>
            <input class="form-submit" id="train-submit" type="submit" value="Добавить">
            <div id="response-train"></div>
        </form>
    </div>
</div>
<script>
    $("#form-train").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: 'train/add',
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
                    $(".resp_info").text("\u041F\u043E\u0435\u0437\u0434\u0020\u0443\u0441\u043F\u0435\u0448\u043D\u043E\u0020\u0434\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0020\u003A\u0029")
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