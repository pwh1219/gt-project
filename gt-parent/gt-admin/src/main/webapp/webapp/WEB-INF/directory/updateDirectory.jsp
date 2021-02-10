<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/28
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #d1, #d3, #d4, #d5, #d6 {
        padding-top: 3%;
        padding-left: 30%;
    }

    #d7 {
        padding-top: 6%;
        padding-left: 42%;
    }
</style>
<head>
    <title>Title</title>
</head>
<%@include file="/common/common.jsp" %>
<script>
    // 返回iframe页面文档（window）
    var contentWindow = parent.$("iframe[title='目录管理']").get(0).contentWindow;
    var direct = contentWindow.$("#tt").treegrid("getSelected");

    $(function () {
        $('#ff').form('load', {
            directId: direct.directId,
            directName:direct.directName,
            directUrl:direct.directUrl
        });
    });


    function save() {
        $('#ff').form('submit', {
            url: '${proPath}/directory/updateDirect.mvc',
            success: function (data) {
                var param = eval('(' + data + ')');
                if (param.msg === 1) {
                    parent.$.messager.show({
                        title: '系统提示',
                        width: 300,
                        height: 150,
                        msg: '修改成功',
                        timeout: 3000,
                        showType: 'slide',
                        size: 30
                    });
                    setTimeout(function () {
                        loadData();
                        closedWindow();
                    }, 4000);
                } else {
                    $.messager.show({
                        title: '系统提示',
                        msg: '修改失败',
                        timeout: 3000,
                        showType: 'slode'
                    })
                }
            }
        });
    }

    function loadData() {
        contentWindow.$("#tt").treegrid('reload');
    }

    function closedWindow() {
        parent.$("#win").window('close');
    }
</script>
<body>
<form id="ff" method="post">
    <input type="hidden" name="directId">
    <div style="padding-top: 3%">
        <div id="d1">
            <div style="float: left;width: 120px;padding-top: 2px"><label for="directName" id="directName" style="font-size: 19px">名称:</label>
            </div>
            <input class="easyui-validatebox" type="text" name="directName"
                   style="width: 500px;font-size: 18px"/>
        </div>

        <div id="d3">
            <div style="float: left;width: 120px"><label for="directUrl" id="directUrl"
                                                         style="font-size: 19px">URL:</label></div>
            <input class="easyui-validatebox" type="text" name="directUrl" style="width: 500px;font-size: 18px"/>
        </div>

        <div id="d4">
            <div style="float: left;width: 120px"><label for="directManager" id="directManager" style="font-size: 19px">权限编码:</label>
            </div>
            <input class="easyui-validatebox" type="text" name="directManager" readonly="readonly"
                   style="width: 500px;font-size: 18px"/>
        </div>

        <div id="d5">
            <div style="float: left;width: 120px"><label for="directManagerType" style="font-size: 19px">类型：</label>
            </div>
            <select id="directManagerType" class="easyui-combox" name="directManagerType"
                    style="width: 500px;font-size: 18px">
                <c:forEach items="${applicationScope.sysParamMap.direct_manager_type}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>

        <div id="d6">
            <div style="float: left;width: 120px"><label for="directType" style="font-size: 19px">状态：</label></div>
            <select id="directType" class="easyui-combox" name="directType" style="width: 500px;font-size: 18px">
                <c:forEach items="${applicationScope.sysParamMap.direct_type}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>

        <div id="d7">
            <span style="font-size: 18px"><input type="button" value="保存" style="font-size: 18px" onclick="save()"></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 18px"><input type="button" value="返回" style="font-size: 18px"
                                                 onclick="closedWindow()"></span>
        </div>

    </div>
</form>
</body>
</html>
