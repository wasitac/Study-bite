package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 로그인, 비밀번호 변경시에만 비밀번호를 가져와서 사용하기 위해 비밀번호와 함께 사용하는 
 * 데이터만 모아서 도메인을 하나 생성했습니다 
 * @author 이지홍
 *
 */
@Getter
@Setter
public class UserLogin {
	private Long userId;
	private String email;
	private String password;
}
