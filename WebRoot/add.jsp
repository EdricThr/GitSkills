<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<s:form action="MyAction_addStudent.action" method="post">
  		
  		<table>
  			<tr>
  				<td>学生姓名：</td>
  				<td><s:textfield name="username" /></td>
  			</tr>
  			<tr>
  				<td>年龄：</td>
  				<td><s:textfield name="age" /></td>
  			</tr>
  			<tr>
  				<td>入学日期：</td>
  				<td><s:textfield name="time" /></td>
  			</tr>
  			<tr>
  				<td>爱好：</td>
  				<td><s:textfield name="habit[0]" /></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<s:submit value="添加"></s:submit>
  				</td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>
