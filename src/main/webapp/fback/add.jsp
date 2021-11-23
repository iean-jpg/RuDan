<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加反馈</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js"></script>
</head>

<form class="layui-form" action="/fback/addFback?userId=${userId}" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">反馈标题</label>
        <div class="layui-input-block">
            <input value="" type="text" name="fbacktitle" lay-verify="title" autocomplete="off" placeholder="请输入新闻标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">反馈内容</label>
        <div class="layui-input-block">
            <textarea name="fbackcontent" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">
            <input type="reset" class="layui-btn layui-btn-primary">
        </div>
    </div>
</form>
</body>
</html>
