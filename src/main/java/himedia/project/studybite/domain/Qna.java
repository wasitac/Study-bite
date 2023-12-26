package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Qna {
	private Long qnaId;
	private Long courseId;
	private String userName;
	private String title;
	private String description;
	private Integer views;
	private Date date;
	private String answer;
}