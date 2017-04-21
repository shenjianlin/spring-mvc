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
    <title></title>
    <script type="text/javascript" src="<c:url value="/resources/jquery.js" />"></script>
</head>
  <a href="<%=request.getContextPath()%>/mvc/hello">hello world!</a>
<br/>
  <a href="<%=request.getContextPath()%>/mvc/hello1">hello1 world!</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/login/init">登  录</a>
<a href="${pageContext.request.contextPath}/login/init">登  录</a>

<br/>
<br/>
<a href="<%=request.getContextPath()%>/file/uploadInit">文件上传</a>

<br/>
<br/>

<form action="${pageContext.request.contextPath}/mvc/hello" method="post">

    <input type="submit" value="XXXX" />
</form>

</body>
</html>
