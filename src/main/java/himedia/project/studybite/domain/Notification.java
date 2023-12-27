package himedia.project.studybite.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 이지홍
 */
@Setter @Getter
@AllArgsConstructor
public class Notification {
	private Long notificationId;
	private Long userId;
	private Long courseId;
	private Long id;
	private Integer category;
	private String title;
}