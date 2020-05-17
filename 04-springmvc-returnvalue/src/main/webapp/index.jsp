<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>index page</title>
    <script src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#commit').click(function () {
                // 发送ajax请求
                $.ajax({
                    url: "test/returnString.action",
                    data:{"name": "王五", "age": 25},
                    /*dataType: "json",*/       /*返回数据类型为字符串时，不能指定类型为json，否则会出现解析错误*/
                    success:function (resp) {
                        alert(resp);
                    }
                });
            });
        });
    </script>
</head>
<body>
<div>
    <input type="button" id="commit" value="ajax请求">
    <br>
    <img src="static/images/1.jpg" style="width: 300px; height: 300px;" alt="图像未成功显示"/>
    <a href="static/html/show.html" title="跳转">静态资源访问</a>
</div>
</body>
</html>
