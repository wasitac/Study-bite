package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Course테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
@NoArgsConstructor
public class Course {
	private Long courseId;
	private String sort;
	private String courseName;
	private String outline;
	private String instructor;
	private String thumbnail;

}