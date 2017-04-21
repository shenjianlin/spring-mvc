<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/7/30 0030
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户新增</title>
</head>
<body>
      <form action="<%=request.getContextPath()%>/user/add" method="post">
          <table border="1" align="center">
              <tr>
                <td>用户编码：</td>
                <td><input type="text" name="userId" /></td>
              </tr>
              <tr>
                <td>用户名称：</td>
                <td><input type="text" name="userName" /></td>
              </tr>
              <tr>
                <td>登陆密码：</td>
                <td><input type="text" name="password"/></td>
              </tr>
              <tr>
                <td>性别：</td>
                <td><input type="text" name="sex"/></td>
              </tr>
              <tr>
                <td>出生日期：</td>
                <td><input type="text" name="birthday"/></td>
              </tr>
              <tr>
                <td>电子邮件：</td>
                <td><input type="text" name="email"/></td>
              </tr>
              <tr>
                <td>联系地址：</td>
                <td><input type="text" name="address"/></td>
              </tr>
              <tr>
                <td>联系电话：</td>
                <td><input type="text" name="phone"/></td>
              </tr>
              <tr align="center">
                <td><input type="submit" value="提 交"/></td>
                <td><input type="reset" value="重 置"/></td>
              </tr>
          </table>

      </form>
</body>
</html>
