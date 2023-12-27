package himedia.project.studybite.service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	// 강의 타이틀 강의 분류, 강의명, 교육자 조회
	public Optional<Course> courseInfo(Long courseId) {
		return courseRepository.courseInfo(courseId);
	}

	/**
	 * 강의의 강좌 목록 가져오기
	 * 
	 * @author 신지은
	 */
	public List<Content> contentsInfo(Long courseId) {
		return contentRepository.contentsInfo(courseId);
	}

	/**
	 * 강좌명 가져오기
	 * 
	 * @author 신지은
	 */
	public Optional<Content> findContentName(Long contentId) {
		return contentRepository.findContentName(contentId);
	}

	/**
	 * 강의 영상 주소 가져오기
	 * 
	 * @author 신지은
	 */
	public Optional<ContentData> findContentUrl(Long contentId) {
		return contentRepository.findContentUrl(contentId);
	}

	/**
	 * 강의 공지 목록
	 * 
	 * @author 김민혜
	 */
	public List<News> findNewsPage(Long courseId, Integer pageNum) {
		return newsRepository.findNewsPage(courseId, pageNum);
	}

	/**
	 * 강사 : 강의 공지 등록
	 * 
	 * @author 신지은
	 */
	public void newsAdd(News news) {
		newsRepository.newsAdd(news);
	}

	/**
	 * 강의 공지 상세
	 * 
	 * @author 김민혜
	 */
	public Optional<News> findNewsDesc(Long newsId) {
		return newsRepository.findNewsDesc(newsId);
	}

	/**
	 * 질의 응답 목록
	 * 
	 * @author 김민혜
	 */
	public List<Qna> findQnaPage(Long courseId, Integer pageNum) {
		return qnaRepository.findQnaPage(courseId, pageNum);
	}

	/**
	 * 질의 응답 상세
	 * 
	 * @author 김민혜
	 */
	public Optional<Qna> findQnaDesc(Long qnaId) {
		return qnaRepository.findQnaDesc(qnaId);
	}

	/**
	 * 질의 응답 등록
	 * 
	 * @author 김민혜
	 */
	public void question(Qna qna) {
		qnaRepository.question(qna);
	}

	// 질의 응답 답변 등록
	public void answer(Qna qna) {
		qnaRepository.answer(qna);
	}

	/**
	 * 질의응답 수정
	 * 
	 * @author 신지은
	 */
	public int qnaUpdate(Qna qna) {
		return qnaRepository.qnaUpdate(qna);
	}

	/**
	 * 질문 삭제
	 * 
	 * @author 신지은
	 */
	public void qnaDelete(Qna qna) {
		qnaRepository.qnaDelete(qna);
	};

	/**
	 * 파일 업로드
	 * 
	 * @author 신지은
	 */
	public void upload(FileBoard fileBoard, MultipartFile file) throws Exception {
		// 1. 파일 저장 경로 설정 :
		String filePath = "D:\\fullstack\\workspace-LMS\\Study-bite\\src\\main\\webapp\\resources\\files";
		// 랜덤으로 이름 생성
		UUID uuid = UUID.randomUUID();
		// 2. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용
		String fileName = uuid + "_" + file.getOriginalFilename();
		// 3. 파일 생성
		File saveFile = new File(filePath, fileName); // 파일을 생성하면 경로는 filePath, 이름은 name으로 저장
		// 5. 서버로 전송
		file.transferTo(saveFile); // 예외 처리 필요

		fileBoard.setFilename(fileName);
		fileBoard.setFilepath(filePath + fileName);

		boardRepository.save(fileBoard);
	}

	/**
	 * 질의응답 파일 조회
	 * 
	 * @author 신지은
	 */
	public Optional<FileBoard> findFile(Long qnaId) {
		return boardRepository.findQnaFile(qnaId);
	}

	// 강의 공지 조회수
	public Long newsViewCnt(Long newsId) {
		return newsRepository.newsViewCnt(newsId);
	}

	// 강의 공지 글 개수
	public int cntNews(Long courseId) {
		return newsRepository.cntNews(courseId);
	}

	// 질의 응답 조회수
	public Long qnaViewCnt(Long qnaId) {
		return qnaRepository.qnaViewCnt(qnaId);
	}

	// 질의 응답 글 개수
	public int cntQna(Long courseId) {
		return qnaRepository.cntQna(courseId);
	}
}