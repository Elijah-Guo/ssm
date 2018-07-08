<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- 页面头部 -->
<header class="main-header">
	<!-- Logo -->
	<a href="all-admin-index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>数据</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>数据</b>后台管理</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${pageContext.request.contextPath}/img/bb.jpg"
						class="user-image" alt="User Image"> <span class="hidden-xs">
							<security:authentication property="principal.username" />
					</span>
					<%--用户名的显示
					原理:从security中获取当前线程，或者session,获取认证对象Authentication，
					利用认证对象，获取主角对象principal，利用主角对象，获取主角(用户名)的所有信息
					操作:前台方式两种
					1:${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}
					2:利用security的标签
					<security:authentication property="principal(主角).username" />
					--%>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
							class="img-circle" alt="User Image"></li>

						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<%--当退出的时候利用secuity提供的退出方式，并销毁session--%>
							<div class="pull-right">
								<a href="${pageContext.request.contextPath}/logout"
									class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>
<!-- 页面头部 /-->