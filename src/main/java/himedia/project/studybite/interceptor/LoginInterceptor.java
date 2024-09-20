package himedia.project.studybite.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import himedia.project.studybite.dto.User;

/**
 * 저장된 유저정보가 없으면 로그인 화면으로 이동
 * @author 이지홍
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
        // 정적 리소스 경로에 대해 세션 검사 생략
        if (uri.startsWith("/studybite/resources/")) {
            return true; // 세션 검사 생략하고 다음 필터로 진행
        }
		HttpSession session = request.getSession();
		Optional<User> user = Optional.ofNullable((User)(session.getAttribute("user")));

		if (user.isPresent())
			return true;
		
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}
}