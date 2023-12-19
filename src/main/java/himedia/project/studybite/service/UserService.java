package himedia.project.studybite.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.User;
import himedia.project.studybite.domain.UserLogin;
import himedia.project.studybite.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// 로그인
	public Optional<User> login(UserLogin userLogin) {
		Optional<User> user = userRepository.login(userLogin);
//		log.info(user.get().getUser_name());
		if(user.isEmpty()) {
			log.info("userService >> null");
			return null;
			}
		return user;
	}
	public Optional<User> isLogin(Long user_id){
		Optional<User> user = userRepository.findUserById(user_id);
		return user;
	}
	// 비밀번호 체크
	public void checkPassword(Long userId, String password) {
		userRepository.checkPassword(userId, password);
	}
	
	// 비밀번호 변경
	public void updatePassword(Long userId, String newPassword) {
		userRepository.updatePassword(userId, newPassword);
	}
}
