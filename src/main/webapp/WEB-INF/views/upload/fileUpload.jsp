<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/7/30 0030
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/file/upload" enctype="multipart/form-data" method="post">

  <input type="file" name="file"/>
  <input type="submit"/>
</form>

</body>
</html>
