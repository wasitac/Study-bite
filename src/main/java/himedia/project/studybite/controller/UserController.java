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
import org.springframework.web.bind.annotation.RequestParam;
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
		request.getSession().invalidate();
		model.addAttribute("userLogin", new UserLogin());
		return "/index";
	}

	// 로그인
	@PostMapping("/")
	public String login(@ModelAttribute UserLogin userLogin, HttpServletRequest request, Model model) {
		User userInfo = null;
		Optional<User> user = userService.login(userLogin);

		if (user.isEmpty()) {
			request.setAttribute("msg", "로그인 정보가 일치하지 않습니다");
			request.setAttribute("url", "");
			return "/common/alert";
		}

		userInfo = user.get();
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("user", userInfo);
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
	public String dashboard(@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
		List<Course> courses = userCourseService.findCourse(userId);
		List<News> newses = userCourseService.findNews(userId);

		model.addAttribute("courses", courses);
		model.addAttribute("newses", newses);
		model.addAttribute("user", user);
		return "/home/home";
	}

	// 수강과목
	@GetMapping("/course")
	public String course(@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
		List<Course> courses = userCourseService.findCourse(userId);
		Integer courseCount = userCourseService.findCount(userId);

		model.addAttribute("courses", courses);
		model.addAttribute("courseCount", courseCount);
		model.addAttribute("user", user);
		return "/home/course";
	}

	// 내 정보
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
		if (userService.updatePassword(passwordUpdate)) {
			request.getSession().invalidate();
			return "redirect:/";
		}

		request.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		request.setAttribute("url", "mypage/update");
		return "/common/alert";
	}

	// 공지사항
	@GetMapping("/notice")
	public String notice(@RequestParam(name = "page", required = false) Integer pageNum,
			@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
//		int page = 1;
		if (pageNum == null) {
			pageNum = 0;
		}
		List<Notice> notices = userService.findPage(pageNum);
		model.addAttribute("notices", notices);
		model.addAttribute("notices", notices);
		model.addAttribute("user", user);
		return "/home/notice";
	}

	// 공지사항 상세
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
}