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
<title>注册</title>
</head>

<body class="login-layout">
<div class="logintop">    
    <span>欢迎使用舆情分析系统</span>    
    <ul>
  
  <!--   <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li> -->
    </ul>    
    </div>
    <div class="loginbody"  style="top:-19px;height:768px; ">
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
								<div id="login-box" class="login-box widget-box no-border visible" style="height:1200px;">
									<div class="widget-body">
										<div class="widget-main" style="height:768px; ">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												用户注册
											</h4>

											<div class="login_icon"><img src="images/login.png" /></div>

											<form id="registerform">
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
															<input type="password" class="form-control" placeholder="请输入密码" name="userNewPassword">
															<i class="icon-lock"></i>
														</div>
													</label>
                                                     </div>
                                                      <div class="form-group">
													<label class="block clearfix">
														<div class="block input-icon input-icon-right"  >
															<input type="password" class="form-control" placeholder="请输入确认密码" name="userPassword">
															<i class="icon-lock"></i>
														</div>
													</label>
                                                     </div>
                                                 	  <div class="form-group">
													<label class="block clearfix">
														<div class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="请输入手机号"  name="telephone">
															<i class="icon-user"></i>
														</div>
													</label>
													</div>
													 	  <div class="form-group">
													<label class="block clearfix">
														<div class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="请输入邮箱"  name="email">
															<i class="icon-user"></i>
														</div>
													</label>
													</div>
													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<span class="lbl"  style="float:left;"><a  href="web/visitor/toLogin">已有账号?去登录</a></span>
														</label>

														<button type="button" onclick="register()" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															注册
														</button>
													</div>
                                                    <span style="color:red;" id="hip"></span>
													<div class="space-4"></div>
												</fieldset>
												<input type="hidden" name="userType" value="2">
											</form>

										
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
    <script src="assets/script/business/register.js<%=version %>"></script>
	<script src="assets/js/ace-extra.min.js"></script>
		

	 
    
   <script src="assets/js/layer/layer.js" type="text/javascript"></script>