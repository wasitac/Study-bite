package himedia.project.studybite.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import himedia.project.studybite.domain.Notification;

/**
 * @author 이지홍
 */
public interface NotificationRepository {
	// 알림 조회
	@Select("select * from notification where userId = #{userId} order by notificationId desc")
	List<Notification> findNotification(Long userId);

	// 알림 확인 시 삭제
	@Delete("delete from notification where notificationId = #{notificationId}")
	void deleteNotification(Long notificationId);

	// 알림 전송
	@Insert("insert into notification(userId, courseId, id, category, title) values(#{userId}, #{courseId}, #{id}, #{category}, #{title})")
	@Options(useGeneratedKeys = true, keyProperty = "notificationId")
	void addNotification(Notification notification);
}