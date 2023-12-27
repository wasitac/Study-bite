package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * qna 테이블의 DAO
 * @author 김민혜
 */
@Setter @Getter
public class Qna {
	private Long qnaId;
	private Long courseId;
	private Long qnaNum;
	private String userName;
	private String title;
	private String description;
	private Integer views;
	private Date date;
	private String answer;
}