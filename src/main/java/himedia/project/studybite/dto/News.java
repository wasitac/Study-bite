package himedia.project.studybite.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 김민혜
 */
@Setter @Getter
@NoArgsConstructor
public class News {
	private Long newsId;
	private Long courseId;
	private String userName;
	private String title;
	private String description;
	private Integer views;
	private Date date;
}