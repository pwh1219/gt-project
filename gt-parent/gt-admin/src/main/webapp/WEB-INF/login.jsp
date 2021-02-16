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
<%@include file="../common/common.jsp" %>
<script type="text/javascript" src="${proPath}/js/login.js"></script>
<style type="text/css">
    #bg {
        margin: 0px;
        padding: 0px;
        background: url('/img/gt-back.jpg');
        background-size: 1700px;
        width: 1688px;
        height: 800px;
        overflow-y: hidden;
        overflow-x: hidden;
    }

    #dd1 {
        padding: 0px;
        margin: 0px;
        width: 100%;
        height: 15%;
    }

    #dd2 {
        padding: 0px;
        margin: 0px;
        width: 100%;
        height: 63%;
    }

    #t1 {
        font-family: 宋体;
        font-size: 50px;
        padding-left: 35%;
        padding-top: 5%;
        color: #8F5700;
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
        padding-top: 4%;
    }

</style>
<body id="bg">

<div id="dd1">
    <div id="t1">高铁后台管理系统</div>
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
            <form id="ff" method="post" action="${proPath}/user/login">
                <div>
                    <label for="userCount" id="userCount">账&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                    <input class="easyui-validatebox" type="text" name="userCount" data-options="required:true"/>
                </div>
                <br/>
                <div>
                    <label for="password" id="password">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                    <input class="easyui-validatebox" type="password" name="password"
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
</body>
</html>
