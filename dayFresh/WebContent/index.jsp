<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天天生鲜-首页</title>
<link rel="short icon" href="images/logo.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/foot.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
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
                	<a href="#">首页</a>
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
     	<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
     	<div class="search_con fl">
            <form action="goods.jsp">
                  <input type="text" class="input_text fl" name="key_words" placeholder="搜索商品" />
                  <input type="button" class="input_btn fr"  value="搜索" />
            </form>
        </div>
     	<div class="guest_cart fr">
     		<img src="images/float.gif"/>
     	</div>
     </div>

    <!-- 商品分类 -->
    <div class="navbar_con">
    	<div class="navbar">
    		<h1 class="fl">全商品分类</h1>
    		<ul class="navlist fl">
    			<li><a href="#">首页</a></li>
                <li class="interval">|</li>
                <li><a href="">手机生鲜</a></li>
                <li class="interval">|</li>
                <li><a href="">抽奖</a></li>
    		</ul>
    	</div>
    </div>
    
    <!-- 导航栏 -->
    <div class="center_con clearfix">
        <div class="subnav fl">
            <ul>
                <li><a href="#model01" class="fruit">新鲜水果</a></li>
                <li><a href="#model02" class="seafood">海鲜水产</a></li>
                <li><a href="#model03" class="meet">猪牛羊肉</a></li>
                <li><a href="#model04" class="egg">禽类蛋品</a></li>
                <li><a href="#model05" class="vegetables">新鲜蔬菜</a></li>
                <li><a href="#model06" class="ice">速冻食品</a></li>
            </ul>
        </div>
        <div class="slide fl">
            <ul class="slide_pics">
                <li><a href="" class=""><img src="images/slide.jpg" alt="幻灯片"></a></li>
                <li><a href="" class=""><img src="images/slide02.jpg" alt="幻灯片"></a></li>
                <li><a href="" class=""><img src="images/slide03.jpg" alt="幻灯片"></a></li>
                <li><a href="" class=""><img src="images/slide04.jpg" alt="幻灯片"></a></li>
            </ul>
            <div class="prev"></div>
            <div class="next"></div>
            <ul class="points"></ul>
        </div>
        <div class="adv fl">
            <a href=""><img src="images/adv01.jpg" alt="清凉一夏"></a>
            <a href=""><img src="images/adv02.jpg" alt="盛夏尝鲜"></a>
        </div>
    </div>
    
    <div id="mainFood"></div>
    <script>
	    $.post('goods.action',{goodsOption:'findType'},function(data){
			showAllFood(data);
		},'json');
	    function showAllFood(arr){
	    	var strAll='';
	    	for(var i=1;i<=6;i++){
	    		var strul='';
	    		var strdiv='';
	    		var x=0;
	    		var no=0;
	    		for(var j=0;j<arr.length;j++){
	    			if(arr[j].typeNo==i && x<4){
	    				no=j;
	    				x++;
	    	    		strul+='<li>'
	        	        	+'<h4><a href="details.html">'+arr[j].goodsName+'</a></h4>'
	        	            +'<a href="details.jsp?goodsNo='+arr[j].goodsNo+'"><img src="'+arr[j].pictures+'"></a>'
	        	            +'<div class="prize">￥ '+arr[j].price+'</div>'
	        	        +'</li>';
	        	        strdiv+='<a href="details.jsp?goodsNo='+arr[j].goodsNo+'">'+arr[j].goodsName+'</a>';
	    	    	}
	    		}
	    		strAll+='<div class="list_model" id="model0'+i+'">'
    	    	    	+'<div class="list_title clearfix">'
    	    	        	+'<h3 class="fl" id="model01">'+arr[no].typeName+'</h3>'	
    	    	        	+'<div class="subtitle fl">'
    	    	            	+'<span>|</span>'
    	    	        		+strdiv
    	    	          	+'</div>'
    	    	            +'<a href="goods.jsp?typeNo='+i+'" class="goods_more fr" id="fruit_more">查看更多</a>'
    	    	        +'</div>'
    	    	    	+'<div class="goods_con clearfix">'
    	    	        	+'<div class="goods_banner fl"><img src="images/banner0'+i+'.jpg"></div>'
    	    	        	+'<ul class="goods_list fl">'
    						+strul
    	    	        	+'</ul>'
    	    	        +'</div>'
    	    	    +'</div>';
	    	}
	    	$("#mainFood").html(strAll);
	    }
    </script>
    
    
    <!-- 版权所有 -->
    <div class="footer">
    	<div class="foot_link">
        	<a href="#">关于我们</a> <span> | </span>
            <a href="#">联系我们</a> <span> | </span>
            <a href="#">招聘广告</a> <span> | </span>
            <a href="#">友情链接</a>
        </div>
    	<p>CopyRight &copy; 2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
        <p>电话：0734-8355998 湘ICP备16015987号-1</p>
    </div>
    
    <!--  注意引入顺序 -->
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/slide.js"></script>
   <!--  <script>
		//获取url地址栏
    	function getQueryString(name) {
			//正则表达式
			var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
			///获取url中从问号（"?"符）开始的字符串
			var url = decodeURI(window.location.search);
			//截取？后面的字符串
			var r = url.substr(1).match(reg);
			if (r != null) {
				//decodeURI() 函数可对 encodeURI() 函数编码过的 URI 进行解码
				return decodeURI(r[2]);
			}
			return null;
		}
		
    	//调用此方法
		var nickname = GetQueryString("nickname");
		//用户昵称
		if( nickname != null && nickname != ''){
			$(".login_info em").text(nickname);
		}
    </script> -->
    <script type="text/javascript" src="js/search.js"></script>
</body>
</html>
