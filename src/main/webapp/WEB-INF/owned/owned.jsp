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
<form class="form-inline definewidth m20" action="car/owned_query" method="post">    
    用户名称：
    <input type="text" name="model" id="model"
    class="abc input-default" placeholder="" value="${model}">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">
   	 查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增角色</button>
    <button type="button" class="btn btn-success" id="importExcel">Excel导入</button>
    <button type="button" class="btn btn-success" id="outExcel">Excel导出</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>id</th>
        <th>车辆编号</th>
        <th>使用单位</th>
        <th>车辆类型</th>
        <th>车牌号码</th>
        <th>操作</th>
    </tr>
    </thead>
    	<s:iterator value="pageModel.result" var="owned">
		     <tr>
	            <td><s:property value="id"/></td>
	            <td><s:property value="vehicleId"/></td>
	            <td><s:property value="depid"/></td>
	            <td><s:property value="model"/></td>
	            <td><s:property value="licenseCode"/></td>
	            <td>
	                <a href="car/owned_updatePage?id=<s:property value="#owned.id"/>">编辑</a>  &nbsp;&nbsp;
	                <a href="javascript:del(<s:property value="#owned.id"/>)">删除</a>                
	            </td>
	        </tr>	
        </s:iterator>
</table>
	<form action="car/owned_query" method="post" id="pager" >
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

				window.location.href="car/owned_init";
		 });
		
		$('#importExcel').click(function(){

				window.location.href="uploadExcel.jsp";
		 });
		 
		 $('#outExcel').click(function(){

				window.location.href="car/owned_outExcel?fileName=owned_data.xls";
		 });

    });
    
	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "car/owned_delete?id=" + id;
			
			window.location.href=url;		
		
	}
	
}
</script>