package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;
/**
 * FileBoard 테이블의 DAO
 * @author 신지은
 */
@Setter @Getter
public class FileBoard {
	private int category;
	private Long id;
	private String filename;
	private String filepath;

}
