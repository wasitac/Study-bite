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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	private final UserRepository userRepository;
	private final NoticeRepository noticeRepository;
	
	// 로그인
	public Optional<User> login(UserLogin userLogin) {
		Optional<User> user = userRepository.login(userLogin);
		return user;
	}
	
	public Optional<User> findUser(Long userId){
		Optional<User> user = userRepository.findUserById(userId);
		return user;
	}

	// 비밀번호 변경
	public Boolean updatePassword(PasswordUpdate passwordUpdate) {
		// 유저가 입력한 현재 비밀번호가 일치하면 유저아이디를 리턴, 비밀번호를 변경합니다
		if(userRepository.checkPassword(passwordUpdate).isEmpty()) 
			return false;
		
		userRepository.updatePassword(passwordUpdate);
		return true;
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
	
	// 공지사항 총 개수
	public int cntNotice() {
		return noticeRepository.cntNotice();
	}
}