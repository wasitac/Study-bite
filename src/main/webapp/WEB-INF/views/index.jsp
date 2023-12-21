<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">
<%@ include file="./common/config.jsp"%>
    <title>로그인</title>
    <link href="${resPath}/css/sign-in.css" rel="stylesheet">
  </head>
  <body class="d-flex align-items-center justify-content-center py-4 bg-blue50">
	  <form action="${context}" method="post">
	    <img class="mb-4 cropping" src="${resPath}/img/logoSmall.png" alt="studybite" width="300">
	    <div class="form-floating">
	    	<input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com">
	    	<label for="floatingInput">Email address</label>
	    </div>
	    <div class="form-floating">
	    	<input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
	    	<label for="floatingPassword">Password</label>
	    </div>
		<div class="text-center">
	  		<button class="btn btn-primary w-50 py-2" type="submit">로그인</button>
		</div>
		<div class="text-center">
			<a href="#">비밀번호를 찾기</a>
		</div>
	  </form>
    </body>
</html>
