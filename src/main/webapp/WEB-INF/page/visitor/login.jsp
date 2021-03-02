<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/manage/common/scheme.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace1.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="css/style.css"/>
         <link rel="stylesheet" type="text/css" href="assets/css/bootstrapValidator.css">
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="assets/js/jquery-1.11.1.min.js"></script>       
        <script src="assets/js/bootstrapValidator.min.js" type="text/javascript"></script>
<title>登录</title>
</head>

<body class="login-layout">
<div class="logintop">    
    <span>欢迎使用舆情分析系统</span>    
    <ul>
  
  <!--   <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li> -->
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
	<h1>
									<i class="icon-leaf green"></i>
									<span class="orange">舆情</span>
									<span class="white">分析系统</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box widget-box no-border visible">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												用户登录
											</h4>

											<div class="login_icon"><img src="images/login.png" /></div>

											<form id="loginform">
												<fieldset>
													<div class="form-group">
													<label class="block clearfix">
														<div class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="请输入账号"  name="account">
															<i class="icon-user"></i>
														</div>
													</label>
													</div>
                                                    <div class="form-group">
													<label class="block clearfix">
														<div class="block input-icon input-icon-right"  >
															<input type="password" class="form-control" placeholder="请输入密码" name="userPassword">
															<i class="icon-lock"></i>
														</div>
													</label>
</div>
													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<span class="lbl"  style="margin-left:80px;"><a  href="web/visitor/toRegister">没有账号?去注册</a></span>
														</label>

														<button type="button" onclick="login()" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>
                                                    <span style="color:red;" id="hip"></span>
													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">通知</span>
											</div>

											<div class="social-login center">
											本网站系统用于舆情分析系统,不再对IE7以下浏览器支持。
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											

											
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
                        </div>

</body>
</html>
<script src="assets/js/jquery-1.11.1.min.js"></script>       
        <script src="assets/js/bootstrapValidator.min.js" type="text/javascript"></script>
    <script src="assets/script/business/login.js<%=version %>"></script>
	<script src="assets/js/ace-extra.min.js"></script>
		
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	 
    
   <script src="assets/js/layer/layer.js" type="text/javascript"></script>