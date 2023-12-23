package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.User;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.UserLogin;

@Repository
public interface UserRepository {
	//컬럼명하고 도메인 필드명이 달라서 자동으로 연결이 안되는것 같음
	// 로그인
	@Select ("select * from user where email like #{email} and password like #{password}")
	Optional<User> login(UserLogin userLogin);
	
	// id로 유저 찾기
	@Select ("select * from user where userId = #{userId}")
	Optional<User> findUserById(Long userId);
	
	// 비밀번호 확인
	@Select("select userId from user where userId = #{userId} and password like #{password}")
	Optional<Long> checkPassword(PasswordUpdate passwordUpdate);
	
	// 비밀번호 변경
	@Update("update user set password=#{newPassword} where userId=#{userId}")
	void updatePassword(PasswordUpdate passwordUpdate);
}