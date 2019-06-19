<%--
  Created by IntelliJ IDEA.
  User: gou
  Date: 2019/6/17
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>森林病虫害防治系统</title>
    <link rel="stylesheet" href="studentCheckWeb/cssandjs/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="studentCheckWeb/cssandjs/style/admin.css" media="all">
    <link rel="stylesheet" href="studentCheckWeb/cssandjs/mycss.css" media="all">
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">虫害详细信息</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body">
    <span style=" position:relative;left:50px">名称</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestName}</p><br>
    <span style=" position:relative;left:50px">繁殖</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestBreed}</p><br>
    <span style=" position:relative;left:50px">寄主</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestBreed}</p><br>
    <span style=" position:relative;left:50px">天敌</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestBreed}</p><br>
    <span style=" position:relative;left:50px">主要危害</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestBreed}</p><br>
    <span style=" position:relative;left:50px">防治措施</span>
    <p style="width: 250px;word-wrap:break-word;word-break:break-all;overflow: hidden;position:relative;left:150px;top:-25px;">${insectPestBreed}</p><br>
</div>
<div style="width: 400px;position:absolute;left:550px;top: 120px">
    <span style="position: relative;top: -60px;">幼虫图片</span>
    <img src="" width="200" height="150" style="position: relative;left: 30px">
    <br><span style=" position:absolute;top:180px;">成虫图片</span>
    <img src="" width="200" height="150" style="position: relative;left: 90px;top: 30px;">
</div>
<button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:50px;left:450px">返回</button>
</body>
</html>
