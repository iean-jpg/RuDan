<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath(); %>
<html>
<head>
    <title>用户首页</title>
    <link rel="stylesheet" href="<%=path%>/lib/layui-v2.6.3/css/layui.css">
    <script src="<%=path%>/lib/layui-v2.6.3/layui.js"></script>
</head>
<body>
    <div class="layui-carousel" id="show">
        <div carousel-item>
            <c:forEach items="${prodSession}" var="prod">
                <c:if test="${prod.getProdFirstShow() == 1}">
                    <img src="/images/${prod.getProdImage()}"/>
                </c:if>
            </c:forEach>
        </div>
    </div>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#show'
            ,width: '100%' //设置容器宽度
            ,height: '100%'
            ,arrow: 'always' //始终显示箭头
        });
    });
</script>
</body>
</html>
