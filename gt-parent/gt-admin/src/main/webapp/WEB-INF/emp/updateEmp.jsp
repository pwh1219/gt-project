<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2021/1/3
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="/common/common.jsp" %>
<script>
    var contentWindow = parent.$("iframe[title='员工管理']").get(0).contentWindow;
    var rows = contentWindow.$("#dg").datagrid("getSelected");

    $(function () {
        $("#ff").form('load', {
            empId:rows.empId,
            empAccount: rows.empAccount,
            empName: rows.empName,
            empParentCompany: '${sessionScope.login.empParentCompany}',
            empShopName: '${sessionScope.login.empShopName}',
            empDeptType: '${sessionScope.login.empDeptType}'
        })
    });

    function goBack() {
        parent.$("#win").window('close');
    }

    function saveEmp() {
        $("#ff").form('submit', {
            url: '${proPath}/emp/updateEmp.mvc',
            success: function (data) {
                var param = eval('(' + data + ')');
                if (param.msg === 1) {
                    parent.$.messager.show({
                        title: '系统提示',
                        width: 300,
                        height: 150,
                        msg: '修改员工信息成功',
                        timeout: 3000,
                        showType: 'slide',
                        size: 30
                    });
                    contentWindow.$('#dg').datagrid("load");
                    goBack();
                } else {
                    parent.$.messager.show({
                        title: '系统提示',
                        width: 300,
                        height: 150,
                        msg: '修改员工信息失败',
                        timeout: 3000,
                        showType: 'slide',
                        size: 30
                    })
                }
            }
        })
    }


</script>
<style>
    #d1, #d2, #d3, #d4, #d5, #d6, #d7, #d8 {
        padding-left: 240px;
        padding-top: 20px;
    }
</style>
<body>
<form id="ff" method="post">
    <input type="hidden" name="empId">
    <div>
        <div id="d1">
            <div style="float: left;width: 96px">登录账号：</div>
            <input type="text" class="easyui-validatebox" data-options="required:true" id="empAccount" name="empAccount"
                   style="height: 24px">
        </div>

        <div id="d2">
            <div style="float: left;width: 96px">姓名：</div>
            <input type="text" class="easyui-validatebox" data-options="required:true" id="empName" name="empName"
                   style="height: 24px">
        </div>

        <div id="d3">
            <div style="float: left;width: 96px">部门类型：</div>
            <input type="text" id="empDeptType" name="empDeptType" style="height: 24px">
        </div>

        <div id="d4">
            <div style="float: left;width: 96px">总店铺名称：</div>
            <input type="text" id="empParentCompany" name="empParentCompany" style="height: 24px">
        </div>


        <div id="d5">
            <div style="float: left;width: 96px">店铺名称：</div>
            <input type="text" id="empShopName" name="empShopName" style="height: 24px">
        </div>

        <div id="d6">
            <div style="float: left;width: 96px">职务：</div>
            <input type="text" id="empDuty" name="empDuty" style="height: 24px">
        </div>

        <div id="d7">
            <div style="float: left;width: 96px">锁定：</div>
            <select id="empLockStatus" class="easyui-combox" name="empLockStatus" style="width: 164px;height: 22px">
                <c:forEach items="${applicationScope.sysParamMap.emp_lock_status}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>

        <div id="d8">
            <div style="float: left;width: 96px">状态：</div>
            <select id="empStatus" class="easyui-combox" name="empStatus" style="width: 164px;height: 22px">
                <c:forEach items="${applicationScope.sysParamMap.emp_status}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>
        <div style="padding-left: 300px;padding-top: 20px">
            <input type="button" value="保存" onclick="saveEmp()">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="goBack()">
        </div>
    </div>
</form>
</body>
</html>
