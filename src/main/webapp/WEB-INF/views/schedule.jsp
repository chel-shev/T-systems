<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="cols col-5 search_result">
    <form action="" class="form_search">
        <div class="search_header">
            <div class="win sea sea_schedule">
                <div class="cols col-16">
                    <input class="form-ticket-input" name="station" id="station_f" placeholder="Станция"/>
                </div>
            </div>
        </div>
        <div class="date_departure">
            <div class="win dat">
                <div class="cols col-5">
                    <input class="input_date input_date_from" id="from" type="text" value=""
                           placeholder="C...">
                </div>
                <div class="cols col-5">
                    <input class="input_date input_date_to" id="to" type="text" placeholder="По...">
                </div>
                <div class="cols col-6">
                    <input class="button_search" type="submit" value="ПОИСК">
                </div>
            </div>
        </div>
    </form>
    <div class="account_page">

    </div>

    <!--Список поиска-->
    <div class="result_search_list" id="result_search_list">
        <div class="result_search">
            <div class="cols col-7 result_from">
                <div class="station_from">
                    Великий Новгород
                </div>
                <div class="dep_time">
                    12.02.2016 15:00
                </div>
            </div>
            <div class="cols col-7 result_to">
                <div class="station_to">
                    Санкт-Петербург
                </div>
                <div class="arr_time">
                    12.02.2016 22:00
                </div>
            </div>
            <div class="col-14 route_info">

            </div>
            <div class="cols col-2 bay">
                <div class="bay_info">

                    КУПИТЬ
                </div>
            </div>
        </div>
    </div>
</div>
<div class="cols col-11 content">1</div>

<script>
    $.ajax({
        url: "/ferrovia/search/avtocomplete",
        type: "post",
        success: function (response) {
            $("#station_f").autocomplete({source: response});
        }
    });

    $("#form_search").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: "/ferrovia/schedule/result",
            type: "post",
            data: form.serialize(),
            success: function (response) {
                $('#result_search_list').html(response)
            }
        });
    });

    $("#ticket_search").click(function () {
        $.ajax({
            url: "/ferrovia/ticket",
            type: "post",
            success: function (response) {
                $(".menu-ul").html('<li class="menu-li"><a id="schedule" class="menu-a" href="#schedule"> <img src="resources/images/image-orange.svg" style="transform: translateY(4px)"> Расписание</a></li>');
                $(".content_row").html(response)
            }
        });
    });

    var dates = $("#from, #to").datepicker({
        defaultDate: "+1w",
        dateFormat: "yy-mm-dd",
        minDate: 0,
        maxDate: "+1M +15D",
        onSelect: function (selectedDate) {
            var option = this.id === "from" ? "minDate" : "maxDate",
                instance = $(this).data("datepicker"),
                date = $.datepicker.parseDate(
                    instance.settings.dateFormat || $.datepicker._defaults.dateFormat,
                    selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
        }
    });

    $(".account_button").click(function () {
        $.ajax({
            url: "/ferrovia/user",
            type: "post",
            success: function (response) {
                $(".account_page").html(response).slideToggle(1500);
            }
        });
    })
</script>