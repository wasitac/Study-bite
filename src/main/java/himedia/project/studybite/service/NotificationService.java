package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Notification;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;

/**
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
	
	public Optional<Notification> getNotification(Long notificationId) {
		return notificationMapper.findNotificationById(notificationId);
	}
	
	public String getPath(Notification notification) {
		Integer category = notification.getCategory();
		Long courseId = notification.getCourseId();
		String path = "";
		
		if(category == 3)
			path = "/course/" + courseId + "/qna/" + notification.getQnaId();
		else if(category == 2)
			path = "/course/" + courseId + "/news/" + notification.getNewsId();
		else
			path = "/notice/" + notification.getNoticeId();
		
		return path;
	}
}