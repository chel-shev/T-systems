<%@ page contentType="text/html;charset=UTF-8" %>

<div id="station-list" class="account_enter">
    <div class="account_title">ДОБАВИТЬ НАПРАВЛЕНИЕ</div>
    <div class="sing-in">
        <form id="line">
            <input class="form-input" placeholder="Станция">
        </form>
        <button class="form_add" id="add">Добавить</button>
        <button class="form_add" id="remove">Удалить</button>
        <button class="form_add" id="send">Сохранить</button>
        <div class="response_line"></div>
    </div>
</div>
<script>
    var stations;
    $.ajax({
        url: 'search/autocomplete',
        type: 'post',
        success: function (response) {
            stations = response;
            $(".form-input").autocomplete({source: stations});
        }
    });

    Array.prototype.remove = function (value) {
        var idx = this.indexOf(value);
        if (idx !== -1) {
            return this.splice(idx, 1);
        }
        return false;
    };

    var i = $(".form-input").length;
    $('#add').click(function () {
        var value = $('.form-input:last');
        if (value.val() !== '' && stations.indexOf(value.val()) !== -1) {
            value.prop("disabled", true);
            stations.remove(value.val());
            $('<div><input type="text" class="form-input"/></div>').fadeIn('slow').appendTo('#line');
            i++;
            $(".form-input").autocomplete({source: stations});
        }
    });

    $("#remove").click(function () {
        var input = $('.form-input:last');
        if (i > 1) {
            input.remove();
            var prev = $('.form-input:last');
            stations.push(prev.val());
            prev.prop("disabled", false);
            i--;
        }
    });

    $("#send").click(function () {
        var value = $('.form-input:last');
        if (value.val() !== '' && stations.indexOf(value.val()) !== -1) {
            var str = "";
            $(".form-input").each(function () {
                str = str + $(this).val() + ",";
            });
            $.ajax({
                url: 'line/add',
                type: 'post',
                data: {"line": str},
                success: function (response) {
                    $(".resp_info").text("\u041D\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0438\u0435\u0020\u0443\u0441\u043F\u0435\u0448\u043D\u043E\u0020\u0434\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u043E\u0020\u003A\u0029")
                        .fadeIn(1000);
                    setTimeout(function () {
                        $(".resp_info").fadeOut(1000);
                    }, 4000);
                    $(".content").html(response);
                }
            });
            $.ajax({
                url: 'line/new',
                type: 'post',
                success: function (response) {
                    $('.account_page')
                        .html(response)
                        .show();
                }
            });
        }
    });
</script>



