<%--
  Created by IntelliJ IDEA.
  User: gou
  Date: 2019/6/14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加考勤</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../cssandjs/mycss.css" media="all">
    <link rel="stylesheet" href="../cssandjs/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../cssandjs/style/admin.css" media="all">
    <link rel="stylesheet" href="../cssandjs/style/login.css" media="all">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
</head>
<body>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>学生考勤系统</h2>
            <p>学生考勤系统-添加考勤</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <form action="addCheck" method="post">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                    <input type="text" name="studentName" id="LAY-user-login-username" lay-verify="required" placeholder="学生姓名" class="layui-input">
                    <div style="color: green" id="error">${error}</div>
                </div>
                <div class="layui-from-item">
                    <select id="selectClass" name="checkType">
                        <option value="迟到">迟到</option>
                        <option value="请假">请假</option>
                        <option value="早退">早退</option>
                        <option value="作业">作业</option>
                    </select>
                </div><br>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                    <input type="text" name="checkStatus" id="LAY-user-login-check" lay-verify="required" placeholder="考勤状况" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">添 加</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $("#LAY-user-login-username").blur(function () {
        var studentName=$("#LAY-user-login-username").val();
        $.post("nameServlet",{"studentName":studentName},function(result){
            if("1"!=result){
                $("#error").val(result);
            }
        });
    });
</script>
</body>
</html>
