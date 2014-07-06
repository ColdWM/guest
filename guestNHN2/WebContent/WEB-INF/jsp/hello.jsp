<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.ArrayList,dto.Guest,java.util.HashMap"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head ng-app>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest book to Suchan</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">
	 <script src="http://code.angularjs.org/angular-1.0.0rc10.min.js"></script>

</head>
<body>
<input type="text" ng-model="yourName">
	      <p>안녕하세요, {{yourName}} !!!</p>
<center>
${message}<br>

<form action="save.nhn" name="guestInsertform" method="post">
<div id="legend">
      <legend class="">방명록 ^_^</legend>
    </div>

		<div class="control-group">
				<!-- Email -->
				<label class="control-label" for="username">E mail</label>
				<div class="controls">
					<input type="email" id="email" name="guestE" ng-model="text" required class="input-xlarge">
					<span class ="error" ng-show = "guestInsertform.guestE.$error.email">Not Valid email!!!!</span>
					<tt>guestInsertform.$error.email = {{!!guestInsertform.$error.email}}</tt><br/>
				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" id="password" name="guestPA" placeholder="password"
						class="input-xlarge">
				</div>
			</div>
		<br>
		<textarea class="span8" rows="8" id="guestText" name="guestText" placeholder="내용을 입력하세요."></textarea><br>
		<input type= "submit" role="button" class="btn btn-inverse" value="방명록쓰기"></td>
						
</form>
	<c:forEach items="${requestScope.guestList}" var="guest">
		<div class="well">
		${guest.guestE}&nbsp;&nbsp;&nbsp;${guest.guestDate}<a href="updateMove.nhn?guestId=${guest.guestId}">수정하기</a><br>
		<textarea class="span8" rows="8" readonly="readonly">${guest.guestText}</textarea></div>
		
		
	</c:forEach>
			
			</center>
			<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
	</script>
			
</body>
</html>