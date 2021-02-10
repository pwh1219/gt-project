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
        loadParam();
    });

    function loadParam() {
        $('#dg').datagrid({
            url: '${proPath}/manage/manage.mvc',
            singleSelect: true,
            columns: [[
                {checkbox: true},
                {field: 'patNum', title: '模式编号', width: 150,},
                {field: 'manaPatNum', title: '餐营模式', width: 150},
                {
                    field: 'manaStatus', title: '启用', width: 150, formatter: function (value) {
                        if (value == 1) {
                            return "是";
                        }
                        if (value == 2) {
                            return "否";
                        }
                    }
                }
            ]],
            toolbar: [
                {
                    text: '启用',
                    iconCls: 'icon-ok',
                    handler: function () {
                        var rows = $("#dg").datagrid("getSelected");
                        if (rows == null) {
                            $.messager.alert("系统提示", "请选择启用记录！");
                            return;
                        }
                        $.messager.confirm('确认', '确认启用？', function (r) {
                            if (r) {
                                $.ajax({
                                    url: '${proPath}/manage/updateManage.mvc',
                                    data: {
                                        manaStatus: rows.manaStatus,
                                        manaPatNum: rows.manaPatNum,
                                        patNum: rows.patNum
                                    },
                                    method: 'post',
                                    success: function (param) {
                                        if (param.msg === 1) {
                                            parent.$.messager.show({
                                                title: '系统提示',
                                                width: 300,
                                                height: 150,
                                                msg: '操作成功',
                                                timeout: 3000,
                                                showType: 'slide',
                                                size: 30
                                            });
                                            $("#dg").datagrid("load");
                                        } else {
                                            $.messager.show({
                                                title: '系统提示',
                                                msg: '操作失败',
                                                timeout: 3000,
                                                showType: 'slide'
                                            })
                                        }
                                    }
                                })
                            }
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
        $('#tt').tabs({
            border: false,
            onSelect: function (title) {
               if (title == "餐营模式"){
                   loadParam();
               }else {
                   loadParam2();
               }
            }
        });
    });

    function loadParam2() {
        $('#dg2').datagrid({
            url: '${proPath}/pay/pay.mvc',
            singleSelect: true,
            columns: [[
                {checkbox: true},
                {field: 'proNum', title: '流程编号', width: 150,},
                {field: 'payPro', title: '支付流程', width: 150},
                {
                    field: 'payProStatus', title: '启用', width: 150, formatter: function (value) {
                        if (value == 1) {
                            return "是";
                        }
                        if (value == 2) {
                            return "否";
                        }
                    }
                }
            ]],
            toolbar: [
                {
                    text: '启用',
                    iconCls: 'icon-ok',
                    handler: function () {
                        var rows = $("#dg2").datagrid("getSelected");
                        if (rows == null) {
                            $.messager.alert("系统提示", "请选择启用记录！");
                            return;
                        }
                        $.messager.confirm('确认', '确认启用？', function (r) {
                            if (r) {
                                $.ajax({
                                    url: '${proPath}/pay/updatePay.mvc',
                                    data: {
                                        proNum: rows.proNum,
                                        payPro: rows.payPro,
                                        payProStatus: rows.payProStatus
                                    },
                                    method: 'post',
                                    success: function (param) {
                                        if (param.msg === 1) {
                                            parent.$.messager.show({
                                                title: '系统提示',
                                                width: 300,
                                                height: 150,
                                                msg: '操作成功',
                                                timeout: 3000,
                                                showType: 'slide',
                                                size: 30
                                            });
                                            $("#dg2").datagrid("load");
                                        }else if (param.msg === 2){
                                            parent.$.messager.show({
                                                title: '系统提示',
                                                width: 300,
                                                height: 150,
                                                msg: '该记录不可以重复启用',
                                                timeout: 3000,
                                                showType: 'slide',
                                                size: 30
                                            });
                                        } else {
                                            $.messager.show({
                                                title: '系统提示',
                                                msg: '操作失败',
                                                timeout: 3000,
                                                showType: 'slide'
                                            })
                                        }
                                    }
                                })
                            }
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
</script>
<head>
    <title>Title</title>
</head>
<body>

<div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
    <div title="餐营模式">
        <div>
            <table id="dg"></table>
        </div>
    </div>
    <div title="支付流程">
        <div>
            <table id="dg2"></table>
        </div>
    </div>
</div>

</body>
</html>

