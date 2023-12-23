package himedia.project.studybite.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Notice;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.dto.PasswordUpdate;
import himedia.project.studybite.dto.UserLogin;
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

	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("userLogin", new UserLogin());
		return "/index";
	}
//테스트용주석
	// 로그인
	@PostMapping("/")
	public String login(@ModelAttribute UserLogin userLogin, HttpServletRequest request, Model model) {
		Optional<User> user = userService.login(userLogin);
		User userInfo = user.get();

		if (user.isEmpty()) {
			request.setAttribute("msg", "로그인 정보가 일치하지 않습니다");
			request.setAttribute("url", "");
			return "/common/alert";
		}

		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userInfo.getUserId());
		// 코스 컨트롤러에서 rightbar에 이름 표시하기 위해 넣었습니다
		session.setAttribute("userName", userInfo.getUserName());
		return "redirect:/home";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);

		if (session != null)
			session.invalidate();

		return "redirect:/";
	}

	// 대시보드
	@GetMapping("/home")
	public String dashboard(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		List<Course> courses = userCourseService.findCourse(userId);
		model.addAttribute("courses", courses);

		List<News> newses = userCourseService.findNews(userId);
		model.addAttribute("newses", newses);

		Optional<User> user = userService.findUser(userId);
		model.addAttribute("user", user.get());
		return "/home/home";
	}

	// 수강과목
	@GetMapping("/course")
	public String course(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		List<Course> courses = userCourseService.findCourse(userId);
		Integer courseCount = userCourseService.findCount(userId);
		Optional<User> user = userService.findUser(userId);

		model.addAttribute("courses", courses);
		model.addAttribute("courseCount", courseCount);
		model.addAttribute("user", user.get());
		return "/home/course";
	}

	// 내 정보
	@GetMapping("/mypage")
	public String mypage(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		Optional<User> user = userService.findUser(userId);

		if (user.isEmpty()) {
			log.info("mypage 유저 정보 없음");
			return "index";
		}

		model.addAttribute("user", user.get());
		return "/home/mypage";
	}

	@GetMapping("/mypage/update")
	public String mypageUpdate(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		Optional<User> user = userService.findUser(userId);

		if (user.isEmpty())
			return "index";

		model.addAttribute("user", user.get());
		return "/home/mypageUpdate";
	}

	@PostMapping("/mypage/update")
	public String postMypageUpdate(@SessionAttribute(name = "userId", required = false) Long userId,
			@ModelAttribute PasswordUpdate passwordUpdate, HttpServletRequest request, Model model) {

		passwordUpdate.setUserId(userId);

		// 비밀번호 변경에 성공하면 다시 로그인화면으로 이동
		if (userService.updatePassword(passwordUpdate))
			return "redirect:/";

		request.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		request.setAttribute("url", "mypage/update");
		return "/common/alert";
	}

	// 공지사항
	@GetMapping("/notice")
	public String notice(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		int page = 1;
		List<Notice> notices = userService.findPage(page);
		Optional<User> user = userService.findUser(userId);

		model.addAttribute("notices", notices);
		model.addAttribute("user", user.get());
		return "/home/notice";
	}

	// 공지사항 상세
	@GetMapping("/notice/{noticeId}")
	public String noticeDesc(@PathVariable Long noticeId,
			@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
		userService.viewcnt(noticeId);
		Notice notice = userService.findNoticeDesc(noticeId).get();
		Optional<User> user = userService.findUser(userId);

		model.addAttribute("notice", notice);
		model.addAttribute("prev", userService.prev(noticeId));
		model.addAttribute("next", userService.next(noticeId));
		model.addAttribute("user", user.get());
		return "/home/noticeDesc";
	}
}
