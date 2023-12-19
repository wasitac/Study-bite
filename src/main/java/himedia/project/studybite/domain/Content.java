package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Content {
	private Long content_id;
	private Long course_id;
	private String instructor;
	private String content_name;
	private String content_data;
}
