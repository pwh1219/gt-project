<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/24
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="/common/common.jsp" %>
<script>
    $(function () {
        $('#tt').tabs({
            fit: true,
            border: false
        })
    });

    function loadRole() {
        $('#dg').datagrid({
            url: '${proPath}/role/selectAll.mvc',
            singleSelect:true,
            columns: [[
                {checkbox: true},
                {field: 'roleName', title: '角色名称', width: 300,},
                {
                    field: 'roleStatus', title: '状态', width: 300, formatter: function (value, row, index) {
                        if (value == 1) {
                            return "可用";
                        }
                        if (value == 2) {
                            return "禁用";
                        }
                    }
                },
                {
                    field: 'roleCreateTime', title: '创建时间', width: 300, formatter: function (value, row, index) {
                        return dateFormat(value);
                    }
                },
            ]],
            toolbar: [{
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    parent.$('#win').window({
                        title: '添加角色',
                        width: 1200,
                        height: 600,
                        collapsible: false,
                        minimizable: false,
                        maximizable: false,
                        draggable: false,
                        resizable: false,
                        content: "<iframe src='${proPath}/base/goURL/role/addRole.mvc' width=100% height=100% frameborder='0px'></iframe>",
                        modal: true
                    });
                }
            }, '-', {
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    var role = $("#dg").datagrid("getSelected");
                    if (role.roleName === "系统管理员"){
                            $.messager.alert("系统提示","系统管理员不可以修改");
                            return;
                    }
                    parent.$('#win').window({
                        title: '修改菜单权限',
                        width: 1200,
                        height: 600,
                        collapsible: false,
                        minimizable: false,
                        maximizable: false,
                        draggable: false,
                        resizable: false,
                        content: "<iframe src='${proPath}/base/goURL/role/updateRole.mvc'  width=100% height=100% frameborder='0px'></iframe>",
                        modal: true
                    });
                }
            }, '-', {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    var role = $("#dg").datagrid("getSelected");
                    if (role.roleName === "系统管理员"){
                        $.messager.alert("系统提示","系统管理员不可以修改");
                        return;
                    }
                    $.messager.confirm("系统提示", "确认删除数据？", function x(r) {
                        if (r) {
                            $.ajax({
                                url: '${proPath}/role/deleteRole.mvc',
                                data: {roleId: '' + role.roleId + ''},
                                method: "post",
                                success: function (param) {
                                    // var param = eval('(' + data + ')');
                                    if (param.msg === 1) {
                                        parent.$.messager.show({
                                            title: '系统提示',
                                            width: 300,
                                            height: 150,
                                            msg: '删除成功',
                                            timeout: 3000,
                                            showType: 'slide',
                                            size: 30
                                        });
                                        setTimeout(function () {
                                            $("#dg").datagrid("reload");
                                        }, 2000);
                                    } else {
                                        $.messager.show({
                                            title: '系统提示',
                                            msg: '添加失败',
                                            timeout: 3000,
                                            showType: 'slide'
                                        })
                                    }
                                }
                            })
                        } else {
                            parent.$("#win").window('close');
                        }
                    })
                }
            }, '-', {
                text: '设置人员',
                iconCls: 'icon-add',
                handler: function () {
                    parent.$('#win').window({
                        title: '设置人员',
                        width: 900,
                        height: 600,
                        collapsible: false,
                        minimizable: false,
                        maximizable: false,
                        draggable: false,
                        resizable: false,
                        content: "<iframe src='${proPath}/base/goURL/role/setRole.mvc' width=100% height=100% frameborder='0px'></iframe>",
                        modal: true
                    });
                }
            }, '-', {
                text: '设置权限',
                iconCls: 'icon-add',
                handler: function () {
                    var row = $("#dg").datagrid("getSelected");
                    if (row == null){
                        $.messager.alert("系统提示","请选择需要设置权限的角色！");
                        return
                    }
                    parent.$('#win').window({
                        title: '设置权限',
                        width: 1200,
                        height: 600,
                        collapsible: false,
                        minimizable: false,
                        maximizable: false,
                        draggable: false,
                        resizable: false,
                        content: "<iframe src='${proPath}/base/goURL/role/setPermission.mvc' width=100% height=100% frameborder='0px'></iframe>",
                        modal: true
                    });
                }
            }],
            fitColumns: true,
            pagination: true,
            rownumbers: true,
            pageSize: 10,
            pageList: [5, 10, 15, 20, 50],

        })
    }

    $(function () {
        loadRole();
    })
</script>
<body>
<div id="tt" class="easyui-tabs" data-options="fit:true">
    <div id="reloads" title="角色列表" style="background-color: rgba(104,95,102,0.33)">
        <table id="dg"></table>
    </div>
</div>
</body>
</html>
