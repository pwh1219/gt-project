<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2021/1/3
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="/common/common.jsp" %>
<script>
    // 返回iframe页面文档（window）
    var contentWindow = parent.$("iframe[title='职务管理']").get(0).contentWindow;
    var rows = contentWindow.$("#dg").datagrid("getSelected");

    $(function () {
        $("#ff").form('load', {
            empDutyParentCompany: rows.empDutyParentCompany,
            empDutyShopName: rows.empDutyShopName,
            empDutyDeptType:rows.empDutyDeptType,
            empDutyId:rows.empDutyId
        })
    });

    function save() {
        $('#ff').form('submit', {
            url: '${proPath}/duty/updateDuty.mvc',
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
<style>
    #d1, #d2, #d3,#d4,#d5 {
        padding-top: 3%;
        padding-left: 24%;
    }

    #d6 {
        padding-top: 6%;
        padding-left: 42%;
    }
</style>
<body>
<form id="ff" method="post">
    <INPUT TYPE="hidden" NAME="empDutyId">
    <div style="padding-top: 3%">
        <div id="d1">
            <div style="float: left;width: 120px;padding-top: 2px">
                <label for="empDutyParentCompany" id="empDutyParentCompany" style="font-size: 19px">总店铺名称:</label>
            </div>
            <input class="easyui-validatebox" data-options="required:true"
                   type="text" name="empDutyParentCompany" style="width: 300px;font-size: 18px"/>
        </div>

        <div id="d2">
            <div style="float: left;width: 120px;padding-top: 2px">
                <label for="empDutyShopName" id="empDutyShopName" style="font-size: 19px">店铺名称:</label>
            </div>
            <input class="easyui-validatebox" data-options="required:true"
                   type="text" name="empDutyShopName" style="width: 300px;font-size: 18px"/>
        </div>

        <div id="d3">
            <div style="float: left;width: 120px;padding-top: 2px">
                <label for="empDutyName" id="empDutyName" style="font-size: 19px">职务:</label>
            </div>
            <input class="easyui-validatebox" data-options="required:true"
                   type="text" name="empDutyName" style="width: 300px;font-size: 18px"/>
        </div>

        <div id="d4">
            <div style="float: left;width: 120px">
                <label for="empDutyUerStatus" style="font-size: 19px">是否启用：</label>
            </div>
            <select id="empDutyUerStatus" class="easyui-combox" name="empDutyUerStatus"
                    style="width: 300px;font-size: 18px">
                <c:forEach items="${applicationScope.sysParamMap.emp_duty_uer_status}" var="s">
                    <option value="${s.key}">${s.value}</option>
                </c:forEach>
            </select>
        </div>

        <div id="d5">
            <div style="float: left;width: 120px;padding-top: 2px">
                <label for="empDutyComment" id="empDutyComment" style="font-size: 19px">备注:</label>
            </div>
            <input class="easyui-validatebox"
                   type="text" name="empDutyComment" style="width: 300px;font-size: 18px"/>
        </div>

        <div id="d6">
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
