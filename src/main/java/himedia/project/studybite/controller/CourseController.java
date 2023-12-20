package himedia.project.studybite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.service.CourseService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
	
	private final CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	//강의 개요
	@GetMapping("/{courseId}")
	public String courseInfo(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		model.addAttribute("courseInfo", courseInfo.get());
		return "course/info";
	}
	
	//강의 목차
	@GetMapping("/{courseId}/contents")
	public String contenList(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		List<Content> contents = courseService.contents(courseId);
		
		model.addAttribute("contents", contents);
		model.addAttribute("courseInfo", courseInfo.get());
		return "course/contentList";
	}
	
	//강의 콘텐츠 시청
	@GetMapping("/{courseId}/contents/{contentsId}")
	public String content(@PathVariable Long contentsId, Model model) {
		Optional<Content> content = courseService.findContentName(contentsId);
		model.addAttribute("content", content.get());
		return "course/content";
	}
	
	// URI들은 나중에 {courseId}, {qnaId} 넣어서 수정
	
	// 질의 응답 목록
	@GetMapping("/qna")
	public String qna() {
		return "/course/qna";
	}
	
	// 질의 응답 게시글
	@GetMapping("/qna/qnaid")
	public String qnaDesc() {
		return "/course/qnaDesc";
	}
	
	// 질의 응답 등록 폼
	@GetMapping("/qna/question")
	public String qnaQuestion() {
		return "/course/qnaForm";
	}
	
	// 질의 응답 등록 후
	/* 나중에 수정
	 * @PostMapping("/course/qna/question") public String qnaQ() { return
	 * "redirect:/course/qna/{qnaId}"; }
	 */
	
	@GetMapping("/news")
	public String news() {
		return "/course/news";
	}
	
	@GetMapping("/news/newsDesc")
	public String newsDesc() {
		return "/course/newsDesc";
	}
	
	
	

}
