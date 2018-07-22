<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="static.jsp"%>
<html>
<head>
    <title>错误信息提示</title>
    <script type="text/javascript">
        function goBack() {
            window.location.href = "${pageContext.request.contextPath}/AccountViewAction/AccountView";
        }
    </script>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1>${msg}</h1>
        <p>您可以进行以下操作:</p>
        <p><a class="btn btn-primary btn-lg" role="button" onclick="goBack()">
            返回</a>
        </p>
    </div>
</div>
</body>
</html>
