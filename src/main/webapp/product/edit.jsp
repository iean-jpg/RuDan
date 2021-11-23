<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改产品</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
    <script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
</head>
<body>
<form enctype="multipart/form-data" class="layui-form" action="/product/updateProduct?prodId=${prodSession.getProdId()}" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdName()}" type="text" name="prodname" lay-verify="title" autocomplete="off" placeholder="请输入产品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择产品分类</label>
        <div class="layui-input-block">
            <select name="catid" lay-filter="aihao">
                <c:forEach items="${catSession}" var="category">
                    <option value="${category.getCatId()}">${category.getCatName()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品型号</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdType()}" type="text" name="prodtype" lay-verify="title" autocomplete="off" placeholder="请输入产品型号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品价格</label>
        <div class="layui-input-block">
            <input value="${prodSession.getProdPrice()}" type="text" name="prodprice" lay-verify="title" autocomplete="off" placeholder="请输入产品价格" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否首页展示</label>
        <div class="layui-input-block">
            <input type="radio" name="prodfirstshow" value="1" title="是" checked="">
            <input type="radio" name="prodfirstshow" value="0" title="否">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">产品描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="proddesc">${prodSession.getProdText()}</textarea>
        </div>
    </div>
    <div class="layui-form">
        <label class="layui-form-label">上传图片</label>
        <div class="layui-input-block">
            <input type="file" name="prodimage" class="layui-btn layui-btn-danger"><i class="layui-icon"></i></input>
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
