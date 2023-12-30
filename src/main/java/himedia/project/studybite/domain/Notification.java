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
	private Long qnaId;
	private Long newsId;
	private Long noticeId;
	// 1: notice, 2: news, 3: qna
	private Integer category;
	private String title;
	
	public Notification(Long userId, Long courseId, Long descId, Integer category, String title) {
		this.userId = userId;
		this.courseId = courseId;
		this.category = category;
		this.title = title;
		
		if (category == 3)
			this.qnaId = descId;
		else if (category == 2)
			this.newsId = descId;
		else
			this.noticeId = descId;
	}
	
}