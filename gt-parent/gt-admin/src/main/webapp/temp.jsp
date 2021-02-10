<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/6
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/common.jsp" %>
<html>
<head>
    <title>模板页面</title>
</head>
<body>
<ul id="tt"></ul>

<c:forEach var="directory" items="${applicationScope.directory}">
    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
        <div title=${directory.directName}  style="padding:10px;">
        </div>
    </div>
</c:forEach>


</body>
<script>
    $(function () {
        $('#tt').tree({
            url: '${proPath}/directory/selectDirect.mvc',
        });
    })
</script>
</html>


<%--
<c:forEach var="directory" items="${applicationScope.first}">
    <div id="aa" class="easyui-accordion" data-options="selected:true" style="width:240px;">
        <div title=${directory.directName}   style="overflow:auto;padding:10px" data-options="selected:false">
            <c:forEach var="directories" items="${applicationScope.second}">
                <c:if test="${directory.directId == directories.fatherDirect}">
                    <a id="btn" href="#" class="easyui-linkbutton">${directories.directName}</a>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:forEach>--%>
