<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>首页</title>
</head>
<body>
<h2>你好! ${userName}</h2>
    <a href="swagger-ui.html" >
        <input type="submit" value="点击进入swagger">
    </a>
<form method="get" action="/test1">
    <input type="submit" value="点击进入test1">
</form>
<form method="get" action="/test2">
    <input type="submit" value="点击进入test2">
</form>
<form method="post" action="/logout">
    <input type="submit" value="退出">
</form>

</body>
</html>
