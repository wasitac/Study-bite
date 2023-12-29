package himedia.project.studybite.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Notification;

/**
 * @author 이지홍
 */
@Repository
public interface NotificationMapper {

	// 알림목록 조회
	@Select("select * from notification where userId = #{userId} order by notificationId desc")
	List<Notification> findNotifications(Long userId);

	// 특정 알림 찾기
	@Select("select * from notification where notificationId = #{notificationId}")
	Notification findNotificationById(Long notificationId);

	// 알림 확인 시 삭제
	@Delete("delete from notification where notificationId = #{notificationId}")
	void deleteNotification(Long notificationId);

	/**
	 * 알림 테이블에 알림을 삽입하는 메소드
	 * 전체 공지사항은 모든 유저에게 알림을 보내고, 강의 공지사항은 해당 과목을 수강하는 학생들에게 알림을 보낸다.
	 * 질의응답은 1대 1상호작용이므로 userId에 알림을 받을 유저의 아이디를 입력한다.
	 * (질문한다면 강사의 id가, 답변한다면 답변을 받는 학생의 id가 들어간다.)
	 * 
	 * @author 이지홍
	 */
	@Insert("insert into notification(userId, courseId, id, category, title) values(#{userId}, #{courseId}, #{id}, #{category}, #{title})")
	@Options(useGeneratedKeys = true, keyProperty = "notificationId")
	void addQnaNotification(Notification notification);
	
//	@Insert("insert into notification(userId, courseId, id, category, title)")
//	@Options(useGeneratedKeys = true, keyProperty = "notificationId")
	void addNewsNotification(List<Notification> notifications);
	
//	@Insert("insert into notification(userId, courseId, id, category, title) values(#{userId}, #{courseId}, #{id}, #{category}, #{title})")
//	@Options(useGeneratedKeys = true, keyProperty = "notificationId")
//	void addNoticeNotification(Notification notification);
	
}