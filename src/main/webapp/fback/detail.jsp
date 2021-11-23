<%--
  Created by IntelliJ IDEA.
  User: WhiteWolf
  Date: 2021年11月23日
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反馈详情</title>
    <style>
        .Title{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="layui-main">
        <h2 class="Title">${fbackSession.getFbackTitle()}</h2>
        <div>反馈者：${fbackSession.getUserName()}反馈时间:${fbackSession.getFbackDateTime()}</div>
        <div class="layui-text">
            ${fbackSession.getFbackContent()}
        </div>
    </div>
</body>
</html>
