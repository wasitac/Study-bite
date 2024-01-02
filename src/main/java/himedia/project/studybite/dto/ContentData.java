package himedia.project.studybite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ContentData 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
@AllArgsConstructor
public class ContentData {
	private Long contentId ;
	private String contentUrl;
}