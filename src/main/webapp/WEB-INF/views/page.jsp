<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ferrovia</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/grid.css">
    <link rel="stylesheet" href="resources/css/menu.css">
    <link rel="stylesheet" href="resources/css/form.css">
    <link rel="stylesheet" href="resources/css/table.css">
    <link rel="stylesheet" href="resources/css/car.css">
    <link rel="stylesheet" href="resources/css/ticket.css">

    <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="resources/css/date.css">
    <script src="resources/js/jquery-3.2.1.js"></script>
    <script src="resources/js/jquery-ui.js"></script>
    <script src="resources/js/date.js"></script>
</head>
<body>

<div class="container">
    <div class="resp_info">

    </div>

    <div class="row header_row">
        <header>
            <div class="cols col-5">
                <div class="com">
                    <div class="name">
                        <img src="resources/images/train.svg" style="margin-left:10px; margin-right:5px;" alt="train">Ferrovia
                    </div>
                </div>
            </div>
            <div class="cols col-8">
                <ul class="menu-ul user_menu">
                    <li class="menu-li" id="change"><a id="schedule" class="menu-a" href="#schedule">
                        <img src="resources/images/image-orange.svg" style="transform: translateY(4px)">
                        Расписание</a></li>
                    <div class="admin_menu">

                    </div>
                </ul>
            </div>
            <div class="cols col-3">
                <div class="account_button">
                    <div class="user_icon">
                        <svg version="1.1" viewBox="0 0 482.9 482.9" width="2em" height="2em"
                             transform="translate(0, 8)">
                            <g>
                                <path d="M239.7,260.2c0.5,0,1,0,1.6,0c0.2,0,0.4,0,0.6,0c0.3,0,0.7,0,1,0c29.3-0.5,53-10.8,70.5-30.5    c38.5-43.4,32.1-117.8,31.4-124.9c-2.5-53.3-27.7-78.8-48.5-90.7C280.8,5.2,262.7,0.4,242.5,0h-0.7c-0.1,0-0.3,0-0.4,0h-0.6    c-11.1,0-32.9,1.8-53.8,13.7c-21,11.9-46.6,37.4-49.1,91.1c-0.7,7.1-7.1,81.5,31.4,124.9C186.7,249.4,210.4,259.7,239.7,260.2z     M164.6,107.3c0-0.3,0.1-0.6,0.1-0.8c3.3-71.7,54.2-79.4,76-79.4h0.4c0.2,0,0.5,0,0.8,0c27,0.6,72.9,11.6,76,79.4    c0,0.3,0,0.6,0.1,0.8c0.1,0.7,7.1,68.7-24.7,104.5c-12.6,14.2-29.4,21.2-51.5,21.4c-0.2,0-0.3,0-0.5,0l0,0c-0.2,0-0.3,0-0.5,0    c-22-0.2-38.9-7.2-51.4-21.4C157.7,176.2,164.5,107.9,164.6,107.3z"
                                      fill="#ff9308"></path>
                                <path d="M446.8,383.6c0-0.1,0-0.2,0-0.3c0-0.8-0.1-1.6-0.1-2.5c-0.6-19.8-1.9-66.1-45.3-80.9c-0.3-0.1-0.7-0.2-1-0.3    c-45.1-11.5-82.6-37.5-83-37.8c-6.1-4.3-14.5-2.8-18.8,3.3c-4.3,6.1-2.8,14.5,3.3,18.8c1.7,1.2,41.5,28.9,91.3,41.7    c23.3,8.3,25.9,33.2,26.6,56c0,0.9,0,1.7,0.1,2.5c0.1,9-0.5,22.9-2.1,30.9c-16.2,9.2-79.7,41-176.3,41    c-96.2,0-160.1-31.9-176.4-41.1c-1.6-8-2.3-21.9-2.1-30.9c0-0.8,0.1-1.6,0.1-2.5c0.7-22.8,3.3-47.7,26.6-56    c49.8-12.8,89.6-40.6,91.3-41.7c6.1-4.3,7.6-12.7,3.3-18.8c-4.3-6.1-12.7-7.6-18.8-3.3c-0.4,0.3-37.7,26.3-83,37.8    c-0.4,0.1-0.7,0.2-1,0.3c-43.4,14.9-44.7,61.2-45.3,80.9c0,0.9,0,1.7-0.1,2.5c0,0.1,0,0.2,0,0.3c-0.1,5.2-0.2,31.9,5.1,45.3    c1,2.6,2.8,4.8,5.2,6.3c3,2,74.9,47.8,195.2,47.8s192.2-45.9,195.2-47.8c2.3-1.5,4.2-3.7,5.2-6.3    C447,415.5,446.9,388.8,446.8,383.6z"
                                      fill="#ff9308"></path>
                            </g>
                        </svg>
                    </div>
                    <div class="user_name">
                        <c:choose>
                            <c:when test="${userJSP.email == null}">
                                Регистрация | Вход
                            </c:when>
                            <c:otherwise>
                                ${userJSP.first_name} ${userJSP.last_name.charAt(0)}.
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </header>
    </div>

    <div class="row content_row">
        <%@include file="user_ticket_search.jsp" %>
    </div>

    <div class="row footer_row">
        <footer>
            <div class="cols col-16">
                <svg version="1.1" width="3.5em" height="3.5em"
                     viewBox="0 0 486.208 486.208" transform="translate(0, -5)">
                    <g>
                        <path d="M478.996,219.227l-186.039-54l33.976-41.794h20.909c-1.057,4.382,0.97,9.078,5.155,11.229                          c1.464,0.751,3.023,1.107,4.562,1.107c3.629,0,7.131-1.982,8.902-5.433L367.66,128c3.096-6.024,3.14-12.313,0.122-17.254
                         c-2.839-4.648-7.896-7.314-13.881-7.314h-70.334c-9.332,0-19.438,6.49-24.031,15.432c-2.521,4.913-0.586,10.941,4.327,13.464
                         c4.912,2.523,10.94,0.585,13.464-4.327c1.249-2.433,4.773-4.568,6.24-4.568h17.59l-29.163,35.874
                         c-10.458-2.757-20.439-5.074-28.518-6.897c-3.374-0.762-13.447-2.201-27.428-2.201c-22.11,0-55.843,3.574-90.966,20.605
                         c-47.539,23.053-81.532,72.511-93.938,92.705l-1.235,2.008c-9.854,16.021-20.043,32.589-26.492,51.212
                         c-9.362,27.034,0.787,49.428,27.151,59.903c10.391,4.127,22.286,6.133,36.365,6.133c0.886,0,1.769-0.008,2.65-0.022
                         c25.103-0.407,45.408-1.243,63.906-2.631c24.284-1.819,45.493-5.592,64.835-11.528c63.577-19.513,123.852-40.978,196.038-67.013
                         c18.592-6.705,37.459-13.596,55.704-20.259c8.702-3.178,26.347-9.606,26.466-9.646c8.448-2.771,9.691-9.125,9.67-12.71
                         l0.005-30.134C486.209,224.381,483.269,220.467,478.996,219.227z
                         M466.204,254.143c-7.666,2.794-15.331,5.593-22.996,8.394
                         c-18.228,6.655-37.073,13.539-55.629,20.229c-71.93,25.942-131.972,47.325-195.121,66.707
                         c-17.901,5.495-37.681,8.997-60.462,10.704c-9.59,0.719-19.705,1.285-30.762,1.721c13.622-16.564,17.65-30.611,12.3-42.622
                         c-6.312-14.161-24.358-22.08-55.173-24.212c-8.126-0.562-15.976-0.628-22.547-0.501l9.587-15.297l12.016,2.114
                         c0.012,0.002,30.817,5.72,56.973,0.023c17.027-3.708,29.321-15.854,36.742-22.787c0.555-0.518,59.173-54.847,58.674-68.417
                         c-0.146-3.929-1.743-7.445-4.665-9.894c-3.492-2.928-9.56-5.814-26.588-6.409c14.399-2.848,27.31-3.688,37.497-3.688
                         c12.823,0,21.424,1.349,23.023,1.71c10.567,2.386,24.461,5.632,38.183,9.577l165.853,48.14l-189.004-4.362
                         c-0.06-0.004-0.116-0.006-0.174-0.006c-43.828,0-79.896,50.9-81.411,53.066c-0.571,0.819-0.603,1.899-0.076,2.748
                         c0.46,0.744,1.269,1.186,2.125,1.186c0.122,0,0.245-0.01,0.369-0.027l291.27-37.103L466.204,254.143z"
                              fill="#444"></path>
                    </g>
                </svg>
            </div>
        </footer>
    </div>

</div>
<script>
    $(".account_button").click(function () {
        $.ajax({
            url: "user",
            type: "post",
            success: function (response) {
                $(".account_page").html(response).toggle("slide", {
                    direction: "left"
                }, 500);
            }
        });
    })
</script>
</body>
</html>