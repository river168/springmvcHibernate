<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/head.jsp" %>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
 <title>合同信息输入</title>
 <base href="<%=basePath%>">
  <LINK href="style/main_table.css" type=text/css rel=stylesheet>
  <script language="JavaScript" src="js/commUtil.js" ></script>
  <script language="JavaScript" src="js/jquery.js"></script>	
</head>

<body>

        <table width="100%"   border="0" valign=top  align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="6"><img src="images/main_01.gif" width="6" height="6"/></td>
          <td width="981" bgcolor="#A3A3A3"><img src="images/main_02.gif" width="560" height="6"></td>
          <td width="10"><img src="images/main_03.gif" width="6" height="6"/></td>
        </tr>
        <tr >
          <td colspan="3"   ><table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
              <tr>
                <td background="images/main_title_bg1.gif"><table width="100%"  border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td width="1%"><img src="images/dot9.gif" width="14" height="14"/></td>
                    <td width="99%">合同信息输入ByObject </td>
                  </tr>
                </table></td>
              </tr>
              
              <tr><td align=center height=500>
             
<form name="updateHetongForm" method=post action="hetongAction.do?method=update">
<input type="hidden" name="id"  value="${hetong.id}" />



  <table  class="table5">
	<tr>
		<td nowrap height="3" width="76"><strong>基站名称</strong></td>
		<td  nowrap height="3" width="197">
		<input name="jzmc"  value="${hetong.jzmc}"/></td>
		<td  nowrap height="3" width="77"><b>合同</b></td>
		<td  nowrap height="3" width="258"><input name="hetong" value="${hetong.hetong}"/></td>
	</tr>
	<tr>
		<td  nowrap height="34" width="76"><strong><span lang="en-us">&nbsp;&nbsp;&nbsp;
		</span>期别</strong></td>
		<td  nowrap height="34" width="197"><input name="jibie" value="${hetong.jibie}"/></td>
		<td  nowrap height="34" width="77"><strong>区域</strong></td>
		<td  nowrap height="34" width="258"><input name="quyu" value="${hetong.quyu}"/></td>
	</tr>
	<tr>
		<td  nowrap height="17" width="76"><strong><span lang="en-us">&nbsp;&nbsp;&nbsp;
		</span>镇区</strong></td>
		<td  nowrap height="17" width="197"><input name="zhengqu"  value="${hetong.zhengqu}" /></td>
		<td  nowrap height="17" width="77"><strong>面积(M2)</strong></td>
		<td  nowrap height="17" width="258"><input name="mianji" value="${hetong.mianji}"/></td>
	</tr>
	<tr>
		<td  nowrap height="16" width="76"><strong><span lang="en-us">&nbsp;&nbsp;&nbsp;
		</span>地址</strong></td>
		<td nowrap  height="16" width="197"><input name="dizhi" value="${hetong.dizhi}" /></td>
		<td nowrap  height="16" width="77"><strong>业主姓名</strong></td>
		<td  nowrap height="16" width="258"><input name="yzmc" value="${hetong.yzmc}" /></td>
	</tr>
	<tr>
		<td  nowrap height="1" width="76"><strong>业主电话</strong></td>
		<td  nowrap height="1" width="197"><input name="yzdh" value="${hetong.yzdh}"/></td>
		<td  nowrap height="1" width="77"></td>
		<td  nowrap height="1" width="258"></td>
	</tr>
	<tr>
		<td  nowrap height="7" width="608" colspan="4" align=center>
		<input type="submit" id="frmSubmit"  name="frmSubmit" value="提交表单" /> 
		<input type="button" value="返回主页面"  id="goback"  name="goback"/>

		</span></td>
		</tr>
</table>
<input type="hidden"  value="${message}"  name="message" id="message">
</form>

        
              
          </table></td>
        </tr>
        <tr>
          <td><img src="images/main_05.gif" width="6" height="6"/></td>
          <td bgcolor="#A3A3A3"><img src="/images/main_06.gif" width="560" height="6"/></td>
          <td><img src="images/main_07.gif" width="6" height="6"/></td>
        </tr>
      </table>
     

</body>
</html>



<script type="text/javascript">
$(function(){
	//返回主页面
	$("#goback").click(function(){
		window.location.href="hetongAction.do?method=queryList";
	});
	
	var message=$("#message").val();
	$("#frmSubmit").click(function(){
	 $("#updateHetongForm").submit();
	});
	
	if(message=="success"){
		alert("修改成功!");
		return false;
	}
    if(message=="fail"){
		alert("修改失败!");
		return false;
	}

});

</script>


