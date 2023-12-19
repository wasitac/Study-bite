package himedia.project.studybite.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {
	private Long user_id;
	private String user_category;
	private String user_name;
	private String email;
	private String phone;
}
