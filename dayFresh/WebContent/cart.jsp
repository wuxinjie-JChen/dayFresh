<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天天生鲜-购物车</title>
<link rel="shortcut icon" href="images/logo.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/cart.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</head>

<body>
	<!-- 头部 -->
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎${{member.nickName}}来到天天生鲜</div>
			<div class="fr">
				<div class="login_info fl">
					欢迎：<em></em>
				</div>
				<div class="login_btn fl">
					<a href="index.jsp">首页</a>
                	<span> | </span>
					<a href="login.jsp">登录</a> <span>|</span> <a href="register.jsp">注册</a>
				</div>
				<div class="user_link fl">
					<span> | </span> <a href="user.jsp">用户中心</a> <span> | </span> <a
						href="cart.jsp">我的购物车</a> <span> | </span> <a href="order.jsp">我的订单</a>
				</div>
			</div>
		</div>
	</div>

	<!-- 搜索框-->
	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
		<div class="search_con fl">
			<form action="goods.jsp" method="get">
				<input type="text" placeholder="搜索商品" class="input_text fl"
					name="key_words"> <input type="submit" value="搜索"
					class="input_btn fr">
			</form>
		</div>
		<div class="guest_cart fr">
			<img src="images/float.gif" />
		</div>
	</div>

	<!-- 购物车 -->
	<div class="cart_con">
		<h2 class="total_count">
			全部商品<em></em>件
		</h2>
		<div class="cart_list_th clearfix">
			<ul>
				<li class="col01">商品名称</li>
				<li class="col02">商品单位</li>
				<li class="col03">商品价格(元)</li>
				<li class="col04">数量</li>
				<li class="col05">小计(元)</li>
				<li class="col06">操作</li>
			</ul>
		</div>
		<div class="cart_list_td clearfix"></div>
		<div class="setelements"  id="c2">
			<ul>
				<li class="col01"><input type="checkbox" checked id="all"></li>
				<li class="col02"><label for="all">全选</label></li>
				<li class="col03">
						合计(不含运费)：<span>￥</span>
						<em id="totalPrices"></em><br>
						共计<b id="totalNumbers"></b>件商品
				</li>
				<li class="col04"><a href="#">去结算</a></li>
			</ul>
		</div>
	</div>

	<!-- 版权所有 -->
	<div class="footer">
		<div class="foot_link">
			<a href="#">关于我们</a> <span> | </span> <a href="#">联系我么</a> <span>
				| </span> <a href="#">招聘人才</a> <span> | </span> <a href="#">友情链接</a>
		</div>
		<p>CcpyRight &copy; 2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
		<p>电话：0734-8355998 湘ICP备16015987号</p>
	</div>

	<script type="text/javascript">
		$.post("cart.action",{cartOption : 'findAll'},function(data) {
			if(data==null || data.length<=0){
				alert("购物车为空，请先添加商品！");
				window.location.href="index.jsp";
			}
			var str = '';
			//var cartNo=0;
			for (var i = 0; i < data.length; i++) {
				str += '<ul>'
					+ '<li class="col01"><input type="checkbox"  checked="checked" class="inchecked" id="'+data[i].goodsNo+'" onclick="beiClicked()"/></li>'
					+ '<li class="col02"><img src="'+data[i].pictures+'"></li>'
					+ '<li class="col03">'+ data[i].goodsName+ '<br><em>'+ data[i].price+ '元/'+ data[i].unit+ '</em></li>'
					+ '<li class="col04">'+ data[i].unit+ '</li>'
					+ '<li class="col05">'+ data[i].price+ '</li>'
					+ '<li class="col06">'
						+'<div class="num_add">'
							+ '<a href="javascript:void(0)" onclick="lost(this,'+ data[i].goodsNo+ ')" class="minus fl">-</a>'
							+ '<input type="text" value="'+data[i].num+'" class="num_show fl">'
							+ '<a href="javascript:void(0)" onclick="add(this,'+ data[i].goodsNo+ ')" class="add fl">+</a>'
						+ '</div>'
					+ '</li>'
					+ '<li class="col07">'+ data[i].price* data[i].num+ '</li>'
					+ '<li class="col08"><a href="javascript:;" onclick="delGoods(this,'+data[i].goodsNo+')">删除</a></li>'
				+ '</ul>';
				//cartNo=data[i].cartNo;
			}
			$('.cart_list_td').html(str);
			//$('.setelements ul li.col04 a').prop('href','order.jsp?cartNo='+cartNo);
			productCount();
		}, 'json');
		
		function beiClicked(){
			productCount();
		}
		// JavaScript Document
		//商品数量的添加
		function add(obj, goodsNo) {
			//获取购物车中点击的商品数量
			var num = $(obj).prev().val();
			num++;
			//数量写入标签中
			$(obj).prev().val(num);
			//获取单价
			var price = $(obj).parent().parent().prev().html();
			//获取小计
			var total = num * price * 1.00;
			//获取小计标签
			var $subtotal = $(obj).parent().parent().next();
			//小计价钱写入标签中
			//total = returnFloat(total);
			$subtotal.text(total.toFixed(2));
			$.post("cart.action",{cartOption:'addMinusNum',goodsNo:goodsNo,op:'add'},function(data) {
			},'json');
			productCount();
		}
		//保留两位小数的方位
		function returnFloat(value) {
			//Math js中的静态的数学对象  round四舍五入
			var value = Math.round(value * 100) / 100;
			//转换成字符串并以.分割成数组
			var xsd = value.toString().split(".");
			//判断数组长度
			if (xsd.length == 1) { //整数
				value = value.toString() + ".00";//拼接
				return value;
			}
			if (xsd.length > 1) { //带小数
				if (xsd[1].length < 2) {
					value = value.toString() + "0";
				}
				return value;
			}
		}

		//删除商品
		function delGoods(obj,goodsNo) {
			//温馨提示
			var result = confirm("您确定要删除购物车中当前商品吗？");
			//找到对应的UL
			$ul = $(obj).parent().parent();
			//判断
			if (result) {
				$ul.remove();
				$.post("cart.action",{cartOption:'delGoods',goodsNo:goodsNo},function(data) {
				},'json');
				productCount();
				var aaa=$('.cart_list_td ul');
				if(aaa.length<=0){
					alert("购物车为空,请先挑选商品");
				}
				//alert(aaa.length);
			}
		}

		//全选和全不选
		$("#all").click(function() {
			//alert(132);
			//获取全选是否被选中
			/* var flag = $(this).is(":checked");
			//判断
			if (flag) {
				$(".cart_list_td ul .col01 input").prop("checked",true);
			} else {
				$(".cart_list_td .col01 input").removeProp("checked");
			} */

			//获取全选是否被选中
			//prop 获取标签的固有属性  attr 自动义的属性
			var flag = $(this).prop("checked");
			//判断
			$(".cart_list_td ul .col01 input").prop("checked", flag);

			if (flag) {
				$(".cart_list_td ul .col01 input").prop("checked", true);
			} else {
				$(".cart_list_td .col01 input").prop("checked",false);
			}
			productCount();
		});

		//商品数量的减法
		function lost(obj,goodsNo) {
			//获取购物车中点击的商品数量
			var num = $(obj).next().val();
			//判断此商品的数量是否大于1
			if (num <= 1) {
				return;
			}
			num--;
			//数量写入标签中
			$(obj).next().val(num);
			//获取单价
			var price = $(obj).parent().parent().prev().html();
			//获取小计
			var total = num * price * 1.00;
			//获取小计标签
			var $subtotal = $(obj).parent().parent().next();
			//小计价钱写入标签中
			total = returnFloat(total);
			$subtotal.text(total);
			$.post("cart.action",{cartOption:'addMinusNum',goodsNo:goodsNo,op:'minus'},function(data) {
			});
			productCount();
		}
		var total = 0;
		//计算商品总额的方法
		function productCount() {
			total = 0;// 总价
			var price;//每一行的市场价
			var number;//每一行的数量
			var numbers = 0;//总数量
			var myul = $(".cart_list_td ul");
			for (var i = 0; i < myul.length; i++) {//循环每一行
				var a=$(".cart_list_td  ul:eq(" + i + ") .col01 input").prop("checked");
				if(a!=null&& $(".cart_list_td  ul:eq(" + i + ") .col01 input").prop("checked")==true){
					price = $(".cart_list_td  ul:eq(" + i + ")").find(".col05")
					.html();
					number = $(".cart_list_td  ul:eq(" + i + ")").find(
					".col06 input").val();
					total += price * number;
					numbers += number * 1.0;
				}
				
			}
			//alert(total);
			$("#totalPrices").html(total.toFixed(2));
			$("#totalNumbers").html(numbers);
			$(".total_count em").html(numbers);
		}
		
		$(function(){
			$('.cart_list_td ul .col01 input[type="checkbox"]').click(function() {
				/* alert(123); */
				productCount();
			});
			
			$('.setelements ul .col04 a').click(function() {
				//alert(123);
				var a=$('.inchecked[checked="checked"]');
				//alert(b.length);
				var goodsNo='';
				for(var i=0;i<a.length;i++){
					goodsNo+=$(a[i]).attr("id")+',';
				}
				$.post("orderInfo.action",{orderOption:'createOrder',goodsNo:goodsNo,totalPrice:total},function(data){
					if(data.length>0){
						location.href="order.jsp?orderNo="+data;
						return;
					}
				},'json');
			});
		});
	</script>
</body>
</html>
