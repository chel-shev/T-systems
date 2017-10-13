<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="cols col-5 search_result">
    <form action="schedule/result" id="form_schedule">
        <div class="search_header">
            <div class="win sea sea_schedule">
                <div class="cols col-16">
                    <input class="form-ticket-input" name="station" id="station_f" placeholder="Станция" required/>
                </div>
            </div>
        </div>
        <div class="date_departure">
            <div class="win dat">
                <div class="cols col-5">
                    <input class="input_date input_date_from" id="from" type="text" name="from_date" value=""
                           placeholder="C..." required>
                </div>
                <div class="cols col-6">
                    <input class="button_search" type="submit" value="ПОИСК">
                </div>
                <div class="cols col-5">
                    <input class="input_date input_date_to" id="to" type="text" name="to_date" placeholder="По..."
                           required>
                </div>
            </div>
        </div>
    </form>
    <div class="account_page">
    </div>

    <div class="result_search_list" id="result_schedule">
    </div>
</div>
<div class="cols col-11 content">1</div>

<script>
    $.ajax({
        url: "search/autocomplete",
        type: "post",
        success: function (response) {
            $("#station_f").autocomplete({source: response});
        }
    });

    $("#form_schedule").submit(function (e) {
        e.preventDefault();
        var form = $(this);
        $.ajax({
            url: "schedule/result",
            type: "post",
            data: form.serialize(),
            success: function (response) {
                $('#result_schedule').html(response)
            }
        });
    });

    $("#ticket_search").click(function () {
        $.ajax({
            url: "ticket",
            type: "post",
            success: function (response) {
                $("#change").html('<a id="schedule" class="menu-a" href="#schedule"> <img src="resources/images/image-orange.svg" style="transform: translateY(4px)"> Расписание</a>');
                $(".content_row").html(response);
                $(".resp_info").text("\u041F\u043E\u0438\u0441\u043A\u0020\u0431\u0438\u043B\u0435\u0442\u043E\u0432\u002E")
                    .fadeIn(1000);
                setTimeout(function () {
                    $(".resp_info").fadeOut(1000);
                }, 4000);
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
</script>