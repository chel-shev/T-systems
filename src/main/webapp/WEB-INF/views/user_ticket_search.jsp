<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="cols col-5 search_result">
    <form action="search/result" id="form_search_ticket">
        <div class="search_header">
            <div class="win sea sea_search">
                <div class="cols col-7">
                    <input class="input_search input_search_from" name="from" id="station_f"
                           placeholder="Откуда..." required>
                </div>
                <div class="cols col-2">
                    <div class="train_image">
                    </div>
                </div>
                <div class="cols col-7">
                    <input class="input_search input_search_to" name="to" id="station_t" placeholder="Куда..." required>
                </div>
            </div>
        </div>
        <div class="date_departure">
            <div class="win dat">
                <div class="cols col-5">
                    <input class="input_date input_date_from" id="from" name="from_date" placeholder="С..." required>
                </div>
                <div class="cols col-6">
                    <input class="button_search" type="submit" value="ПОИСК">
                </div>
                <div class="cols col-5">
                    <input class="input_date input_date_to" id="to" name="to_date" placeholder="По..." required>
                </div>
            </div>
        </div>
    </form>
    <div class="account_page">
    </div>

    <div class="result_search_list" id="result_search_list">
    </div>
</div>
<div class="cols col-11 content"></div>


<script>
    $.ajax({
        url: "search/autocomplete",
        type: "post",
        success: function (response) {
            $("#station_f, #station_t").autocomplete({source: response});
        }
    });

    $("#form_search_ticket").submit(function (e) {
        $(".resp_info").text("\u0418\u0449\u0435\u043C\u002E\u002E\u002E")
            .fadeIn(1000);
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: "search/result",
            type: "post",
            data: form.serialize(),
            success: function (response) {
                if (String(response).replace(/\s+/g, ' ') === " ") {
                    $(".resp_info").text("\u0411\u0438\u043B\u0435\u0442\u043E\u0432\u0020\u043F\u043E\u0020\u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u043C\u0020\u043F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u0430\u043C\u0020\u043D\u0435\u0442\u0021")
                        .fadeIn(1000);
                    setTimeout(function () {
                        $(".resp_info").fadeOut(1000);
                    }, 4000);
                    $('#result_search_list').html(response);
                } else {
                    $('#result_search_list').html(response);
                    setTimeout(function () {
                        $(".resp_info").fadeOut(1000);
                    }, 0);
                }
            }
        });
    });

    var dates = $("#from, #to").datepicker({
        defaultDate: "+1w",
        dateFormat: "yy-mm-dd",
        minDate: 0,
        maxDate: "+1M +15D",
        showOtherMonths: true,
        selectOtherMonths: true,
        onSelect: function (selectedDate) {
            var option = this.id === "from" ? "minDate" : "maxDate",
                instance = $(this).data("datepicker"),
                date = $.datepicker.parseDate(
                    instance.settings.dateFormat || $.datepicker._defaults.dateFormat,
                    selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
        }
    });

    $("#schedule").click(function () {
        $.ajax({
            url: "schedule",
            type: "post",
            success: function (response) {
                $("#change").html('<a id="ticket_search" class="menu-a" href="#ticket_search"> <img src="resources/images/schedule-orange.svg" style="transform: translateY(4px)"> Поиск Билетов</a>');
                $(".content_row").html(response);
                $(".resp_info").text("\u0420\u0430\u0441\u043F\u0438\u0441\u0430\u043D\u0438\u0435\u002E")
                    .fadeIn(1000);
                setTimeout(function () {
                    $(".resp_info").fadeOut(1000);
                }, 4000);
            }
        });
    });
</script>