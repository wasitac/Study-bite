package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ContentData 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
@NoArgsConstructor
public class ContentData {
	private Long contentId ;
	private String contentUrl;
}