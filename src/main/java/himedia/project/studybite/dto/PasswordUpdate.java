package himedia.project.studybite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 비밀번호 변경 기능에서 사용하는 dto입니다.
 * @author 이지홍
 */
<<<<<<< Updated upstream
@Setter
@Getter
=======
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> Stashed changes
public class PasswordUpdate {
	private Long userId;
	private String password;
	private String newPassword;
}
