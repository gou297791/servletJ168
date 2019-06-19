<%--
  Created by IntelliJ IDEA.
  User: gou
  Date: 2019/6/16
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生考勤系统-统计</title>
    <link rel="stylesheet" href="../cssandjs/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../cssandjs/style/admin.css" media="all">
    <link rel="stylesheet" href="../cssandjs/mycss.css" media="all">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" style="padding-top: 10px">
                    <!--搜索-->
                    <div class="layui-form">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">学生姓名</label>
                                <div class="layui-col-md6">
                                    <input type="text" name="studentName" id="LAY-user-login-username" lay-verify="required" placeholder="学生姓名" class="layui-input" style="width: 200px">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">考勤类型</label>
                                <div class="layui-input-inline">
                                    <select id="selectClass" name="checkType">
                                        <option value="">不限</option>
                                        <option value="迟到">迟到</option>
                                        <option value="请假">请假</option>
                                        <option value="早退">早退</option>
                                        <option value="作业">作业</option>
                                    </select>
                                </div>
                            </div><br>
                            <div class="layui-inline">
                                <label class="layui-form-label">起始时间</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="checkStartDate" class="layui-input" id="test-laydate-normal-cn" placeholder="yyyy-MM-dd">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">结束时间</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="checkEndDate" class="layui-input" id="test-laydate-normal-cn2" placeholder="yyyy-MM-dd">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <button class="layui-btn layadmin-btn-admin" id="findITem" lay-button="findItem()" lay-filter="LAY-user-back-serch" style="padding-right: 30px">
                                    <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <div class="layui-card-body">
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>考勤类型</th>
                            <th>考勤状况</th>
                            <th>录入人</th>
                        </tr>
                        <c:forEach items="${list}" var="list">
                            <tr><td>${list.student.studentName}</td><td>${list.checkType}</td>
                                <td>${list.checkStatus}</td><td>${list.checkPerson}</td></tr>
                        </c:forEach>
                        </thead>
                    </table>
                    <div class="layui-card-body">
                        <div id="test-laypage-demo20"></div>
                        <ul id="test-laypage-biuuu_city_list">
                            <li><a href="javaScript:void(0)" id="firstId" class="a-page-class">首页</a>
                                <a href="javaScript:void(0)" id="prevId" class="a-page-class">上一页</a>
                                <span id="conditionNum"></span>
                                <a href="javaScript:void(0)" id="nextId" class="a-page-class">下一页</a>
                                <a href="javaScript:void(0)" id="lastId" class="a-page-class">尾页</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="studentCheckWeb/cssandjs/layui/layui.js"></script>
<script>
    layui.config({
        base: 'studentCheckWeb/cssandjs/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function() {
        var laydate = layui.laydate;

        //示例代码

        //常规用法
        laydate.render({
            elem: '#test-laydate-normal-cn'
        });
        //常规用法
        laydate.render({
            elem: '#test-laydate-normal-cn2'
        });
    });
    var curentPage=1;//当前页初始值
    var  allCount=0;//总行数
    var countPage=10;//每页显示的行数
    var maxPage=0; //总页数
    var startPage=0;//起始位置
    //计算起始位置
    function startPageF(){
        startPage=(curentPage-1)*countPage;
    }
    //计算总页数
    function maxPageF(){
        if(allCount%countPage==0){
            maxPage=allCount/countPage;
            maxPage=parseInt(maxPage);//取整数
        }else{
            maxPage=parseInt(allCount/countPage)+1;
        }
    }
    //首页
    $("#firstId").click(function () {
        curentPage=1;
        //计算起始页
        startPageF();
    });
    //尾页
    $("#lastId").click(function () {
        curentPage=maxPage;
        //计算起始页
        startPageF();

    });
    //下一页
    $("#nextId").click(function () {
        //判断当前页是否是尾页
        if(curentPage!=maxPage){
            curentPage=curentPage+1;
        }
        //计算起始页
        startPageF();
    });
    //上一页
    $("#prevId").click(function () {
        //判断当前页是否是首页
        if(curentPage==1){
            curentPage=maxPage;
        }else{
            curentPage=curentPage-1;
        }
        //计算起始页
        startPageF();
    });
    $(".a-page-class").click(function () {
        $.post("messageServlet",{"startPage":startPage,"countPage":countPage},function(result){
            var json=eval("("+result+")");
            htmlFunction(json);
        });
    });
    $("#findITem").click(function () {
        findItem();
    });
    $(document).ready(function(){
        findItem();
    });
    function findItem() {
        curentPage=1;
        //计算起始页
        startPageF();
        var studentName=$("#LAY-user-login-username").val();
        var checkType=$("#selectClass").val();
        var checkStartDate=$("#test-laydate-normal-cn").val();
        var checkEndDate=$("#test-laydate-normal-cn2").val();
        $.post("findConditionServlet",{"studentName":studentName,"checkType":checkType,
            "checkStartDate":checkStartDate,"checkEndDate":checkEndDate,
            "startPage":startPage,"countPage":countPage},function(result){
            var json=eval("("+result+")");
            htmlFunction(json);
        });
    }
    function htmlFunction(json){
        var table= $(".layui-table");
        var html="<colgroup><col width=\"150\"><col width=\"150\"><col width=\"200\"><col></colgroup>\n" +
            "<thead><tr><th>姓名</th><th>考勤类型</th><th>考勤状况</th><th>录入人</th></tr></thead>"
        //组装身体
        $.each(json.list,function () {
            html+="<tr>"
            html+="<td>"+this.student.studentName+"</td><td>"+this.checkType+"</td><td>"+this.checkStatus+"</td><td>"+this.checkPerson+"</td>"
            html+= "</tr>"
        });
        //放入到table标签
        table.html(html);
        //获得总行数
        allCount=json.pageNum;
        //计算总页数
        maxPageF();
        $("#conditionNum").html(curentPage+"/"+maxPage);
    }
</script>
</body>
</html>
</html>
