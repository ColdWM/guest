<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.ArrayList,dto.Guest,java.util.HashMap"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
${message}
<table border="1">

	<c:forEach items="${requestScope.guestList}" var="guest">
				<tr>
					<td>${guest.guestE}</td>
					<td>
						${guest.guestText}
						
					</td>
					<td>${guest.guestDate}</td>
				</tr>		
			</c:forEach>
			
			</table>
			</center>
</body>
</html>