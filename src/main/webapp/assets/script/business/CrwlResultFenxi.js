 var vm;
      
      $(function(){
    	  initVue();
          vm.getJsonList();

      })
      
      
      function initVue(){
    	  
    		vm = new Vue({
    	        el: '#vueBox',
    	        data:function(){
    	        	
    	             return {
    	              param: {
    	            	  id:"",
    	            	  pageNum: 1,
    	            	  pageSize: 10
    	                },
    	              
      	            
    	                total:0,
    	              
    	           
    	            
    	           
    	       columns1: [
               {
					type : 'index',
					title : '序号',
					align : 'center',
					width: 80
				},
				            { title: '关键词',  key: 'gjc'},
				            { title: '爬取出的记录数',  key: 'count'},
    	                    
    	                ],
    	               data1:[],
    	                
    	            }
    	        },
    	        created:function(){
    	        	
    	        },
    	        methods:{
    	            changePageNum: function (pageNum) {
    	              this.param.pageNum = pageNum;
    	              this.getJsonList();
    	            },
    	        
    	        
    	        search:function(){
          	        	   this.param.pageNum = 1;
        	        	   this.getJsonList();
        	       },
        	      
        	       change:function(date){
	    	            var date = new Date(date);  
	    	            var  date_value=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();   
	    	            return date_value;
	    	            },
    	           getJsonList:function(){
    	        	   var load=this.$Loading;
    	        	   load.start();
    	        	   var Data = this.param;
    	        	   var  that=this;
    	            	$.ajax({
    	                  type:"post",
    	                  url:"web/manage/getStaticsCrwlResultList",
    	                  data:Data,
    	                  dataType:'json',
    	                  async:false,
    	                  success : function(data) {  
    	                   vm.data1 = data.data.result;
    	                   vm.total = data.data.total;
    	                   load.finish();
    	                  },
    	                 error :function() {
    	                	 load.error();
    	                	 that.error("后台报错");
    	                  }
    	            	 });
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

    
      


      




      
        	 
