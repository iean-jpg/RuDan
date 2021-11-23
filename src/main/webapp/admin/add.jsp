<%--
  Created by IntelliJ IDEA.
  User: WhiteWolf
  Date: 2021年11月22日
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="/admin/addUser" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input value="" type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input value="" type="text" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block">
            <input value="" type="text" name="rname" lay-verify="title" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input value="" type="text" name="email" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <input value="" type="text" name="company" lay-verify="title" autocomplete="off" placeholder="请输入公司名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input value="" type="text" name="tel" lay-verify="title" autocomplete="off" placeholder="请输入电话" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">传真地址</label>
        <div class="layui-input-block">
            <input value="" type="text" name="fax" lay-verify="title" autocomplete="off" placeholder="请输入传真地址" class="layui-input">
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
