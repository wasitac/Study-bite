package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import himedia.project.studybite.dto.Notice;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.User;
import himedia.project.studybite.dto.UserLogin;
import himedia.project.studybite.mapper.NoticeMapper;
import himedia.project.studybite.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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
	public String updatePassword(PasswordUpdate passwordUpdate, HttpServletRequest request) {
		// 유저가 입력한 현재 비밀번호가 일치하면 유저아이디를 리턴, 비밀번호를 변경합니다
		String msg = "";
		String url = "mypage/update";
		
		if (userMapper.checkPassword(passwordUpdate).isEmpty()) {
			msg = "비밀번호가 일치하지 않습니다";
		} else if (passwordUpdate.getPassword().equals(passwordUpdate.getNewPassword())) {		
			msg = "기존 비밀번호와 같은비밀번호 입니다. 다른 비밀번호로 변경해주세요"; 
		} else {
			userMapper.updatePassword(passwordUpdate);
			msg = "비밀번호가 변경되었습니다. 다시 로그인해 주세요";
			HttpSession session = request.getSession();
			session.invalidate();
			url = "";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/common/alert";
		
		
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