<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>

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
	<form class="form-inline definewidth m20" action="sys/user_query"
		method="get">
		用户名称： <input type="text" name="username" id="username"
			class="abc input-default" placeholder="" value="${username}">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
		<button type="button" class="btn btn-success" id="syndata">同步用户</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名称</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>电话</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
		</thead>
		<s:iterator value="pageModel.result" var="user">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="username" /></td>
				<td><s:property value="realname" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="phone" /></td>
				<td><s:property value="depid" /></td>
				<td><a href="edit.html">编辑</a></td>
			</tr>
		</s:iterator>
	</table>

	<form action="sys/user_query" method="post" id="pager">
		<input type="hidden" name="currentPage" id="currentPage"
			value="${pageModel.currentPage }"> <input type="hidden"
			name="pageSize" id="pageSize" value="${pageModel.pageSize }">
		<s:hidden name="username"></s:hidden>
		<!-- 
           <input type="hidden" name="username" value='<s:property value="username"/>'> -->
	</form>
	<div class="inline pull-right page">
		<jsp:include page="../../pageBar.jsp"></jsp:include>
	</div>
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "sys/user_init";
		});

	});
	
	$(function() {

		$('#syndata').click(function() {

			window.location.href = "sys/user_syndata";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}

	
</script>