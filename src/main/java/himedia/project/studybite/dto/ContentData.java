package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * ContentData 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
public class ContentData {
	private Long contentId ;
	private String contentDataName;
	private String contentPicture;
	private String contentUrl;
}