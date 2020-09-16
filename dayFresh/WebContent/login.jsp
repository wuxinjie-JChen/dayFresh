<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>天天生鲜-登陆</title>
<link rel="icon" href="images/yclogo.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/login.css">
</head>

<body>
	<!-- logo区区域 -->
	<div class="login_top">
    	<a href="index.html" class="login_logo"><img src="images/logo02.png"></a>
    </div>
	
	<!-- 内容区域 -->
    <div class="login_form_bg">
    	<div class="login_form_wrap clearfix">
        	<div class="login_banner fl"></div>
            <div class="slogn fl">日夜兼程 · 急速送达</div>	
            <div class="login_form fr">
                <div class="login_title	clearfix">
                    <h1 class="fl">用户登陆</h1>
                    <a href="register.jsp" class="fl">立即注册</a>
                </div>
				<!-- 登录区域 -->
                <div class="form_input clearfix">
                    <form>
						<ul>
                            <li>
                                <input type="text" name="nickname" class="name_input" id="nickname" placeholder="请输入用户名" id="nickname">
                                <div class="user_error">输入错误</div>
                            </li>
                            <li>
                                <input type="password" name="pwd" class="pwd_input" id="pwd" placeholder="请输入密码" id="pwd">
                                <div class="pwd_error">密码错误</div>
                            </li>
                            <li>
                            	<div>
                                <input type="text" name="yzm" id="yzm" class="yzm_input"
                                placeholder="请输入验证码">
                                <img class="code" src="code.action" onClick="refresh(this)">
                                <!--  <img class="code" src="images/yzm.png">-->
                               <!--   </div>
                                    
                                    <img id="image" src="code/getCode" title="验证码图" onclick="refresh(this)"/>
                                  --> 
                                <div class="code_error">验证码错误</div>
                            </li>
                            <!-- <li>
                                <div class="more_input clearfix">
                                    <input type="checkbox" name="" id="remember">
                                    <label for="remember">记住用户名</label>
                                    <a href="#">忘记密码</a>
                                </div>
                            </li> -->
                            <li>
                               <input type="button" value="登录" class="submit_input" onclick = "login()">
                            </li>
                      	</ul>
                    </form>
                </div>
            </div>
         </div>
    </div>
	
	<!-- 版权所有-->
    <div class="footer">
    	<div class="foot_link">
        	<a href="#">关于我们</a><span> | </span>
        	<a href="#">联系我们</a><span> | </span>
        	<a href="#">招聘广告</a><span> | </span>
            <a href="#">友情链接</a>
        </div>
        <p>CopyRight &copy;  2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
        <p>电话：0734-8355998 湘ICP备16015987号</p>
    </div>
	<script src="js/jquery-3.4.1.min.js"></script>
	<script>
		//切换验证码
		function refresh(){
			var time=new Date().getTime();
			$('.code').attr("src","code.action?d"+time);
		}
		
		//登陆
		function login(){
			//获取用户名
			var nickname = $("#nickname").val();
			//获取密码
			var pwd = $("#pwd").val();
			//获取验证码
			var yzm = $("#yzm").val();
			var yzm_tf
			$.post("codes.action",{yzm:yzm},function(data){
				yzm_tf=data;
			});
			$.post("member.action",{op:'login',nickName:nickname,pwd:pwd},function(data){
				if(yzm_tf==1&&data!=null){
					location.href="index.jsp";
				}else{
					alert("登陆失败");
				}
			},'json');
		};
	</script>
</body>
</html>
