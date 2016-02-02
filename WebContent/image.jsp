<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<head>
<style>
	body{
		background-image:url("http://res.cloudinary.com/zihaow/image/upload/v1454386586/newPhoto_voytug.jpg");
		background-size:cover;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Image Gallery</title>
</head>
<body style="margin: 0;">
	<div ng-app="app" ng-controller="appController"">
		<ul ng-repeat="(key, value) in photoes" style="margin: 0;padding: 0;">
			<li ng-repeat="photo in value" style="display: inline-block;width:50%;">
				<img src="{{ photo.secure_url }}" style="width: 100%;height: 100%;">
			</li>
		</ul>
	</div>
<script>
	var app = angular.module('app', []);
	app.controller('appController', function($scope, $http) {
   		$scope.test = "qhbcehqbc";
   		$http.get("/cloudinaryAssignment/all").then(function(response){
   			$scope.photoes = response.data;
   		});
	});
</script>
</body>
</html>