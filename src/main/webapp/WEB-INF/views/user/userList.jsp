<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/7/30 0030
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <script type="text/javascript" src="<c:url value="/resources/jquery.js" />"></script>
</head>
<br/>
<br/>
<br/>

<h2 align="center">系统登录用户列表</h2>

<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/user/addInit">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
用户编码：<input type="text" id="userId" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="view" value="查 询"/>
<br/><br/>
<table border="1" align="center">
    <thead>
    <tr>
        <td>序号</td>
        <td>用户编码</td>
        <td>用户名</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>电子邮件</td>
        <td>联系地址</td>
        <td>联系电话</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="data" varStatus="s">
        <tr>
            <td><c:out value="${s.index+1}"/></td>
            <td><c:out value="${data.userId}"/></td>
            <td><c:out value="${data.userName}"/></td>
            <td><c:out value="${data.password}"/></td>
            <td><c:out value="${data.birthday}"/></td>
            <td><c:out value="${data.email}"/></td>
            <td><c:out value="${data.address}"/></td>
            <td><c:out value="${data.phone}"/></td>
            <td>
                <a href="<%=request.getContextPath()%>/user/modifyInit?userId=${data.userId}">修 改</a>
                <a href="<%=request.getContextPath()%>/user/modifyInit2/${data.userId}">修 改2</a>
                <a href="<%=request.getContextPath()%>/user/delete/${data.userId}">删 除</a>
                <a href="<%=request.getContextPath()%>/user/delete2?userId=${data.userId}">删 除2</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<br/>
<br/><br/>
<div align="center">
    用户编码：<label id="user"></label><br/>
    登陆密码：<label id="password"></label><br/>
    用户名称：<label id="userName"></label><br/>
    出生年月：<label id="birthday"></label><br/>
    电子邮件：<label id="email"></label><br/>
    联系地址：<label id="address"></label><br/>
    联系电话：<label id="phone"></label><br/>

    <br/><br/>
    角色ID：<label id="roleId"></label><br/>
    角色名称：<label id="roleName"></label><br/>

    <br/><br/>
    <div id="scores"></div>
</div>
</body>
<script type="text/javascript">

    $(function () {

        $("#view").click(function () {
            var userId = $("#userId").val();

            $.ajax({
                type: "GET",
                url: "<%=request.getContextPath()%>/user/user.json/" + userId,
                contentType: "application/json",
                data: {},
                dataType: "json",
                success: function (data) {
//                    var user = eval(data);

                    $("#user").text(data.userId);
                    $("#userName").text(data.userName);
                    $("#password").text(data.password);
                    $("#birthday").text(data.birthday);
                    $("#email").text(data.email);
                    $("#address").text(data.address);
                    $("#phone").text(data.phone);
                    $("#roleId").text(data.role.roleId);
                    $("#roleName").text(data.role.roleName);

                    var html = '';
                    /*循环的时一对多的成绩*/
                    $.each(data.scores, function(index, text){
                        html += '<label>' + text['item']
                                + ':</label><label>' + text['scoreNum']
                                + '</label><br/>';
                    });

                    $('#scores').html(html);
                }
            });
        });
    });
</script>
</html>
