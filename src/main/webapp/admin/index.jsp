<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员主页</title>
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">管理员首页</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="../images/头像.png" class="layui-nav-img">
                    ${userSession.getUserName()}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/user/queryUserById?userId=${userSession.getUserId()}">个人信息</a></dd>
                    <dd><a href="/user/firmupdate?userId=${userSession.getUserId()}">修改密码</a></dd>
                    <dd><a href="/login.jsp">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/getalluser">用户列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">新闻管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/news/getallnews">新闻列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">分类管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/category/getAllCat">分类列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">产品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/product/getallproduct">产品列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">反馈管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/fback/getallfback">反馈列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframeMain" src="" style="width: 100%;height: 100%;"></iframe>
    </div>

    <div class="layui-footer">
    </div>
</div>
<script src="../lib/layui-v2.6.3/layui.js"></script>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script>
    $(document).ready(function(){undefined
        $("dd>a").click(function (e) {undefined
            e.preventDefault();
            $("#iframeMain").attr("src",$(this).attr("href"));
        });
    });
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>
