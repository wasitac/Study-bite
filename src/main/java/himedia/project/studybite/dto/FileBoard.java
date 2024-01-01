package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * FileBoard 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
@NoArgsConstructor
public class FileBoard {
	private Long id;
	private String filename;
	private String originName;
	private String filepath;
	private String filetype;
	private Long qnaId;
	private Long newsId;
}
