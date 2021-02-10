<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/16
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="common/common.jsp" %>
<script type="text/javascript" src="${proPath}/js/login.js"></script>
<%--<link type="text/css" rel="stylesheet" href="${proPath}/css/login.css"/>--%>

<style type="text/css">
    #bg {
        margin: 0px;
        padding: 0px;
        background: url('/img/bg.jpg');
        background-size: 1300px;
        width: 1688px;
        height: 800px;
        overflow-y: hidden;
        overflow-x: hidden;
    }

    #dd1 {
        padding: 0px;
        margin: 0px;
        width: 100%;
        height: 10%;
    }

    #dd2 {
        padding: 0px;
        margin: 0px;
        width: 100%;
        height: 63%;
    }

    #dd3 {
        padding: 0px;
        margin: 0px;
        width: 100%;
        height: 10%;
    }

    #t1 {
        font-family: 宋体;
        font-size: 50px;
        padding-left: 32%;
        padding-top: 24px;
        color: #8F5700;
    }

    #t3 {
        height: 95%;
        padding-left: 300px;
        padding-top: 24px;
        font-size: 30px;
        font-family: 微软雅黑;
    }

    #s1 {
        font-size: 30px;
        color: #99cdff;
        padding-left: 30%;
    }

    #ff {
        font-size: 30px;
        padding-left: 150px;
    }

    #win_body{
        padding-bottom: 100px;
        padding-left: 480px;
        padding-top: 40px;
    }

</style>
<body id="bg">

<div id="dd1">
    <div id="t1">软拓点餐后台管理系统</div>
</div>

<div id="dd2">
    <div id="win_body">
        <div style="width: 600px;height: 450px;border: 3px solid beige;">
            <br/>
            <span id="s1">请填写登录信息</span>
            <br/>
            <hr color="red"/>
            <br/>
            <br/>
            <form id="ff" method="post" action="${proPath}/emp/login.mvc">
                <div>
                    <label for="usercode" id="usercode">账&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                    <input class="easyui-validatebox" type="text" name="empAccount" data-options="required:true"/>
                </div>
                <br/>
                <div>
                    <label for="password" id="password">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                    <input class="easyui-validatebox" type="password" name="empPassword"
                           data-options="validType:'length[6,16]'"/>
                </div>
                <br>
                <span style="color: red">${sessionScope.loginMsg}</span>
                <br/>
                &nbsp;&nbsp;&nbsp;
                <a id="btn1" href="#" class="easyui-linkbutton" onclick="login()">登&nbsp;&nbsp;录</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a id="btn2" href="#" class="easyui-linkbutton" onclick="resetForm()">重&nbsp;&nbsp;置</a>
            </form>
        </div>
    </div>
</div>

<div id="dd3">
    <div id="t3">
        <span>版权所有 CopyRight &nbsp &copy xxx公司 | 地址：xxx |&nbsp;&nbsp邮编：xxx |&nbsp;&nbsp;反馈意见：xxx</span>
    </div>
</div>
</body>
</html>
