<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath(); %>
<html>
<head>
    <title>用户首页</title>
    <link rel="stylesheet" href="<%=path%>/lib/layui-v2.6.3/css/layui.css">
    <script src="<%=path%>/lib/layui-v2.6.3/layui.js"></script>
    <style>
        .layui-carousel{
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="layui-carousel" id="show">
        <div carousel-item>
            <c:forEach items="${prodSession}" var="prod">
                <c:if test="${prod.getProdFirstShow() == 1}">
                    <a href="/product/showdetail?prodId=${prod.getProdId()}"><img src="/images/${prod.getProdImage()}"/></a>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6">
            <div class="layui-panel">
                <div style="padding: 30px;">
                    <ul class="news">
                        <e:forEach items="${newsSession}" var="news">
                            <li><a href="/news/queryNews?newsId=${news.getNewsId()}">${news.getNewsTitle()}</a></li>
                        </e:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md6">
            <div class="layui-panel">
                <div style="padding: 30px;">一个面板</div>
            </div>
        </div>
    </div>
    <script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#show'
            ,width: '50%' //设置容器宽度
            ,height: '50%'
            ,arrow: 'always' //始终显示箭头
        });
    });
</script>
</body>
</html>
