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
<form action="sys/role_saveOrUpdate" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
	<input type="hidden" name="id" value="<s:property value="id"/>" >
    <tr>
        <td width="10%" class="tableleft">角色名称</td>
        <td><input type="text" name="rolename" value="<s:property value="rolename"/>"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">角色描述</td>
        <td><input type="text" name="demo" value="<s:property value="demo"/>"/></td>
    </tr>
    
     <tr>
        <td class="tableleft">菜单 </td>
        <td>
        	<ul>
        		<s:iterator value="menuList.{? #this.pid==0}" var="big">
        			<li>
						<label class='checkbox inline'>
							<input type='checkbox' <s:property value="#big.id in menus.{id}?'checked':''"/>
							ids="biggroup" name='menus.id' value='<s:property value="#big.id"/>' />
							<s:property value="#big.menuname"/>
						</label>
						<ul>
							<s:iterator value="menuList.{? #this.pid==#big.id}" var="small1">
								<li>
									<label class='checkbox inline'>
										<input type='checkbox'  <s:property value="#small1.id in menus.{id}?'checked':''"/>
										 name='menus.id' value='<s:property value="#small1.id"/>' />
										<s:property value="#small1.menuname"/>
									</label>
									<ul>
										<s:iterator value="menuList.{? #this.pid==#small1.id}" var="small2">
											<li>
												<label class='checkbox inline'>
													<input type='checkbox' <s:property value="#small2.id in menus.{id}?'checked':''"/>
													 name='menus.id' value='<s:property value="#small2.id"/>' />
													<s:property value="#small2.menuname"/>
												</label>
											</li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>
					</li>
        		</s:iterator>
        	</ul>
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