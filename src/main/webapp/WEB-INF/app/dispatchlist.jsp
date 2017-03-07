<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title></title>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" action="sys/role_query"
		method="get">
		角色名称： 
		 <input type="text" name="rolename" id="rolename"
			class="abc input-default" placeholder="" value="${rolename }">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		
		<button type="button" class="btn btn-success" id="addnew">新增角色</button>
		
		
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>id</th>
				<th>用车事由</th>
				<th>出发地</th>
				<th>目的地</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<s:iterator value="pageModel.result" var="u">
			<tr>
				<td><s:property value="#u.id" /></td>
				<td><s:property value="#u.requisitionReason" /></td>
				<td><s:property value="#u.startPlace" /></td>
				<td><s:property value="#u.destination" /></td>
				<td><s:property value="#u.state" /></td>
				<td>
				
				<a href="car/app_choiceCar?id=<s:property value="#u.id" />">调度车辆</a>
				
				
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<form action="car/app_query" method="post" id="pager" >
          <input type="hidden" name="currentPage" id="currentPage" value="${pageModel.currentPage }">   
           <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">  
          
           <!-- 
           <input type="hidden" name="username" value='<s:property value="username"/>'> -->
    </form>
	<div class="inline pull-right page">
		
			<%@include file="../../pageBar.jsp" %>

	</div>
	
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "sys/role_init";
		});
		
		

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>
