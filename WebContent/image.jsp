<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Image Gallery</title>
</head>
<body>

	
	<div ng-app="app" ng-controller="appController"">
		<ul >
			<li>{{ test }}</li>
		</ul>
	</div>
	
	<!--  
		<a class="backButton" href="<%= request.getAttribute("whatTheHell") %>">Download</a>
	-->
<script>
var app = angular.module('app', []);

app.controller('appController', function($scope, $http) {
   	$scope.test = "qhbcehqbc";
   	$http.get("/cloudinaryAssignment/all").then(function(response){
   		console.log(response);
   	});
});
</script>
</body>
</html>