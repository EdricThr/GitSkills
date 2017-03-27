<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改学生信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
<body>
	<form action="MyAction_updateStudent.action">
		<!-- 隐藏域，保存主键 -->
  		<s:hidden name="id"></s:hidden>
  
  		<table>
  			<tr>
  				<td>学生名：</td>
  				<td><s:textfield name="username"/></td>
  			</tr>
  			<tr>
  				<td>年龄：</td>
  				<td><s:textfield name="age"/></td>
  			</tr>
  			<tr>
  				<td>入学日期：</td>
  				 <td>
  				 	<s:textfield name="time" />
  				 </td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<s:submit value="修改"></s:submit>
  				</td>
  			</tr>
  		</table>
	</form>

</body>
</html>