package himedia.project.studybite.domain;

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
public class User {
	private Long userId;
	private Integer role;
	private String userName;
	private String password;
	private String email;
	private String phone;
}