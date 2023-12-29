package himedia.project.studybite.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Notice;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.UserLogin;
import himedia.project.studybite.service.NotificationService;
import himedia.project.studybite.service.UserCourseService;
import himedia.project.studybite.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
	private final UserService userService;
	private final UserCourseService userCourseService;
	private final NotificationService notificationService;
	/**
	 * 로그인 화면
	 * @author 이지홍
	 */
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		model.addAttribute("userLogin", new UserLogin());
		return "/index";
	}
	
	/**
	 * 로그인 post 요청 
	 * @author 이지홍
	 */
	@PostMapping("/")
	public String login(@ModelAttribute UserLogin userLogin, HttpServletRequest request, Model model) {
		Optional<User> user = userService.login(userLogin);
		if (user.isEmpty()) {
			request.setAttribute("msg", "로그인 정보가 일치하지 않습니다");
			request.setAttribute("url", "");
			return "/common/alert";
		}
		
		User userInfo = user.get();
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("user", userInfo);
		
		return "redirect:/home";
	}

	/**
 	* 로그아웃
 	* @author 이지홍
 	*/
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);

		if (session != null)
			session.invalidate();

		return "redirect:/";
	}
	
	/**
	 * 	대시보드
	 * @author 송창민
	 */
	@GetMapping("/home")
	public String dashboard(@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
		List<Course> courses = userCourseService.findCourse(userId);
		List<News> newses = userCourseService.findNews(userId);
		Iterator<Course> iter = courses.iterator();
		
		while(iter.hasNext()) {
			Course iterCourse = iter.next();
			if(userCourseService.findAttendanceCount(userId, iterCourse.getCourseId()) == 7)
				iter.remove();
		}

		model.addAttribute("courses", courses);
		model.addAttribute("newses", newses);
		model.addAttribute("user", user);

		if(user.getRole() == 2)
			return "redirect:/course";
		
		return "/home/home";
	}
	

	/**
	 * 	수강과목
	 * @author 송창민
	 */
	@GetMapping("/course")
	public String course(@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
		List<Course> courses = userCourseService.findCourse(userId);
		Integer courseCount = userCourseService.findCount(userId);
		List<Course> finishedCourse = new ArrayList<Course>();
		Iterator<Course> iter = courses.iterator();
		Integer finishedCount = 0;
	
		while(iter.hasNext()) {
			Course iterCourse = iter.next();
			if(userCourseService.findAttendanceCount(userId, iterCourse.getCourseId()) == 7) {
				finishedCourse.add(iterCourse);
				iter.remove();
				finishedCount++;
				courseCount--;
			}
		}
		
		model.addAttribute("courses", courses);
		model.addAttribute("courseCount", courseCount);
		model.addAttribute("finishedCourse", finishedCourse);
		model.addAttribute("finishedCount", finishedCount);
		model.addAttribute("user", user);
		return "/home/course";
	}

	/**
	 * 내 정보
	 * @author 이지홍
	 */
	@GetMapping("/mypage")
	public String mypage(@SessionAttribute(name = "user", required = false) User user, Model model) {
		model.addAttribute("user", user);
		return "/home/mypage";
	}

	@GetMapping("/mypage/update")
	public String mypageUpdate(@SessionAttribute(name = "user", required = false) User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("passwordUpdate", new PasswordUpdate());
		return "/home/mypageUpdate";
	}

	@PostMapping("/mypage/update")
	public String postMypageUpdate(@SessionAttribute(name = "user", required = false) User user,
			@ModelAttribute PasswordUpdate passwordUpdate, HttpServletRequest request, Model model) {
		Long userId = user.getUserId();
		passwordUpdate.setUserId(userId);

		// 비밀번호 변경에 성공하면 다시 로그인화면으로 이동
		if (userService.updatePassword(passwordUpdate))
			return "redirect:/";

		request.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		request.setAttribute("url", "mypage/update");
		return "/common/alert";
	}

	/**
	 * 공지사항 목록
	 * @author 김민혜
	 */
	@GetMapping("/notice")
	public String notice(@RequestParam(name = "page", required = false) Integer pageNum,
			@SessionAttribute(name = "user", required = false) User user, Model model) {

		if (pageNum == null) {
			pageNum = 0;
		}
		
		List<Notice> notices = userService.findPage(pageNum);

		String location = "notice?";

		int noticeCnt = userService.cntNotice();
		int num = userService.cntNotice() / 10;

		if (noticeCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("notices", notices);
		model.addAttribute("user", user);
		model.addAttribute("location", location);
		model.addAttribute("num", num);
		return "/home/notice";
	}

	/**
	 * 공지사항 검색
	 * @author 김민혜
	 */
	@GetMapping("/notice/search")
	public String search(@RequestParam(name = "page", required = false) Integer pageNum,
			@RequestParam(name = "search", required = false) String search,
			@SessionAttribute(name = "user", required = false) User user, Model model) {

		if (pageNum == null) {
			pageNum = 0;
		}

		List<Notice> notices = userService.search(search, pageNum);

		String location = "notice/search?search=" + search + "&";

		int noticeCnt = userService.cntSearchNotice(search);
		int num = userService.cntSearchNotice(search) / 10;

		if (noticeCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("notices", notices);
		model.addAttribute("user", user);
		model.addAttribute("location", location);
		model.addAttribute("num", num);
		return "/home/notice";
	}

	/**
	 * 공지사항 상세
	 * @author 김민혜
	 */
	@GetMapping("/notice/{noticeId}")
	public String noticeDesc(@PathVariable Long noticeId, @SessionAttribute(name = "user", required = false) User user,
			Model model) {
		userService.viewcnt(noticeId);
		Notice notice = userService.findNoticeDesc(noticeId).get();

		model.addAttribute("notice", notice);
		model.addAttribute("prev", userService.prev(noticeId));
		model.addAttribute("next", userService.next(noticeId));
		model.addAttribute("user", user);
		return "/home/noticeDesc";
	}
	
	/**
	 * 알림 확인 시 삭제 
	 * 
	 * @author 이지홍
	 */
	@DeleteMapping("/notification/{notificationId}")
	public void readNotification(@PathVariable Long notificationId) {
		notificationService.readNotification(notificationId);
	}
	
}