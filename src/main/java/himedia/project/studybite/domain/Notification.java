package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 이지홍
 */
@Setter @Getter
public class Notification {
	private Long notificationId;
	private Long userId;
	private Long courseId;
	private Long id;
	// 1: notice, 2: news, 3: qna
	private Integer category;
	private String title;
	
	public Notification(Long userId, Long courseId, Long id, Integer category, String title) {
		this.userId = userId;
		this.courseId = courseId;
		this.id = id;
		this.category = category;
		this.title = title;
	}
	
}