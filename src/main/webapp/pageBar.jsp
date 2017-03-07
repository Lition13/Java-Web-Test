<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <div>
        共有${pageModel.totalCount }条记录，共${pageModel.pageCount }页，每页
      <select name="pageSize" onchange="changePageSize(this.value)" style="width: 50px;">
          <option value="3" ${pageModel.pageSize==3?"selected":"" }>3</option>
          <option value="5"  ${pageModel.pageSize==5?"selected":"" }>5</option>
          <option value="10"  ${pageModel.pageSize==10?"selected":"" }>10</option>
          <option value="100"   ${pageModel.pageSize==100?"selected":"" }>100</option>
      </select>  
        条记录，当前${pageModel.currentPage }/${pageModel.pageCount }页，
    <a href="javascript:homePage()">首页</a>|
    <a href="javascript:frontPage()">上一页</a>|
    <a href="javascript:nextPage()">下一页</a>|
    <a href="javascript:lastPage()">尾页</a>|
    转到<select name="currentPage" onchange="goPage(this.value)" style="width: 50px;">
       <c:forEach begin="1" end="${pageModel.pageCount }" var="i">
          <option value=${i }  ${pageModel.currentPage==i?"selected":"" }>${i }</option>
       </c:forEach>
    </select>
   </div>
   
   
    <script type="text/javascript">
       function homePage(){
    	   document.getElementById("currentPage").value=1;
    	   document.getElementById("pager").submit();//表单提交
    	   
       }
       function frontPage(){
    	   document.getElementById("currentPage").value=${pageModel.currentPage<=1? 1 : pageModel.currentPage-1 };
    	   document.getElementById("pager").submit();//表单提交
       }
       function nextPage(){
    	   document.getElementById("currentPage").value=${pageModel.currentPage>=pageModel.pageCount?pageModel.pageCount:pageModel.currentPage+1 };
    	   document.getElementById("pager").submit();//表单提交
       }
       function lastPage(){
    	   document.getElementById("currentPage").value=${pageModel.pageCount };
    	   document.getElementById("pager").submit();//表单提交
       }
       function goPage(cur_page){
    	   document.getElementById("currentPage").value=cur_page;
    	   document.getElementById("pager").submit();//表单提交
       }
       function changePageSize(cur_pageSize){
    	   document.getElementById("pageSize").value=cur_pageSize;
    	   document.getElementById("pager").submit();//表单提交
       }
    </script>