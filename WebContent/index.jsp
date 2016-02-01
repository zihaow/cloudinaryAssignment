<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Awesome Mike</title>
<style>
	.backButton:hover{
		color:#fff !important;
		background-color:#000;
		-webkit-transition: 0.5s; 
    	transition: 0.5s;
	}
</style>
</head>
<body style="margin: 0;">
	<p style="font-family: sans-serif;margin: 0;font-size:19px;text-align: center;">Image was uploaded successfully.</p>
	<a class="backButton" href="index.html" style="border: 1px solid #000;border-radius: 3px;padding: 3px 10px;
    font-family: sans-serif;text-decoration: none;color:#000;position: relative;
    top: 10px;left: calc(50% - 142.5px);">Back</a>
    <a class="backButton" href="<%= request.getAttribute("whatTheHell") %>" style="border: 1px solid #000;border-radius: 3px;padding: 3px 10px;
    font-family: sans-serif;text-decoration: none;color:#000;position: relative;
    top: 10px;left: calc(50% - 108.5px);" download>Download</a>
    <a class="backButton" href="index.html" style="border: 1px solid #000;border-radius: 3px;padding: 3px 10px;
    font-family: sans-serif;text-decoration: none;color:#000;position: relative;
    top: 10px;left: calc(50% - 81.5px);">Delete</a>
    <img style="position: relative;top: 20px;left: 0;width:100%;height:100%;"src="<%= request.getAttribute("whatTheHell") %>">
     
</body>
</html>

<cl:jsinclude/>
<cl:jsconfig/>