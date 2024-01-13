package himedia.project.studybite.interceptor;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import himedia.project.studybite.dto.Notification;
import himedia.project.studybite.dto.User;
import himedia.project.studybite.service.NotificationService;

/**
 * 요청때 마다 알림을 갱신하기 위한 인터셉터
 * 
 * @author 이지홍
 */
public class NotificationInterceptor implements HandlerInterceptor {
	private final NotificationService notificationService;

	@Autowired
	public NotificationInterceptor(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		Optional<User> user = Optional.ofNullable((User) (session.getAttribute("user")));

		if (user.isPresent()) {
			List<Notification> notifications = notificationService.getNotifications(user.get());
			session.setAttribute("notifications", notifications);
		}
		return true;
	}
}