<%--
  Created by IntelliJ IDEA.
  User: jekim
  Date: 2022-10-11
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<style>
    .login-form {
        width: 340px;
        margin: 50px auto;
        font-size: 15px;
    }
    .login-form form {
        margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {
        font-size: 15px;
        font-weight: bold;
    }

</style>
<body>
<div class="login-form">
    <form action="/index" method="post">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input type="text" name='user_id' id="user_id" class="form-control"
                   placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password"  name='password' id="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
<%--    <c:if test="${msg == 'failure'}">--%>
<%--        <p style="color: red;">로그인 실패</p>--%>
<%--    </c:if>--%>
        <div class="clearfix">
            <a href="/signupPage" class="float-right">Create an Account</a><br>
        </div>
    </form>
</div>


</body>
</html>
