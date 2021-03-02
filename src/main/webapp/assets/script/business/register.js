/**
 * 注册
 */
function register(){
	  var bootstrapValidator = $("#registerform").data('bootstrapValidator');
 	   bootstrapValidator.validate();
 	   if(!bootstrapValidator.isValid()){
 		    return ;
 	   }
 	 
 	   
 	   
    $.ajax({
        type: "post",
        url: "web/visitor/saveOrUpdateUser",
        data: $("#registerform").serialize(),
        dataType: "json",
        success: function(data){
        	
                 if(data.data!=-1){
                	 $("#hip").empty();
                	 window.location.href="web/visitor/toLogin";
                     
                 }else{
                	 $("#hip").empty();
                	 $("#hip").html("账号已存在，请换其他账号注册!");
                 }

         }

    });

}






function formValidator(){
	   $('#registerform').bootstrapValidator({
               message:'这个值不是有效的',
                feedbackIcons: {
 	                   valid: 'glyphicon glyphicon-ok',
                       invalid: 'glyphicon glyphicon-remove',
                          validating: 'glyphicon glyphicon-refresh'
                },
 	               fields: {
 	            	  userNewPassword: {
 	 	                   validators: {
 	 	                       identical: {
 	 	                           field: 'userPassword',
 	 	                           message: '两次输入的密码不相符'
 	 	                       },
 	 	                      notEmpty: {
 		                            message: '不能为空'
 		                        }
 	 	                   }
 	 	               },
 	 	              userPassword: {
 	 	                   validators: {
 	 	                       identical: {
 	 	                           field: 'userNewPassword',
 	 	                           message: '两次输入的密码不相符'
 	 	                       },
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
 	 	                
 	               email: {
 	            	   validators:{
 	                      regexp: {
 	                          regexp: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/ ,
 	                          message: '请输入正确的邮箱地址'
 	                      }
 	                      
 	                  }
	                },
	                telephone: {
	                    validators:{
	                        regexp: {
	                            regexp: /^1\d{10}$/ ,
	                            message: '请输入正确的11位手机号'
	                        }
	                        
	                    }
 	                }
 	               
 	             
 	            }
 	        });
 }
  
  $(function(){
	   formValidator();
	   

  });