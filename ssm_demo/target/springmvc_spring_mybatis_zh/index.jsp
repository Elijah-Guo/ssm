<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="static.jsp"%>
<html>
<head>
    <title>数据展示</title>
</head>
<body>
<form action="AccountViewAction/AccountView" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">名字</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="firstname"
                   placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">姓</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="lastname"
                   placeholder="请输入姓">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">查询</button>
        </div>
    </div>
</form>
<!-- 添加功能 -->
<form action="${pageContext.request.contextPath}/AccountOperateAction/AccountOperate" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username"
                   placeholder="请输入用户姓名">
        </div>
    </div>
    <div class="form-group">
        <label for="money" class="col-sm-2 control-label">用户金额</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="money" id="money"
                   placeholder="请输入用户金额">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">添加</button>
        </div>
    </div>
</form>


<div>
    <c:if test="${not empty accounts}">
        <table class="table table-hover">
            <caption>账户信息展示</caption>
            <thead>
            <tr>
                <th>账户ID</th>
                <th>账户名称</th>
                <th>账户金额</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${accounts}" var="a" varStatus="s">
                <c:choose>
                    <c:when test="${s.index%2==0}">
                        <tr class="active">
                    </c:when>
                    <c:otherwise>
                        <tr class="success">
                    </c:otherwise>
                </c:choose>
                    <td>${a.id}</td>
                    <td>${a.username}</td>
                    <td>
                        <fmt:formatNumber type="currency" value="${a.money}" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
