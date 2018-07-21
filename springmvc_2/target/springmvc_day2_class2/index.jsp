<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc第二天知识点汇总</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        //contentType---告诉服务器你要传什么数据过去
        //datatype---告诉服务器你想要什么类型的数据
        function dd(id) {
            $.ajax({
                type:"post",
                url:"UserViewAction/ajax",
                contentType:"application/json;charset=UTF-8",
                data:'{"id":id}',//这里是字符串-->'' key值也需要加引号
                datatype:"json",
                success:function (d) {
                    alert(d.id);
                    alert(d.username);
                    alert(d.birthday);
                    alert(d.sex);
                    alert(d.address);
                }
            })
        }
    </script>
</head>
<body>
      <h1>任务1：测试框架</h1>
      <div>
            <a href="UserViewAction/ceshi?date=1994-06-13">测试连接</a>
      </div>
      <form action="UserViewAction/ceshi">
          请输入你的生日:<input type="date" name="date">
          <input type="submit" value="提交">
      </form>
      <h1>ModelAttribute的使用,request对象存值</h1>
      <form action="UserViewAction/addrequest" method="post">
          <input hidden="id" value="1">
          <p>请输入您的姓名:<input type="text" name="username"></p>
          <p><input type="submit" value="提交"></p>
      </form>
      <h1>SessionAttribute的使用,使用session对象存值</h1>
      <div>
          <a href="UserViewAction/addsession?username=赵文明&sex=女&address=北京">存值</a>
          <a href="UserViewAction/getsession">取值</a>
          <a href="UserViewAction/removesession">删除值</a>
      </div>
      <h1>Restful风格的使用</h1>
      <div>
          <a href="UserViewAction/Restful/1">入门使用，获取id</a>
      </div>
      <p>Restful支持put/detele请求</p>
      <form action="UserViewAction/insertRestful" method="post">
          请输入姓名:<input type="text" name="username">
          请输入密码:<input type="text" name="password">
          <input type="submit" value="提交">
      </form>
      <form action="UserViewAction/updateRestful/1" method="post">
          <input type="hidden" name="_method" value="PUT"/>
          请输入姓名:<input type="text" name="username">
          请输入密码:<input type="text" name="password">
          <input type="submit" value="更新">
      </form>
      <form action="UserViewAction/deleteRestful/1" method="post">
          <input type="hidden" name="_method" value="DELETE"/>
          请输入姓名:<input type="text" name="username">
          请输入密码:<input type="text" name="password">
          <input type="submit" value="删除">
      </form>
      <h1>控制器方法的返回值</h1>
      <form action="UserViewAction/login" method="post">
          请输入您的账户:<input type="text" name="username"><br>
          请输入您的密码:<input type="text" name="password">
          <input type="submit" value="登陆">
      </form>
      <h1>返回值的转发和重定向(不太常用)</h1>
      <form action="UserViewAction/ZZlogin" method="post">
          请输入您的账户:<input type="text" name="username"><br>
          请输入您的密码:<input type="text" name="password">
          <input type="submit" value="登陆">
      </form>
      <h1>requestbody的使用</h1>
      <form action="UserViewAction/login1" method="post">
          账号:<input type="text" name="username">
          密码:<input type="text" name="password">
          年龄:<input type="text"name="age">
          <input type="submit" value="注册">
      </form>
      <h1>springmvc中的ajax交互</h1>
      <div>
          <input type="button" value="获取id为1的用户数据" onclick="dd(1)">
      </div>
      <h1>文件上传</h1>
      <form action="UserViewAction/upload" enctype="multipart/form-data" method="post">
          用户：<input type="text" name="username"><br>
          文件:<input type="file" name="uploadfile"><br>
          <input type="submit" name="上传">
      </form>
      <h1>文件上传到其他tomcat服务器</h1>
      <form action="UserViewAction/yuancheng" enctype="multipart/form-data" method="post">
          用户：<input type="text" name="username"><br>
          文件:<input type="file" name="uploadfile"><br>
          <input type="submit" name="上传">
      </form>
      <h1>异常报错</h1>
      <div>
          <a href="UserViewAction/error">测试报错功能</a>
      </div>
</body>
</html>