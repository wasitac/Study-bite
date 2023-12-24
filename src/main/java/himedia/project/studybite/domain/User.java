package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {
	private Long userId;
	private String userCategory;
	private String userName;
	private String password;
	private String email;
	private String phone;
}
