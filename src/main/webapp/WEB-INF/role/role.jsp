<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
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
<form class="form-inline definewidth m20" action="sys/role_query" method="post">    
    用户名称：
    <input type="text" name="rolename" id="rolename"
    class="abc input-default" placeholder="" value="${rolename}">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">
   	 查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增角色</button>
    
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>角色id</th>
        <th>角色名称</th>
        <th>角色描述</th>
       
        <th>操作</th>
    </tr>
    </thead>
    	<s:iterator value="pageModel.result" var="role">
		     <tr>
	            <td><s:property value="#role.id"/></td>
	            <td><s:property value="rolename"/></td>
	            <td><s:property value="demo"/></td>
	            <td>
	                <a href="sys/role_updatePage?id=<s:property value="#role.id"/>">编辑</a>  &nbsp;&nbsp;
	                <a href="javascript:del(<s:property value="#role.id"/>)">删除</a>                
	            </td>
	        </tr>	
        </s:iterator>
</table>
	<form action="sys/role_query" method="post" id="pager" >
        <input type="hidden" name="currentPage" id="currentPage" value="${pageModel.currentPage }">   
         <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">  
         <!--<s:hidden name="username"></s:hidden>
          
         <input type="hidden" name="username" value='<s:property value="username"/>'> -->
    </form>
<div class="inline pull-right page">
	<%@include file="../../pageBar.jsp" %>
</div>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="sys/role_init";
		 });


    });
    
	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "sys/role_delete?id=" + id;
			
			window.location.href=url;		
		
	}
	
}
</script>