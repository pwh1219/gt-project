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
        $('#tt').tabs({
            fit: true,
            border: false
        })
    });

    $(function () {
        $('#pp').pagination({});
    });

    function reloads() {
        $.messager.confirm('系统提示','您想要重新加载系统参数吗？',function(r){
            if (r){
                loadParam();
                $.messager.show({
                    title:'系统提示',
                    msg:'系统参数加载成功',
                    timeout:5000,
                    showType:'show'
                })
            }
        });
    }

    function loadParam() {
        $('#dg').datagrid({
            url: '${proPath}/sysParam/loadParams.mvc',
            columns: [[
                {field: 'sysParamField', title: '所属类型键', width: 300,},
                {field: 'sysParamType', title: '所属类型名', width: 300},
                {field: 'sysParamValue', title: '参数键', width: 300},
                {field: 'sysParamText', title: '参数值', width: 300}
            ]],
            fitColumns: true,
            pagination: true,
            rownumbers: true,
            pageSize: 10,
            pageList: [5, 10, 15, 20, 50],
        });
    }

    $(function () {
        loadParam();
    })
</script>
<head>
    <title>Title</title>
</head>
<body>
<div id="tt" class="easyui-tabs" data-options="fit:true">
    <div id="reloads" title="系统参数列表" style="background-color: rgba(104,95,102,0.33)">
        <div style="background-color: rgba(238,161,42,0.39)">
            <div style="width: 300px;height: 30px;padding-left: 20px" onclick="reloads()">
                <a href="#" style="text-decoration:none;color: #685f66">
                    <span><img src="/img/reload.png"></span>&nbsp;&nbsp;
                    <span style="font-size: 20px">重新加载系统参数</span>
                </a>
            </div>
        </div>
        <table id="dg"></table>
    </div>
</div>
</body>
</html>
