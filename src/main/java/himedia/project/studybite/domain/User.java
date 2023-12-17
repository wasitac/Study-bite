package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long userId;
//	현재 erd에 password 없음
//	private String password;
	private String userCategory;
	private String userName;
	private String email;
	private String phone;
}
