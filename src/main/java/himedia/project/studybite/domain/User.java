package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long userId;
	private String userCategory;
	private String userName;
	private String email;
	private String phone;
}
