package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserCourse {
	private Long userId;
	private Long contentId;
	private Date date;
}
