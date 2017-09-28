<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td height="260"><tiles:insertAttribute name="menu" /></td>
			<td width="360"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>