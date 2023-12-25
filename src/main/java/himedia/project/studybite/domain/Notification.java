package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Notification {
	private Long notificationId;
	private Long userId;
	private int category;
	private String title;
	private Long courseId;
	private Long id;
	private int isChecked;
}
