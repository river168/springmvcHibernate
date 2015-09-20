<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/head.jsp" %>
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
  <script language="JavaScript" src="js/table_tr.js" ></script>
  <script language="JavaScript" src="js/jquery.js"></script>
  <link rel="stylesheet" href="<%=basePath%>/resources/flexigrid/css/flexigrid.css" type="text/css" ></link>
  <script src="<%=basePath%>/resources/flexigrid/js/flexigrid.pack.js"></script>
  <script src="<%=basePath%>/resources/flexigrid/js/flexigrid.js"></script>	
  <script language="JavaScript" src="<%=basePath%>js/hetong.js" ></script>
  
  <script type="text/javascript">
  $(function(){
	  
	  $("#btnquery").click(function(){
		  var params = [
		                {"name" : "jzmc", "value" : $("#jzmc").val()},
		                {"name" : "quyu", "value" : $("#quyu").val()},
		                {"name" : "yzdh", "value" : $("#yzdh").val()}
		                ]; 
		  // flex 组建参数 传递
		  $('#mytable').flexOptions({params : params,newp : 1}).flexReload();
		  
	  });
	  
  });

  </script>
</head>


<body>
     <form   name="myform" method="post" action="hetongAction.do?method=queryList" >

        <table width="100%"  border="0" valign=top  align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="6"><img src="images/main_01.gif" width="6" height="6"/></td>
          <td width="981" bgcolor="#A3A3A3"><img src="images/main_02.gif" width="560" height="6"></td>
          <td width="10"><img src="images/main_03.gif" width="6" height="6"/></td>
  <pre></pre>      </tr>
        <tr bgcolor="#F0F0F0">
          <td colspan="3" background="images/bg.gif" bgcolor="#F0F0F0" class="TABLE">
		  <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1" >
              <tr>
                <td background="images/main_title_bg1.gif">
				<table width="100%"  border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td width="1%"><img src="images/dot9.gif" width="14" height="14"/></td>
                    <td width="99%">合同信息输入springmvc+hibernate+FlexGrid表格组件 </td>
                  </tr>
                </table>
				</td>
              </tr>
              
              <tr><td>
             
              <table border=0 >
                <tr><td>基站名称:
                <input type=text id="jzmc" name="jzmc" size=15 value="${jzmc}"/>
                <td> 区域：
                <input type=text id="quyu" name="quyu" size=15 value="${quyu}"/>
                
                <td> 业主电话：
                <input type=text id="yzdh" name="yzdh" size=15 value="${yzdh}"/>
                <input type=button  id = "btnquery" value="查询">&nbsp;
                <input type=reset  value="清空"    id="resetObj" >
                <input type=button value="增加"     onclick="window.location='hetongAction.do?method=toaddpage'">
                <input type=button value="删除" onclick="doDelete()"> 
                <input type=button value="修改" onclick="doUpdate()"> 
              </table>              
              <tr>
                <td width="50%" class="TABLE5">
                    <!-- FlexGrid  表格组件 -->
	                <table id="mytable">
	                
	                </table>
                </td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td><img src="images/main_05.gif" width="6" height="6"/></td>
          <td bgcolor="#A3A3A3"><img src="images/main_06.gif" width="560" height="6"/></td>
          <td><img src="images/main_07.gif" width="6" height="6"/></td>
        </tr>
      </table>
    <input type="hidden"  value="${message}"  name="message" id="message">
</form>
<script language="javascript">
/*这是JQuery的语法，$表示JQuery对象，
直接传函数体进去，表示当页面加载完毕时执行这个函数*/
$(function(){
	$("#resetObj").click(function(){ 
		location.href = 'hetongAction.do?method=reset'; //清空查询条件：因为输入的控件绑定了queryList方法中的参数值
	});

 var message=$("#message").val();
  if(message!=""){
	  alert(message);
	  $("#message").val("");//清空消息防止刷新重新报消息 
	  return false;
  }
});
</script>
</body>
</html>




