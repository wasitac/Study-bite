package himedia.project.studybite.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import himedia.project.studybite.domain.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 모든 요청마다 로그인 여부를 확인하기 위한 인터셉터입니다.
 * 
 * @author 이지홍
 *
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		Optional<User> user = Optional.ofNullable((User)(session.getAttribute("user")));
		/**
		 * 로그인 세션이 없으면 로그인 화면으로 이동하게 만듭니다. session을 파기한 후의 요청에 값이 안들어있는 session이 생겨있습니다.
		 * 그래서 attribute의 값이 없을 때를 로그인 되어있지 않은 상태로 판별했습니다.
		 * 
		 * @author 이지홍
		 */
		if (user.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

		log.info("preHandler: userId >>" + user.get().getRole());
		return true;
	}

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//
//	}
}
