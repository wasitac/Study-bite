package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;
/**
 * Course테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
public class Course {
	private Long courseId;
	private String sort;
	private String courseName;
	private String outline;
	private String instructor;
	private String thumbnail;

}