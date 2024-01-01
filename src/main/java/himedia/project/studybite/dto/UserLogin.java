package himedia.project.studybite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로그인시에만 비밀번호를 가져와서 사용하기 위해 따로 만든 dto입니다. 
 * @author 이지홍
 */
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
	private String email;
	private String password;
}
