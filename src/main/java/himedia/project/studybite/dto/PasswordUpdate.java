package himedia.project.studybite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 이지홍
 */
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUpdate {
	private Long userId;
	private String password;
	private String newPassword;
}
