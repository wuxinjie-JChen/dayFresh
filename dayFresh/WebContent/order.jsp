<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天天生鲜-支付订单</title>
 <link rel="shortcut icon" href="images/logo.png">
 <link rel="stylesheet" href="css/reset.css">
 <link rel="stylesheet" href="css/main.css">
 <link rel="stylesheet" href="css/order.css">
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
            <input type="text" placeholder="搜素商品" name="" class="input_text fl">
            <input type="button" value="搜索" class="input_btn fr">
        </div>
    </div>
     
    <!-- 收货地址 -->
    <h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix" id="realAddr">
		<dl>
			<dt>寄送到：</dt>
			<dd><input type="radio" name="" checked="checked"><!-- 北京市 海淀区 东北旺西路8号中关村软件园 （李思 收） 159****0775 --></dd>
		</dl>
		<a href="user.jsp?updateAddr=true&orderNo=${param.orderNo}" class="edit_site">编辑收货地址</a>
	</div>
    
   	<!-- 支付方式 -->	
    <h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
		</div>
	</div>
    
   	<!-- 商品列表 -->
    <h3 class="common_title">商品列表</h3>
	<div class="common_list_con clearfix" id="goodsList">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col02">商品单位</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		<div></div>
		<!-- <ul class="goods_list_td clearfix">
			<li class="col01">1</li>			
			<li class="col02"><img src="images/goods/goods012.jpg"></li>
			<li class="col03">奇异果</li>
			<li class="col04">500g</li>
			<li class="col05">25.80元</li>
			<li class="col06">1</li>
			<li class="col07">25.80元</li>	
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">2</li>			
			<li class="col02"><img src="images/goods/goods003.jpg"></li>
			<li class="col03">大兴大棚草莓</li>
			<li class="col04">500g</li>
			<li class="col05">16.80元</li>
			<li class="col06">1</li>
			<li class="col07">16.80元</li>	
		</ul> -->
	</div>
     
    <!-- 金额结算 -->	
    <h3 class="common_title">总金额结算</h3>
	<div class="common_list_con clearfix" id="end">
		<div class="settle_con">
			<div class="total_goods_count">共<em>0</em>件商品，总金额<b>0</b>元</div>
			<div class="transit">运费：<b>10</b>元</div>
			<div class="total_pay">实付款：<b>0</b>元</div>
		</div>
	</div>
	<div class="order_submit clearfix">
		<a href="javascript:pay()" id="order_btn">付款</a>
	</div>	
    
    <!-- <div class="popup_con">
		<div class="popup">
			<p>订单提交成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>     -->
        
    <!-- 版权所有 -->
	<div class="footer">
    	<div class="foot_link">
    		<a href="#">关于我们</a> <span> | </span>
            <a href="#">联系我么</a> <span> | </span>
            <a href="#">招聘人才</a> <span> | </span>
            <a href="#">友情链接</a> 
    	</div>
    	<p>CcpyRight &copy; 2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
        <p>电话：0734-8355998 湘ICP备16015987号</p>
    </div>
    
    <script src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);
			$('.popup_con').fadeIn('fast', function() {
				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.jsp';
					});
				},3000)
				
			});
		});
		var addrNo=0;
		var realPrice=0;
		$.post("orderInfo.action",{orderOption:'findOrder',orderNo:"${param.orderNo}" },function(data){
			//alert(123);
			var str='';
			var totalNum=0;
			var totalPrice=0;
			var realAddr='';
			//alert(data[0].addrNo);
			for(var i=0;i<data.length;i++){
				//addrNo=data[i].addrNo;
				str+='<ul class="goods_list_td clearfix">'
						+'<li class="col01">'+i+1+'</li>'		
						+'<li class="col02"><img src="'+data[i].pictures+'"></li>'
						+'<li class="col03">'+data[i].goodsName+'</li>'
						+'<li class="col04">'+data[i].unit+'</li>'
						+'<li class="col05">'+data[i].price+'元</li>'
						+'<li class="col06">'+data[i].nums+'</li>'
						+'<li class="col07">'+data[i].price*data[i].nums+'元</li>'
					+'</ul>';
					totalNum+=data[i].nums;
					totalPrice+=data[i].price*data[i].nums;
					/* if(i==0){
						realAddr+=data[i].province+"  "+data[i].city+"  "
						+data[i].area+"  "+data[i].addr+"("+data[i].name+"  收)  "+data[i].tel;
					} */
			}
			$('#goodsList div').html(str);
			$('#end .settle_con .total_goods_count em').html(totalNum);
			$('#end .settle_con .total_goods_count b').html(totalPrice);
			if($('#end .settle_con .transit b').html()!='0'){
				realPrice=totalPrice+10;
				$('#end .settle_con .total_pay b').html(totalPrice+10);
			}
			//$('#realAddr dl dd').html(realAddr);
		},'json');
		$.get("addr.action",{addrOption:'findAddrInfo'},function(data){
			var realAddr="";
			if(data!=null && data.length>0){
				realAddr+=data[0].province+"  "+data[0].city+"  "+data[0].area
				+"  "+data[0].addr+"("+data[0].name+"  收)  "+data[0].tel;
				addrNo=data[0].addrNo;
			}
			$('#realAddr dl dd').html(realAddr);
		},'json');
		function pay(){
			var realA=$('#realAddr dl dd').html();
			if(realA.length<=0 || realA==null){
				alert("地址为空,请先编辑地址！！！");
				return;
			}
			$.post("orderInfo.action",{orderOption:'addAddr',orderNo:'${param.orderNo}',addrNo:addrNo},function(data){
				//alert(data);
				if(data>0){
					//alert(123);
					location.href="alipay.trade.page.pay.jsp?WIDout_trade_no="+'${param.orderNo}'+"&WIDtotal_amount="+realPrice+"&WIDsubject='123'";
				}else{
					//alert(1);
				}
			},'json');
			//location.href="alipay.trade.page.pay.jsp?WIDout_trade_no="+'${param.orderNo}'+"&WIDtotal_amount="+realPrice+"&WIDsubject='123'";
		}
 	</script>
</body>
</html>