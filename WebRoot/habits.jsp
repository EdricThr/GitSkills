<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生详细信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
		<!-- 隐藏域，保存主键 -->
		<s:hidden name="id"></s:hidden>
		<table>
			<tr>
				<td>学生名：</td>
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
				<td><s:textfield name="habit" /></td>
			</tr>
		</table>
</body>
</html>