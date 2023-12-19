package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Course {
	private Long course_id;
	private String sort;
	private String course_name;
	private String outline;
}
