<%--
  Created by IntelliJ IDEA.
  User: zhangfangli
  Date: 2018/4/28
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>signup</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<form action="${ctx}/signup"  method="post" enctype="multipart/form-data" >
    <h2 class="form-signin-heading">Please sign up</h2>
    <label for="inputName" class="sr-only">Username</label>
    <input type="text" id="inputName" class="form-control" placeholder="Username" required="" autofocus="" name="t_name">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="" name="t_pwd">
    <label for="inputAge" class="sr-only">Age</label>
    <input type="number" id="inputAge" class="form-control" placeholder="Age" required="" name="t_age">
    <label for="inputAddr" class="sr-only">Address</label>
    <input type="text" id="inputAddr" class="form-control" placeholder="Address" required="" name="t_address">
    <label for="inputPic" class="sr-only">Pic</label>
    <input type="file" id="inputPic" class="form-control" placeholder="Pic" required="" name="t_pic">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
</form>
</div>

</body>
</html>
