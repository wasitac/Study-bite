package himedia.project.studybite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 이지홍
 */
@Setter @Getter
@NoArgsConstructor
public class UserLogin {
	private String email;
	private String password;
}
