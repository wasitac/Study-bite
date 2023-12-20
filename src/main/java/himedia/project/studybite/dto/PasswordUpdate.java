package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordUpdate {
	private Long userId;
	private String password;
	private String newPassword;
}
