<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>后台登录</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!-- //for-mobile-apps -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
    <!-- main -->
    <div class="main">
        <h1>
           天天生鲜后台管理系统
        </h1>
        <h3><i>Tian Tian Sheng Xian Management System</i></h3>
        <form>
            <input type="text" name="adminName" value="用户名" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '用户名';}"
                   required="">
            <input type="password" name="adminPwd" value="Password" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}"
                   required="">
            <input type="button" value="登录" onclick="login()">
        </form>
    </div>
    <div class="footer">
        <p>
            &copy 衡阳市源辰信息科技有限公司<a href="http://www.hnycinfo.com" target="_blank">源辰信息</a>
        </p>
    </div>
    <script type="text/javascript" src="js/jquery.min.js"></script>
   
    <script type="text/javascript">
    
    		function login(){
    			//获取用户名密码
    			var name=$('input[name="adminName"]').val();
    			var pwd=$('input[name="adminPwd"]').val();
    			$.post('../admin.action',{op:'login',adminName:name,adminPwd:pwd},function(data){
    				if(data==1){
    					location.href="manager/index.jsp";
    				}else{
    					alert("登陆失败");
    				}
    			});
    		}
    </script>
</body>
</html>