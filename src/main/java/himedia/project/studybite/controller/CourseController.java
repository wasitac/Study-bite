package himedia.project.studybite.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.ContentData;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.FileBoard;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;
import himedia.project.studybite.domain.User;
import himedia.project.studybite.domain.UserCourse;
import himedia.project.studybite.service.CourseService;
import himedia.project.studybite.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
@Slf4j
public class CourseController {
	private final CourseService courseService;
	private final UserCourseService userCourseService;

	/**
	 * @author 신지은
	 */
	// 강의 개요
	@GetMapping("/{courseId}")
	public String courseInfo(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		model.addAttribute("courseInfo", courseInfo.get());
		return "course/info";
	}

	/**
	 * @author 신지은
	 */
	// 강의 목차
	@GetMapping("/{courseId}/contents")
	public String contenList(@PathVariable Long courseId, @SessionAttribute(name = "user", required = false) User user,
			Model model) {
		Long userId = user.getUserId();
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		List<Content> contents = courseService.contentsInfo(courseId);
		List<UserCourse> userCourses = userCourseService.findUserCourse(userId, courseId);
		Integer attCount = userCourseService.findAttendanceCount(userId, courseId);
		Integer attPercentage = Math.round(((float) attCount / 7F) * 100);
		
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("contents", contents);
		model.addAttribute("userCourses", userCourses);
		model.addAttribute("attPercentage", attPercentage);
		return "course/contentList";
	}

	/**
	 * @author 신지은
	 */
	// 강의 콘텐츠 시청
	@GetMapping("/{courseId}/contents/{contentsId}")
	public String content(@PathVariable Long courseId, @PathVariable Long contentsId,
			@SessionAttribute(name = "user", required = false) User user, Model model) {
		Long userId = user.getUserId();
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		Optional<Content> content = courseService.findContentName(contentsId);
		Optional<ContentData> contentData = courseService.findContentUrl(contentsId);
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		userCourseService.updateDate(date, contentsId, userId);

		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("content", content.get());
		model.addAttribute("contentData", contentData.get());
		return "course/content";
	}

	// 강의 공지 목록
	@GetMapping("/{courseId}/news")
	public String news(@PathVariable Long courseId, @RequestParam(name = "page", required = false) Integer pageNum, Model model) {
		
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		
		if (pageNum == null) {
			pageNum = 0;
		}
		
		List<News> news = courseService.findNewsPage(courseId, pageNum);
		
		String location = "course/" + courseId + "/news";
		
		int newsCnt = courseService.cntNews(courseId);
		int num = courseService.cntNews(courseId) / 10;
		
		if (newsCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("news", news);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("num", num);
		model.addAttribute("location", location);
		return "/course/news";
	}

	// 강의 공지 상세
	@GetMapping("/{courseId}/news/{newsId}")
	public String newsDesc(@PathVariable Long courseId, @PathVariable Long newsId, Model model) {
		courseService.newsViewCnt(newsId);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		News news = courseService.findNewsDesc(newsId).get();

		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("news", news);
		return "/course/newsDesc";
	}

	// 질의 응답 목록
	@GetMapping("/{courseId}/qna")
	public String qna(@PathVariable Long courseId, @RequestParam(name = "page", required = false) Integer pageNum, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		
		if (pageNum == null) {
			pageNum = 0;
		}
		
		List<Qna> qna = courseService.findQnaPage(courseId, pageNum);
		
		String location = "course/" + courseId + "/qna";
		
		int qnaCnt = courseService.cntQna(courseId);
		int num = courseService.cntQna(courseId) / 10;
		
		if (qnaCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("qna", qna);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("num", num);
		model.addAttribute("location", location);
		return "/course/qna";
	}

	// 질의 응답 등록 폼
	@GetMapping("/{courseId}/qna/add")
	public String qnaQuestion(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "/course/qnaForm";
	}

	/**
	 * @author 김민혜(), 신지은(파일 업로드 기능)
	 */
	// 질의 응답 등록
	@PostMapping("/{courseId}/qna/add")
	public String postQnaQuestion(@PathVariable Long courseId, @ModelAttribute Qna qna,
			@RequestParam(name = "file", required = false)  MultipartFile file, HttpServletRequest request, FileBoard fileBoard, Model model)
			throws Exception {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		qna.setCourseId(courseId);
		courseService.question(qna);

		fileBoard.setId(qna.getQnaId());
		courseService.upload(request, fileBoard, file);

		model.addAttribute("courseInfo", courseInfo.get());
		return "redirect:/course/" + courseId + "/qna/" + qna.getQnaId();
	}
	
	// 질의 응답 답변 등록
	@PostMapping("/{courseId}/qna/answer")
	public String postQnaAnswer(@PathVariable Long courseId, @ModelAttribute Qna qna, HttpServletRequest request, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		qna.setCourseId(courseId);
		courseService.answer(qna);
		
		model.addAttribute("courseInfo", courseInfo.get());
		return "redirect:/course/" + courseId + "/qna/" + qna.getQnaId();
	}

	/**
	 * @author 김민혜(), 신지은(파일 다운로드 기능)
	 */
	// 질의 응답 상세
	@GetMapping("/{courseId}/qna/{qnaId}")
	public String qnaDesc(@PathVariable Long courseId, @PathVariable Long qnaId, Model model) {
		courseService.qnaViewCnt(qnaId);
		Qna qna = courseService.findQnaDesc(qnaId).get();
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		Optional<FileBoard> fileBoardInfo = courseService.findFile(2, qnaId);

		model.addAttribute("qna", qna);
		if (!fileBoardInfo.isEmpty())
			model.addAttribute("fileBoard", fileBoardInfo.get());
		model.addAttribute("courseInfo", courseInfo.get());
		return "/course/qnaDesc";
	}

	/**
	 * @author 신지은
	 */
	// 질의 응답 수정
	@PostMapping("/{courseId}/qna/{qnaId}/edit")
	public String qnaEdit(@PathVariable Long courseId, @PathVariable Long qnaId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		// Qna qna = courseService.qnaInfo(qnaId);

		// model.addAttribute("qna", qna);
		model.addAttribute("courseInfo", courseInfo.get());
		return "course/qnaEdit";
	}

	// 출결 확인
	@GetMapping("/{courseId}/attendance")
	public String attendance(@PathVariable Long courseId, @SessionAttribute(name = "user", required = false) User user,
			Model model) {
		List<UserCourse> userCourses = userCourseService.findUserCourse(user.getUserId(), courseId);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		Integer attCount = userCourseService.findAttendanceCount(user.getUserId(), courseId);
		Integer attPercentage = Math.round(((float) attCount / 7F) * 100);

		model.addAttribute("userCourses", userCourses);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("attPercentage", attPercentage);
		return "/course/attendance";
	}
}