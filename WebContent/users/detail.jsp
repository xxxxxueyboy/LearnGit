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
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			<a href="index/cate.action?id=${map.pet.cate.cateid }">${map.pet.cate.catename }</a>
			<code> &gt; </code>
			${map.pet.petname }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">动物分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<s:iterator value="map.cateList">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cateid }" class="  f_l">${catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</s:iterator>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门动物</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<s:iterator value="map.hotList">
							<ul class="clearfix">
								<li class="goodsimg"><a
									href="index/detail.action?id=${petid }" target="_blank"><img
										src="${image }" alt="${petname }" class="B_blue" /> </a></li>
								<li><a href="index/detail.action?id=${petid }"
									target="_blank" title="${petname }">${petname }</a> <br />
							</ul>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>


		<div class="AreaR">

			<div id="goodsInfo" class="clearfix">


				<div class="imgInfo">
					<a href="${map.pet.image }" id="zoom1"
						class="MagicZoom MagicThumb" title="${map.pet.petname }">
						<img src="${map.pet.image }" alt="${map.pet.petname }"
						width="360px;" height="360px" />
					</a>
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>

				<div class="textInfo">
						<h1 class="clearfix">${map.pet.petname }</h1>

						<ul class="ul2 clearfix">
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>动物号：</strong><font class="shop" id="ECS_SHOPPRICE">${map.pet.pno }</font>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>

									<strong>动物类型：</strong><a
										href="index/cate.action?id=${map.pet.cate.cateid }">${map.pet.cate.catename }</a>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>发布日期：</strong>${map.pet.addtime}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>动物点击数：</strong>${map.pet.hits}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>动物点状态：</strong>${map.pet.status}
								</dd>
							</li>
						</ul>
						<s:if test="map.pet.status =='未领养'">
						<ul class="bnt_ul">
							<li class="padd">
							<a href="index/preApply.action?id=${map.pet.petid }">申请领养</a>
							</li>
						</ul>
						</s:if>
				</div>
			</div>
			<div class="blank"></div>


			<div class="box">

				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>动物描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>${map.pet.contents }</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>

	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
