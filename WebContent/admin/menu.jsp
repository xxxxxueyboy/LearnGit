<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<base href="<%=basePath%>" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ecf4ff;
}

.dtree {
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0000ff;
	white-space: nowrap;
}

.dtree img {
	border: 0px;
	vertical-align: middle;
}

.dtree a {
	color: #333;
	text-decoration: none;
}

.dtree a.node, .dtree a.nodeSel {
	white-space: nowrap;
	padding: 1px 2px 1px 2px;
}

.dtree a.node:hover, .dtree a.nodeSel:hover {
	color: #0000ff;
}

.dtree a.nodeSel {
	background-color: #AED0F4;
}

.dtree .clip {
	overflow: hidden;
}
-->
</style>
<link href="css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/dtree.js"></script>
</head>
<body>
	<table width="96%" border="0" cellpadding="10" cellspacing="0"
		align="center">
		<tr>
			<td valign="top"><div class="menu">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><script type="text/javascript">
							d = new dTree('d');
							d.config.target="main";
							d.add(0,-1,'管理菜单');
							d.add(1, 0, '管理员', '');
							d.add(11, 1, '新增管理员', 'admin/createAdmin.action');
							d.add(12, 1, '管理员列表','admin/getAllAdmin.action');
							d.add(13, 1, '查询管理员','admin/queryAdminByCond.action');
							d.add(2, 0, '网站用户', '');
							d.add(22, 2, '网站用户列表','users/getAllUsers.action');
							d.add(23, 2, '查询网站用户','users/queryUsersByCond.action');
							d.add(3, 0, '网站公告', '');
							d.add(31, 3, '新增网站公告', 'article/createArticle.action');
							d.add(32, 3, '网站公告列表','article/getAllArticle.action');
							d.add(33, 3, '查询网站公告','article/queryArticleByCond.action');
							d.add(4, 0, '义工活动', '');
							d.add(41, 4, '新增义工活动', 'activities/createActivities.action');
							d.add(42, 4, '义工活动列表','activities/getAllActivities.action');
							d.add(43, 4, '查询义工活动','activities/queryActivitiesByCond.action');
							d.add(5, 0, '义工报名', '');
							d.add(52, 5, '义工报名列表','asign/getAllAsign.action');
							d.add(53, 5, '查询义工报名','asign/queryAsignByCond.action');
							d.add(6, 0, '动物类型', '');
							d.add(61, 6, '新增动物类型', 'cate/createCate.action');
							d.add(62, 6, '动物类型列表','cate/getAllCate.action');
							d.add(63, 6, '查询动物类型','cate/queryCateByCond.action');
							d.add(7, 0, '动物', '');
							d.add(71, 7, '新增动物', 'pet/createPet.action');
							d.add(72, 7, '动物列表','pet/getAllPet.action');
							d.add(73, 7, '查询动物','pet/queryPetByCond.action');
							d.add(8, 0, '领养申请', '');
							d.add(82, 8, '领养申请列表','applys/getAllApplys.action');
							d.add(83, 8, '查询领养申请','applys/queryApplysByCond.action');
							d.add(9, 0, '留言交流', '');
							d.add(92, 9, '留言交流列表','bbs/getAllBbs.action');
							d.add(93, 9, '查询留言交流','bbs/queryBbsByCond.action');
							document.write(d);							</script></td>
						</tr>
					</table>
				</div></td>
		</tr>
	</table>
</body>
</html>