<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--^^^^^添加对jstl列表的支持^^^^^--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>listBooks</title>
</head>
<body>
	 
	
	<form id="updateForm" action="${pageContext.request.contextPath}/user/update" method="post">
    <input type="hidden" value="${users.id}" name="id"/>
    <table  align="center" bgcolor="aqua" border="1" cellpadding="0">
      <tr>
            <td>姓名：</td>
            <td><input type="text" value="${users.username}" name="username"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" value="${users.age}" name="age"/></td>
        </tr>
        <tr>
            <td>手机：</td>
            <td><input type="text" value="${users.phone}" name="phone"/></td>
        </tr>
        <tr>
            <td>email：</td>
            <td><input type="text" value="${users.email}" name="email"/></td>
        </tr>
        <tr>
            <td>pwd：</td>
            <td><input type="text" value="${users.pwd}" name="pwd"/></td>
        </tr>
       <tr><td width="140" colspan="2"><input type="submit" value="更新" /></td></tr>
    </table>
  </form>
</body>
</html>