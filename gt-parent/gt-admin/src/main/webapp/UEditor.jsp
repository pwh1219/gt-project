<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2021/1/5
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%-- 引入UEditor js 文件--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.min.js"></script>
<body>
<form action="${pageContext.request.contextPath}/ueditor/ue.mvc" method="post">
    <script id="ue" name="ue" type="text/plain">
    这里是富文本编辑器
    </script>
    <script type="text/javascript">
        <%-- UE.getEditor("container") 中的  container 要和上边的id一样 --%>
        var ue = UE.getEditor("ue", {
            // 设置UEditor的参数
            // 宽度
            initialFrameWidth: 500,
            // 高度
            initialFrameHeight: 200,
            // 工具栏
            toolbars: [
                ['undo', 'redo', 'bold', 'italic', 'underline', 'fontborder', 'formatmatch', 'forecolor', 'backcolor', 'fontfamily', 'fontsize', 'indent', 'justifyleft', 'justifyright', 'justifycenter', 'justifyjustify', 'insertimage', 'attachment', 'inserttable', 'deletetable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols']]
        });
    </script>
    <input type="submit">
</form>
</body>
</html>
