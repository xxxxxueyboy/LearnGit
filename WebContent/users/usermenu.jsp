<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="userMenu">
	
	<a href="index/usercenter.action"><img src="themes/xecmoban_shunfeng/images/u2.gif" />用户信息</a>
	<a href="index/prePwd.action"><img src="themes/xecmoban_shunfeng/images/u3.gif" />修改密码</a>
	<a href="index/myasign.action"><img src="themes/xecmoban_shunfeng/images/u3.gif" />我的报名</a>
	<a href="index/myApply.action"><img src="themes/xecmoban_shunfeng/images/u3.gif" />我的申请</a>
	<a href="index/exit.action" style="background: none; text-align: right; margin-right: 10px;"> 
	<img src="themes/xecmoban_shunfeng/images/bnt_sign.gif" /> </a>
	
</div>
