package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Content {
	private Long contentId;
	private Long courseId;
	private String instructor;
	private String contentName;
	private String contentData;
}
