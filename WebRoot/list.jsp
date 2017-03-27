<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>学生列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
</head>

<body>
	<input type="button" name="btnAdd" onclick="window.location.href='add.jsp'" id="btnAdd" value="添加学生" />
	<!-- <a href="javascript:window.location.href='add.jsp'">添加用户</a> -->
	<table border="1" align="center">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>学生名称</th>
			<th>年龄</th>
			<th>入学日期</th>
			<th>操作</th>
		</tr>
		<s:if test="#request.stuList != null">
			<s:iterator var="stu" value="#request.stuList" status="st">
				<tr>
					<td><s:property value="#st.count" /></td>
					<td><s:property value="#stu.id" /></td>
					<td><s:property value="#stu.username" /></td>
					<td><s:property value="#stu.age" /></td>
					<td><s:property value="#stu.time" /></td>
					<td>
						<s:a href="MyAction_goHabits.action?id=%{#stu.id}">查看爱好</s:a>
						<s:a href="MyAction_goUpdate.action?id=%{#stu.id}">修改</s:a>
						<s:a href="MyAction_deleteStudent.action?id=%{#stu.id}">删除</s:a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="6">对不起，没有你要显示的数据</td>
			</tr>
		</s:else>
	</table>
</body>
</html>
