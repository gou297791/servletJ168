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
        <h1 align="center">修改用户信息</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body">
    <span style=" position:relative;left:300px">用户名</span>
    <span style=" position:relative;left:370px">${userName}</span>
    <br>
    <span style=" position:relative;left:300px;top: 50px">新密码</span>
    <input type="text" style=" position:relative;left:370px;top: 50px"/>
    <br>
    <span style=" position:relative;left:300px;top: 100px">确认新密码</span>
    <input type="text" style=" position:relative;left:340px;top: 100px"/>
    <br>
    <span style=" position:relative;left:300px;top: 150px">真实姓名</span>
    <span style=" position:relative;left:355px;top: 150px">${trueName}</span>
    <br>
    <div class="layui-inline">
        <label class="layui-form-label"style=" position:relative;left:260px;top: 200px">用户等级</label>
        <div class="layui-input-inline" style=" position:relative;left:325px;top: 210px">
            <select name="label">
                <option value="0">超级管理员</option>
                <option value="1">资料管理员</option>
                <option value="2">灾情管理员</option>
                <option value="3">专家管理员</option>
                <option value="4">库房管理员</option>
            </select>
        </div>
    </div>
</div>
<button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:250px;left:450px">修改</button>
</body>
<%--<script src="studentCheckWeb/cssandjs/layui/css/modules/layui.js"></script>--%>
<%--<script>--%>
    <%--layui.config({--%>
        <%--base: '../../../layuiadmin/' //静态资源所在路径--%>
    <%--}).extend({--%>
        <%--index: 'lib/index' //主入口模块--%>
    <%--}).use(['index', 'form'], function(){--%>
        <%--var $ = layui.$--%>
            <%--,admin = layui.admin--%>
            <%--,element = layui.element--%>
            <%--,form = layui.form;--%>

        <%--form.render(null, 'component-form-element');--%>
        <%--element.render('breadcrumb', 'breadcrumb');--%>

        <%--form.on('submit(component-form-element)', function(data){--%>
            <%--layer.msg(JSON.stringify(data.field));--%>
            <%--return false;--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
</html>
