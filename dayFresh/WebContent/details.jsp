<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天天生鲜-商品详情</title>
<link rel="short icon" href="images/logo.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/details.css">
</head>

<body>
	<!-- 头部  -->
	<div class="header_con">
    	<div class="header">
    		<div class="welcome fl">欢迎 ${{member.nickName}}来到天天生鲜</div>
    		<div class="fr">
            	<div class="login_info fl">
                	欢迎：<em></em>
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
                    <a href="user.jsp">用户中心</a>
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
                    <li><a href="#model01" class="sealfood">海鲜水产</a></li>
                    <li><a href="#model01" class="meet">猪牛羊肉</a></li>
                    <li><a href="#model01" class="egg">禽类蛋品</a></li>
                    <li><a href="#model01" class="vegetables">新鲜蔬菜</a></li>
                    <li><a href="#model01" class="ice">速冻食品</a></li>
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
        <span>&gt;</span>
        <a href="javascript:void(0)">商品详情</a>
     </div>
     
    <!-- 商品展示 -->
    <div class="goods_details_con clearfix">
    	<div class="goods_details_pic fl">
    		<img src="">
    	</div>
    	<div class="goods_details_list fr">
        	<h3></h3>
        	<p></p>
        	<div class="price_bar">  
            	<span class="show_price">￥<em></em>元</span>
                <span class="show_unit">单位：<em></em></span>
            </div>
            <div class="goods_num clearfix">
				<div class="num_name fl">数量：</div>
				<div class="num_add fl">
					<input type="text" class="num_show fl" value="1" />
					<a href="javascript:;" class="add fr">+</a>
					<a href="javascript:;" class="minus fr">-</a>	
				</div>
			</div>
			<div class="total">总价：<em></em>元</div>
			<div class="operate_btn">
				<!-- <a href="javascript:;" class="buy_btn" id="buy_btn">立即购买</a> -->
				<a href="javascript:;" class="add_cart" id="">加入购物车</a>				
			</div>
        </div>
    </div>
    
    <!-- 商品详情 -->
    <div class="main_wrap clearfix">
		<div class="l_wrap fl clearfix">
			<div class="new_goods">
				<h3>新品推荐</h3>
				<ul>
				</ul>
			</div>
		</div>

		<div class="r_wrap fr clearfix">
			<ul class="detail_tab clearfix">
				<li class="active">商品介绍</li>
				<li>评论</li>
                <li>推荐</li>
			</ul>
			<div class="tab_content">
				<dl>
					<dt>商品详情：</dt>
					<dd></dd>
				</dl>
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
    <script src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
	    $.post("goods.action",{goodsOption:'findGoods',goodsNo:'${param.goodsNo}',goodsName:'${param.key_words}'},function(data){
	    	$('.login_info em').html('${session.memberName}');
	    	if(data!=null&& data.length>0){
	    		$('.goods_details_con .goods_details_pic img').attr('src',data[0].pictures);
	    		$('.goods_details_list h3').html(data[0].goodsName);
	    		if(data[0].descr==null || data[0].descr.length<=0){
	    			$('.goods_details_list p').html('暂无描述');
	    		}else{
	    			$('.goods_details_list p').html(data[0].descr);
	    		}
	    		$('.price_bar .show_price em').html(data[0].price);
	    		$('.price_bar .show_unit em').html(data[0].unit);
	    		$('.total  em').html(data[0].price);
	    		if(data[0].intro==null || data[0].intro.length<=0){
	    			$('.tab_content dl dd').html("暂无详情");
	    		}else{
	    			$('.tab_content dl dd').html(data[0].intro);
	    		}
	    		$('.add_cart').prop("id",data[0].goodsNo);
	    	}
	    },'json');
    </script>
	<script>
		$(function(){
			function add_goods(goodsNo,nums){
				$.get("cart.action",{cartOption:'addCart',goodsNo:goodsNo,nums:nums,op:'all'},function(data){
					if(data<=0){
						alert('添加失败');
					}else{
						alert('商品添加成功');
					}
				},'json');
			}
			$('.add').click(function(){
				var num=parseInt($('.num_add .num_show').prop('value'));
				num++;
				$('.num_add .num_show').prop('value',num);
				var price=parseInt($('.show_price em').html());
    			$('.total  em').html(price*num);
			});
			$('.minus').click(function(){
				var num=parseInt($('.num_add .num_show').prop('value'));
				if(num>1){
					num--;
				}
				$('.num_add .num_show').prop('value',num);
				var price=parseInt($('.show_price em').html());
    			$('.total  em').html(price*num);
			});
			//立即购买
			/* $("#buy_btn").click(function(){
				location.href = "order.jsp";
			}); */
			
			//加入购物车
			$(".add_cart").click(function(){
				var goodsNo=$(".add_cart").prop("id");
				var nums=$('.num_add .num_show').prop('value');
				add_goods(goodsNo,nums);
			});
			
			
			$(".detail_tab li").click(function(){
				$(".detail_tab li").removeAttr('class');
				$(this).prop('class','active');
			});
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
		});
	</script>
	<script type="text/javascript" src="js/search.js"></script>
</body>
</html>
