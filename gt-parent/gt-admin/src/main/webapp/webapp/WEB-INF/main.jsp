<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020/12/17
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp" %>


<script type="text/javascript" src="${proPath}/js/main.js"></script>
<link type="text/css" rel="stylesheet" href="${proPath}/css/main.css">
<html>
<head>
    <title>Title</title>
</head>
<script>
    /* $(function () {
         $.ajax({
             url: '${proPath}/directory/selectDirect.mvc',
            success: function (directories) {
                $.each(directories, function (i, d) {
                    $('#aa').accordion({
                        animate: false
                    });
                })
            },
        })
    });
*/

    function updatepwd(url) {
        $('#win').window({
            collapsible: false,
            minimizable: false,
            maximizable: false,
            title: '修改密码',
            width: 700,
            height: 500,
            modal: true,
            content: '<iframe src="' + url + '"  width="100%" height="100%" frameborder="no"></iframe>',
        });
    }

    function logout() {
        $.messager.confirm('系统提示', '您确认要退出系统吗？', function (r) {
            if (r) {
                window.location = "${proPath}/emp/logout.mvc";
                <%--url:'${proPath}/emp'--%>
                <%--     异步方法不能返回同步页面
                    $.ajax({
                                   url:'${proPath}/emp/logout.mvc',
                                    type:'post'
                           })
                --%>
            }
        });
    }

    /*    history.pushState(null, null, "${proPath}/login.jsp");
    window.addEventListener('popstate', function () {
        history.pushState(null, null, "${proPath}/login.jsp");
    });*/

    $(function () {
        $.ajax({
            url: '${proPath}/directory/selectDirect.mvc',
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var directory = data[i];
                    if (directory.directId === 1) {
                        $('#aa').accordion('add', {
                            title: directory.directName,
                            selected: true,
                            id: directory.directId
                        });
                    } else {
                        $('#aa').accordion('add', {
                            title: directory.directName,
                            selected: false,
                            id: directory.directId
                        });
                    }

                    $('#' + directory.directId + '').tree({
                            data: directory.children,
                            onClick: function (node) {
                                $('#tt').tabs('add', {
                                    title: node.directName,
                                    content: '<iframe src="${proPath}' + node.directUrl + '.mvc" title="'+node.directName+'" width="100%" height="100%" frameborder="0px"></iframe>',
                                    border: false,
                                    closable: true,
                                    tools: [{
                                        iconCls: 'icon-mini-refresh',
                                        handler: function () {}
                                    }]
                                })
                            }
                        }
                    )
                }
            }
        })
        ;
    });

    $(function () {
        $("#td1").tabs({
            iconCls: 'icon-mini-refresh'
        })
    });

    $(function () {
        $('#tt').tabs({
            border: false,
            fit: true
        });
    })
</script>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true" style="width:600px;height:400px;">
    <div data-options="region:'north',title:'',split:false,collapsible:false"
         style="height:50px;background-color: #eeb882">
        <img id="img1" src="${proPath}/img/dc.jpg" alt="图片丢失">
        <div style="display:inline-block;"><span style="font-size:26px;color: #8F5700;padding-left: 5px">
            软拓点餐后台管理系统</span>
        </div>
        <div style="float: right">
            <span style="font-size: 20px;">欢迎您：</span>
            <span id="span2" style="color: red;font-size: 30px;">${sessionScope.login.empName}</span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 30px"><a href="#" onclick="updatepwd('${proPath}/base/goURL/emp/updatepwd.mvc')"
                                             style="color: grey">修改密码</a>  </span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 30px"><a href="#" onclick="logout()" style="color: #ee1e34">退出系统</a>  </span>
        </div>
    </div>

    <div id="rr" data-options="region:'south',title:'',split:false,collapsible:false"
         style="height:41px;text-align: center;background-color: #8f8d91">
        <span style="font-size: 30px;font-family: 华文楷体;">系统版本号：v1.0.1 &nbsp;&nbsp;发布时间：2020 年  12 月 25 日</span>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:240px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true" style="background-color: #eeede0">
        </div>
    </div>

    <div id="ta1" data-options="region:'center',title:'',split:false" style="background:#eee;">
        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div data-options="closable:true" title="欢迎使用">
                <div>
                    <img src="${proPath}/img/bodybg.jpg" alt="图片丢失" style="width:1293px;height: 609px">
                </div>
            </div>
        </div>
    </div>
</div>

<div id="win"></div>
</body>
</html>
