<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- jQuery 3 -->
<script src="assets/js/jquery-1.10.2.min.js"></script> 
				
 <script type="text/javascript">
      $(function(){
    	  var list = $('.sidebar').find('ul').find('li');
    	  for(var i = 0; i < list.length; i++) {
    		  if(window.location.pathname=="/"+$(list[i]).find("a").attr("href")){
    			  $(list[i]).addClass("active");
    			  if($(list[i]).parent("ul").length>0){
    				//  $(list[i]).parent("ul").addClass("active open");
    				  if($(list[i]).parent("ul").parent("li").length>0){
    					  $(list[i]).parent("ul").parent("li").addClass("active open");
    				  }
    			  }
    		  }
            }
      }) 

    </script>
<meta http-equiv="X-UA-Compatible" content="IE=10">	
		<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
		<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
				
					  <c:if test="${user.userType eq '2'}">
							<li >
							<a href="web/manage/toUserInfo">
								<i class="icon-dashboard"></i>
								<span class="menu-text">个人信息 </span>
							</a>
						</li>
							<li >
							<a href="web/manage/toCrwlCategory">
								<i class="icon-dashboard"></i>
								<span class="menu-text">舆情信息采集 </span>
							</a>
						</li>
				
						<li >
							<a href="web/manage/toCrwlResultList">
								<i class="icon-dashboard"></i>
								<span class="menu-text">舆情管理 </span>
							</a>
						</li>
						<li >
							<a href="web/manage/toCrwlResultFenxi">
								<i class="icon-dashboard"></i>
								<span class="menu-text">舆情分析 </span>
							</a>
						</li>
					
</c:if>
  <c:if test="${user.userType eq '1'}">
                     	<li >
							<a href="web/manage/toUserAudit">
								<i class="icon-dashboard"></i>
								<span class="menu-text">用户审核</span>
							</a>
						</li>
          		<li >
							<a href="web/manage/toUserList">
								<i class="icon-dashboard"></i>
								<span class="menu-text">用户管理 </span>
							</a>
						</li>
						
  </c:if>
				


			
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>
