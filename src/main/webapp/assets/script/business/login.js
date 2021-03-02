



/**
 * 登录
 */
function login(){
	  var bootstrapValidator = $("#loginform").data('bootstrapValidator');
 	   bootstrapValidator.validate();
 	   if(!bootstrapValidator.isValid()){
 		    return ;
 	   }
 	 
 	  
    $.ajax({
        type: "post",
        url: "web/visitor/userLogin",
        data: $("#loginform").serialize(),
        dataType: "json",
        success: function(data){
                 if(data.flag){
                	 console.log(data)
                	 $("#hip").empty();
                	 if(data.user.userType=='1'){
                		 window.location.href="web/manage/toUserAudit";
                	 }else{
                		 window.location.href="web/manage/toUserInfo";
                	 }
                		 
                    
                     
                 }else{
                	 $("#hip").empty();
                	 $("#hip").html(data.resultMsg);
                 }

         }

    });

}






function formValidator(){
	   $('#loginform').bootstrapValidator({
 	　　　　　　　　message: '这个值不是有效的',
 	            　 feedbackIcons: {
 	                　　　　　　　　valid: 'glyphicon glyphicon-ok',
 	                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
 	                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
 	            　　　　　　　　   },
 	               fields: {
 	            	  userPassword: {
 	                    message: '不能为空',
 	                    validators: {
 	                        notEmpty: {
 	                            message: '不能为空'
 	                        }
 	                      
 	                    }
 	                },
 	               account: {
 	            	  message: '不能为空',
	                    validators: {
	                        notEmpty: {
	                            message: '不能为空'
	                        }
	                      
	                    }
 	                },
 	                
 	             
 	            }
 	        });
 }
  
  $(function(){
	   formValidator();
	   

  });