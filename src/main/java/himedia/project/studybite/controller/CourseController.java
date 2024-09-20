package himedia.project.studybite.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import himedia.project.studybite.dto.Content;
import himedia.project.studybite.dto.ContentData;
import himedia.project.studybite.dto.Course;
import himedia.project.studybite.dto.FileBoard;
import himedia.project.studybite.dto.News;
import himedia.project.studybite.dto.Notification;
import himedia.project.studybite.dto.Qna;
import himedia.project.studybite.dto.User;
import himedia.project.studybite.dto.UserCourse;
import himedia.project.studybite.service.CourseService;
import himedia.project.studybite.service.NotificationService;
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
	private final NotificationService notificationService;

	/**
	 * 강의 개요
	 * 
	 * @author 신지은
	 */
	@GetMapping("/{courseId}")
	public String courseInfo(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "course/info";
	}

	/**
	 * 강의 목차
	 * 
	 * @author 신지은(강의 목차 조회), 
	 * 	       송창민(수강한 날짜, 퍼센트 표시)
	 */
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
	 * 강의 콘텐츠 시청
	 * 
	 * @author 신지은(강의 콘텐츠 데이터 조회)
	 *         송창민(콘텐츠 수강 시 현재 날짜 저장)
	 */
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

	/**
	 * 강사 : 강의 공지 등록 폼
	 * 
	 * @author 신지은
	 */
	@GetMapping("/{courseId}/news/add")
	public String NewsForm(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		model.addAttribute("courseInfo", courseInfo.get());
		return "course/newsForm";
	}

	/**
	 * 강사 : 강의 공지 등록
	 * 
	 * @author 신지은
	 * @author 이지홍(강의 공지 알림)
	 */
	@PostMapping("/{courseId}/news/add")
	public String postNewsAdd(@PathVariable Long courseId, @ModelAttribute News news, @RequestParam MultipartFile file,
			@SessionAttribute(name = "user", required = false) User user, HttpServletRequest request,
			FileBoard fileBoard, Model model) throws Exception {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		news.setCourseId(courseId);
		news.setUserName(user.getUserName());
		courseService.newsAdd(news);

		if (!file.isEmpty()) {
			fileBoard.setNewsId(news.getNewsId());
			courseService.upload(fileBoard, file, request);
		}

		List<Long> member = userCourseService.findCourseMember(courseId);
		List<Notification> notifications = new ArrayList<Notification>();

		for (int i = 1; i < member.size(); i++) {
			notifications.add(new Notification(member.get(i), courseId, news.getNewsId(), 2, news.getTitle()));
		}

		notificationService.sendNotification(notifications);

		model.addAttribute("courseInfo", courseInfo.get());
		return "redirect:/course/" + courseId + "/news/" + news.getNewsId();
	}

	/**
	 * 강의 공지 목록
	 * 
	 * @author 김민혜(공지 목록 조회, 페이지네이션), 
	 *         신지은(유저 확인 후 공지 등록버튼 활성화), 
	 *         송창민(목록 번호 일정하게 표시)
	 */
	@GetMapping("/{courseId}/news")
	public String news(@PathVariable Long courseId, @RequestParam(name = "page", required = false) Integer pageNum,
			@SessionAttribute(name = "user", required = false) User user, Model model) {

		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		if (pageNum == null) {
			pageNum = 0;
		}

		List<News> news = courseService.findNewsPage(courseId, pageNum);

		String location = "course/" + courseId + "/news?";

		int newsCnt = courseService.cntNews(courseId);
		int num = courseService.cntNews(courseId) / 10;

		if (newsCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("news", news);
		model.addAttribute("newsCnt", newsCnt);
		model.addAttribute("user", user);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("num", num);
		model.addAttribute("location", location);
		return "/course/news";
	}

	/**
	 * 강의 공지 상세
	 * @author 김민혜(강의 공지 상세 조회, 조회수 증가, 이전글/다음글)
	 *         신지은(강의 공지 첨부파일 조회, 수정 삭제)
	 */
	@GetMapping("/{courseId}/news/{newsId}")
	public String newsDesc(@PathVariable Long courseId, @PathVariable Long newsId,
			@SessionAttribute(name = "user", required = false) User user, Model model) {
		courseService.newsViewCnt(newsId);
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		News news = courseService.findNewsDesc(newsId).get();
		Optional<FileBoard> fileBoardInfo = courseService.findNewsFile(newsId);

		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("news", news);
		model.addAttribute("user", user);
		model.addAttribute("prev", courseService.prev(courseId, newsId));
		model.addAttribute("next", courseService.next(courseId, newsId));
		if (!fileBoardInfo.isEmpty())
			model.addAttribute("fileBoard", fileBoardInfo.get());
		return "/course/newsDesc";
	}

	/**
	 * 강사 : 강의 공지 수정 폼
	 * 
	 * @author 신지은
	 */
	@GetMapping("/{courseId}/news/{newsId}/editForm")
	public String newsEditForm(@PathVariable Long courseId, @PathVariable Long newsId, HttpServletRequest request,
			FileBoard fileBoard, Model model) {

		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		News news = courseService.findNewsDesc(newsId).get();
		Optional<FileBoard> fileBoardInfo = courseService.findNewsFile(newsId);

		log.info(request.getRequestURI());

		model.addAttribute("requestURI", request.getRequestURI());
		// editForm에서 form의 modelAttribute가 될 값
		model.addAttribute("select", news);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("news", news);

		if (fileBoardInfo.isPresent())
			model.addAttribute("fileBoard", fileBoardInfo.get());
		return "course/editForm";
	}
	
	/**
	 * 강사 : 강의 공지 수정
	 * @author 신지은
	 * @throws Exception
	 */
	@PostMapping("/{courseId}/news/{newsId}")
	public String newsEdit(@PathVariable Long courseId, @RequestParam MultipartFile file, @RequestParam String confirmResult, 
			@ModelAttribute News news, FileBoard fileBoard, HttpServletRequest request, Model model) throws Exception {

		courseService.newsUpdate(news);
		
		//기존 파일만 삭제
		if(confirmResult.equals("true")) {
			FileBoard fileboard = courseService.findNewsFile(news.getNewsId()).get();
			File newFile = new File(fileboard.getFilepath());
			if(newFile.exists()) {
				newFile.delete();
				courseService.fileDelete(fileBoard);
			}	
		}
		//기존파일 삭제 후, 새로운 파일 업로드
		if(!file.isEmpty()) {
			try {
				FileBoard fileboard = courseService.findNewsFile(news.getNewsId()).get();		
				File newFile = new File(fileboard.getFilepath());
				
				if(newFile.exists()) 
					newFile.delete();
				
				courseService.fileDelete(fileboard);
				
			} catch (NoSuchElementException e) {
				log.info(e +" " + news.getNewsId() + "번 공지의 첨부파일이 없습니다.");
			}
			courseService.upload(fileBoard, file, request);
		}

		return "redirect:/course/{courseId}/news/{newsId}";
	}
	
	/**
	 * 강사 : 강의 공지 삭제
	 * 
	 * @author 신지은
	 */
	@DeleteMapping("/{courseId}/news/{newsId}")
	public String newsDelete(@ModelAttribute News news) {
		courseService.newsDelete(news);
		return "redirect:/course/{courseId}/news";
	}

	/**
	 * 질의 응답 목록
	 * @author 김민혜(목록 조회, 페이지네이션)
	 *         송창민(목록 번호 일정하게 표시)
	 */
	@GetMapping("/{courseId}/qna")
	public String qna(@PathVariable Long courseId, @RequestParam(name = "page", required = false) Integer pageNum,
			Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		if (pageNum == null) {
			pageNum = 0;
		}

		List<Qna> qna = courseService.findQnaPage(courseId, pageNum);
		String location = "course/" + courseId + "/qna?";

		int qnaCnt = courseService.cntQna(courseId);
		int num = courseService.cntQna(courseId) / 10;

		if (qnaCnt % 10 != 0)
			num = num + 1;

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("qna", qna);
		model.addAttribute("qnaCnt", qnaCnt);
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("num", num);
		model.addAttribute("location", location);
		return "/course/qna";
	}

	/**
	 * 질의 응답 등록 폼
	 * @author 김민혜
	 */
	@GetMapping("/{courseId}/qna/add")
	public String qnaQuestion(@PathVariable Long courseId, Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		
		model.addAttribute("courseInfo", courseInfo.get());
		
		return "/course/qnaForm";
	}

	/**
	 * 질의 응답 질문 등록
	 * 
	 * @author 김민혜(질의 응답 등록)
	 * @author 신지은(파일 업로드 기능)
	 * @author 이지홍(질문 알림)
	 */
	@PostMapping("/{courseId}/qna/add")
	public String postQnaQuestion(@PathVariable Long courseId, @ModelAttribute Qna qna,
			@RequestParam MultipartFile file, @SessionAttribute(name = "user", required = false) User user,
			FileBoard fileBoard, HttpServletRequest request, Model model) throws Exception {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);

		qna.setUserId(user.getUserId());
		qna.setCourseId(courseId);
		qna.setUserName(user.getUserName());
		courseService.question(qna);

		if (!file.isEmpty()) {
			fileBoard.setQnaId(qna.getQnaId());
			courseService.upload(fileBoard, file, request);
		}

		List<Long> member = userCourseService.findCourseMember(courseId);
		Notification notification = new Notification(member.get(0), courseId, qna.getQnaId(), 3, qna.getTitle());
		notificationService.sendNotification(notification);

		model.addAttribute("courseInfo", courseInfo.get());
		return "redirect:/course/{courseId}/qna/" + qna.getQnaId();
	}

	/**
	 * 질의 응답 답변 등록
	 * 
	 * @author 김민혜
	 * @author 이지홍(답변 알림)
	 */
	@PostMapping("/{courseId}/qna/answer")
	public String postQnaAnswer(@PathVariable Long courseId, @ModelAttribute Qna qna, HttpServletRequest request,
			Model model) {
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		qna.setCourseId(courseId);
		courseService.answer(qna);
		Optional<Qna> findQna = courseService.findQnaDesc(qna.getQnaId());
		
		if(findQna.isEmpty()) {
			request.setAttribute("msg", "해당 질문이 존재하지 않습니다");
			request.setAttribute("url", "/{courseId}/qna");
			return "/common/alert";
		}
		
		Qna q = findQna.get();
		Notification notification = new Notification(q.getUserId(), courseId, q.getQnaId(), 3, q.getTitle());
		notificationService.sendNotification(notification);

		model.addAttribute("courseInfo", courseInfo.get());
		return "redirect:/course/" + courseId + "/qna/" + qna.getQnaId();
	}

	/**
	 * @author 김민혜(질의 응답 상세, 조회수 증가)
	 * 		   신지은(저장한 파일 조회 기능, 수정 삭제)
	 */
	@GetMapping("/{courseId}/qna/{qnaId}")
	public String qnaDesc(@PathVariable Long courseId, @PathVariable Long qnaId,
			@SessionAttribute(name = "user", required = false) User user, Model model) {
		
		courseService.qnaViewCnt(qnaId);
		Qna qna = courseService.findQnaDesc(qnaId).get();
		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		Optional<FileBoard> fileBoardInfo = courseService.findQnaFile(qnaId);

		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("qna", qna);
		if (!fileBoardInfo.isEmpty())
			model.addAttribute("fileBoard", fileBoardInfo.get());
		model.addAttribute("user", user);
		return "/course/qnaDesc";
	}

	/**
	 * 질의 응답 수정 폼
	 * @author 신지은
	 */
	@GetMapping("/{courseId}/qna/{qnaId}/editForm")
	public String qnaEditForm(@PathVariable Long courseId, @PathVariable Long qnaId, HttpServletRequest request,
			Model model) {

		Optional<Course> courseInfo = courseService.courseInfo(courseId);
		Qna qna = courseService.findQnaDesc(qnaId).get();
		Optional<FileBoard> fileBoardInfo = courseService.findQnaFile(qnaId);

		log.info(request.getRequestURI());

		model.addAttribute("requestURI", request.getRequestURI());
		model.addAttribute("courseInfo", courseInfo.get());
		model.addAttribute("qna", qna);
		model.addAttribute("select", qna);
		if (fileBoardInfo.isPresent())
			model.addAttribute("fileBoard", fileBoardInfo.get());
		return "course/editForm";
	}
	
	/**
	 * 질의 응답 수정
	 * @author 신지은
	 * @throws Exception 
	 */
	@PostMapping("/{courseId}/qna/{qnaId}")
	public String qnaEdit(@PathVariable Long courseId, @RequestParam MultipartFile file, @RequestParam String confirmResult, @ModelAttribute Qna qna, 
			FileBoard fileBoard, HttpServletRequest request, Model model) throws Exception {
		
		courseService.qnaUpdate(qna);
		
		//기존 파일만 삭제
		if(confirmResult.equals("true")) {
			FileBoard fileboard = courseService.findQnaFile(qna.getQnaId()).get();
			File newFile = new File(fileboard.getFilepath());
			if(newFile.exists()) {
				newFile.delete();
				courseService.fileDelete(fileBoard);
			}	
		}
		// 기존 파일 삭제 후, 새로운 파일 업로드
		if(!file.isEmpty()) {
			try {
				FileBoard fileboard = courseService.findQnaFile(qna.getQnaId()).get();		
				File newFile = new File(fileboard.getFilepath());
				
				if(newFile.exists()) 
					newFile.delete();
				
				courseService.fileDelete(fileBoard);
				
			} catch (NoSuchElementException e) {
				log.info(e +" " + qna.getQnaId() + "번 공지의 첨부파일이 없습니다.");
			}
			courseService.upload(fileBoard, file, request);
		}
		
		return "redirect:/course/{courseId}/qna/{qnaId}";
	}

	/**
	 * 질의 응답 삭제
	 * @author 신지은
	 */
	@DeleteMapping("/{courseId}/qna/{qnaId}")
	public String qnaDelete(@ModelAttribute Qna qna) {
		courseService.qnaDelete(qna);
		return "redirect:/course/{courseId}/qna";
	}

	/**
	 * 출결 확인
	 * @author 송창민
	 */
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
	
	/**
	 * 파일 다운로드
	 * @author 신지은 
	 */
	@GetMapping("/{sort}/{id}/filedown")
	public void fileDown(@PathVariable Long id, @PathVariable String sort, HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileBoard fileBoard = new FileBoard();
		
		if(sort.equals("qna")) {
			fileBoard =  courseService.findQnaFile(id).get();
			log.info("courseService.findQnaFile(id) 실행");
		}
		else if(sort.equals("news")) {
			fileBoard = courseService.findNewsFile(id).get();
			log.info("courseService.findQnaFile(id) 실행");
		}
		log.info("fileBoard originName>>>>> {}", fileBoard.getOriginName());
		
		response.reset();
		response.setContentType("application/octer-stream");
		String fileName = URLEncoder.encode(fileBoard.getOriginName() , "UTF-8");
		//응답 헤더 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		
		//응답 바디에 파일 데이터 싣기
		String filePath = request.getSession().getServletContext().getRealPath("/resources/files/") + fileBoard.getFilename();
		File file = new File(filePath);
		
		if(file.exists()) {
			InputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			os.flush();
			os.close();
			is.close();
		}
	}
	
}