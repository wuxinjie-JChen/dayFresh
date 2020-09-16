<%@page import="com.yc.po.AdminPO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>天天生鲜管理系统</title>
<style type="text/css">
#personalInfo{
	width:100px;
	height:200px;
	padding-top: 50px;
}
</style>
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<link rel="stylesheet" type="text/css" href="../css/bases.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/addGoods.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'north'" class="north" style="height:60px">
        	
        	<ul>
        		<li class="a">管理人员:[<span style="color:red"><%=session.getAttribute("adminName") %></span>]欢迎登陆天天生鲜管理系统</li>
        		<li><a id="mm" class="easyui-linkbutton btns" data-options="plain:true">修改密码</a></li>
        		<li><a class="easyui-linkbutton btns" data-options="plain:true" href="loginout.jsp">安全退出</a></li>
        	</ul>
        </div>
        <div id="personalInfo" title="修改密码">
      		<table cellpadding="5" align="center">
				<tbody>
				<tr>
					<td>用户名:</td>
					<td><input value="<%=session.getAttribute("adminName") %>" class="easyui-validatebox textbox validatebox-text" type="text" id="updateUname" style="background: #F5F5F5;" disabled="disabled">
					</td>
				</tr>
				<tr>
					<td>原密码:</td>
					<td><input class="easyui-validatebox textbox validatebox-text" type="password" id="oldPassword" data-options="required:true" title=""></td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input class="easyui-validatebox textbox validatebox-text" type="password" id="newPassword" data-options="required:true" title=""></td>
				</tr>
				<tr>
					<td>确认新密码:</td>
					<td><input class="easyui-validatebox textbox validatebox-text" type="password" id="newPasswordAgain" data-options="required:true" title=""></td>
				</tr>
				<tr>
        			<td><input type="button" value="修改" onclick="modify()"></td>
        			<td><input type="button" value="取消" onclick="quxiao()"></td>
        		</tr>
			</tbody></table>
        </div>
        <div data-options="region:'south'" style="height:50px;"></div>
        <div data-options="region:'west'" title="导航菜单" style="width:220px;">
        	<div class="easyui-accordion" style="width:200px;height:300px" data-options="fit:true">
				<div title="商品管理">
					<ul>
						<li><a class="easyui-linkbutton btn" data-options="plain:true" href="showGoods.html">商品列表</a></li>
						<li><a class="easyui-linkbutton btn" data-options="plain:true" href="addGoods.html">添加商品</a></li>
					</ul>
				</div>
				<div title="订单管理">
					<ul>
						<li><a class="easyui-linkbutton btn" data-options="plain:true" href="order.html">订单列表</a></li>
						<li><a class="easyui-linkbutton btn" data-options="plain:true" href="showOrderItem.html">订单详情</a></li>
					</ul>
				</div>
				<div title="用户管理">
					<ul>
						<li><a class="easyui-linkbutton btn" data-options="plain:true" href="showUser.html">用户列表</a></li>
					</ul>
				</div>
				
			</div>
        	
        </div>
        <div data-options="region:'center'">
        	<div id="show_center" class="easyui-tabs" data-options="fit:true"></div>
        </div>
    </div>
    <script type="text/javascript">
    	$('#mm').click(function(){
    		$('#personalInfo').window({
    		    width:600,
    		    height:400,
    		    modal:true
    		});
    	});
    	
    	function quxiao(){
    		//取消修改密码
			$('#oldPassword').val('');
			$('#newPassword').val('');
			$('#newPasswordAgain').val('');
    	}
    	
    	function modify(){
    		//确认修改密码
			var updateUname=$('#updateUname').val();
			var updateExamClass=$('#updateExamClass').val();
			var oldPassword=$('#oldPassword').val();
			var newPassword=$('#newPassword').val();
			var newPasswordAgain=$('#newPasswordAgain').val();
			if(newPassword==newPasswordAgain){
				$.post("../../admin.action", {op:'modify',adminName:updateUname,oldPwd:oldPassword,newPwd:newPassword}, function(data) {
					if(data==0){
						//data为0，表示修改密码不成功，原密码不正确
						//清空密码框
						$('#oldPassword').val('');
						$('#newPassword').val('');
						$('#newPasswordAgain').val('');
						alert('修改密码不成功，原密码不正确');
						return;
					}else if(data==1){
						//data为1，表示修改密码成功
						//清空密码框
						$('#oldPassword').val('');
						$('#newPassword').val('');
						$('#newPasswordAgain').val('');
						alert('修改密码成功');
						$('#personalInfo').window('close');
					}
				});
			}else{
				alert('两次输入密码不一致，请重新输入');
				//清空密码框
				$('#newPassword').val('');
				$('#newPasswordAgain').val('');
				return;
			}
    	}
    	$(function(){
    		$('#show_center').tabs('add',{
        		title:"首页",
        		content:'欢迎使用天天生鲜后台管理系统........',
        		fit:true,
        		tools:[{
        		   iconCls:'icon-clear',
        		   handler:function(){
        			   $('#show_center').tabs('close'); 
        		     }
        		 }]
        	});
    	});
    	$('.btn').click(function(){
    		var href=$(this).attr('href');
    		var name=$(this).html();
    		if($('#show_center').tabs('exists',name)){
    			$('#show_center').tabs('select',name);
    		}else{
    			$('#show_center').tabs('add',{
            		title:name,
            		href:href,
            		fit:true,
            		tools:[{
            		   iconCls:'icon-clear',
            		   handler:function(){
            			   $('#show_center').tabs('close',name); 
            		     }
            		 }]
            	});
    		}
    		return false;
    	});
    </script>
</body>
</html>