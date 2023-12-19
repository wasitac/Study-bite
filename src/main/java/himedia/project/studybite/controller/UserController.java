package himedia.project.studybite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * 메서드를 흐름이 맞는 위치에 넣어주세요
 * 
 */

@Controller
public class UserController {
		
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
	public String dashboard() {
		return "/home/home";
	}
	
	// 수강과목
	@GetMapping("/course")
	public String course() {
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
	
	@GetMapping("/home/notice/noticeid")
	public String noticeDesc() {
		return "/home/noticeDesc";
	}
	
}
