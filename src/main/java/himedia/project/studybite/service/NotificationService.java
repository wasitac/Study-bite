package himedia.project.studybite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Notification;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;

/**
 * notificationInterceptor에서 주입받아 사용하는 service
 * @author 이지홍
 */
@Service
@RequiredArgsConstructor
public class NotificationService {
	private final NotificationRepository notificationRepository;

	public List<Notification> getNotification(User user) {
		Long userId = user.getUserId();
		return notificationRepository.findNotification(userId);
	}

	public void sendNotification(Notification notification) {
		notificationRepository.addNotification(notification);
	}

	public void readNotification(Long notificationId) {
		notificationRepository.deleteNotification(notificationId);
	}
}