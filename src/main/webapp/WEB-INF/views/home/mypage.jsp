<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>
<body class="container" style="margin: 0; padding: 0;">
	<div class="row">
		<div class="col ">
			<%@ include file="../common/leftbar.jsp"%>
		</div>
		<div class="col">
			<h3>송창민</h3>
			<label>E-mail</label>
		</div>
		<div class="col">
			<%@ include file="../common/rightbar.jsp"%>
		</div>
	</div>
</body>
</html>