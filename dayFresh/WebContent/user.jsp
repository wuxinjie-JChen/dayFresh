<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>天天生鲜-用户中心</title>
 <link rel="shortcut icon" href="images/logo.png"/>
 <link rel="stylesheet" href="css/reset.css"/>
 <link rel="stylesheet" href="css/main.css"/>
 <link rel="stylesheet" href="css/user.css"/>
</head>

<body>
	<!-- 头部  -->
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
        <a href="index.html" class="logo fl"><img src="images/logo.png" /></a>
        <div class="search_con fl">
            <input type="text" placeholder="搜素商品" name="" class="input_text fl" />
            <input type="button" value="搜索" class="input_btn fr"/>
        </div>
        <div class="guest_cart fr">
     		<img src="images/float.gif"/>
     	</div>
     </div
     
    ><!-- 用户中心界面 -->
    <div class="main_con clearfix">
    
    	<!-- 左侧用户菜单栏 -->
		<div class="left_menu_con fl clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="javascrit:void(0)" class="active" id="info">· 个人信息</a></li>
				<li><a href="javascrit:void(0)" id="order">· 全部订单</a></li>
				<li><a href="javascrit:void(0)" id="site">· 收货地址</a></li>
			</ul>
		</div>
        
        <!-- 右侧信息展示 -->
        <div class="right_content fr clearfix">
			<!-- 基本信息  -->
            <div class="info_con clearfix right">
                <h3 class="common_title2">基本信息</h3>
                <ul class="user_info_list" id="12345">
                	<!-- <li id="realname">真实姓名:<span></span></li> -->
                    <li id="username">用户名称:<span></span></li>
                    <li id="tel">联系方式:<span></span></li>
                    <li id="email">email:<span></span></li>
                </ul>
            	<!-- <h3 class="common_title2">最近浏览</h3>
                <div class="has_view_list">
                    <ul class="goods_type_list clearfix">
                        <li>
                            <a href="detail.html"><img src="images/goods/goods003.jpg"></a>
                            <h4><a href="detail.html">大兴大棚草莓</a></h4>
                            <div class="operate">
                                <span class="prize">￥16.80</span>
                                <span class="unit">16.80/500g</span>
                                <a href="#" class="add_goods" title="加入购物车"></a>
                            </div>
                        </li>
                        <li>
                            <a href="#"><img src="images/goods/goods004.jpg"></a>
                            <h4><a href="#">吐鲁番梨光杏</a></h4>
                            <div class="operate">
                                <span class="prize">￥5.50</span>
                                <span class="unit">5.50/500g</span>
                                <a href="#" class="add_goods" title="加入购物车"></a>
                            </div>
                        </li>
                    </ul>
                </div> -->
            </div>
            
           <!-- 查看订单 -->
           <div class="order_icon right">
           		<!-- <h3 class="common_title2">全部订单</h3>
				<ul class="order_list_th w978 clearfix">
					<li class="col01">2016-8-21 17:36:24</li>
					<li class="col02">订单号：56872934</li>
					<li class="col02 stress">未支付</li>		
				</ul>

				<table class="order_list_table w980">
					<tbody> -->
						<!-- <tr>
							<td width="55%">
								<ul class="order_goods_list clearfix">					
									<li class="col01"><img src="images/goods02.jpg"/></li>
									<li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>	
									<li class="col03">1</li>
									<li class="col04">11.80元</li>	
								</ul>
								<ul class="order_goods_list clearfix">					
									<li class="col01"><img src="images/goods02.jpg"/></li>
									<li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>	
									<li class="col03">1</li>
									<li class="col04">11.80元</li>	
								</ul>
							</td>
							<td width="15%">33.60元</td>
							<td width="15%">待付款</td>
							<td width="15%"><a href="#" class="oper_btn">去付款</a></td>
						</tr> -->
					<!-- </tbody>
				</table> -->
			
				<div class="pagenation">
					<ul>
                        <li><a href="#">上一页</a></li>
                        <li><a href="#" class="active">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">下一页</a></li>
					</ul>
				</div>
           </div>
            
            <!-- 收货地址 -->
            <div class="site_con right" id="addrInfo">
                <h3 class="common_titile2">收货地址</h3>
                <div class="site_top">
                    <dl>
                        <dt>当前地址</dt>
                        <dd>收件对象：<span></span></dd>
                        <dd>收货地址：<span></span></dd>
                        <dd>电话号码：<span></span></dd>
                    </dl>
                    <input type="button" name="" value="编辑地址" class="info_submit" />
                </div>
                <h3 class="common_title2">编辑地址</h3>
                <div class="site_btm">
                    <form >
                        <div class="form_group">
                            <label for="name">收件人： </label>
                            <input type="text" name="name" id="name" disabled="disabled"/>
                        </div>
                        <div class="form_group">
                            <label for="province">省： </label>
                            <input name="province" id="province" disabled="disabled"/>
                        </div>
                        <div class="form_group">
                            <label for="city">市： </label>
                            <input name="city" id="city" disabled="disabled"/>
                        </div>
                        <div class="form_group">
                            <label for="area">县： </label>
                            <input name="area" id="area" disabled="disabled"/>
                        </div>
                        <div class="form_group form_group2">
                            <label for="addr">详细地址：</label>
                            <textarea class="site_area" name="addr" id="addr" disabled="disabled"></textarea>
                        </div>
                        <!-- <div class="form_group">
                            <label for="email">邮编： </label>
                            <input type="text" name="email" id="email"  disabled="disabled"/>
                        </div> -->
                        <div class="form_group">
                            <label for="tel">手机： </label>
                            <input type="text" name="tel" id="tel" disabled="disabled"/>
                        </div>
                        <input type="submit" name="" value="提交" class="info_submit"  disabled="disabled"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
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

</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	function topay(s,b){
		if(s!=0){
			alert("订单已支付！！");
			return ;
		}
		window.location.href="order.jsp?orderNo="+b;
	}
	$(function(){
		var pay='${param.pay}';
		//alert(pay);
		if(pay=='ok'){
			$.post("order.action",{op:'payOk'},function(data){
				//alert(data+'a222');
			});
		}
		
		
		var param='${param.updateAddr}';
		//alert(param.length>0);
		if(param.length>0){
			$('.left_menu_con ul li a[class="active"]').removeAttr('class');
			$('#site').prop('class','active');
			$('.right_content .right').css('display','none');
			$('#addrInfo').css("display",'block');
			getSite();
		}else{
			getInfo();
		}
		$('.left_menu_con ul li a').click(function(){
			/* var s=$(this).html();
			alert(s); */
			$('.left_menu_con ul li a[class="active"]').removeAttr('class');
			$(this).prop('class','active');
			$('.right_content .right').css('display','none');
			//alert($(this)==$('#order'));
			var name=$(this).prop("id");
			if(name=='info'){
				$('.right_content .info_con').css("display",'block');
				getInfo();
			}else if(name=='order'){
				$('.right_content .order_icon').css("display",'block');
				getOrder();
			}else if(name=='site'){
				$('.right_content .site_con').css("display",'block');
				getSite();
			}
		});
		
		//获取个人信息
		function getInfo(){
			$.post("member.action",{op:'findMemberInfo'},function(data){
				$('.info_con .user_info_list #username span').html(data.nickName);
				$('.info_con .user_info_list #tel span').html(data.tel);
				$('.info_con .user_info_list #addr span').html(data.nickName);
				$('.info_con .user_info_list #realname span').html(data.realName);
				$('.info_con .user_info_list #email span').html(data.email);
			},'json');
		}
		//获取全部订单
		function getOrder(){
			$.post("order.action",{op:'findAllOrder'},function(data){
				//console.log(data);
				var str='';
				if(data==null || data.length<0){
					str='暂无订单,请先添加订单！';
				}else{
					str+='<h3 class="common_title2">全部订单</h3>';
					for(var i=0;i<data.length;i++){
						var status=0;
						var orderNo='';
						var statusText='';
						var orderDate='';
						var str01='';
						var totalprice=0;
						var payStatus='已付款';
						for(var j=0;j<data[i].length;j++){
							str01+='<ul class="order_goods_list clearfix">'					
									+'<li class="col01"><img src="'+data[i][j].pictures+'"/></li>'
									+'<li class="col02">'+data[i][j].goodsName+'<em>'+data[i][j].price+'元/'+data[i][j].unit+'</em></li>'
									+'<li class="col03">'+data[i][j].nums+'</li>'
									+'<li class="col04">'+data[i][j].price*data[i][j].nums+'元</li>'
								+'</ul>';
								orderDate=data[i][j].orderDate;
								orderNo=data[i][j].orderNo;
								status=data[i][j].status;
								totalprice+=data[i][j].price*data[i][j].nums;
						}
						if(status==0){
							statusText='未支付';
							payStatus="待付款";
						}else if(status==1){
							statusText='已支付,未发货';
						}else if(status==2){
							statusText='已发货';
						}
						str+='<ul class="order_list_th w978 clearfix">'
								+'<li class="col01">'+orderDate+'</li>'
								+'<li class="col02">订单号:'+orderNo+'</li>'
								+'<li class="col02 stress"><span>订单状态:</span>'+statusText+'</li>'		
							+'</ul>'
	
							+'<table class="order_list_table w980">'
								+'<tbody>'
									+'<tr>'
										+'<td width="55%">'
										+str01
										+'</td>'
										+'<td width="15%">'+totalprice+'元</td>'
										+'<td width="15%">'+payStatus+'</td>'
										+'<td width="15%"><a href="#" class="oper_btn" onclick="topay('+status+","+orderNo+')">去付款</a></td>'
									+'</tr>'
							+'</tbody>'
						+'</table>';
					}
				}
				$('.order_icon').html(str);
			},'json');
		}
		//获取收货地址
		function getSite(){
			$.post("addr.action",{addrOption:'findAddrInfo'},function(data){
				if(data==null || data==""){
					return;
				}
				var realAddr=data[0].province+"  "+data[0].city+"  "+data[0].area+"  "+data[0].addr;
				var name=data[0].name;
				var tel=data[0].tel;
				
				$('.site_top dl dd:eq(0) span').html(name);
				$('.site_top dl dd:eq(1) span').html(realAddr);
				$('.site_top dl dd:eq(2) span').html(tel);
				
				$('#name').val(name);
				$('#province').val(data[0].province);
				$('#city').val(data[0].city);
				$('#area').val(data[0].area);
				$('#addr').val(data[0].addr);
				$('.form_group #tel').val(tel);
			},'json');
		}
		
		$('.site_top input').click(function(){
			$('.site_btm input').removeAttr("disabled");
			$('.site_btm form div.form_group textarea').removeAttr("disabled");
		});
		//alert(13);
		$('.site_btm form').submit(function(){
			//return false;
			var name=$('#name').val();
			var province=$('#province').val();
			var city=$('#city').val();
			var area=$('#area').val();
			var addr=$('#addr').val();
			var tel=$('.form_group #tel').val();
			if(name==null || name.length<=0){
				alert('请先输入收件人名称！！！！');
				return false;
			}
			if(province==null || province.length<=0){
				alert('请先输入省名！！！！');
				return false;
			}
			if(city==null || city.length<=0){
				alert('请先输入市名！！！！');
				return false;
			}
			if(area==null || area.length<=0){
				alert('请先输入县(区)名！！！！');
				return false;
			}
			if(addr==null || addr.length<=0){
				alert('请先输入详细地址！！！！');
				return false;
			}
			if(tel==null || tel.length<=0){
				alert('请先输入收件人电话号码！！！！');
				return false;
			}
			$.get("addr.action",{addrOption:'updateInfo',tel:tel,name:name,province:province,city:city,area:area,addr:addr},
				function(data){
					//alert(data);
					if(data>0){
						alert("地址信息修改成功");
						if(param.length>0){
							window.location.href="order.jsp?orderNo="+'${param.orderNo}';
						}
						return false;
					}else{
						alert("地址信息修改失败");
					}
				//alert(123);
			});
			return false;
		});
		
	});
</script>
</html>