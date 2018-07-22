<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="static.jsp"%>
<html>
<head>
    <title>错误信息提示</title>
    <script type="text/javascript">
        function goBack() {
            window.history.go(-1);
        }
    </script>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1>不好意思！报错了!</h1>
        <p>错误原因:${message}。</p>
        <p><a class="btn btn-primary btn-lg" role="button" onclick="goBack()">
            返回</a>
        </p>
    </div>
</div>
</body>
</html>
