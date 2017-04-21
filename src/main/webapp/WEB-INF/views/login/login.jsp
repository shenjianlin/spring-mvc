<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/7/30 0030
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
</head>

    <form action="<%=request.getContextPath()%>/login/valLogin" method="post">
       <label>用户名：</label>
      <input type="text" id="userName" name="userName"/>

      <label>密码：</label>
      <input type="password" id="password" name="password"/>

      <input type="submit" value="提交"/>
    </form>

</body>
</html>
