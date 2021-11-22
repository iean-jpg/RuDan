<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>新闻列表</title>
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="stylesheet" href="../../static/css/font.css" />
    <link rel="stylesheet" href="../../static/css/weadmin.css" />
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="weadmin-nav">
			<span class="layui-breadcrumb">
				<a href="javascript:;">首页</a> <a href="javascript:;">新闻管理</a>
				<a href="javascript:;"> <cite>新闻列表</cite></a>
			</span>
    <a class="layui-btn layui-btn-sm" style="margin-top:3px;float:right" href="javascript:location.replace(location.href);"
       title="刷新">
        <i class="layui-icon layui-icon-refresh"></i>
        <!-- <i class="layui-icon" style="line-height:30px">&#x1002;</i> -->
    </a>
</div>

<div class="weadmin-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 we-search" action="/news/queryNewsByTitle" method="get">
            新闻搜索：
            <div class="layui-inline">
                <input type="text" name="newstitle" placeholder="请输入新闻标题" autocomplete="off" class="layui-input" />
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                <i class="layui-icon layui-icon-search"></i>
            </button>
        </form>
    </div>
    <div class="weadmin-block">
        <button class="layui-btn" onclick="WeAdminShow('添加用户','../news/add.jsp',600,400)">
            <i class="layui-icon layui-icon-add-circle-fine"></i>添加
        </button>
        <span class="fr" style="line-height:40px">共有数据：${newsCount}条</span>
    </div>
    <table class="layui-table" id="memberList">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
                    <i class="layui-icon">&#xe605;</i>
                </div>
            </th>
            <th>标题</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${newsSession}" var="news">
            <tr data-id="1">
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id="1">
                        <i class="layui-icon">&#xe605;</i>
                    </div>
                </td>
                <td>${news.getNewsTitle()}</td>
                <td>${news.getNewsDateTime()}</td>
                <td class="td-manage">
                    <a title="编辑" onclick="WeAdminEdit('编辑','../news/edit.jsp', 1, 600, 400)" href="/news/queryNewsById?newsId=${news.getNewsId()}">
                        <i class="layui-icon layui-icon-edit"></i>
                    </a>
                    <a title="删除" onclick="member_del(this,'要删除的id')" href="/news/delNews?newsId=${news.getNewsId()}">
                        <i class="layui-icon layui-icon-delete"></i>
                    </a>
                    <a title="详情" onclick="" href="/news/queryNews?newsId=${news.getNewsId()}">
                        <i class="layui-icon layui-icon-about"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="">&lt;&lt;</a>
            <span class="current">1</span>
            <a class="next" href="">&gt;&gt;</a>
        </div>
    </div>
</div>
<!--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>-->
<script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="../static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
