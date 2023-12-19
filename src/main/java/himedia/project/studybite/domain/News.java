package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class News {
	private Long news_id;
	private Long course_id;
	private String user_name;
	private String title;
	private String description;
	private Integer views;
}
