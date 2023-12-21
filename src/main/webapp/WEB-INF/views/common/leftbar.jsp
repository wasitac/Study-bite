<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./url.jsp"%>

<div class="d-flex flex-column flex-shrink-0 position-fixed top-0 start-0 vh-100 bg-body-tertiary w-25" style="max-width:280px;" id="leftbarContainer">
    <a href="/studybite/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
      <img class="w-100 p-3" src="${resPath}/img/logoSmall.png" alt="studybite">
    </a>
    <hr>
   <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="/studybite/home" class="nav-link link-body-emphasis">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
          대시보드
        </a>
      </li>
      <li class="nav-item">
        <a href="/studybite/course" class="nav-link link-body-emphasis">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
          수강과목
        </a>
      </li>
      <li class="nav-item">
        <a href="/studybite/mypage" class="nav-link link-body-emphasis">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
          내 정보
        </a>
      </li>
      <li class="nav-item">
        <a href="/studybite/notice" class="nav-link link-body-emphasis">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
          공지사항
        </a>
      </li>
    </ul>
  </div>
<script type="text/javascript" src="/studybite/resources/js/basic.js"></script>