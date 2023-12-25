package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 로그인 시 session에 저장되는 유저 정보입니다.
 * 비밀번호는 가져오지 않고 비밀번호가 필요한 작업은 따로 dto를 만들어 사용했습니다.
 * @author 이지홍
 *
 */
@Setter @Getter
public class User {
	private Long userId;
	private String role;
	private String userName;
	private String email;
	private String phone;
}
