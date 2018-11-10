<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>登录</title>
</head>
<body>
<h1>${message}</h1>
<div id="form-div">
    <form id="form1" method="post" action="/login">
        <p>用户名：<input name="username" type="text" id="txtUserName" tabindex="1" size="15" value=""/></p>
        <p>密　码：<input name="password" type="password" id="TextBox2" tabindex="2" size="16" value=""/></p>
        <p><input type="submit" value="登录" onclick="login()">&nbsp;<input type="reset" value="重置"></p>
    </form>
</div>
</body>
</html>
