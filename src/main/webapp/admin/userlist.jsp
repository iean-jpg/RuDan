<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>用户列表</title>
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
				<a href="javascript:;">首页</a> <a href="javascript:;">用户管理</a>
				<a href="javascript:;"> <cite>用户列表</cite></a>
			</span>
    <a class="layui-btn layui-btn-sm" style="margin-top:3px;float:right" href="javascript:location.replace(location.href);"
       title="刷新">
        <i class="layui-icon layui-icon-refresh"></i>
        <!-- <i class="layui-icon" style="line-height:30px">&#x1002;</i> -->
    </a>
</div>

<div class="weadmin-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 we-search" action="/user/queryUserByName" method="get">
            用户搜索：
            <div class="layui-inline">
                <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input" />
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                <i class="layui-icon layui-icon-search"></i>
            </button>
        </form>
    </div>
    <div class="weadmin-block">
        <button class="layui-btn" onclick="WeAdminShow('添加用户','add.jsp',600,400)">
            <i class="layui-icon layui-icon-add-circle-fine"></i>添加
        </button>
        <span class="fr" style="line-height:40px">共有数据：${userCount}条</span>
    </div>
    <table class="layui-table" id="memberList">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
                    <i class="layui-icon">&#xe605;</i>
                </div>
            </th>
            <th>ID</th>
            <th>用户名</th>
            <th>真实姓名</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>公司</th>
            <th>加入时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userSession}" var="user">
            <tr data-id="1">
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id="1">
                        <i class="layui-icon">&#xe605;</i>
                    </div>
                </td>
                <td>${user.getUserId()}</td>
                <td>${user.getUserName()}</td>
                <td>${user.getUserRname()}</td>
                <td>${user.getUserTel()}</td>
                <td>${user.getUserEmail()}</td>
                <td>${user.getUserCompany()}</td>
                <td>${user.getUserDateTime()}</td>
                <td class="td-status">
                <span class="layui-btn layui-btn-normal layui-btn-xs">
                    <c:choose>
                        <c:when test="${user.getUserRight()==0}">
                            管理员
                        </c:when>
                        <c:when test="${user.getUserRight()==1}">
                            普通用户
                        </c:when>
                    </c:choose>
                </span>
                </td>
                <td class="td-manage">
                    <a title="编辑" onclick="WeAdminEdit('编辑','/admin/edit.jsp', 1, 600, 400)" href="/user/queryUserById?userId=${user.getUserId()}">
                        <i class="layui-icon layui-icon-edit"></i>
                    </a>
                    <a title="删除" onclick="member_del(this,'要删除的id')" href="/user/deleteUser?userId=${user.getUserId()}">
                        <i class="layui-icon layui-icon-delete"></i>
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
