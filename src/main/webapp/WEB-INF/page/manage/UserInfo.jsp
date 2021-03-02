<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/manage/common/scheme.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
      		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
        <link rel="stylesheet" href="assets/js/iview/iview.css">
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		     
<title>管理</title>
</head>
<style>
         .ivu-table-border td, .ivu-table-border th {
    border-right: 1px solid #65abd5 !important;
}
.ivu-table th {
    height: 40px !important;
    white-space: nowrap !important;
    overflow: hidden !important;
    background-color: #337da8 !important;
    color: white !important;
    font-weight: bold !important; 
}
.ivu-btn-primary:hover {
    color: #fff;
    background-color: #337da8 !important;
    border-color: #337da8 !important;
}
.ivu-btn-primary {
    color: #fff;
    background-color: #337da8 !important;
    border-color: #337da8 !important;
}
textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"] {
    border-radius: 0 !important;
    color: #858585;
    background-color: #fff;
    border: 1px solid #d5d5d5;
    padding: 5px 4px;
    margin-left: 0px !important;
    line-height: 1.2;
    font-size: 14px;
    font-family: inherit;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    -webkit-transition-duration: .1s;
    transition-duration: .1s;
}
[v-cloak]{
            display:none !important;
        }
        .ztree li a.curSelectedNode{
        background-color: white !important;
        border: 1px white solid !important;
        }
</style>
<body>
    <jsp:include page="/WEB-INF/page/manage/common/Header.jsp"></jsp:include>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
			

			 <jsp:include page="/WEB-INF/page/manage/common/LeftMenu.jsp"></jsp:include>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
						

							<li>
								<a href="javascript:void(0)">个人信息</a>
							</li>
							<li class="active">个人信息维护</li>
						</ul><!-- .breadcrumb -->


					</div>

			<div class="page-content" id="vueBox">
 <div class="sort_style">
 <div  style="width:400px;float:left;border-right:1px solid black;padding-right:30px;">
       <i-form :model="detailform" label-position="left" :label-width="100"     ref="detailform"  >
                                     <Form-item label="姓名" prop="userName">
                                             <i-input v-model="detailform.userName" placeholder="请输入姓名"></i-input>
                                     </Form-item>
                                <Form-item label="性别 " :label-width="100">
                                     <i-select  placeholder="请选择性别 "  v-model="detailform.sex" style="width: 100%;dispaly:none;" clearable v-cloak>
                                           <i-option value="男" >男</i-option>
                                            <i-option value="女" >女</i-option>
                                     </i-select>   
                                </Form-item> 
                                  <Form-item label="身份证号"  >
                                              <i-input v-model="detailform.idcard" placeholder="请输入身份证号" ></i-input>
                                    </Form-item>
                                     <Form-item label="部门"  >
                                              <i-input v-model="detailform.depart" placeholder="请输入部门" ></i-input>
                                    </Form-item>
                                     <Form-item label="职位"  >
                                              <i-input v-model="detailform.position" placeholder="请输入职位" ></i-input>
                                    </Form-item>
                                     <Form-item label="联系方式"  >
                                              <i-input v-model="detailform.telephone" placeholder="请输入联系方式" ></i-input>
                                    </Form-item>
                                            <Form-item label="邮箱"  >
                                              <i-input v-model="detailform.email" placeholder="请输入邮箱" ></i-input>
                                    </Form-item>
                                       
                               
                                 
                     </i-form>
                     <div style="text-align:center;">
                        <i-button type="primary" @click="save" v-cloak icon="md-save">保存</i-button>
                        </div>
                     </div>
                     <div  style="width:400px;float:left;margin-left:40px;padding-left:32px">
                     <i-form :model="passwordform" label-position="left" :label-width="100"    ref="passwordform"  >
                     
                                      <Form-item label="原密码" >
                                             <i-input v-model="passwordform.orinPass"  type="password"  placeholder="请输入原密码"></i-input>
                                     </Form-item>
                                      <Form-item label="现密码"  >
                                             <i-input v-model="passwordform.userPassword"  type="password"  placeholder="请输入现密码"></i-input>
                                     </Form-item>
                                      <Form-item label="确认密码"  >
                                             <i-input v-model="passwordform.userConfirmPassword"  type="password"  placeholder="请输入确认密码"></i-input>
                                     </Form-item>
                     
                     </i-form>
                     <div style="text-align:center;">
                        <i-button type="primary" @click="savePass" v-cloak icon="md-save">保存</i-button>
                        </div>
                        
                  
                     </div>

                        
 </div>
 </div>
</div>
</body>
</html>
        <script src="assets/js/jquery-1.10.2.min.js"></script>
          <link rel="stylesheet" href="assets/js/iview/iview.css" />
           <script src="assets/js/vue.2.5.17/vue.min.js"></script>
          <script src="assets/js/iview/iview.min.js"></script>
          		<script src="assets/js/bootstrap.min.js"></script>
         <script src="assets/script/business/UserInfo.js<%=version%>"></script>
         
