package himedia.project.studybite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.ContentData;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;
import himedia.project.studybite.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

	private final CourseService courseService;
	@GetMapping("/{courseId}")
	public String courseInfo(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		model.addAttribute("courseInfo", courseInfo.get());
		return "course/info";
	}

	// 강의 목차
	@GetMapping("/{courseId}/contents")
	public String contenList(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		List<Content> contents = courseService.contents(courseId);

		model.addAttribute("contents", contents);
		model.addAttribute("courseInfo", courseInfo.get());
		return "course/contentList";
	}

	// 강의 콘텐츠 시청
	@GetMapping("/{courseId}/contents/{contentsId}")
	public String content(@PathVariable Long contentsId, Model model) {
		Optional<Content> content = courseService.findContentName(contentsId);
		Optional<ContentData> contentData = courseService.findContentUrl(contentsId);
		
		model.addAttribute("content", content.get());
		model.addAttribute("contentData", contentData.get());
		return "course/content";
	}

	// 강의 공지 목록
	@GetMapping("/{courseId}/news")
	public String news(@PathVariable Long courseId, Model model) {
		List<News> news = courseService.findNewsPage(courseId);
		model.addAttribute("news", news);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "/course/news";
	}

	// 강의 공지 상세
	@GetMapping("/{courseId}/news/{newsId}")
	public String newsDesc(@PathVariable Long courseId, @PathVariable Long newsId, Model model) {
		courseService.newsViewCnt(newsId);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		News news = courseService.findNewsDesc(newsId).get();
		model.addAttribute("news", news);
		return "/course/newsDesc";
	}

	// 질의 응답 목록
	@GetMapping("/{courseId}/qna")
	public String qna(@PathVariable Long courseId, Model model) {
		List<Qna> qna = courseService.findQnaPage(courseId);
		model.addAttribute("qna", qna);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "/course/qna";
	}

	// 질의 응답 상세
	@GetMapping("/{courseId}/qna/{qnaId}")
	public String qnaDesc(@PathVariable Long courseId, @PathVariable Long qnaId, Model model) {
		courseService.qnaViewCnt(qnaId);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		Qna qna = courseService.findQnaDesc(qnaId).get();
		model.addAttribute("qna", qna);
		return "/course/qnaDesc";
	}

	// 질의 응답 등록 폼
	@GetMapping("/{courseId}/qna/add")
	public String qnaQuestion(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "/course/qnaForm";
	}

	// 질의 응답 등록
	@PostMapping("/{courseId}/qna/add")
	public String postQnaQuestion(@PathVariable Long courseId, Qna qna, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		qna.setCourseId(courseId);
		courseService.question(qna);
		return "redirect:/course/" + courseId + "/qna/" + qna.getQnaId();
	}


}
