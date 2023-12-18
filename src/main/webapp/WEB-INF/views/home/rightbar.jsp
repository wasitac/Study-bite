<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="d-flex flex-column flex-shrink-0 p-3 position-fixed top-0 end-0 vh-100 border-start w-100" style="max-width: 400px;">
	<div class="dropdown d-flex align-items-center" style="height: 100px;">
		<img src="resources/img/bellIcon.png" alt="" width="32" height="32" class="rounded-circle ms-3 me-auto "> <a href="#"
			class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle ms-auto me-3" data-bs-toggle="dropdown" aria-expanded="false"> <img src="resources/img/userIcon.png" alt=""
			width="32" height="32" class="rounded-circle me-2"> <strong>userName</strong>
		</a>
		<ul class="dropdown-menu text-small shadow">
			<li><a class="dropdown-item" href="#">로그아웃</a></li>
		</ul>
	</div>
	<hr class="mt-0 mx-0">
	<div class="mt-3">
		<p style="color: #2563eb;">Reminders</p>
	</div>
	<ul class="nav nav-pills flex-column mb-auto">
		<li class="nav-item mb-3">
			<div class="card mb-3 border-0" style="max-width: 540px; background-color: #eff4ff;">
				<div class="row g-0">
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">공지사항 제목</h5>
							<p class="card-text">
								<small class="text-body-secondary">자료구조</small>
							</p>
						</div>
					</div>
					<div class="col-md-4 mt-3"></div>
				</div>
			</div>
		</li>
	</ul>
</div>