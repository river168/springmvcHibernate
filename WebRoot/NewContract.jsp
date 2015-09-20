<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
<base href="<%=basePath%>">
 <title>合同信息输入</title>
 <base href="<%=basePath%>">
  <LINK href="style/main_table.css" type=text/css rel=stylesheet>
  <script language="JavaScript" src="js/commUtil.js" ></script>
  <script language="JavaScript" src="js/jquery.js"></script>	
</head>

<LINK href="../style/main_table.css" type=text/css rel=stylesheet>
<link href="../style/aa.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../js/aa.js" type="text/JavaScript"></script>
<title>合同信息输入</title>
<script language="JavaScript" type="text/JavaScript">
function calCtrlPopup(inputField) {
	showCalendar(inputField.name, 'y-mm-dd');
}
</SCRIPT>
<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>
<body>
      <form name="form1" method="post" action="">
        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="6"><img src="../images/main_01.gif" width="6" height="6"></td>
          <td width="981" bgcolor="#A3A3A3"><img src="../images/main_02.gif" width="560" height="6"></td>
          <td width="10"><img src="../images/main_03.gif" width="6" height="6"></td>
        </tr>
        <tr bgcolor="#F0F0F0">
          <td colspan="3" background="../images/bg.gif" bgcolor="#F0F0F0" class="TABLE"><table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
              <tr>
                <td background="../images/main_title_bg1.gif"><table width="100%"  border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td width="1%"><img src="../images/dot9.gif" width="14" height="14"></td>
                    <td width="99%">合同信息输入</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td width="50%" class="TABLE5"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="14%" height="20" align="right" class="TD1">基站名称：</td>
                        <td width="22%" class="TD2">&nbsp;</td>
                        <td width="12%" align="right" class="TD2">面&nbsp;&nbsp;&nbsp;&nbsp;积：</td>
                        <td width="19%" class="TD2">&nbsp;</td>
                        <td width="11%" align="right" class="TD2">类型：</td>
                        <td width="22%" class="TD3">宏基站</td>
                      </tr>
                      <tr>
                        <td height="20" align="right" class="TD1">期&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        <td class="TD2">&nbsp;</td>
                        <td align="right" class="TD2">区&nbsp;&nbsp;域：</td>
                        <td class="TD2">&nbsp;</td>
                        <td align="right" class="TD2">区&nbsp;&nbsp;&nbsp;&nbsp;镇：</td>
                        <td class="TD3">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="20" align="right" class="TD1">业主电话：</td>
                        <td class="TD2">&nbsp;</td>
                        <td align="right" class="TD2">地&nbsp;&nbsp;址：</td>
                        <td colspan="3" class="TD3">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td class="TABLE5"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="14%" height="20" align="right" class="TD1">合同号：</td>
                    <td width="21%" class="TD2"><input name="textfield12" type="text" class="input">
                    <span class="style1">*</span></td>
                    <td width="16%" align="right" class="TD2">合同有效期限：</td>
                    <td width="49%" class="TD3">从 
                      <input name="parameter4" type="text" class="input" size="10" styleClass="input">
                      <img  style="cursor:hand;" onClick="calCtrlPopup(parameter4)" TITLE="日期选择" NAME="anchor17" ID="anchor17" src="../images/vbeditor.gif" width="16" height="16" >                      到
                      <input name="parameter5" type="text" class="input" size="10">
                      <img  style="cursor:hand;" onClick="calCtrlPopup(parameter5)" TITLE="日期选择" NAME="anchor17" ID="anchor17" src="../images/vbeditor.gif" width="16" height="16" ><span class="TD2"><span class="style1"> *</span></span></td>
                  </tr>
                  <tr>
                    <td height="20" align="right" class="TD1">甲&nbsp;&nbsp;方：</td>
                    <td class="TD2"><input name="textfield13" type="text" class="input">
                    <span class="style1">*</span></td>
                    <td align="right" class="TD2">合同经办人：</td>
                    <td class="TD3"><input name="textfield14" type="text" class="input">
                    <span class="TD2"><span class="style1">*</span></span></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td class="TABLE5"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr align="center">
                    <td height="20" colspan="2" class="TD_title1">租金明细</td>
                    <td colspan="2" class="TD_title3">电费明细</td>
                  </tr>
                  <tr>
                    <td width="16%" height="20" align="right" class="TD1">年　 租&nbsp;&nbsp;&nbsp;金：</td>
                    <td width="30%" class="TD2"><input name="textfield2" type="text" class="input">
                    <span class="style1">*</span></td>
                    <td width="24%" align="right" class="TD2">供电电话：</td>
                    <td width="30%" class="TD3"><input name="textfield3" type="text" class="input"></td>
                  </tr>
                  <tr>
                    <td height="20" align="right" class="TD1">租金付款周期：</td>
                    <td class="TD2"><input name="textfield4" type="text" class="input">
                    <span class="style1">*</span></td>
                    <td align="right" class="TD2">报电类别：</td>
                    <td class="TD3"><select name="select">
                    </select></td>
                  </tr>
                  <tr>
                    <td height="20" align="right" class="TD1">&nbsp;</td>
                    <td class="TD2">&nbsp;</td>
                    <td align="right" class="TD2">电表户号及抄表号：</td>
                    <td class="TD3"><input name="textfield8" type="text" class="input"></td>
                  </tr>
                  <tr>
                    <td height="20" align="right" class="TD1">&nbsp;</td>
                    <td class="TD2">&nbsp;</td>
                    <td align="right" class="TD2">&nbsp;</td>
                    <td class="TD3">&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td class="TABLE5"><table width="100%"  border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td width="14%" align="right" valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
                    <td width="86%"><textarea name="textfield" cols="60" rows="6"></textarea></td>
                  </tr>
                  <tr align="center">
                    <td colspan="2"><table  border="0" cellspacing="1" cellpadding="1">
                      <tr align="center">
                        <td><img src="../images/submit.gif" width="43" height="18" style="cursor:hand ;"></td>
                        <td><img src="../images/reset.gif" width="43" height="18" style="cursor:hand ;"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td><img src="../images/main_05.gif" width="6" height="6"></td>
          <td bgcolor="#A3A3A3"><img src="../images/main_06.gif" width="560" height="6"></td>
          <td><img src="../images/main_07.gif" width="6" height="6"></td>
        </tr>
      </table>
      </form>
</body>
</html>
