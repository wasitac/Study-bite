package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Notice;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.UserLogin;
import himedia.project.studybite.repository.NoticeRepository;
import himedia.project.studybite.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private final UserRepository userRepository;
	private final NoticeRepository noticeRepository;
	
	public UserService(UserRepository userRepository, NoticeRepository noticeRepository) {
		this.userRepository = userRepository;
		this.noticeRepository = noticeRepository;
	}
	
	// 로그인
	public Optional<User> login(UserLogin userLogin) {
		Optional<User> user = userRepository.login(userLogin);
//		log.info(user.get().getUser_name());
		if(user.isEmpty()) {
			//log.info("userService >> null");
			return null;
			}
		return user;
	}
	
	public Optional<User> findUser(Long userId){
		Optional<User> user = userRepository.findUserById(userId);
		return user;
	}

	// 비밀번호 변경
	public void updatePassword(PasswordUpdate passwordUpdate) {
		if(userRepository.checkPassword(passwordUpdate).isEmpty()) {
			log.info("false");
			
			//return false;
		}
		userRepository.updatePassword(passwordUpdate);
		log.info("true");
	}
	
	// 공지사항
	public List<Notice> findPage(int page) {
		return noticeRepository.findPage(page);
	}
	
	// 공지사항 상세
	public Optional<Notice> findNoticeDesc(Long noticeId) {
		return noticeRepository.findNoticeDesc(noticeId);
	}
	
	// 이전글
	public Notice prev(Long noticeId) {
		return noticeRepository.prev(noticeId);
	}
	
	// 다음글
	public Notice next(Long noticeId) {
		return noticeRepository.next(noticeId);
	}
	
	// 조회수
	public Long viewcnt(Long noticeId) {
		return noticeRepository.viewcnt(noticeId);
	}
}
