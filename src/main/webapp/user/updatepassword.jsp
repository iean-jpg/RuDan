<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js"></script>
</head>
<body>
<form class="layui-form" method="post" action="/user/updatePassword?userId=${userId}">
    <div class="layui-form-item">
        <label class="layui-form-label">输入密码</label>
        <div class="layui-input-block">
            <input value="" type="text" name="password" lay-verify="title" autocomplete="off" placeholder="输入密码"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input value="" type="text" name="repwd" lay-verify="title" autocomplete="off" placeholder="确认密码"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn"/>
            <input type="reset" class="layui-btn layui-btn-primary"/>
        </div>
    </div>
</form>
</body>
</html>