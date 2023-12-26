package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;
/**
 * Content 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
public class Content {
	private Long contentId;
	private Long courseId;
	private String contentName;
}