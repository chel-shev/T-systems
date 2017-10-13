$('#add_line').click(function () {
    $.ajax({
        url: 'line/new',
        type: 'post',
        success: function (response) {
            $('.account_page')
                .html(response)
                .show();
        }
    });
    $.ajax({
        url: 'line/list',
        type: 'post',
        success: function (response) {
            $('.content')
                .html(response)
                .show();
        }
    });
});

$("#add_trips").click(function () {
    $.ajax({
        url: 'trip/new',
        type: 'post',
        success: function (response) {
            $('.account_page')
                .html(response)
                .show();
        }
    });
    $.ajax({
        url: 'trip/list',
        type: 'post',
        success: function (response) {
            $('.content')
                .html(response)
                .show();
        }
    });
});

$("#add_train").click(function () {
    $.ajax({
        url: 'train/new',
        type: 'post',
        success: function (response) {
            $('.account_page')
                .html(response)
                .show();
        }
    });
    $.ajax({
        url: 'train/list',
        type: 'post',
        success: function (response) {
            $('.content')
                .html(response)
                .show();
        }
    });
});

$("#add_station").click(function () {
    $.ajax({
        url: 'station/new',
        type: 'post',
        success: function (response) {
            $('.account_page')
                .html(response)
                .show();
        }
    });
    $.ajax({
        url: 'station/list',
        type: 'post',
        success: function (response) {
            $('.content')
                .html(response)
                .show();
        }
    });
});

$("#trips").click(function () {
    $.ajax({
        url: 'trip/view',
        type: 'post',
        success: function (response) {
            $('.account_page')
                .html(response)
                .show();
        }
    });
    $.ajax({
        url: 'trip/list',
        type: 'post',
        success: function (response) {
            $('.content')
                .html(response)
                .show();
        }
    });
});