<%--
  Created by IntelliJ IDEA.
  User: xiaoma
  Date: 2019/3/14
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <fieldset>
        <legend>注册</legend>
        <form action="/user_reg.action" method="post">
            用户名：<input type="text" name="username"/><br/>
            密码：<input type="text" name="password"/><br/>
            <input type="submit" value="注册"/>&nbsp;<input type="reset" value="重置"/>
        </form>
    </fieldset>
</body>
</html>
