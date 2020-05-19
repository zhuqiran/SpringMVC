<%--
  User: zhqiran
  Date: 2020/5/19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询页面</title>
    <script src="/08_springmvc_spring_mybatis_1/static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            loadStudents();
        });
        // 加载数据
        function loadStudents() {
            $.post("/08_springmvc_spring_mybatis_1/process/listStudent.action", {"id": "id"}, function (resp) {
                if(resp){
                    $('#tbody').html("");
                    // 遍历json，为表格赋值
                    $.each(resp, function (i, item) {
                        $('#tbody').append("<tr>").append("<td>"+item.name+"</td>").append("<td>"+item.age+"</td>").append("<td>"+item.score+"</td>").append("</tr>");
                    })
                }
            }, "json");
        }
    </script>
</head>
<body>
<div align="center" style="margin-top: 50px;">
    <table cellspacing="0" cellpadding="5" border="1">
        <thead>
            <tr>
                <td>姓名</td>
                <td>年龄</td>
                <td>分数</td>
            </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</div>
</body>
</html>
