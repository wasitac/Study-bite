package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.User;
import himedia.project.studybite.domain.UserLogin;

@Repository
public interface UserRepository {
	//컬럼명하고 도메인 필드명이 달라서 자동으로 연결이 안되는것 같음
	// 로그인
	@Select ("select * from user where email like #{email} and password like #{password}")
	Optional<User> login(UserLogin userLogin);
	
	// id로 유저 찾기
	@Select ("select * from user where user_id = #{user_id}")
	Optional<User> findUserById(Long user_id);
	
	// 비밀번호 확인
	@Select("select user_id from user where user_id = #userId and password = password")
	UserLogin checkPassword(Long userId, String password);
	
	// 비밀번호 변경
	@Update("update user set password=#{password}, where user_id=#{userId}")
	void updatePassword(Long userId, String password);
}
