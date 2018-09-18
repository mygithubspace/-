<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 35%;
	width: 25%;
	height: 15%;
	padding: 16px;
	border: 2 solid black;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
<script src="static/js/jquery.js"></script>
<script src="static/js/verifyCode.js"></script>
<script src="static/js/Particleground.js"></script>
<script src="static/layer/layer.js"></script>
<script src="static/layer/theme/default/layer.css"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});

		$("#registerBtn").click(function() {
			var password=$("#password").val();
			var repassword=$("#repassword").val();
			if(password!=repassword){
				alert("确认密码错误!");
				return;
			}
			$.post("/register", {
				userName : $("#userName").val(),
				password : $("#password").val(),
			}, function(result) {
				if (result.success) {
					layer.msg("注册成功",{time:1000},function(){
						window.location.href = "/login.jsp";
					});
				} else {
					layer.alert(result.errorMsg, {
						  skin: 'layui-layer-molv' 
						  ,closeBtn: 0
					});
				}
			});

		});

	});
	function login() {
		window.location.href = "/login.jsp";
	}
</script>
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>XX系统</strong> <em>REGISTER</em>
		</dt>
		<dd class="user_icon">
			<input type="text" id="userName" placeholder="账号" class="login_txtbx" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" id="password" placeholder="密码"
				class="login_txtbx" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" id="repassword" placeholder="确认密码"
				class="login_txtbx" />
		</dd>
		<dd>
			<input type="button" id="registerBtn" value="立即登陆" class="submit_btn" />
		</dd>
		<dd>
			<br>
			<p>
				<small>已有账号</small><a href="javascript:login()">点击登录</a>
			</p>
		</dd>
	</dl>
	<div id="fade" class="black_overlay"></div>
	<script type="text/javascript">
		function register() {
			window.location.href = "/regi.html";
		}
	</script>
</body>
</html>
