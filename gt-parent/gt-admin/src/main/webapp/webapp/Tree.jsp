<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/27
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/common.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="tt" >
    <c:forEach var="s" items="${applicationScope.sysParamMap.directManagerType}">
        <c:set var="t" scope="page" value="${s.value}" />
    </c:forEach>
</table>
</body>
<script>
    $('#tt').treegrid({
        url: '${proPath}/directory/selectDirect.mvc',
        fit:true,
        idField: 'id',
        treeField: 'name',
        columns: [[
            {title: '名称 ', field: 'directName', width: 180},
            {field: 'directUrl', title: 'URL', width: 60, align: 'right'},
            {field: 'directManager', title: '权限编码', width: 80},
            {field:'directManagerType', title: '类型', width: 80},
            {field:'directType', title: '状态', width: 80},
            {field:'directSort', title: '排序', width: 80},
        ]]
    });
</script>
</html>
