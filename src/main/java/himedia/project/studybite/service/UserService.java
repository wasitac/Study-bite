package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * 로그인
	 * @author 이지홍
	 */
	public Optional<User> login(UserLogin userLogin) {
		Optional<User> user = userRepository.login(userLogin);
		return user;
	}
	
	public Optional<User> findUser(Long userId){
		Optional<User> user = userRepository.findUserById(userId);
		return user;
	}
	/**
	 * 비밀번호 변경
	 * @author 이지홍
	 */
	public Boolean updatePassword(PasswordUpdate passwordUpdate) {
		// 유저가 입력한 현재 비밀번호가 일치하면 유저아이디를 리턴, 비밀번호를 변경합니다
		if(userRepository.checkPassword(passwordUpdate).isEmpty()) 
			return false;
		
		userRepository.updatePassword(passwordUpdate);
		return true;
	}
	
		/**
	 * 공지사항 목록
	 * @author 김민혜
	 */
	public List<Notice> findPage(Integer pageNum) {
		return noticeRepository.findPage(pageNum);
	}
		
	/**
	 * 공지사항 상세
	 * @author 김민혜
	 */
	public Optional<Notice> findNoticeDesc(Long noticeId) {
		return noticeRepository.findNoticeDesc(noticeId);
	}
	
	/**
	 * 이전글 표시 및 이동
	 * @author 김민혜
	 */
	public Notice prev(Long noticeId) {
		return noticeRepository.prev(noticeId);
	}
	
	/**
	 * 다음글 표시 및 이동
	 * @author 김민혜
	 */
	public Notice next(Long noticeId) {
		return noticeRepository.next(noticeId);
	}
	
	/**
	 * 조회수 증가
	 * @author 김민혜
	 */
	public Long viewcnt(Long noticeId) {
		return noticeRepository.viewcnt(noticeId);
	}
	
	/**
	 * 공지사항 글 개수
	 * @author 김민혜
	 */
	public int cntNotice() {
		return noticeRepository.cntNotice();
	}
	
	// 글 검색
	public List<Notice> search(String search, Integer pageNum) {
		return noticeRepository.search(search, pageNum);
	}
	
	// 검색된 글 개수
	public int cntSearchNotice(String search) {
		return noticeRepository.cntSearchNotice(search);
	}
}