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
    <title>文件上传</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>

<form action="file" method="post" enctype="multipart/form-data" id="formId">
    <input type="file" name="fileName"><p/>
    <input type="text" name="userName" ><p/>
    <span style="color: red" id="hint"></span><br>
    <input type="submit" id="submitId" value="提交">
</form>
</body>
<script>
    $("#submitId").click(function(){
        var file=$("[name='fileName']").val();
        if(""!=file) {
            var strArray = file.split(".");
            if ("jpg" == strArray[1] || "png" == strArray[1]) {
                // $("#submitId").submit();
            } else {
                $("#hint").text("图片格式错误，请重新选择");
                return false;
            }
        }
    } );
</script>
</html>
