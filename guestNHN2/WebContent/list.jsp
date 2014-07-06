<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList,dto.Guest,java.util.HashMap"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
  <head>
    <script src="http://code.angularjs.org/angular-1.0.0rc10.min.js"></script>
  </head>
  <body>
      <input type="text" ng-model="yourName">
      <p>안녕하세요, {{yourName}} !!!</p>
  </body>
</html>