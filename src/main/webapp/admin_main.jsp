<%--
  Created by IntelliJ IDEA.
  User: Alex Kukushkin
  Date: 10/10/2017
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Управление системой</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="admin_css/css/bootstrap.min.css" rel="stylesheet">
    <link href="admin_css/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
          rel="stylesheet">
    <link href="admin_css/css/font-awesome.css" rel="stylesheet">
    <link href="admin_css/css/style.css" rel="stylesheet">
    <link href="admin_css/css/pages/dashboard.css" rel="stylesheet">
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-fixed-top">
    <form class="navbar-inner" method="post">
        <div class="navbar-inner">
            <div class="container"><a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a
                    class="brand" href="registration3.jsp">ADMIN DASHBOARD </a>
                <div class="nav-collapse">
                    <ul class="nav pull-right">
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="icon-cog"></i> Аккаунт <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="javascript:;">Настройки</a></li>
                                <li><a href="javascript:;">Помощь</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="icon-user"></i>Личный кабинет<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="javascript:;">Профиль</a></li>
                                <button name="exit" class="btn btn-sm btn-success btn-block" formaction="/web/admin_main" value="exit" type="submit">
                                    Выход
                                </button>
                            </ul>
                        </li>
                    </ul>
                    <%--<form class="navbar-search pull-right">--%>
                    <%--</form>--%>
                </div>
                <!--/.nav-collapse -->
            </div>
            <!-- /container -->
        </div>
        <!-- /navbar-inner -->
</div>
<!-- /navbar -->
<div class="subnavbar">
    <div class="subnavbar-inner">
        <div class="container">
            <ul class="mainnav">
                <li class="active"><a href="registration3.jsp"><i
                        class="icon-dashboard"></i><span>База пользователей</span> </a></li>
                <li><a href="reports.html"><i class="icon-list-alt"></i><span>Отчёты</span> </a></li>
            </ul>
        </div>
        <!-- /container -->
    </div>
    <!-- /subnavbar-inner -->
</div>
<!-- /subnavbar -->
<div class="main">
    <div class="main-inner">
        <div class="container">
            <div class="row">
                <div class="span6">
                    <!-- /widget -->
                    <div class="widget widget-nopad">
                        <div class="widget-header"><i class="icon-list-alt"></i>
                            <h3> Календарь</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div id='calendar'>
                            </div>
                        </div>
                        <!-- /widget-content -->
                    </div>
                    <!-- /widget -->
                </div>
                <!-- /span6 -->
                <div class="span6">
                    <div class="widget">
                        <div class="widget-header"><i class="icon-bookmark"></i>
                            <h3>Выполнить операции :</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div class="shortcuts">
                                <button type="submit" name="showPatients" value="showPatients" class="shortcut" formaction="/web/patient_list">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр базы пациентов</span>
                                </button>
                                <button type="submit" name="showUsers" value="showUsers" class="shortcut" formaction="/web/user_list">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр базы пользователей</span>
                                </button>
                                <button type="submit" name="showDoctors" value="showDoctors" class="shortcut" formaction="/web/doctor_list">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр базы врачей</span>
                                </button>
                                <button type="submit" name="showSchedule" value="showSchedule" class="shortcut" formaction="/web/doctor_schedule">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр графика работы врачей</span>
                                </button>

                                <a href="javascript:;" class="shortcut"> <i
                                        class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр МедЦентров</span>
                                </a>
                                <a href="javascript:;" class="shortcut"><i class="shortcut-icon icon-list-alt"></i><span
                                        class="shortcut-label">Список талонов</span> </a>
                            </div>
                            <!-- /shortcuts -->
                        </div>
                        <!-- /widget-content -->
                    </div>
                    <!-- /widget -->
                </div>
                <!-- /span6 -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /main-inner -->
</div>
<!-- /main -->
<div class="footer">
    <div class="footer-inner">
        <div class="container">
            <div class="row">
                <div class="span12"> &copy; 2017 alex kukushkin</div>
                <!-- /span12 -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /footer-inner -->
    </form>
</div>
<!-- /footer -->
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="admin_css/js/jquery-1.7.2.min.js"></script>
<script src="admin_css/js/excanvas.min.js"></script>
<script src="admin_css/js/chart.min.js" type="text/javascript"></script>
<script src="admin_css/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="admin_css/js/full-calendar/fullcalendar.min.js"></script>
<script src="admin_css/js/base.js"></script>
<script>

    var lineChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    //    var myLine = new Chart(document.getElementById("area-chart").getContext("2d")).Line(lineChartData);


    var barChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    $(document).ready(function () {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            select: function (start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true,
            events: [
                {
                    title: 'All Day Event',
                    start: new Date(y, m, 1)
                }
            ]
        });
    });
</script><!-- /Calendar -->
</body>
</html>
