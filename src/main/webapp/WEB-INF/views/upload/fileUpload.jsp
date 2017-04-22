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

方法1：
<form action="<%=request.getContextPath()%>/file/upload1" enctype="multipart/form-data" method="post">

    <input type="file" name="file"/>
    <input type="submit"/>
</form>
<br/>
<br/>
<br/>
<br/>

方法2：
<form action="<%=request.getContextPath()%>/file/upload2" enctype="multipart/form-data" method="post">

    <input type="file" name="file" />
    <input type="submit"/>
</form>

<br/>
<br/>
<br/>
<br/>
方法3：
<form action="<%=request.getContextPath()%>/file/upload3" enctype="multipart/form-data" method="post">

    <input type="file" name="file1"/>
    <br/>
    <input type="file" name="file2"/>
    <br/>
    <input type="file" name="file3"/>
    <br/>
    <input type="file" name="file4"/>
    <input type="submit"/>
    <br/>
</form>
<br/>
<br/>
<br/>
<br/>

方法4：

<form action="<%=request.getContextPath()%>/file/upload4" enctype="multipart/form-data" method="post">

    <input type="file" name="files" multiple/>

    <input type="submit"/>
    <br/>
</form>

</body>
</html>
