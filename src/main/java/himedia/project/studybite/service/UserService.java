package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Notice;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.UserLogin;
import himedia.project.studybite.mapper.NoticeMapper;
import himedia.project.studybite.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	private final UserMapper userMapper;
	private final NoticeMapper noticeMapper;

	/**
	 * 로그인
	 * 
	 * @author 이지홍
	 */
	public Optional<User> login(UserLogin userLogin) {
		Optional<User> user = userMapper.login(userLogin);
		return user;
	}

	public Optional<User> findUser(Long userId) {
		Optional<User> user = userMapper.findUserById(userId);
		return user;
	}

	/**
	 * 비밀번호 변경
	 * 
	 * @author 이지홍
	 */
	public Boolean updatePassword(PasswordUpdate passwordUpdate) {
		// 유저가 입력한 현재 비밀번호가 일치하면 유저아이디를 리턴, 비밀번호를 변경합니다
		if (userMapper.checkPassword(passwordUpdate).isEmpty())
			return false;

		userMapper.updatePassword(passwordUpdate);
		return true;
	}

	/**
	 * 공지사항 목록
	 * @author 김민혜
	 */
	public List<Notice> findPage(Integer pageNum) {
		return noticeMapper.findPage(pageNum);
	}

	/**
	 * 공지사항 상세
	 * @author 김민혜
	 */
	public Optional<Notice> findNoticeDesc(Long noticeId) {
		return noticeMapper.findNoticeDesc(noticeId);
	}

	/**
	 * 이전글
	 * @author 김민혜
	 */
	public Notice prev(Long noticeId) {
		return noticeMapper.prev(noticeId);
	}

	/**
	 * 다음글
	 * @author 김민혜
	 */
	public Notice next(Long noticeId) {
		return noticeMapper.next(noticeId);
	}

	/**
	 * 조회수 증가
	 * @author 김민혜
	 */
	public Long viewcnt(Long noticeId) {
		return noticeMapper.viewcnt(noticeId);
	}

	/**
	 * 공지사항 글 개수
	 * @author 김민혜
	 */
	public int cntNotice() {
		return noticeMapper.cntNotice();
	}

	/**
	 * 글 검색
	 * @author 김민혜
	 */
	public List<Notice> search(String search, Integer pageNum) {
		return noticeMapper.search(search, pageNum);
	}

	/**
	 * 검색된 글 개수
	 * @author 김민혜
	 */
	public int cntSearchNotice(String search) {
		return noticeMapper.cntSearchNotice(search);
	}
}