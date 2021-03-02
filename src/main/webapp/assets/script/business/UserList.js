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
				            { title: '账号',  key: 'account',width: 180},
				            { title: '手机号',  key: 'telephone'},
				            { title: '邮箱',  key: 'email'},
				            { title: '性别',  key: 'sex'},
				            { title: '身份证号',  key: 'idcard'},
				            { title: '部门',  key: 'depart'},
				            { title: '职位',  key: 'position'},
    	                    { title: '创建时间',  key: 'createTime'},
     	                    {
    	                        title: '操作',
    	                        key: 'action',
    	                        fixed: 'right',
    	                        width: 200,
    	                        align: 'center',
    	                        render: function(h, params){
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
    	                                        	vm.update(params.row);
    	                                        }
    	                                    }
    	                                }, '编辑'),
    	                              
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
    	                                        	vm.deleteRow(params.row.userId);
    	                                        }
    	                                    }
    	                                }, '删除')
    	                               
    	                                
    	                             
    	               
    	                            ]);
    	                        }
    	                    }
    	                    
    	                ],
    	               data1:[],
    	             
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
        	   	 deleteRow:function(id){
        	   		         var that=this;
    	       	          	 this.$Modal.confirm({
    	     	                    title: '提示框',
    	     	                    content: '<p>确定删除吗？</p>',
    	     	                    onOk:function(){
    	     	                    	$.ajax({
    	     	    	                    type:"post",
    	     	    	                    url:"web/manage/deleteUserList",
    	     	    	                    data:{"userId":id},
    	     	    	                    dataType:'json',
    	     	    	                    async:false,
    	     	    	                    success : function(data) {  
    	     	    	                    	if(data.resultCode=='200'){
    	     	    	                    		that.success('刪除成功!');
	    	     	    	                   		vm.getJsonList();
    	     	    	                   	}else{
    	     	    	                   		
    	     	    	                   	that.warning('刪除失败！');
    	     	    	                   	}
    	     	    	                     
    	     	    	                    },
    	     	    	                   error :function() {
    	     	    	                	  that.error('刪除失败！');
    	     	    	                    }
    	     	    	              	 });
    	     	                    	
    	     	                    }});
    	     	     },
    	           getJsonList:function(){
    	        	   var load=this.$Loading;
    	        	   load.start();
    	        	   var Data = this.param;
    	        	   var  that=this;
    	            	$.ajax({
    	                  type:"post",
    	                  url:"web/manage/getUserList",
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
    	            
    	            save:function(row){
    	            	 var  that=this;
 	    	     		this.$refs['detailform'].validate(function(valid) {
 	                        if (valid) {
    	       	       	$.ajax({
	    	                    type:"post",
	    	                    url:"web/manage/saveOrUpdateUserList",
	    	                    data:that.detailform,
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    	if(data.resultCode=='200'){
	    	                    		if(data.data==-1){
	     	    	                   		    vm.getJsonList();
	     	    	                   		    that.detailModel=false;
	     	    	                   		     that.handleReset();
	    	                    		}else if(data.data==-2){
	     	    	                   		    vm.getJsonList();
	     	    	                   		    that.detailModel=false;
	     	    	                   		     that.handleReset();
	    	                    		}else{
	    	                    			 that.success('操作成功!');
	     	    	                   		    vm.getJsonList();
	     	    	                   		    that.detailModel=false;
	     	    	                   		     that.handleReset();
	    	                    			
	    	                    		}
	    	                    		  
	    	                   	}else{
	    	                   		 this.warning('操作失败！');
	    	                   	}
	    	                     
	    	                    },
	    	                   error :function() {
	    	                	   this.error('操作失败！');
	    	                    }
	    	              	 });
 	                       }else{
	                        	that.$refs.modal.visible = true;
	                        	 that.modalLoading = false;
	                        	 that.detailModel=true;
	                        }
 	    	     		});
    	     	     },
    	     	     add:function(){
    	     	    	this.title="新增";
    	     	    	this.detailform={};
    	     	    	this.detailModel=true;
    	     	     },
    	     	    handleReset:function () {
    	     	    	this.$refs.detailform.resetFields();
    	     	      },
    	     	    update:function(row){
    	     	    	this.title="修改";
    	     	    	this.detailform.userId=row.id;
    	     	    	this.detailform.account=row.account;
    	     	    	this.detailform.telephone=row.telephone;
    	     	    	this.detailform.idcard=row.idcard;
    	     	    	this.detailform.depart=row.depart;
    	     	      	this.detailform.position=row.position;
    	     	   	this.detailform.email=row.email;
    	     	      	
    	     	    	this.detailModel=true;
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

    
      


      




      
        	 
