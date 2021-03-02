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
    	                keyModel:false,
    	                total:0,
    	                detailform1:{
    	                	keys:''
    	                	
    	                },
    	                selection:[],
    	                detailform:{
    	                	categoryName:'',
    	                	categoryUrl:''
    	                },
    	            
    	           
    	       columns1: [
    	                  {
    	                      type: 'selection',
    	                      width: 63,
    	                      align: 'center',
    	                  },    
               {
					type : 'index',
					title : '序号',
					align : 'center',
					width: 80
				},
				            { title: '分类名',  key: 'categoryName',width: 180},
				            { title: '爬取网址',  key: 'categoryUrl'},
				            
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
    	                                        	vm.deleteRow(params.row.id);
    	                                        }
    	                                    }
    	                                }, '删除')
    	                              
    	                                
    	                             
    	               
    	                            ]);
    	                        }
    	                    }
    	                    
    	                ],
    	               data1:[],
    	             
    	               ruleInline: {
    	            	   categoryName: [
   	                        { required: true, message: '不能为空', trigger: 'blur' }
   	                        ],
   	                     categoryUrl: [
   	   	                        { required: true, message: '不能为空', trigger: 'blur' }
   	   	                        ]
   	   	               
   	                },
   	             
 	               ruleInline1: {
 	            	  key: [
	                        { required: true, message: '不能为空', trigger: 'blur' }
	                        ],
	                        pageNum: [
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
    	            setKeys:function(row){
    	            	if(this.selection.length==0){
    	            		
    	            		this.warning('请选中一条记录');
    	            	 	return ;
    	            	}
                        if(this.selection.length!=1){
    	            		
    	            		this.warning('只能选中一条数据');
    	            	 	return ;
    	            	}
    	            	  this.detailform1.id=this.selection[0].id;
    	            	  this.keyModel=true;
    	            	
    	            },
    	           
    	            handleSelectRow(){
    			          //这里是获取点击的这一行的数据，
    			          const selection= this.$refs.selection.getSelection()
    			         this.selection=selection;
    			          
    					   },
    	
    	        search:function(){
          	        	   this.param.pageNum = 1;
        	        	   this.getJsonList();
        	       },
        	      saveKey:function(){
        	    	  var that=this;
        	    	  that.warning('正在爬取，请稍候，爬取完后，弹窗自动关闭！');
        	    	  $.ajax({
   	                    type:"post",
   	                    url:"web/manage/startCrawl",
   	                    data:this.detailform1,
   	                    dataType:'json',
   	                    async:false,
   	                    success : function(data) {  
   	                    	if(data.resultCode=='200'){
   	                    		that.success('操作成功!');
	    	                   		vm.getJsonList();
	    	                   		that.keyModel=false;
	    	                   		
   	                   	}else{
   	                   		
   	                   	that.warning('操作失败！');
   	                   	}
   	                     
   	                    },
   	                   error :function() {
   	                	  that.error('操作失败！');
   	                    }
   	              	 });
        	    	   
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
    	     	    	                    url:"web/manage/deleteCrwlCategory",
    	     	    	                    data:{"id":id},
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
    	                  url:"web/manage/getCrwlCategoryList",
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
	    	                    url:"web/manage/saveOrUpdateCrwlCategory",
	    	                    data:that.detailform,
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    	if(data.resultCode=='200'){
	    	                    	
	    	                    			 that.success('操作成功!');
	     	    	                   		    vm.getJsonList();
	     	    	                   		    that.detailModel=false;
	     	    	                   		     that.handleReset();
	    	                    			
	    	                    		  
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
    	     	    	this.detailform.id=row.id;
    	     	    	this.detailform.categoryName=row.categoryName;
    	     	      	this.detailform.categoryUrl=row.categoryUrl;
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

    
      


      




      
        	 
