<%--
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/24
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp" %>
<html>
<script>
    $(function () {
        $("#ff").form('load', {
            empParentCompany: '${sessionScope.login.empParentCompany}',
            empShopName: '${sessionScope.login.empShopName}'
        })
    });

    function loadParam() {
        $('#dg').datagrid({
            url: '${proPath}/emp/loadEmps.mvc',
            singleSelect: true,
            columns: [[
                {checkbox: true},
                {field: 'empName', title: '姓名', width: 150,},
                {field: 'empAccount', title: '登录账号', width: 150},
                {field: 'empDeptType', title: '部门类型', width: 150},
                {field: 'empParentCompany', title: '总公司', width: 150},
                {field: 'empShopName', title: '店铺名称', width: 150},
                {field: 'empDuty', title: '职务', width: 150},
                {
                    field: 'empLockStatus', title: '锁定', width: 150, formatter: function (value) {
                        if (value == 1) {
                            return "否";
                        }
                        if (value == 2) {
                            return "是";
                        }
                    }
                },
                {
                    field: 'empStatus', title: '状态', width: 150, formatter: function (value) {
                        if (value == 1) {
                            return "可用";
                        }
                        if (value == 2) {
                            return "禁用";
                        }
                    }
                },
                {field: 'empIdentity', title: '身份证号', width: 150},
                {field: 'empPhone', title: '手机号', width: 150},
                {
                    field: 'empWorkStatus', title: '工作状态', width: 150, formatter: function (value) {
                        if (value == 1) {
                            return "在职";
                        }
                        if (value == 2) {
                            return "离职";
                        }
                    }
                }
            ]],
            toolbar: [
                {
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        parent.$('#win').window({
                            center: '',
                            title: '添加员工-基本信息',
                            width: 800,
                            height: 550,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/emp/addEmp.mvc' title='添加子菜单或者按钮' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }, '-', {
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        var rows = $("#dg").datagrid("getSelected");
                        if (rows == null){
                            $.messager.alert("系统提示","请选择需要修改的员工！");
                            return;
                        }
                        parent.$('#win').window({
                            title: '修改菜单权限',
                            width: 800,
                            height: 550,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/emp/updateEmp.mvc' title='修改菜单权限' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }
            ],
            fitColumns: true,
            pagination: true,
            rownumbers: true,
            pageSize: 10,
            pageList: [5, 10, 15, 20, 50],
        });
    }

    $(function () {
        loadParam();
    });

    function searchEmp() {
        var empParentCompany = $("#empParentCompany").val();
        var empShopName = $("#empShopName").val();
        var empStatus = $("#empStatus").val();
        var empName = $("#empName").val();
        var empPhone = $("#empPhone").val();
        var empAccount = $("#empAccount").val();
        var empIdentity = $("#empIdentity").val();
        $('#dg').datagrid("load", {
            empParentCompany:empParentCompany,
            empShopName:empShopName,
            empStatus:empStatus,
            empName:empName,
            empIdentity:empIdentity,
            empPhone:empPhone,
            empAccount:empAccount
        });
    }
</script>

<style>
    #d1 {
        float: left;
    }

    #d2, #d3, #d6, #d7 {
        float: left;
        padding-left: 5%;
    }

    #d4 {
        float: left;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form id="ff" method="post">
        <div>
            <div id="d1">
                <div style="float: left;width: 80px;">总公司：</div>
                <input type="text" id="empParentCompany" name="empParentCompany" readonly="readonly" style="height: 24px">
            </div>

            <div id="d2">
                <div style="float: left;width: 80px">店铺名称：</div>
                <input type="text" id="empShopName" name="empShopName" readonly="readonly" style="height: 24px">
            </div>

            <div id="d3">
                <div style="float: left;width: 80px">状态：</div>
                <select id="empStatus" class="easyui-combox" name="empStatus" style="width: 164px;height: 22px">
                    <c:forEach items="${applicationScope.sysParamMap.emp_status}" var="s">
                        <option value="${s.key}">${s.value}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br/>
        <br/>
        <div>
            <div id="d4">
                <div style="float: left;width: 80px">姓名：</div>
                <input type="text" id="empName" name="empName"  style="height: 24px">
            </div>

            <div id="d6">
                <div style="float: left;width: 80px">身份证号：</div>
                <input type="text"  id="empIdentity" name="empIdentity"  style="height: 24px">
            </div>

            <div id="d7">
                <div style="float: left;width: 80px">手机号码：</div>
                <input type="text" id="empPhone" name="empPhone" style="height: 24px">
            </div>
            <br>
            <br>
            <div id="d5" style="float: left">
                <div style="float: left;width: 123px">登录账号(员工)：</div>
                <input type="text" id="empAccount" name="empAccount" style="height: 24px">
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="搜索" onclick="searchEmp()">
        </div>
    </form>
</div>
<div>
    <table id="dg"></table>
</div>
</body>
</html>

