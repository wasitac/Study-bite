package himedia.project.studybite.interceptor;

import java.io.File;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import himedia.project.studybite.domain.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 모든 요청마다 로그인 여부를 확인하기 위한 인터셉터입니다. 로그인 세션이 없으면 로그인 화면으로 이동하게 만듭니다. session을 파기한
 * 후의 요청에 값이 안들어있는 session이 생겨있습니다. 그래서 attribute의 값이 없을 때를 로그인 되어있지 않은 상태로
 * 판별했습니다.
 * @author 이지홍
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		
		Optional<User> user = Optional.empty();
		if (session != null)
			user = Optional.ofNullable((User) (session.getAttribute("user")));

		if (user.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}
}