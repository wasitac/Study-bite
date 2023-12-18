<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko" data-bs-theme="auto">
    <title>로그인</title>
	<%@ include file="./common/url.jsp"%>
	<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resPath}/css/sign-in.css" rel="stylesheet">
  </head>
  <body class="d-flex align-items-center py-4 bg-body-tertiary">
	<main class="form-signin w-100 m-auto">
	  <form action="${context}" method="post">
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
