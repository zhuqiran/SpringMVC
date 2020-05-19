<%--
  User: zhqiran
  Date: 2020/5/19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <div align="center" style="margin-top: 50px;">
        <table cellspacing="0" cellpadding="5" border="0">
            <form action="/08_springmvc_spring_mybatis_1/process/addStudent.action" method="post">
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age"/></td>
                </tr>
                <tr>
                    <td>分数：</td>
                    <td><input type="text" name="score"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交" align="right"/></td>
                </tr>
            </form>
        </table>
    </div>
</body>
</html>
