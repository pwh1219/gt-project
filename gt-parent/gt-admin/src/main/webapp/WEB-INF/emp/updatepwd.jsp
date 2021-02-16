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
        var isValid = $(this).form('validate');
        if (isValid) {
            var old = $("#oldPwd").val();
            var new1 = $("#newPwd1").val();
            var new2 = $("#newPwd2").val();

            var oldPassword = (old == ${sessionScope.login.password});
            var newPassword = (new1 === new2);

            if (!oldPassword) {
                $.messager.alert('提示信息', "原密码不正确！");
                return;
            }
            if (!newPassword) {
                $.messager.alert('提示信息', "输入的两次密码不一致！");
                return;
            }
        }
        $("#ff").form('submit', {
            url: '${proPath}/user/updatePwd',
            onSubmit: function () {

            },
            success: function (result) {
                var data = eval('(' + result + ')');
                alert(data.msg);
                if (data.msg == "1") {
                    parent.$.messager.show({
                        title: "提示信息",
                        msg: '修改密码成功',
                        showSpeed: 1200,
                        timeout: 3000
                    });
                    setTimeout(closeWindow, 5000);
                } else {
                    parent.$.messager.alert("提示信息", "修改密码失败！");
                }
            }
            ,
        })
        ;
    }

    function closeWindow() {
        // 关闭当前窗口
        parent.$('#win').window('close');
        // 刷新页面
        parent.$('#dg').datagrid('load');
    }
</script>
<body>
<form id="ff" method="post">
    <input hidden="hidden" id="${sessionScope.login.userId}" style="display: none" name="userId"
           value="${sessionScope.login.userId}">
    <div style="padding-top: 30px;padding-left: 140px;">
        <div>
            <span>用户姓名：</span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
                <input type="text" name="userName" value="${sessionScope.login.userName}" readonly="readonly"
                       style="width: 240px">
            </span>
        </div>

        <div style="padding-top: 30px;">
            <span>用户账号：</span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
                <input type="text" name="userCount" value="${sessionScope.login.userCount}" readonly="readonly"
                       style="width: 240px">
            </span>
        </div>

        <div style="padding-top: 30px;">
            <span>
                <label for="password1" id="password1">原密码：</label>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span style="padding-left: 18px">
                <input class="easyui-validatebox" type="password" name="oldPassword"
                       data-options="required:true,validType:'length[6,16]'" id="oldPwd"
                       placeholder="请输入原密码" style="width: 240px"/>
            </span>
        </div>

        <div style="padding-top: 30px;">
            <div>
                <span>
                    <label for="password2" id="password2">新密码：</label>
                </span>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span style="padding-left: 18px">
                <input class="easyui-validatebox" type="password"
                       data-options="required:true,validType:'length[6,16]'" id="newPwd1"
                       placeholder="请输入新密码" style="width: 240px"/>
                </span>
            </div>

            <div style="padding-top: 30px;">
                <span>
                    <label for="empPassword" id="empPassword">确认密码：</label>
                </span>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <span>
                <input class="easyui-validatebox" type="password" name="password" placeholder="请确认您输入的密码"
                       data-options="required:true,validType:'length[6,16]'" id="newPwd2"
                       style="width: 240px"/>
                </span>
            </div>

            <div style="padding-top: 40px;padding-left: 150px">
                <input type="button" value="提交" onclick="submitPwd()"
                       style="width: 60px;font-size: 10px;background-color: #eeede0">
            </div>
        </div>
    </div>
</form>
</body>
</html>
