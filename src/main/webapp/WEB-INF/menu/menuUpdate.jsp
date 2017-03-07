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
<form action="sys/menu_saveOrUpdate" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
	<input type="hidden" name="id" value="<s:property value="id"/>" >
    <tr>
        <td width="10%" class="tableleft">菜单名称</td>
        <td><input type="text" name="menuname" value="<s:property value="menuname"/>"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">地址</td>
        <td><input type="text" name="menulink" value="<s:property value="menulink"/>"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">权限名称</td>
        <td><input type="text" name="securyname" value="<s:property value="securyname"/>"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">权限描述</td>
        <td><input type="text" name="memo" value="<s:property value="memo"/>"/></td>
    </tr>
    
     <tr>
        <td class="tableleft">上级菜单 </td>
        <td>
        	<select name="pid">
        		<option value="0">不选择就为一级菜单</option>
        		<s:iterator value="menuList.{? #this.menulink == null}" var="big">
        			<option value="<s:property value="id"/>"
        			<s:property value="#big.id == id?'selected':''"/>>
        				<s:property value="menuname"/>
        			</option>
        		</s:iterator>
        	</select>
        </td>
    </tr>
    
    
    
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
		 
		 $(':checkbox[ids="biggroup"]').click(function () {
            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
        });

    });
</script>