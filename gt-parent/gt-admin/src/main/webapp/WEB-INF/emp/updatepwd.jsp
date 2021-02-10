<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/21
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<%@include file="/common/common.jsp" %>
<head>
    <title>Title</title>
</head>
<script>
    function submitPwd() {
        $("#ff").form('submit', {
            url: '${proPath}/emp/updatePwd.mvc',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                var old = $("#oldPwd").val();
                var new1 = $("#newPwd1").val();
                var new2 = $("#newPwd2").val();

                if (isValid) {
                    alert(old);
                    var oldPassword = (old == ${applicationScope.login.empPassword});
                    var newPassword = (new1 === new2);

                    if (!oldPassword) {
                        $.messager.alert('提示信息', "原密码不正确！");
                        return;
                    }
                    if (!newPassword) {
                        $.messager.alert('提示信息', "输入的两次密码不一致！");
                        return;
                    }
                } else {
                    $.messager.alert("提示信息", "请填写信息！");
                    return;
                }},
            success: function (data) {

                var data = eval('('+data+')');
                alert(data.result);
                if (data.result === "1") {
                    $.messager.show({
                        title: "提示信息",
                        msg: '修改密码成功',
                        showSpeed: 1200,
                        timeout: 3000
                    });
                    setTimeout(closeWindow,5000);
                } else {
                    $.messager.alert("提示信息", "修改密码失败！");
                }
            },
        });

    }

    function closeWindow() {
        // 关闭当前窗口
        parent.$('#win').window('close');
        // 刷新页面
        parent.$('#dg').datagrid('load');
    }
</script>
<style>
    span {
        color: #0092DC;
        font-size: 18px
    }
</style>
<body>
<form id="ff" method="post">
    <input hidden="hidden" id="${applicationScope.login.empId}" style="display: none" name="empId" value="${applicationScope.login.empId}">
    <div style="padding-top: 30px;padding-left: 140px;">
        <div>
            <span>用户姓名：</span>
            <span><input type="text" value="${applicationScope.login.empName}" readonly="readonly"
                         style="font-size: 20px;color: #8f3242"></span>
        </div>

        <div style="padding-top: 30px;">
            <span>用户账号：</span>
            <span><input type="text" value="${applicationScope.login.empAccount}" readonly="readonly"
                         style="font-size: 20px;color: #8f3242"></span>
        </div>

        <div style="padding-top: 30px;">
            <span><label for="password1" id="password1">原密码：</label></span>
            <span style="padding-left: 18px">
                <input class="easyui-validatebox" type="password" name="oldPassword"
                       data-options="required:true,validType:'length[6,16]'" id="oldPwd"
                       style="font-size: 20px;color: #8f3242" placeholder="请输入原密码"/>
                </span>
        </div>

        <div style="padding-top: 30px;">
            <div>
                <span><label for="password2" id="password2">新密码：</label></span>
                <span style="padding-left: 18px">
                <input class="easyui-validatebox" type="password" name="newPassword"
                       data-options="required:true,validType:'length[6,16]'" id="newPwd1"
                       style="font-size: 20px;color: #8f3242" placeholder="请输入新密码"/>
                </span>
            </div>

            <div style="padding-top: 30px;">
                <span><label for="empPassword" id="empPassword">确认密码：</label></span>
                <span>
                <input class="easyui-validatebox" type="password" name="empPassword" placeholder="请确认您输入的密码"
                       data-options="required:true,validType:'length[6,16]'" id="newPwd2"
                       style="font-size: 20px;color: #8f3242"/>
                </span>
            </div>

            <div style="padding-top: 40px;padding-left: 150px">
                <input type="button" value="提交" onclick="submitPwd()" style="width: 80px;font-size: 20px">
            </div>
        </div>
    </div>
</form>
</body>
</html>
