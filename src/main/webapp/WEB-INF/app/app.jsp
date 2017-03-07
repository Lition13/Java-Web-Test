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
	<form action="car/app_save" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			 <s:hidden name="id"></s:hidden>
			<tr>
			  
				<td width="10%" class="tableleft">出行区域</td>
				<td>
				   出行区域
				</td>
				
				<td width="10%" class="tableleft">申请人</td>
				<td>
				 <input type="text" name="proposer" value='<s:property value="#session.LOGIN_USER.username"/>'>
				</td>
				
				<td width="10%" class="tableleft">联系方式</td>
				<td><s:textfield name="contactWay"></s:textfield></td>
			</tr>
			<tr>
			  
				<td width="10%" class="tableleft">所属部门</td>
				<td>
				   出行区域
				</td>
				
				<td width="10%" class="tableleft">出发地</td>
				<td><s:textfield name="startPlace"></s:textfield></td>
				
				<td width="10%" class="tableleft">目的地</td>
				<td><s:textfield name="destination"></s:textfield></td>
			</tr>
			
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$(':checkbox[idis="biggroup"]').click(
				function() {
					$(':checkbox', $(this).closest('li')).prop('checked',
							this.checked);
				});

		$('#backid').click(function() {
			window.location.href = "sys/menu_query";
		});
	});

	
</script>