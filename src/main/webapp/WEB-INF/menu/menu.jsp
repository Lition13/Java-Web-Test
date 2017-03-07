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
<form class="form-inline definewidth m20" action="sys/menu_query" method="post">    
    菜单名称：
    <input type="text" name="menuname" id="menuname"
    class="abc input-default" placeholder="" value="${menuname}">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">
   	 查询</button>&nbsp;&nbsp; 
   	 <s:if test="'/sys/menu_init' in #session.LOGIN_USER.menusList.{menulink}">
    	<button type="button" class="btn btn-success" id="addnew">新增菜单</button>
    </s:if>
    
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>菜单id</th>
        <th>菜单名称</th>
        <th>菜单地址</th>
        <th>父菜单编号</th>
        <th>权限名称</th>
        <th>菜单描述</th>
       
        <th>操作</th>
    </tr>
    </thead>
    	<!-- 显示一级菜单 -->
    	<s:iterator value="menuList.{? #this.pid==0}" var="big">
		     <tr>
	            <td><s:property value="#big.id"/></td>
	            <td><s:property value="menuname"/></td>
	            <td><s:property value="menulink"/></td>
	            <td><s:property value="pid"/></td>
	            <td><s:property value="securyname"/></td>
	            <td><s:property value="memo"/></td>
	            <td>
	            	<s:if test="'/sys/menu_updatePage' in #session.LOGIN_USER.menusList.{menulink}">
	                <a href="sys/menu_updatePage?id=<s:property value="#big.id"/>">编辑</a>  &nbsp;&nbsp;
	                </s:if>
	                <s:if test="'/sys/menu_delete' in #session.LOGIN_USER.menusList.{menulink}">
	                <a href="javascript:del(<s:property value="#big.id"/>);">删除</a>    
	                </s:if>            
	            </td>
	        </tr>
	        <!-- 显示二级菜单 -->
	        	<s:iterator value="menuList.{? #this.pid==#big.id}" var="small1">
	        		<tr>
			            <td style="padding-left: 30px;"><s:property value="#small1.id"/></td>
			            <td style="padding-left: 30px;"><s:property value="#small1.menuname"/></td>
			            <td><s:property value="#small1.menulink"/></td>
			            <td style="padding-left: 30px;"><s:property value="#small1.pid"/></td>
			            <td style="padding-left: 30px;"><s:property value="#small1.securyname"/></td>
			            <td style="padding-left: 30px;"><s:property value="#small1.memo"/></td>
			            <td>
			            	<s:if test="'/sys/menu_updatePage' in #session.LOGIN_USER.menusList.{menulink}">
			                <a href="sys/menu_updatePage?id=<s:property value="#small1.id"/>">编辑</a>  &nbsp;&nbsp;
			                </s:if>
			                <s:if test="'/sys/menu_delete' in #session.LOGIN_USER.menusList.{menulink}">
			                <a href="javascript:del(<s:property value="#small1.id"/>);">删除</a>
			                </s:if>                
			            </td>
			        </tr>
			        <!-- 显示三级菜单 -->
			        <s:iterator value="menuList.{? #this.pid==#small1.id}" var="small2">
			        	<tr>
				            <td style="padding-left: 60px;"><s:property value="#small2.id"/></td>
				            <td style="padding-left: 60px;"><s:property value="#small2.menuname"/></td>
				            <td><s:property value="#small2.menulink"/></td>
				            <td style="padding-left: 60px;"><s:property value="#small2.pid"/></td>
				            <td style="padding-left: 60px;"><s:property value="#small2.securyname"/></td>
				            <td style="padding-left: 60px;"><s:property value="#small2.memo"/></td>
				            <td>
				            	<s:if test="'/sys/menu_updatePage' in #session.LOGIN_USER.menusList.{menulink}">
				                <a href="sys/menu_updatePage?id=<s:property value="#small2.id"/>">编辑</a>  &nbsp;&nbsp;
				               </s:if>
				               <s:if test="'/sys/menu_delete' in #session.LOGIN_USER.menusList.{menulink}">
				                <a href="javascript:del(<s:property value="#small2.id"/>);">删除</a>                
				            	</s:if>
				            </td>
				        </tr>
			        </s:iterator>
	        	</s:iterator>
        </s:iterator>
</table>
	
</body>
</html>
<script>
	

    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="sys/menu_init";
		 });


    });
    
	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "sys/menu_delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	}
</script>