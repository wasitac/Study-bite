package himedia.project.studybite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.service.UserCourseService;

/*
 * 메서드를 흐름이 맞는 위치에 넣어주세요
 * 
 */

@Controller
public class UserController {
	private final UserCourseService userCourseService;
	
	@Autowired
	public UserController(UserCourseService userCourseService) {
		this.userCourseService = userCourseService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// 로그인
	@PostMapping("/")
	public String login() {
		return "redirect:/home";
	}
	
	// 대시보드
	// login메서드 요청 확인하려고 임시로 만들었습니다. 이 주석하고 같이 지우거나 수정해서 사용하시면 됩니다 - 지홍
	@GetMapping("/home")
	public String dashboard(Model model) {
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
