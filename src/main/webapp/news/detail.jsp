<%--
  Created by IntelliJ IDEA.
  User: WhiteWolf
  Date: 2021年11月22日
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情页</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>${newsSession.getNewsTitle()}</legend>
</fieldset>
<blockquote class="layui-elem-quote">${newsSession.getNewsContent()}</blockquote>
<span class="layui-word-aux" id="test6">${newsSession.getNewsDateTime()}</span>
<a href="javascript:history.go(-1);">返回上一页</a>
</body>
</html>
