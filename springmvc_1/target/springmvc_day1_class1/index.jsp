<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc</title>
</head>
<body>
<div>
    <a href="UserViewAction/hello">springmvc方式弹跳网页</a>
</div>
<div>
    <a href="UserViewAction/method">get/post方法自动转换</a>
</div>
<div>
    <a href="UserViewAction/getparms?username=郭嘉&age=399">获取基本参数</a>
</div>
<div>
    <a href="UserViewAction/getparms1?id=6&user.username=疆良&money=3000">获取实体类</a>
</div>
<form action="UserViewAction/getparms2" method="post">
    <p>请输入用户名:<input type="text" name="username"></p>
    <p>请输入你第一个账户，存入了list集合<input type="text" name="accounts[0].money"></p>
    <p>请输入你第一个账户，存入了map集合<input type="text" name="accountMap['one'].money"></p>
    <input type="submit" value="提交">
</form>
<div>
    <p>requestMapping的params属性</p>
    <a href="UserViewAction/login?isAdmin=0&status=1&type=user">普通用户登录</a>
    <a href="UserViewAction/login?isAdmin=1&status=1&type=admin">管理员登录</a>
    <a href="UserViewAction/login?isAdmin=0&status=1&type=VIP">VIP登录</a>
</div>
<div>
    <p>我就想乱写get传入参数,就想乱写(属性不对应)</p>
    <a href="UserViewAction/getparms3?uuname=昆仑&uuage=699">属性映射</a>
    <br>
    <a href="UserViewAction/getparms4?uuage=888">(属性不对应)特殊用法,可在对应的参数设置后面，追加设置是否必须要此参数的传递</a>
</div>
<hr>
<div>
    <a href="UserViewAction/getparms5?birthday=1994-06-13">SpringMVC类型转换器yyyy-MM-dd格式</a>
</div>
<form action="UserViewAction/getparms5" method="post">
    <p>SpringMVC类型转换器yyyy/MM/dd格式</p>
    请输入你的生日:<input type="date" name="birthday">
    <input type="submit" value="提交">
</form>
<div>
    <a href="UserViewAction/getparms7">httprequest,httpresponse</a>
</div>
<div>
    <a href="UserViewAction/getparms8">request头部信息获取和session信息获取</a>
</div>
</body>
</html>
