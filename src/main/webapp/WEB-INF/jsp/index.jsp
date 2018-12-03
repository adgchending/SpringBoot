<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="shortcut icon" href="static/images/title.jpg" type="image/x-icon">
    <title>SpringBoot</title>
</head>
<body>
<h2>你好! ${userName}</h2>
<form method="get" action="swagger-ui.html">
    <input type="submit" value="点击进入swagger">
</form>
<a href="modeler.html?modelId=1">
    <input type="submit" value="点击进入activiti">
</a>
<form method="get" action="/test1">
    <input type="submit" value="测试shiro(test1)">
</form>
<form method="get" action="/test2">
    <input type="submit" value="测试shiro(test2)">
</form>
<form method="post" action="/logout">
    <input type="submit" value="退出">
</form>
<img src="http://www.chenshangxian.cn:8088/Users/chenshangxian/Downloads/tmp/2018/12/3/4e04fa60-da51-4c94-a04e-c2847e620539.jpg">
<img src="http://www.chenshangxian.cn:8088/img/2018/12/3/4e04fa60-da51-4c94-a04e-c2847e620539.jpg">
</body>
</html>
