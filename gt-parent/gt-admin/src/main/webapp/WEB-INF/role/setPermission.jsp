<%--
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

    var contentWindow = parent.$("iframe[title='角色管理']").get(0).contentWindow;

    var role = contentWindow.$("#dg").datagrid("getSelected");

    $(function () {
        $('#tt').treegrid({
            url: '${proPath}/roleAndEmp/selectDirectAll.mvc',
            fit: true,
            rownumbers: true,
            lines: true,
            singleSelect:false,
            idField: 'id',
            treeField: 'directName',
            onLoadSuccess:function(){
                $.ajax({
                    url: '${proPath}/roleAndEmp/selectRole.mvc',
                    method:'post',
                    data: {
                        roleId: role.roleId
                    },
                    success:function (data) {
                        for (var i = 0; i < data.length; i++) {
                            var id = data[i].dirId;
                            $('#tt').treegrid("select",id);
                        }
                    }
                })
            },
            columns: [[
                {checkbox: true},
                {field: 'directName', title: '名称', width: 300},
                {field: 'directUrl', title: 'URL', width: 400},
                {field: 'directManager', title: '权限编码', width: 298},
                {
                    field: 'directManagerType', title: '类型', width: 100, formatter: function (value, row, index) {
                        if (value == 1) {
                            return '菜单';
                        }
                        if (value == 2) {
                            return '按钮';
                        }
                    }
                }
            ]],
            toolbar: [
                {
                    text: '保存',
                    iconCls: 'icon-save',
                    handler: function () {
                        var direct = $("#tt").treegrid("getSelections");
                        var array = new Array();
                        for (var i = 0;i<direct.length;i++){
                            array[i] = direct[i].directId;
                        }
                        $.ajax({
                            url: '${proPath}/roleAndEmp/saveDirectory.mvc',
                            data:{
                                roleId:role.roleId,
                                array:array
                            },
                        })
                    }
                }, '-', {
                    text: '返回',
                    iconCls: 'icon-back',
                    handler: function () {
                        parent.$('#win').window("close");
                    }
                }
            ]
        });
    });
</script>
<body>
<table id="tt"></table>
</body>
</html>
--%>
