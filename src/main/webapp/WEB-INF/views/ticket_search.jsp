<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="cols col-5 search_result">
    <form action="/ferrovia/search/result" id="form_search_ticket">
        <div class="search_header">
            <div class="win sea sea_search">
                <div class="cols col-7">
                    <input class="input_search input_search_from" name="from" id="station_f"
                           placeholder="Откуда...">
                </div>
                <div class="cols col-2">
                    <div class="train_image">
                    </div>
                </div>
                <div class="cols col-7">
                    <input class="input_search input_search_to" name="to" id="station_t" placeholder="Куда...">
                </div>
            </div>
        </div>
        <div class="date_departure">
            <div class="win dat">
                <div class="cols col-5">
                    <input class="input_date input_date_from" id="from" name="from_date" placeholder="С...">
                </div>
                <div class="cols col-5">
                    <input class="input_date input_date_to" id="to" name="to_date" placeholder="По...">
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

    </div>
</div>

<div class="cols col-11 content">1</div>


<script>
    $.ajax({
        url: "/ferrovia/search/avtocomplete",
        type: "post",
        success: function (response) {
            $("#station_f, #station_t").autocomplete({source: response});
        }
    });

    $("#form-ticket").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: "/ferrovia/search/result",
            type: "post",
            data: form.serialize(),
            success: function (response) {
                $('#result_search_list').html(response)
            }
        });
    });

    $("#form_search_ticket").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: "/ferrovia/search/result",
            type: "post",
            data: form.serialize(),
            success: function (response) {
                $('#result_search_list').html(response)
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

    $("#schedule").click(function () {
        $.ajax({
            url: "/ferrovia/schedule",
            type: "post",
            success: function (response) {
                $(".menu-ul").html('<li class="menu-li"><a id="ticket_search" class="menu-a" href="#ticket_search"> <img src="resources/images/schedule-orange.svg" style="transform: translateY(4px)"> Поиск Билетов</a></li>');
                $(".content_row").html(response);
            }
        });
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