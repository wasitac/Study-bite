package himedia.project.studybite.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.studybite.domain.Notification;

public interface NotificationRepository {

	@Select("select * from notification where userId = #{userId} and isChecked = 1 order by notificationId desc")
	List<Notification> getNotification(Long userId);
	
	@Update("update notification set checked = 2 where notificationId = #{notificationId}")
	void checked(Long notificationId);
	
	@Insert("insert into notification values(#{notification.userId}, #{notification.category}, #{notification.courseId}, #{notification.id}, #{notification.isChecked});")
	@Options(useGeneratedKeys = true, keyProperty = "notificationId")
	void addNotification(Notification notification);
	
	@Select("select title from #{table} where '${table}Id' = #{id} #{course}")
	String getTitle(Long id, String table, String course);
}
