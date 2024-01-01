package himedia.project.studybite.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * UserCourse 테이블의 도메인입니다.
 * @author 송창민
 *
 */

@Setter @Getter
public class UserCourse {
	private Long userId;
	private Long courseId;
	private Long contentId;
	private Date date;
}