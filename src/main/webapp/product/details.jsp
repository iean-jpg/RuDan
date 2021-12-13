<%--
  Created by IntelliJ IDEA.
  User: WhiteWolf
  Date: 2021年11月23日
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品详情页</title>
</head>
<body>
<form enctype="multipart/form-data" class="layui-form" action="/product/updateProduct?prodId=${prodSession.getProdId()}"
      method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdName()}" type="text" name="prodname" lay-verify="title"
                   autocomplete="off" placeholder="请输入产品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品分类</label>
        <div class="layui-input-block">
            <input value="${prodSession.getCategory()}" type="text" name="prodtype" lay-verify="title"
                   autocomplete="off" placeholder="请输入产品型号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品型号</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdType()}" type="text" name="prodtype" lay-verify="title"
                   autocomplete="off" placeholder="请输入产品型号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品价格</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdPrice()}" type="text" name="prodprice" lay-verify="title"
                   autocomplete="off" placeholder="请输入产品价格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">产品描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="proddesc">${prodSession.getProdText()}</textarea>
        </div>
    </div>
    <div class="layui-form">
        <img src="/images/${prodSession.getProdImage()}" class="layui-upload-img" id="photo"
             style="max-height: 100px;max-width: 100px;">
    </div>
    <a href="javascript:history.go(-1);">返回上一页</a>
</form>
</body>
</html>
