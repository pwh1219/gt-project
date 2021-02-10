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
            empDutyParentCompany: '${sessionScope.login.empParentCompany}',
            empDutyShopName: '${sessionScope.login.empShopName}'
        })
    });

    function loadParam() {
        $('#dg').datagrid({
            url: '${proPath}/duty/loadDuties.mvc',
            singleSelect: true,
            columns: [[
                {checkbox: true},
                {field: 'empDutyDeptType', title: '分部', width: 80,},
                {field: 'empDutyParentCompany', title: '总公司', width: 80},
                {field: 'empDutyShopName', title: '店铺名称', width: 80},
                {field: 'empDutyName', title: '职务名称', width: 80},
                {field: 'empDutyComment', title: '备注', width: 100},
                {
                    field: 'empDutyUerStatus', title: '是否启用', width: 40, formatter: function (value) {
                        if (value == 1) {
                            return "是";
                        }
                        if (value == 2) {
                            return "否";
                        }
                    }
                },
                {
                    field: 'empDutyDate', title: '创建时间', width: 100, formatter: function (value) {
                        return dateFormat(value);
                    }
                }
            ]],
            toolbar: [
                {
                    text: '添加职务',
                    iconCls: 'icon-add',
                    handler: function () {
                        parent.$('#win').window({
                            center: '',
                            title: '职务基本信息',
                            width: 800,
                            height: 550,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/duty/addDuty.mvc' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }, '-', {
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        var rows = $("#dg").datagrid("getSelected");
                        if (rows == null){
                            $.messager.alert("系统提示","请选择需要修改的职务！");
                            return;
                        }
                        parent.$('#win').window({
                            title: '职务基本信息',
                            width: 800,
                            height: 550,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/duty/updateDuty.mvc' width=100% height=100% frameborder='0px'></iframe>",
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

    #d2, #d3{
        float: left;
        padding-left: 5%;
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
                <input type="text" id="empDutyParentCompany" name="empDutyParentCompany" readonly="readonly" style="height: 24px">
            </div>

            <div id="d2">
                <div style="float: left;width: 80px">店铺名称：</div>
                <input type="text" id="empDutyShopName" name="empDutyShopName" readonly="readonly" style="height: 24px">
            </div>

            <div id="d3">
                <div style="float: left;width: 80px">是否启用：</div>
                <select id="empDutyUerStatus" class="easyui-combox" name="empDutyUerStatus" style="width: 164px;height: 22px">
                    <c:forEach items="${applicationScope.sysParamMap.emp_status}" var="s">
                        <option value="${s.key}">${s.value}</option>
                    </c:forEach>
                </select>
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

