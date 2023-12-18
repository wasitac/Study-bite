package himedia.project.studybite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/")
	public String login() {
		return "/home/home";
	}
	
	@GetMapping("/home/notices")
	public String notice() {
		return "/home/notice";
	}
	
	@GetMapping("/notices/noticeid")
	public String noticeDesc() {
		return "/home/noticeDesc";
	}
	
}
