
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
 <base href="<%=basePath%>">
  <LINK href="style/main_table.css" type=text/css rel=stylesheet>
</head>
<body>
<table  border="0" cellspacing="0" cellpadding="0"  width="100%">
  <tr>
    <td><img width="100%" src="images/top_07.gif"/></td>
  </tr>
  <tr>
    <td height="25" align="center" background="images/top_09.gif" width="100%"><span class="leftbg">合同管理</span></td>
  </tr>
  <tr>
    <td background="images/top_09.gif" width="100%">
	<table width="96%"  border="0" align="center" cellpadding="1" cellspacing="1" id="button" width="100%">
       <tr>
        
	<td height="25" width="100%"><img src="images/dot.gif" width="12" height="12" border="0"/>
	<a href="hetongAction.do?method=queryList" target="main">合同信息录入</a>     </td>	
	 
	</tr>
    
    
    </table>
    <br></td>
  </tr>
  <tr>
    <td><img src="images/top1_11.gif" width="100%" height="17"/></td>
  </tr>
</table>
</body>
</html>
