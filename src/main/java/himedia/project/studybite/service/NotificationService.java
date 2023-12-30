package himedia.project.studybite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Notification;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;

/**
 * notificationInterceptor에서 주입받아 사용하는 service
 * @author 이지홍
 */
@Service
@RequiredArgsConstructor
public class NotificationService {
	private final NotificationMapper notificationMapper;

	public List<Notification> getNotifications(User user) {
		Long userId = user.getUserId();
		return notificationMapper.findNotifications(userId);
	}

	public void sendNotification(Notification notification) {
		notificationMapper.addQnaNotification(notification);
	}

	public void sendNotification(List<Notification> notifications) {
		notificationMapper.addNewsNotification(notifications);
	}

	public void readNotification(Long notificationId) {
		notificationMapper.deleteNotification(notificationId);
	} 
	
	public String getNotification(Long notificationId) {
		Notification n = notificationMapper.findNotificationById(notificationId);
		Integer category = n.getCategory();
		Long courseId = n.getCourseId();
		String path = "";
		
		if(category == 3)
			path = "/course/" + courseId + "/qna/" + n.getQnaId();
		else if(category == 2)
			path = "/course/" + courseId + "/news/" + n.getNewsId();
		else
			path = "/notice/" + n.getNoticeId();
		
		return path;
	}
}