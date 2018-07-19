<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/17
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">后台登录</header>
    <form:form class="layui-form" method="post" action="/user/login" modelAttribute="loginDto">
        <div class="layui-input-inline">
            <input type="text" name="loginName" id="loginName" required lay-verify="required" placeholder="登录名" autocomplete="off"
                   class="layui-input" value="${loginDto.loginName}"><span style="color: red;" id="loginNameTip"><form:errors path="loginName"/></span>
        </div>
        <div class="layui-input-inline">
            <input type="password" name="loginPassword" id="loginPassword" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input"><span style="color: red;" id="loginPasswordTip"><form:errors path="loginPassword"/></span>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>

        <div>
            <span style="color: red;" id="globalErrorTip">${globalError}</span>
        </div>
        <hr/>
        <!--<div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
        </div>
        <div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
        </div>-->
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form:form>
</div>


<script src="/frame/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form'], function () {

        // 操作对象
        var form = layui.form
            , $ = layui.jquery;

        // you code ..
        $("#loginName").focus(function () {
            $("#loginNameTip").text("");
        }).blur(function () {
            var loginName = $("#loginName").val();
            if (loginName.length == 0){
                $("#loginNameTip").text("登录名不能为空");
                return;
            }
            if (loginName.length < 2 || loginName.length > 30){
                $("#loginNameTip").text("用户名长度必须大小2,小于30位");
            }
        });
        $("#loginPassword").focus(function () {
            $("#loginPasswordTip").text("");
        }).blur(function () {
            var loginPassword = $("#loginPassword").val();
            if (loginPassword.length == 0){
                $("#loginPasswordTip").text("登录密码不能为空");
                return;
            }
            if (loginPassword.length < 2 || loginPassword.length > 30){
                $("#loginPasswordTip").text("登录密码长度必须大小2,小于30位");
            }
        });

    });
</script>
</body>
</html>