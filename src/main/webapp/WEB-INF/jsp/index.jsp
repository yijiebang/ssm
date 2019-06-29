<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--^^^^^添加对jstl列表的支持^^^^^--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>listBooks</title>
</head>
<body>
	<form>
		<table align="center" bgcolor="paleturquoise" border="1" cellpadding="0">
		<caption>查询列表/修改/删除</caption>
			<tr>
				<th width="140">姓名</th>
				<th width="140">年龄</th>
				<th width="140">手机号</th>
				<th width="140">邮箱</th>
				<th width="140">修改</th>
				<th width="140">删除</th>
				<th width="140">下载</th>
			</tr>
			<c:forEach items="${bb}" var="b">
				<%--varStatus="ct"--%>
				<tr>
					<td>${b.username}</td>
					<td>${b.age}</td>
					<td>${b.phone}</td>
					<td>${b.email}</td>
					 
					
					<td><a
						href="${pageContext.request.contextPath}/user/updatepage/${b.id}">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath}/user/deleteUsersByBid?id=${b.id}"
						onclick='return confirm("确认要删除吗?")'>删除</a></td>
						<td><a
						href="${pageContext.request.contextPath}/user/downPhotoById/?fpath=${b.email}">下载</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<form id="add"
		action="${pageContext.request.contextPath}/user/addUsers" method="post">
		<table align="center" bgcolor="paleturquoise" border="1" cellpadding="0">
			<caption>新增</caption>
			<tr>
				<th width="140">姓名</th>
				<th width="140">年龄</th>
				<th width="140">手机号</th>
				<th width="140">邮箱</th>

			</tr>
			<tr>
				<td width="140"><input type="text" value="${users.username}"
					name="username" /></td>
				<td width="140"><input type="text" value="${users.age}"
					name="age" /></td>
				<td width="140"><input type="text" value="${users.phone}"
					name="phone" /></td>
					<td width="140"><input type="text" value="${users.email}"
					name="email" /></td>
				<td width="140"><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>
 
 	<form id="FileOut"
		action="${pageContext.request.contextPath}/user/savePicture" method="post" enctype="multipart/form-data">
		<table align="center" bgcolor="paleturquoise" border="1" cellpadding="0">
			<caption>文件上传</caption>
			<tr>
				 
					<td width="140"><input type="file"  name="image" /></td>
				   <td width="140"><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>

	<form id="export"
		  action="${pageContext.request.contextPath}/user/exportExcel" method="post">
		<table align="center" bgcolor="paleturquoise" border="1" cellpadding="0">
			<caption>easypoi从数据库导出excel</caption>
			<tr>
 				<td width="140"><input type="submit" value="导出" /></td>
			</tr>
		</table>
	</form>
	<form id="importExcel"
		  action="${pageContext.request.contextPath}/user/importExcel" method="post" enctype="multipart/form-data">

		<table align="center" bgcolor="paleturquoise" border="1" cellpadding="0">
			<caption>easypoi导入excel到数据库</caption>
			<tr><td><input type="file" name="textFile"/></td></tr>
			<tr>
				<td width="140"><input type="submit" value="导入" /></td>
			</tr>
		</table>
	</form>
 
</body>
</html>