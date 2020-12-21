<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			申请领养
		</div>
	</div>
	<div class="blank"></div>
	<div class="block table">
		<form action="index/addApply.action" method="post" name="theForm"
			id="theForm" onsubmit="return checkConsignee(this)">
			<div class="flowBox">
				<h6>
					<span>申请领养</span>
				</h6>
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff">动物:</td>
						<td bgcolor="#ffffff" colspan="2">${map.pet.petname }<input name="applys.petid"
							type="hidden" class="inputBg" id="applys.petid" value="${id }" />
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">说明:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="applys.memo"
							type="text" class="inputBg" id="applys.memo" style="width:260px" /> (必填)</td>
					</tr>
					<tr>
						<td colspan="4" align="center" bgcolor="#ffffff"><input
							type="submit" class="bnt_blue_2" value="确定" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
