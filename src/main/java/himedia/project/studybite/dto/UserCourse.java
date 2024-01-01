package himedia.project.studybite.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 송창민
 */

@Setter @Getter
@NoArgsConstructor
public class UserCourse {
	private Long userId;
	private Long courseId;
	private Long contentId;
	private Date date;
}