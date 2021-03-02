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
        <link rel="stylesheet" href="css/style.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
           		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		     
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
								<a href="javascript:void(0)">用户管理</a>
							</li>
							<li class="active">用户管理</li>
						</ul><!-- .breadcrumb -->


					</div>

			<div class="page-content" id="vueBox">
 <div class="sort_style">
        	<i-form  inline>			
			 <Form-item label="账号" :label-width="80">
                     <i-input  placeholder="请输入账号 " style="width: 200px" v-model="param.account"/>
             </Form-item> 
       
                    <i-button type="primary" @click="search" v-cloak icon="ios-search">查询</i-button>
                       <i-button type="primary" @click="add" v-cloak icon="md-add">新增</i-button>
            </i-form>
       <div class="sort_list" >
  
				  <i-table border stripe :columns="columns1" :data="data1"></i-table>
                  <Page :total="total" :current="param.pageNum" :page-size="param.pageSize" @on-change="changePageNum" show-total show-elevator></Page>
       </div>
    
    
       
         <Modal v-model="detailModel" draggable scrollable :title=title @on-ok="save"  :mask-closable="false" :loading="modalLoading" ref="modal" width="700">
                          <i-form :model="detailform" label-position="left" :label-width="100" :rules="ruleInline"  inline  ref="detailform"  >
                                   
                                     <Form-item label="账号" prop="account">
                                             <i-input v-model="detailform.account" placeholder="请输入账号"></i-input>
                                     </Form-item>
                                       <Form-item label="手机号" >
                                             <i-input v-model="detailform.telephone" placeholder="请输入手机号"></i-input>
                                     </Form-item>
                                         <Form-item label="邮箱" >
                                             <i-input v-model="detailform.email" placeholder="请输入邮箱"></i-input>
                                     </Form-item>
                     </i-form>
                     <div  style="color:red;">账号默认密码为123456</div>
                 </Modal>
                 
              
                 
                 
                
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
         <script src="assets/script/business/UserAudit.js<%=version%>"></script>
         
