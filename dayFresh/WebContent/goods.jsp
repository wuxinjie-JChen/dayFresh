<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天天生鲜-商品列表</title>
 <link rel="shortcut icon" href="images/logo.png">
 <link rel="stylesheet" href="css/reset.css">
 <link rel="stylesheet" href="css/main.css">
 <link rel="stylesheet" href="css/goods.css">
</head>

<body>
	<!-- 头部  -->
	<div class="header_con">
    	<div class="header">
    		<div class="welcome fl">欢迎${{member.nickName}}来到天天生鲜</div>
    		<div class="fr">
            	<div class="login_info fl">
                	欢迎：<em>y c</em>
                </div>
                <div class="login_btn fl">
                	<a href="index.jsp">首页</a>
                	<span> | </span>
                	<a href="login.jsp">登录</a>
                    <span> | </span>
                    <a href="register.jsp">注册</a>
                </div>
            	 <div class="user_link fl">
                    <span> | </span>
                    <a href="#">用户中心</a>
                    <span> | </span>
                    <a href="cart.jsp">我的购物车</a>
                    <span> | </span>
                    <a href="order.jsp">我的订单</a>
           		 </div> 
             </div>  
    	</div>
    </div>
    
     <!-- 搜素框 -->
     <div class="search_bar clearfix">
        <a href="index.html" class="logo fl"><img src="images/logo.png"></a>
        <div class="search_con fl">
        	<form>
	            <input type="text" placeholder="搜素商品" name="key_words" class="input_text fl">
	            <input type="button" value="搜索" class="input_btn fr">
	        </form>
        </div>
        <div class="guest_cart fr">
     		<img src="images/float.gif"/>
     	</div>
     </div>
     
    <!-- 全部商品分类 --> 
    <div class="navbar_con">
    	<div class="navbar clearfix">
        	<!-- 动态下拉框 -->
    		<div class="subnav_con fl">
            	<h1 class="fl">全商品分类</h1>
            	<span></span>
                <ul class="subnav">
                    <li><a href="#model01" class="fruit">新鲜水果</a></li>
                    <li><a href="#" class="sealfood">海鲜水产</a></li>
                    <li><a href="#" class="meet">猪牛羊肉</a></li>
                    <li><a href="#" class="egg">禽类蛋品</a></li>
                    <li><a href="#" class="vegetables">新鲜蔬菜</a></li>
                    <li><a href="#" class="ice">速冻食品</a></li>
            	</ul>
            </div>
    		<ul class="navlist fl">
    			<li><a href="index.jsp">首页</a></li>
                <li class="interval">|</li>
                <li><a href="">手机生鲜</a></li>
                <li class="interval">|</li>
                <li><a href="">抽奖</a></li>
    		</ul>
    	</div>
    </div>
     
    <!-- 面包屑导航 --> 
    <div class="breadcrumb" id="breadcrumb">
     	<a href="javascript:void(0)">全部分类</a>
        <span>&gt;</span>
        <a href="javascript:void(0)">新鲜水果</a>
     </div>
     
     <!-- 商品展示区域-->
     <div class="main_wrap clearfix">
     	<!-- 新品推荐 -->
        <div class="l_wrap fl clearfix">
        	<div class="new_goods">
            	<h3>新品推荐</h3>
            	<ul>
                </ul>
            </div>
        </div>
        <!-- 热门类型查询 -->
        <div class="r_wrap fr clearfix">
        	<div class="sort_bar">
            	<a href="javascript:void(0);" id="normal" class="type active">默认</a>
               <!--  <a href="javascript:void(0);" id="price" class="type ">价格</a>
                <a href="javascript:void(0);" id="manUse" class="type ">人气</a> -->
            </div>
        	<ul class="goods_type_list clearfix show1"></ul>
			     <!-- 分页栏-->
			<div class="pagenation">
				<ul>
				</ul>
			</div>
        </div>
   
     </div>
    <!-- 版权所有 -->
    <div class="footer">
    	<div class="foot_link">
        	<a href="#">关于我们</a> <span> | </span>
            <a href="#">联系我们</a> <span> | </span>
            <a href="#">招聘广告</a> <span> | </span>
            <a href="#">友情链接</a>
        </div>
    	<p>CopyRight &copy; 2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
        <p>电话：0734-8355998 湘ICP备16015987号</p>
    </div>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script>
   		$.post('goods.action',{goodsOption:'findByGoodsName',goodsName:'${param.key_words}',typeNo:'${param.typeNo}'},function(data){
			showFood(data);
		},'json');
		function showFood(arr){
			var str='';
			for(var i=0;i<arr.length;i++){
				str+='<li>'
					+'<a href="details.jsp?goodsNo='+arr[i].goodsNo+'"><img src="'+arr[i].pictures+'"></a>'
					+'<h4><a href="#">'+arr[i].goodsName+'</a></h4>'
					+'<div class="operate">'
						+'<span class="prize">￥'+arr[i].price+'</span>'
						+'<span class="unit">'+arr[i].price+'/500g</span>'
						+'<span class="add_goods" onclick="add_goods('+arr[i].goodsNo+')" title="加入购物车"></span>'
					+'</div>'
				+'</li>';
			}
			/* str+='<li><a href="#">上一页</a></li>'
				+''<li><a href="#" class="active">1</a></li>
			+''<li><a href="#">2</a></li>
			+''<li><a href="#">3</a></li>
			+''<li><a href="#">4</a></li>
			+''<li><a href="#">5</a></li>
			+''<li><a href="#">下一页</a></li> */
			$('.goods_type_list').html(str);
		}
		
		function add_goods(goodsNo){
			//var nums=$();
			$.get("cart.action",{cartOption:'addCart',goodsNo:goodsNo,op:'add'},function(data){
				if(data<=0){
					alert('添加失败');
				}else{
					alert('添加成功');
				}
			},'json');
		}
		
		$(function(){
			//新品推荐
			$.post("goods.action",{goodsOption:'findNewGoods'},function(data){
				var str='';
		 		for(var i=0;i<2;i++){
		 			str+='<li>'
						+'<a href="details.jsp?key_words='+data[i].goodsName+'"><img src="'+data[i].pictures+'"></a>'
						+'<h4><a href="details.jsp?key_words='+data[i].goodsName+'">'+data[i].goodsName+'</a></h4>'
						+'<div class="prize">￥'+data[i].price+'</div>'
					+'</li>';
		 		}
		 		$('.l_wrap .new_goods ul').html(str);
		 	},'json');
				
			//热门查询动态样式
			//给我们热门类型查询做点击事件
			$(".type").on("click",function(){
				//默认查询方式 
				var type = "id";
				//移除原来的active的样式
				$(".type").removeClass("active");
				//获取此时点击的对象的文本是什么
				var check = $(this).html();
				//判断
				if(check == "默认"){
					$("#normal").addClass("active");
				}
				if(check == "价格"){
					$("#price").addClass("active");
					type = "gprice"
				}
				if(check == "人气"){
					$("#manUse").addClass("active");
					type = "gsales"
				}
				
				/* //与后台交互 暂不处理
				$.post("goods.action",{goodsOption:'TypeOrder',type:type,goodsName:'${param.key_words}'},function(data){
					//模拟动态页面
					var str = '';
					var count = data.length;
					for(var i= 1;i <2;i++){
						if(i<10){
							str += ' <li> <a href="#"><img src="images/goods/goods00'+i+'.jpg"></a>';
						}else{
							str += ' <li> <a href="#"><img src="images/goods/goods0'+i+'.jpg"></a>';
						}
		                str += 	'<h4><a href="#">牛奶草莓</a></h4>'+
								'<div class="operate">'+
								'<span class="prize">￥16.80</span>'+
							   '<span class="unit">16.80/500g</span>'+
								'<a href="cart.html" class="add_goods" title="加入购物车"></a>'+
								'</div></li>';
					}
					//写入网页指定的标签中
					$(".show1").html(str);
				}); */
			});
		});
	</script>
	<script type="text/javascript" src="js/search.js"></script>
</body>
</html>
