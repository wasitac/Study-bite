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

	public List<Notification> getNotifications(User user) {
		Long userId = user.getUserId();
		return notificationRepository.findNotifications(userId);
	}

	public void sendNotification(Notification notification) {
		notificationRepository.addQnaNotification(notification);
	}

	public void sendNotification(List<Notification> notifications) {
		notificationRepository.addNewsNotification(notifications);
	}

	public void readNotification(Long notificationId) {
		notificationRepository.deleteNotification(notificationId);
	} 
	
	public String getNotification(Long notificationId) {
		Notification n = notificationRepository.findNotificationById(notificationId);
		Integer category = n.getCategory();
		Long id = n.getId();
		Long courseId = n.getCourseId();
		String path = "";
		
		if(category == 3)
			path = "/course/" + courseId + "/qna/" + id;
		else if(category == 2)
			path = "/course/" + courseId + "/news/" + id;
		else
			path = "/notice/" + id;
		
		return path;
	}
}