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
    	            	  modal:false,
    	              param: {
    	            	  id:"",
    	            	  pageNum: 1,
    	            	  pageSize: 10
    	                },
    	              
      	            
    	                title:'',
    	                modalLoading: true,
    	                detailModel:false,
    	                content:'',
    	                total:0,
    	              
    	                detailform:{
    	                	question:'',
    	                	answer:''
    	                },
    	            
    	           
    	       columns1: [
               {
					type : 'index',
					title : '序号',
					align : 'center',
					width: 80
				},
				            { title: '关键词',  key: 'gjc',width: 180},
				            { title: '标题',  key: 'title'},
				            { title: '地址',  key: 'url'},
				            { title: '发微博的用户昵称',  key: 'userName'},
				            { title: '数据来源',  key: 'type'},
    	                    { title: '创建时间',  key: 'createTime'},
     	                    {
    	                        title: '操作',
    	                        key: 'action',
    	                        fixed: 'right',
    	                        width: 200,
    	                        align: 'center',
    	                        render: function(h, params){
    	                        	if(params.row.type!='贴吧'){
    	                        		
    	                        		return h('div', [
    	             	                                h('Button', {
    	             	                                    props: {
    	             	                                        type: 'primary',
    	             	                                        size: 'small'
    	             	                                    },
    	             	                                    style: {
    	             	                                    	marginRight: '5px',
    	              	                                        marginTop: '7px',
    	              	                                         marginBottom: '7px',
    	             	                                    },
    	             	                                    on: {
    	             	                                        click:function(){
    	             	                                        	vm.view(params.row);
    	             	                                        }
    	             	                                    }
    	             	                                }, '查看内容')
    	             	                              
    	             	                               
    	             	                                
    	             	                             
    	             	               
    	             	                            ]);
    	                        	}else{
    	                        		
    	                        		
    	                        		return h('div', [
     	             	                                h('Button', {
     	             	                                    props: {
     	             	                                        type: 'primary',
     	             	                                        size: 'small'
     	             	                                    },
     	             	                                    style: {
     	             	                                    	marginRight: '5px',
     	              	                                        marginTop: '7px',
     	              	                                         marginBottom: '7px',
     	             	                                    },
     	             	                                    on: {
     	             	                                        click:function(){
     	             	                                        	vm.crwlContent(params.row);
     	             	                                        }
     	             	                                    }
     	             	                                }, '爬取网页内容')
     	             	                              
     	             	                               
     	             	                                
     	             	                             
     	             	               
     	             	                            ]);
    	                        		
    	                        	}
    	                            
    	                        }
    	                    }
    	                    
    	                ],
    	               data1:[],
    	               contrntModel:false,
    	               ruleInline: {
    	            	   account: [
   	                        { required: true, message: '不能为空', trigger: 'blur' }
   	                        ]
   	   	               
   	                },
    	                
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
    	     	    view:function(row){
    	     	    	this.content=row.content;
    	     	    	this.contrntModel=true;
    	     	    	
    	     	    },
    	     	   crwlContent:function(row){
    	     		  $.ajax({
    	                  type:"post",
    	                  url:"web/manage/startCrawlContent",
    	                  data:{"id":row.id,"url":row.url},
    	                  dataType:'json',
    	                  async:false,
    	                  success : function(data) {
    	                	  vm.content=data.data;
    	                	  vm.contrntModel=true;
    	                  },
    	                 error :function() {
    	                  }
    	            	 });
    	     		   
    	     		  
    	     	   },
    	           getJsonList:function(){
    	        	   var load=this.$Loading;
    	        	   load.start();
    	        	   var Data = this.param;
    	        	   var  that=this;
    	            	$.ajax({
    	                  type:"post",
    	                  url:"web/manage/getCrwlResultList",
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

    
      


      




      
        	 
