<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/31
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/common/common.jsp" %>
<script>
    var contentWindow = parent.$("iframe[title='角色管理']").get(0).contentWindow;
    var role = contentWindow.$("#dg").datagrid("getSelected");

    $(function () {
        select()
    });

    function tg2(){
        $.ajax({
            url: '${proPath}/roleAndEmp/selectEmp.mvc',
            data: {
                roleId: role.roleId
            },
            success: function (data) {
                $('#dg2').datagrid({
                    data: data,
                    singleSelect: true,
                    fit: true,
                    columns: [[
                        {checkbox: true,},
                        {field: 'empName', width: 237, height:450, align: "center"},
                    ]],
                })
            }
        })
    }
    $(function () {
        tg2();
    });

    function selectRole() {
        var roleName = $("#name").val();
        $('#dg1').datagrid('load', {
            empName: roleName
        });
    }

    function select() {
        $('#dg1').datagrid({
            url: '${proPath}/roleAndEmp/selectAll.mvc',
            singleSelect: true,
            fit:true,
            columns: [[
                {checkbox: true,},
                {field: 'empName', width: 277, height:450,align: "center"},
            ]]
        });
    }

    function getSelected1() {
        var emp1 = $("#dg1").datagrid("getSelected");
        var emp2 = $("#dg2").datagrid("getSelected");
        if (emp2 != null) {
            $.messager.alert("系统提示", "请选择未添加员工进行添加！");
            $('#dg2').datagrid('load');
            return;
        }

        if (emp1 == null) {
            $.messager.alert("系统提示", "请选择未添加员工进行添加！");
            return;
        }
        return emp1;
    }

    function getSelected2() {
        var emp1 = $("#dg1").datagrid("getSelected");
        var emp2 = $("#dg2").datagrid("getSelected");
        if (emp1 != null) {
            $.messager.alert("系统提示", "请选择已添加员工进行删除！");
            $('#dg1').datagrid('load');
            return;
        }

        if (emp2 == null) {
            $.messager.alert("系统提示", "请选择已添加员工进行删除！");
            return;
        }
        return emp2;
    }

    function addRole() {
        var selected = getSelected1();
        if (selected != null) {
            $.ajax({
                url: '${proPath}/roleAndEmp/addRoleAndEmp.mvc',
                data: {
                    roleId: role.roleId,
                    empId: selected.empId
                },
                dataType: 'json',
                method: 'post',
                success: function (param) {
                    if (param.msg == 1) {
                        parent.$.messager.show({
                            title: '系统提示',
                            width: 300,
                            height: 150,
                            msg: '添加员工成功',
                            timeout: 3000,
                            showType: 'slide',
                            size: 30
                        });
                        tg2();
                    } else if (param.msg == 0) {
                        parent.$.messager.show({
                            title: '系统提示',
                            width: 300,
                            height: 150,
                            msg: '员工已存在',
                            timeout: 3000,
                            showType: 'slide',
                            size: 30
                        });
                    } else {
                        parent.$.messager.show({
                            title: '系统提示',
                            width: 300,
                            height: 150,
                            msg: '添加员工失败',
                            timeout: 3000,
                            showType: 'slide',
                            size: 30
                        })
                    }
                }
            })
        }
    }

    function removeRole() {
        var selected2 = getSelected2();
        if (selected2 != null) {
            $.ajax({
                url: '${proPath}/roleAndEmp/removeRole.mvc',
                data: {
                    roleId: role.roleId,
                    empId: selected2.empId
                },
                dataType: 'json',
                method: 'post',
                success: function (param) {
                    if (param.msg == 1) {
                        parent.$.messager.show({
                            title: '系统提示',
                            width: 300,
                            height: 150,
                            msg: '删除员工成功',
                            timeout: 3000,
                            showType: 'slide',
                            size: 30
                        });
                        tg2();
                    }else {
                        parent.$.messager.show({
                            title: '系统提示',
                            width: 300,
                            height: 150,
                            msg: '删除员工失败',
                            timeout: 3000,
                            showType: 'slide',
                            size: 30
                        })
                    }
                }
            })
        }
    }

</script>
<style>
    #md {
        margin: 10px;
        width: 95%;
        border: 3px solid #685f66;
        height: 95%;
    }

    #d1, #d2, #d3 {
        margin: 18px;
        height: 92%;
    }

    #d1 {
        border: 1px black solid;
        width: 310px;
        float: left;
    }

    #d2 {
        margin-left: 36px;
        border: none;
        width: 100px;
        float: left;
    }

    #d3 {
        border: 3px solid black;
        width: 270px;
        float: right;
    }

    .datagrid-header .datagrid-cell span {
        font-size: 16px;
    }

    .datagrid-cell-c1-empName {
        width: 270px;
        color: revert;
    }

    .datagrid-header .datagrid-cell {
        height: auto;
        background-color: #ccc;

    }

</style>
<head>
    <title>Title</title>
</head>
<body style="margin: 0;padding: 0">
<div id="md">
    <div id="d1">
        <div style="padding-left: 1px;padding-top: 10%">
            <span>&nbsp;&nbsp;待选员工：
                <input type="text" id="name" name="empName" style="height: 25px">&nbsp;<input type="button" value="搜索"
                                                                                              onclick="selectRole()">
            </span>
            <div style="padding-top: 10px;width: 100%;height: 85%">
                <table id="dg1"></table>
            </div>
        </div>
    </div>
    <div id="d2">
        <div style="float: left;margin-top: 130px">
            <input type="button" value="添加 -----》" style="font-size: 18px" onclick="addRole()">
        </div>
        <div style="float: left;margin-top: 180px">
            <input type="button" value="《----- 移除" style="font-size: 18px" onclick="removeRole()">
        </div>
    </div>
    <div id="d3">
        <div style="padding-top: 10%;">
            <span style="font-size: 18px">&nbsp;&nbsp;&nbsp;已添加员工：</span>
            <div style="padding-top: 10px;height: 85%;width: 100%">
                <table id="dg2"></table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
