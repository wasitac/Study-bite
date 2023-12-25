package himedia.project.studybite.service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.ContentData;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.FileBoard;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;
import himedia.project.studybite.repository.BoardRepository;
import himedia.project.studybite.repository.ContentRepository;
import himedia.project.studybite.repository.CourseRepository;
import himedia.project.studybite.repository.NewsRepository;
import himedia.project.studybite.repository.QnaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
	private final CourseRepository courseRepository;
	private final ContentRepository contentRepository;
	private final NewsRepository newsRepository;
	private final QnaRepository qnaRepository;
	private final BoardRepository boardRepository;
	/**
	 * @author 신지은
	 */
	// 강의 타이틀 강의 분류, 강의명, 교육자 조회
	public Optional<Course> courseInfo(Long courseId) {
		return courseRepository.courseInfo(courseId);
	}
	/**
	 * @author 신지은
	 */
	// 강의의 강좌 목록 가져오기
	public List<Content> contents(Long courseId) {
		return contentRepository.contents(courseId);
	}
	/**
	 * @author 신지은
	 */
	// 강좌명 가져오기
	public Optional<Content> findContentName(Long contentId) {
		return contentRepository.findContentName(contentId);
	}
	/**
	 * @author 신지은
	 */
	// 강의 영상 주소 가져오기
	public Optional<ContentData> findContentUrl(Long contentId) {
		return contentRepository.findContentUrl(contentId);
	}

	// 강의 공지 목록
	public List<News> findNewsPage(Long courseId) {
		return newsRepository.findNewsPage(courseId);
	}
	
	// 강의 공지 상세
	public Optional<News> findNewsDesc(Long newsId) {
		return newsRepository.findNewsDesc(newsId);
	}
	
	// 질의 응답 목록
	public List<Qna> findQnaPage(Long courseId) {
		return qnaRepository.findQnaPage(courseId);
	}
	
	// 질의 응답 상세
	public Optional<Qna> findQnaDesc(Long qnaId) {
		return qnaRepository.findQnaDesc(qnaId);
	}
	// 질의 응답 등록
	public void question(Qna qna) {
		qnaRepository.question(qna);
	}
	
	/**
	 * @author 신지은
	 */
	// 질의 응답 조회
//	public Qna qnaInfo(Long qnaId) {
//		return qnaRepository.selectQna(qnaId);
//	}
	
	/**
	 * @author 신지은
	 */
	// 질문 파일 저장
	public void upload(FileBoard fileBoard, MultipartFile file) throws Exception {
		//1. 파일 저장 경로 설정 : 
		String filePath = "C:\\upload" ;
		//랜덤으로 이름 생성
		UUID uuid = UUID.randomUUID();		
		// 2. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용
		String fileName = uuid + "_" + file.getOriginalFilename();
		// 3. 파일 생성
		File saveFile = new File(filePath, fileName);	//파일을 생성하면 경로는 filePath, 이름은 name으로 저장
		// 5. 서버로 전송
		file.transferTo(saveFile);					//예외 처리 필요
		
		fileBoard.setCategory(2);
		fileBoard.setFilename(fileName);
		fileBoard.setFilepath("C:\\upload\\" + fileName);
		
		boardRepository.save(fileBoard);
	}
	
	// 강의 공지 조회수
	public Long newsViewCnt(Long newsId) {
		return newsRepository.newsViewCnt(newsId);
	}
	
	// 질의 응답 조회수
	public Long qnaViewCnt(Long qnaId) {
		return qnaRepository.qnaViewCnt(qnaId);
	}
	
}