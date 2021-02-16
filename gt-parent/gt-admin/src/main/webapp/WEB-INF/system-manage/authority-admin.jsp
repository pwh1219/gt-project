<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/24
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/common/common.jsp" %>
<head>
    <title>Title</title>
</head>
<script>
    $(function () {
        loadData();
    });

    function loadData() {
        $('#tt').treegrid({
            url: '${proPath}/directory/selectDirectAll.mvc',
            fit: true,
            rownumbers: true,
            lines: true,
            idField: 'id',
            treeField: 'directName',
            columns: [[
                {checkbox: true},
                {field: 'directName', title: '名称', width: 200},
                {field: 'directUrl', title: 'URL', width: 400},
                {field: 'directManager', title: '权限编码', width: 300},
                {
                    field: 'directManagerType', title: '类型', width: 100, formatter: function (value, row, index) {
                        if (value == 1) {
                            return '菜单';
                        }
                        if (value == 2) {
                            return '按钮';
                        }
                    }
                },
                {
                    field: 'directType', title: '状态', width: 100, formatter: function (value, row, index) {
                        if (value == 1) {
                            return '可用';
                        }
                        if (value == 2) {
                            return '禁用';
                        }
                    }
                },
                {field: 'directSort', title: '排序', width: 100},
            ]],
            toolbar: [
                {
                    text: '添加根菜单',
                    iconCls: 'icon-add',
                    handler: function () {
                        parent.$('#win').window({
                            center: '',
                            title: '添加子菜单或者按钮',
                            width: 1200,
                            height: 600,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/directory/addRoot.mvc' title='添加子菜单或者按钮' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }, '-', {
                    text: '添加子菜单或者按钮',
                    iconCls: 'icon-add',
                    handler: function () {
                        var direct = $("#tt").treegrid("getSelected");
                        if (direct == null) {
                            $.messager.alert("系统提示", "请选择给父菜单添加！");
                            return;
                        }

                        if (direct.directManagerType === "2") {
                            $.messager.alert("系统提示", "请选择菜单类型作为父菜单！");
                            return;
                        }

                        parent.$('#win').window({
                            title: '添加子菜单或者按钮',
                            width: 1200,
                            height: 600,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/directory/addDirectory.mvc' title='添加子菜单或者按钮' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }, '-', {
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        parent.$('#win').window({
                            title: '修改菜单权限',
                            width: 1200,
                            height: 600,
                            collapsible: false,
                            minimizable: false,
                            maximizable: false,
                            draggable: false,
                            resizable: false,
                            content: "<iframe src='${proPath}/base/goURL/directory/updateDirectory.mvc' title='修改菜单权限' width=100% height=100% frameborder='0px'></iframe>",
                            modal: true
                        });
                    }
                }, '-', {
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function () {
                        var id = $("#tt").treegrid("getSelected");
                        $.messager.confirm("系统提示", "确认删除数据？", function x(r) {
                            if (r) {
                                $.ajax({
                                    url: '${proPath}/directory/delete.mvc',
                                    data: {directId: '' + id.directId + ''},
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
                                                $("#tt").treegrid("reload");
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
                }
            ]
        })
    }
</script>
<body>
<table id="tt"></table>
</body>
</html>
