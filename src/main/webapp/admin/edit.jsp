<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js"></script>
</head>
<body>
<form class="layui-form" action="/user/editUser?userId=${userSession.getUserId()}" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserName()}" type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserRname()}" type="text" name="rname" lay-verify="title" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserEmail()}" type="text" name="email" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserCompany()}" type="text" name="company" lay-verify="title" autocomplete="off" placeholder="请输入公司名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserTel()}" type="text" name="tel" lay-verify="title" autocomplete="off" placeholder="请输入电话" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">传真地址</label>
        <div class="layui-input-block">
            <input value="${userSession.getUserFax()}" type="text" name="fax" lay-verify="title" autocomplete="off" placeholder="请输入传真地址" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="radio" name="right" value="0" title="管理员">
            <input type="radio" name="right" value="1" title="普通用户" checked="">
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
