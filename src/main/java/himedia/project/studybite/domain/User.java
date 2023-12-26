package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;
/**
 * @author 이지홍
 */
@Setter @Getter
public class User {
	private Long userId;
	private String role;
	private String userName;
//	private String password;
	private String email;
	private String phone;
}