<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<head>
<style>
	body{
		background-image:url("http://res.cloudinary.com/zihaow/image/upload/v1454386586/newPhoto_voytug.jpg");
		background-size:cover;
	}
	
	.backButton:hover {
		color:#fff !important;
		background-color:#000;
		-webkit-transition: 0.5s; 
    	transition: 0.5s;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Image Gallery</title>
</head>
<body style="margin: 0;" ng-controller="appController"">

	<div style="position: fixed;top: 10px;left: calc(50% - 87.5px);cursor: pointer;">
		<a href="index.html" class="backButton" style="color: #000;text-decoration: none;font-family: sans-serif;font-weight: 100;border: 1px solid #000;padding: 3px 10px;border-radius: 3px;">Back to Upload Page</a>
	</div>
	<div>
		<ul ng-repeat="(key, value) in photoes" style="margin: 0;padding: 0;">
			<li ng-repeat="photo in value" style="display: inline-block;width:50%;">
				<img ng-click="showThisImage(photo.secure_url, photo.public_id)" src="{{ photo.secure_url }}" style="width: 100%;height: 100%;cursor:pointer;">
			</li>
		</ul>
	</div>
	
	<div class="popup" style="position:fixed;top:calc(50% - 275px);left:calc(50% - 450px);width:900px;height:550px;" ng-show="showPopUp">
		<img src="{{ zoomPhoto }}" style="width:100%;height: calc(100% - 30px);">
		<div class="options" style="position:absolute;width:100%;height:30px;bottom:0;left:0;">
			<a ng-click="deletePhoto()" style="cursor:pointer;background-color: #000;color: #ffffff;opacity: 0.7;width: 33.3%;position: absolute;height: 100%;left: 0;text-align: center;font-size: 20px;font-family: fantasy;">Delete</a>
			<a ng-href="{{ zoomPhoto }}" style="cursor:pointer;background-color: #000;color: #ffffff;opacity: 0.7;width: 33.3%;position: absolute;height: 100%;left: 33.3%;text-align: center;font-size: 20px;font-family: fantasy;" download>Download</a>
			<a ng-click="hidePopUp()" style="cursor:pointer;background-color: #000;color: #ffffff;opacity: 0.7;width: 33.3%;position: absolute;height: 100%;left: 66.7%;text-align: center;font-size: 20px;font-family: fantasy;">Exit</a>
		</div>
	</div>
<script>
	var app = angular.module('app', []);
	app.controller('appController', function($scope, $http, $location) {
		
		// get all images.
   		$http.get("/cloudinaryAssignment/all").then(function(response){
   			$scope.photoes = response.data;
   		});
   		
		var thisPhotoID;
   		$scope.showThisImage = function(url, id){
   			$scope.showPopUp = true;
   			$scope.zoomPhoto = url;
   			thisPhotoID = id;
   		};
   		
   		$scope.hidePopUp = function() {
   			$scope.showPopUp = false;
   		};
   		
   		$scope.deletePhoto = function() {
   			$http.delete("/cloudinaryAssignment/delete/"+thisPhotoID).then(function(response){
   				$scope.showPopUp = false
   				console.log(response.status);
   			});
   		};
	});
</script>
</body>
</html>