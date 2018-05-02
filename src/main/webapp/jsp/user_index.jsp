<%--
  Created by IntelliJ IDEA.
  User: zhangfangli
  Date: 2018/4/27
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Home</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${sessionScope.user eq null}">
    <c:redirect url="index.jsp"/>
</c:if>
<h1 style="text-align: center">Home Page</h1>

<ul class="nav nav-tabs" id = 'ad'>
    <li role="presentation" class="active"><a href="#" onclick="addclass()">username:${sessionScope.user.t_name}</a></li>
    <li role="presentation"><a href="#" onclick="addclass()">age:${sessionScope.user.t_age}</a></li>
    <li role="presentation"><a href="#" onclick="addclass()">address:${sessionScope.user.t_address}</a></li>
</ul>

<img src="${ctx.concat('/static/img/').concat(user.t_name).concat('.jpg')}"/>
<div style="margin-top: 2%">
    <button type="button" class="btn btn-default"><a href="${ctx}/jsp/home.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Personal Page</a></button>
</div>
<script>
    function addclass(){
        var aLi = document.getElementById('ad').getElementsByTagName("li");
        var i = 0;
        for (i = 0; i < aLi.length; i++){
            aLi[i].onclick = function (){
                for (i = 0; i < aLi.length; i++) aLi[i].className = aLi[i].className.replace(/\s?active/,"");
                this.className += " active";
            };
        }
    }
</script>

</body>

</html>
