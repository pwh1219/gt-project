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
                window.location = "${proPath}/user/logout";
            }
        });
    }

    $(function () {
        $.ajax({
            url: '${proPath}/authority/selectAuthority',
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var authority = data[i];
                    if (authority.authorityId === 1) {
                        $('#aa').accordion('add', {
                            title: authority.authorityName,
                            selected: true,
                            id: authority.authorityId
                        });
                    } else {
                        $('#aa').accordion('add', {
                            title: authority.authorityName,
                            selected: false,
                            id:authority.authorityId
                        });
                    }

                    $('#' + authority.authorityId + '').tree({
                            data: authority.children,
                            onClick: function (node) {
                                $('#tt').tabs('add', {
                                    title: node.authorityName,
                                    content: '<iframe src="${proPath}' + node.authorityUrl + '.mvc" title="' + node.authorityName + '" width="100%" height="100%" frameborder="0px"></iframe>',
                                    border: false,
                                    closable: true,
                                    tools: [{
                                        iconCls: 'icon-mini-refresh',
                                        handler: function () {
                                        }
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
         style="height:36px;">

        <div style="float: left">
            <img id="img1" src="${proPath}/img/dc.jpg" alt="图片丢失">
        </div>

        <div style="float: left;padding-top: 3px;padding-left: 2px">
            <span style="font-size:20px;padding-left: 5px">高吧后台管理系统</span>
        </div>

        <div style="float: right;padding-top: 5px">
            <span style="font-size: 20px;">欢迎您：</span>
            <span id="span2" style="font-size: 20px;">
                ${sessionScope.login.userName}
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 20px">
                <a href="#" onclick="updatepwd('${proPath}/base/goURL/emp/updatepwd')">修改密码</a>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size: 20px">
                <a href="#" onclick="logout()">退出系统</a>
            </span>
            &nbsp;&nbsp;
        </div>
    </div>

    <div id="rr" data-options="region:'south',title:'',split:false,collapsible:false"
         style="height:41px;text-align: center;">
        <span style="font-size: 30px;font-family: 华文楷体;">系统版本号：v1.0.1 &nbsp;&nbsp;发布时间：2020 年  12 月 25 日</span>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:240px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true">
        </div>
    </div>

    <div id="ta1" data-options="region:'center',title:'',split:false">
        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div data-options="closable:true" title="欢迎使用"  style="background-image:url('/img/gt-back.jpg');background-size: 100%;">
                <div style="background: image('${proPath}/img/gt-back')">
                </div>
            </div>
        </div>
    </div>
</div>

<div id="win"></div>
</body>
</html>
