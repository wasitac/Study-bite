package himedia.project.studybite.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 김민혜
 */
@NoArgsConstructor
@Setter @Getter
public class Qna {
	private Long qnaId;
	private Long courseId;
	private Long userId;
	private String userName;
	private String title;
	private String description;
	private Integer views;
	private Date date;
	private String answer;
}