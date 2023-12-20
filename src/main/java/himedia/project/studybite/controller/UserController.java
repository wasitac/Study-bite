package himedia.project.studybite.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.domain.UserLogin;
import himedia.project.studybite.service.UserCourseService;
import himedia.project.studybite.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 메서드를 흐름이 맞는 위치에 넣어주세요
 * 
 */

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserCourseService userCourseService;

//	@Autowired
//	public UserController(UserService userService, UserCourseService userCourseService) {
//		this.userService = userService;
//		this.userCourseService = userCourseService;
//	}
	
	// 유저가 로그인 한 세션이 남아있다면 바로 대시보드로 이동하고, 없으면 로그인 페이지로 이동
//	@GetMapping("/")
//	public String index(Model model, @SessionAttribute(name = "user_id", required = false) Long user_id) {
//		// 로그인 정보를 담을 객체 생성
//		Optional<User> loginUser = userService.isLogin(user_id);
//		if(loginUser.isEmpty()) {
//			return "index";
//		}
//		model.addAttribute("userLogin", new UserLogin());
//		return "home";
//	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("userLogin", new UserLogin());
		return "index";
	}
	
	// 로그인
	@PostMapping("/")
	public String login(@ModelAttribute UserLogin userLogin, HttpServletRequest request, Model model) {
		/*
		 *  로그인에 실패하면 로그인 화면으로 리다이렉트하고 성공하면 기존에 있는 세션을 파기하고 세션 가져오기
		 *  세션이 없으면 세션을 생성해 userId를 저장합니다
		 */
		Optional<User> user = userService.login(userLogin);
		
		if(user.isEmpty()) {
			log.info("로그인 실패");		
			return "redirect:/";
		}
		User userInfo = user.get(); 
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("user_id", userInfo.getUser_id());
//		log.info("세션 id" + session.getId());
//		session.setMaxInactiveInterval(1800); 
		return "redirect:/home";
	}
	// 로그아웃 
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}return "redirect:/";
	}
	
	// 대시보드
	@GetMapping("/home")
	public String dashboard(Model model, @SessionAttribute(name = "user_id", required = false) Long user_id) {
		// 세션확인
		// log.info("대시보드 -> user_id >>" + user_id);
		List<Course> courses = userCourseService.findCourse(47L);
//		List<Course> courses = userCourseService.findCourse(user_id);
		model.addAttribute("courses", courses);
		
		List<News> newses = userCourseService.findNews(47L);
//		List<News> newses = userCourseService.findNews(user_id);
		model.addAttribute("newses", newses);
		return "/home/home";
	}
	
	// 수강과목
	@GetMapping("/course")
	public String course(Model model) {
		List<Course> courses = userCourseService.findCourse(47L);
//		List<Course> courses = userCourseService.findCourse(user_id);
		model.addAttribute("courses", courses);
		
		return "/home/course";
	}
	// 내 정보
	@GetMapping("/mypage")
	public String mypage() {
		return "/home/mypage";
	}
	
	@GetMapping("/mypageUpdate")
	public String mypageUpdate() {
		return "/home/mypageUpdate";
	}
	
	@PostMapping("/mypageUpdate")
	public String postMypageUpdate() {
		return "redirect:/";
	}
	
	// 공지사항
	// notices -> notice로 변경했습니다
	@GetMapping("/home/notice")
	public String notice() {
		return "/home/notice";
	}
	
	@GetMapping("/notice/noticeid")
	public String noticeDesc() {
		return "/home/noticeDesc";
	}
	
}
