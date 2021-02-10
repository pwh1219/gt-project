<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/31
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #d1, #d2, #d3 {
        padding-top: 3%;
        padding-left: 30%;
    }

    #d4 {
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
    var contentWindow = parent.$("iframe[title='角色管理']").get(0).contentWindow;

    var role = contentWindow.$("#dg").datagrid("getSelected");

    $(function () {
        alert(role.roleId);
        var time = dateFormat(role.roleCreateTime);
        $('#ff').form('load', {
            roleId:role.roleId,
            roleName: role.roleName,
            roleCreateTime:time,
            roleStatus:role.roleStatus
        });
    });

    function save() {
        $('#ff').form('submit', {
            url: '${proPath}/role/updateRole.mvc',
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
                    }, 2000);
                } else {
                    $.messager.show({
                        title: '系统提示',
                        msg: '修改失败',
                        timeout: 3000,
                        showType: 'slide'
                    })
                }
            }
        });
    }

    function loadData() {
        contentWindow.$("#dg").datagrid('load');
    }

    function closedWindow() {
        parent.$("#win").window('close');
    }
</script>
<body>
<form id="ff" method="post">
    <input type="hidden" name="roleId">
    <div style="padding-top: 3%">
        <div id="d1">
            <div style="float: left;width: 120px;padding-top: 2px"><label for="roleName" id="roleName"
                                                                          style="font-size: 19px">名称:</label>
            </div>
            <input class="easyui-validatebox" data-options="required:true" type="text" name="roleName"
                   style="width: 300px;font-size: 18px"/>
        </div>

        <div id="d2">
            <div style="float: left;width: 120px;padding-top: 2px"><label for="roleCreateTime" id="roleCreateTime"
                                                                          style="font-size: 19px">创建时间:</label>
            </div>
            <span>
                <input class="easyui-datetimebox" name="roleCreateTime" data-options="showSeconds:true" style="width: 300px;height:26.8px;font-size: 20px">
            </span>
        </div>

        <div id="d3">
            <div style="float: left;width: 120px"><label for="roleStatus" style="font-size: 19px">状态：</label>
            </div>
            <select id="roleStatus" class="easyui-combox" name="roleStatus"
                    style="width: 300px;font-size: 18px">
                <c:forEach items="${applicationScope.sysParamMap.role_status}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>

        <div id="d4">
            <span style="font-size: 18px"><input type="button" value="保存" style="font-size: 18px"
                                                 onclick="save()"></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 18px"><input type="button" value="返回" style="font-size: 18px"
                                                 onclick="closedWindow()"></span>
        </div>

    </div>
</form>
</body>
</html>
