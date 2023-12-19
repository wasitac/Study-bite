package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Notice {
	private Long notice_id;
	private String title;
	private String description;
	private Integer views;
}
