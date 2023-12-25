package himedia.project.studybite.interceptor;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import himedia.project.studybite.domain.Notification;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 요청때 마다 알림을 갱신하기 위한 인터셉터
 * 
 * @author 이지홍
 */
@RequiredArgsConstructor
@Slf4j
public class NotificationInterceptor implements HandlerInterceptor {
	private final NotificationService notificationService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		Optional<User> user = Optional.ofNullable((User)(session.getAttribute("user")));
		List<Notification> notifications = notificationService.getNotification(user.get().getUserId());
		
		session.setAttribute("notifications", notifications);
		log.info("알림 인터셉터" + notifications.get(1).getUserId());
		return true;
	}
}
