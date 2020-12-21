<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="footer">
	<div class="foot_con">
		<div class="blank"></div>

		<div class="blank"></div>
		<div id="bottomNav" class="rolling"></div>

		<div class="text" style="height: 1px; width: 1px; overflow: hidden;">
			<br />
		</div>

		<div class="record">
				 2020 ${title } design by 周丽青
			<p style="color: #999;">浙江省宁波市鄞州区首南街道钱湖南路8号 Tel: 150 6783 5550
				</p>
			<a href="admin/index.jsp" target="_blank">管理员入口</a>
		</div>
	</div>
	<div class="blank"></div>
</div>