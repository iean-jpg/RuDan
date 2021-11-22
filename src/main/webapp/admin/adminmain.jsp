<%--
  Created by IntelliJ IDEA.
  User: WhiteWolf
  Date: 2021年11月22日
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>管理员首页</title>
</head>
<body>
<c:forEach items="${userSession}" var="user">
    ${user.getUserId()}
    ${user.getUserName()}
    ${user.getUserRname()}
    ${user.getUserPwd()}
    ${user.getUserEmail()}
    ${user.getUserTel()}
    ${user.getUserDateTime()}
</c:forEach>
</body>
</html>
