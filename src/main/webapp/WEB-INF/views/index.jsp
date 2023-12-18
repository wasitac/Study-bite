<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko" data-bs-theme="auto">
  <head><script src="/docs/5.3/assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.118.2">
    <title>Signin Template · Bootstrap v5.3</title>
	<%@ include file="./common/url.jsp"%>
	<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${resPath}/css/sign-in.css" rel="stylesheet">
  </head>
  <body class="d-flex align-items-center py-4 bg-body-tertiary">
	<main class="form-signin w-100 m-auto">
	  <form action="">
	    <img class="mb-4 cropping" src="${resPath}/img/logo.png" alt="studybite" width="300">
	    <div class="form-floating">
	    	<input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
	    	<label for="floatingInput">Email address</label>
	    </div>
	    <div class="form-floating">
	    	<input type="password" class="form-control" id="floatingPassword" placeholder="Password">
	    	<label for="floatingPassword">Password</label>
	    </div>
		<div class="text-center">
	  		<button class="btn btn-primary w-50 py-2" type="submit">로그인</button>
		</div>
		<div class="text-center">
			<a href="/">비밀번호를 찾기</a>
		</div>
	  </form>
	</main>
    </body>
</html>
