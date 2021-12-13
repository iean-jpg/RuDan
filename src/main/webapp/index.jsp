<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./lib/bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./lib/Flat-UI-master/dist/css/flat-ui.min.css"/>
    <link rel="stylesheet" href="./lib/layui-v2.6.3/css/layui.css">
    <script src="./lib/bootstrap-3.3.4/dist/js/jquery-1.11.3.min.js"></script>
    <script src="./lib/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <script src="./lib/Flat-UI-master/dist/js/flat-ui.min.js"></script>
    <script src="lib/layui-v2.6.3/layui.js"></script>
    <title>首页</title>
    <style>
        .row {
            margin-top: 20px;;
        }

        .center {
            text-align: center;
        }

        .pagination {
            background: #cccccc;
        }
    </style>
    <script type="text/javascript">
        function a() {
            $.ajax({
                url: "/welcome",//servlet文件的名称
                type: "GET",
            });
            $(function () {
                $('#myTabs a').click(function (e) {
                    $(this).tab('show')
                });
            })
    </script>
</head>
<body onload="a()">
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">欢迎光临</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="layui-carousel" id="test1">
        <div carousel-item>
            <C:forEach items="${newsSession}" var="news">
                <div class="jumbotron">
                    <h1>${news.getNewsTitle()}</h1>
                    <p>...</p>
                    <p><a class="btn btn-primary btn-lg" href="/news/queryNews?newsId=${news.getNewsId()}"
                          role="button">了解更多</a></p>
                </div>
            </C:forEach>
        </div>
    </div>
    <div class="row">
        <C:forEach items="${prodSession}" var="prod">
            <div class="col-sm-4 col-md-3">
                <div class="thumbnail">
                    <a href="/product/showdetail?prodId=${prod.getProdId()}">
                        <img style="width: 100%; height: 200px; display: block;" alt="100%x200"
                             src="/images/${prod.getProdImage()}">
                    </a>
                    <div class="caption center">
                        <h3>${prod.getProdName()}${prod.getProdType()}</h3>
                        <p><span>价格:</span><span>${prod.getProdPrice()}</span></p>
                        <p><a class="btn btn-primary btn-block" role="button"
                              href="/product/showdetail?prodId=${prod.getProdId()}">查看详情</a></p>
                    </div>
                </div>
            </div>
        </C:forEach>
    </div>
    <nav class="center">
        <ul class="pagination  pagination-lg">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">末页</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always' //始终显示箭头
        });
    });
</script>
</body>
</html>
