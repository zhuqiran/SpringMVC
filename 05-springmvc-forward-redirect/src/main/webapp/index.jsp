<%--
  User: zhqiran
  Date: 2020/5/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
</head>
<body>
    <p>------------演示forward-------------</p>
    <form action="test/forwardToView.action" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age">
        <input type="submit" value="forward到视图">
    </form>
    <hr>
    <form action="test/forwardToController.action" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age">
        <input type="submit" value="forward到控制器">
    </form>

    <p>------------演示redirect------------</p>
    <form action="test/redirectToView.action" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age">
        <input type="submit" value="forward到控制器">
    </form>

    <hr>
    <form action="test/redirectToController.action" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age">
        <input type="submit" value="forward到控制器">
    </form>
</body>
</html>
