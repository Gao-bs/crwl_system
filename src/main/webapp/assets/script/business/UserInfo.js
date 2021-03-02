 var vm;
      
      $(function(){
    	  initVue();
    	   vm.getUserInfo();
      })
      
      
      function initVue(){
    	  
    		vm = new Vue({
    	        el: '#vueBox',
    	        data:function(){
    	        	
    	             return {
    	             
    	                detailform:{
    	                },
    	                passwordform:{
    	                	
    	                }
    	              
    	                
    	            }
    	        },
    	        created:function(){
    	        },
    	        methods:{
    	     
   	             
    	        	 change:function(date){
 	    	            var date = new Date(date);  
 	    	            var  date_value=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();  
 	    	            return date_value;
 	    	            },
 	    	           getUserInfo:function(){
 	    	        	   
                        var  that=this;
   	            	  	$.ajax({
	    	                    type:"post",
	    	                    url:"web/manage/getUserInfo",
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    		that.detailform=data.data;
	    	                   	
	    	                    },
	    	                   error :function() {
	    	                    }
	    	              	 });
 	    	        	   
 	    	        	   
 	    	           },
 	    	   
    	            save:function(row){
    	            	 var  that=this;
    	            	 if(that.detailform.birthday!=''){
    	            		 that.detailform.birthday=that.change(that.detailform.birthday);
    	            	 }
    	            	
    	            	  	$.ajax({
	    	                    type:"post",
	    	                    url:"web/manage/saveOrUpdateUser",
	    	                    data:that.detailform,
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    	if(data.resultCode=='200'){
	    	                    		   that.success('操作成功!');
     	    	                   		     that.handleReset();
     	    	                   		     that.getUserInfo();
	    	                   	}else{
	    	                   		that.warning('操作失败！');
	    	                   	}
	    	                     
	    	                    },
	    	                   error :function() {
	    	                	   that.error('操作失败！');
	    	                    }
	    	              	 });
    	     	     },
    	     	    savePass:function(row){
   	            	 var  that=this;
   	            	 if( typeof(that.passwordform.orinPass)=='undefined' || that.passwordform.orinPass==''){
	            		 this.warning('原密码不能为空！');
	            		 return;
	            	 }
   	            	if( typeof(that.passwordform.userPassword)=='undefined' || that.passwordform.userPassword==''){
	            		 this.warning('新密码不能为空');
	            		 return;
	            	 }
   	            	
   	            	if( typeof(that.passwordform.userConfirmPassword)=='undefined' || that.passwordform.userConfirmPassword==''){
	            		 this.warning('确认密码不能为空');
	            		 return;
	            	 }
   	            	if( that.passwordform.userPassword!=that.passwordform.userConfirmPassword){
	            		 this.warning('新密码和确认密码不相符');
	            		 return;
	            	 }
   	          	$.ajax({
                    type:"post",
                    url:"web/manage/updatePass",
                    data:that.passwordform,
                    dataType:'json',
                    async:false,
                    success : function(data) {  
                    	if(data.resultCode=='200'){
                    		if(data.data==-1){
                    			 that.warning('原密码不正确!');
                    			 
                    		}else{
                    			 that.success('操作成功!');
                    			 
                    		}
                    		  
                   	}else{
                   		that.warning('操作失败！');
                   	}
                     
                    },
                   error :function() {
                	   that.error('操作失败！');
                    }
              	 });
   	     	     },
    	     	    handleReset:function () {
    	     	    	this.$refs.detailform.resetFields();
    	     	      },
    	     	   
    	     	     success :function(msg) {
    	     	    	this.$Message.config({
    	     	    	    top: 50,
    	     	    	    duration: 3
    	     	    	});
    	                 this.$Message.success(msg);
    	             },
    	             warning :function(msg) {
    	            	 this.$Message.config({
    	            		    top: 50,
    	            		    duration: 3
    	            		});
    	                 this.$Message.warning(msg);
    	             },
    	             error :function(msg) {
    	            	 this.$Message.config({
    	            		    top: 50,
    	            		    duration: 3
    	            		});
    	                 this.$Message.error(msg);
    	             }
    	     
    	   
    	        }
    	    });
    	}

    
    

      




      
        	 
