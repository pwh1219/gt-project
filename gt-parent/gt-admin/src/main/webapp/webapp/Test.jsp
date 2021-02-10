<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/27
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="tt" style="width:600px;height:400px"></table>
</body>
<script>
    $('#tt').treegrid({
        url:'${proPath}/Tree.json',
        idField:'id',
        treeField:'name',
        columns:[[
            {title:'Task Name',field:'directName',width:180},
            {field:'persons',title:'Persons',width:60,align:'right'},
            {field:'begin',title:'Begin Date',width:80},
            {field:'end',title:'End Date',width:80}
        ]]
    });
</script>
</html>
