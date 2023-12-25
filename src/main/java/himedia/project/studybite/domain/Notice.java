package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Notice {
	private Long noticeId;
	private String title;
	private String description;
	private Integer views;
	private Date date;
}