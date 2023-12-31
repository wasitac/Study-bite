package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 이지홍
 */
@Setter
@Getter
public class PasswordUpdate {
	private Long userId;
	private String password;
	private String newPassword;
}
