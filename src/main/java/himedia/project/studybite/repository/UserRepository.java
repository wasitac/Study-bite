package himedia.project.studybite.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRepository {
	
	// 로그인
	void login();
	// 비밀번호 변경
	@Update("update user set password=#{password}, where user_id=#{userId}")
	void updatePassword(Long userId, String password);
}
