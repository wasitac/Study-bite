package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Content 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
@NoArgsConstructor
public class Content {
	private Long contentId;
	private Long courseId;
	private String contentName;
}