package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Course {
	private Long courseId;
	private String sort;
	private String courseName;
	private String outline;
	private String instructor;
}
