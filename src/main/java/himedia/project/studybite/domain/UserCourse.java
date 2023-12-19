package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserCourse {
	private Long user_id;
	private Long content_id;
	private Date date;
}
