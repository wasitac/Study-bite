package himedia.project.studybite.service;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.project.studybite.dto.Content;
import himedia.project.studybite.dto.ContentData;
import himedia.project.studybite.dto.Course;
import himedia.project.studybite.dto.FileBoard;
import himedia.project.studybite.dto.News;
import himedia.project.studybite.dto.Qna;
import himedia.project.studybite.mapper.BoardMapper;
import himedia.project.studybite.mapper.ContentMapper;
import himedia.project.studybite.mapper.CourseMapper;
import himedia.project.studybite.mapper.NewsMapper;
import himedia.project.studybite.mapper.QnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
	private final CourseMapper courseMapper;
	private final ContentMapper contentMapper;
	private final NewsMapper newsMapper;
	private final QnaMapper qnaMapper;
	private final BoardMapper boardMapper;

	// 강의 타이틀 강의 분류, 강의명, 교육자 조회
	public Optional<Course> courseInfo(Long courseId) {
		return courseMapper.courseInfo(courseId);
	}

	/**
	 * 강의의 강좌 목록 가져오기
	 * @author 신지은
	 */
	public List<Content> contentsInfo(Long courseId) {
		return contentMapper.contentsInfo(courseId);
	}

	/**
	 * 강좌명 가져오기
	 * @author 신지은
	 */
	public Optional<Content> findContentName(Long contentId) {
		return contentMapper.findContentName(contentId);
	}

	/**
	 * 강의 영상 주소 가져오기
	 * @author 신지은
	 */
	public Optional<ContentData> findContentUrl(Long contentId) {
		return contentMapper.findContentUrl(contentId);
	}

	/**
	 * 강의 공지 목록
	 * @author 김민혜
	 */
	public List<News> findNewsPage(Long courseId, Integer pageNum) {
		return newsMapper.findNewsPage(courseId, pageNum);
	}

	/**
	 * 강사 : 강의 공지 등록
	 * @author 신지은
	 */
	public void newsAdd(News news) {
		newsMapper.newsAdd(news);
	}

	/**
	 * 강의 공지 상세
	 * @author 김민혜
	 */
	public Optional<News> findNewsDesc(Long newsId) {
		return newsMapper.findNewsDesc(newsId);
	}
	
	/**
	 * 강사 : 강의 공지 수정
	 * @author 신지은
	 */
	public int newsUpdate(News news) {
		return newsMapper.newsUpdate(news);
	}
	
	/**
	 * 강사 : 강의 공지 삭제
	 * @author 신지은
	 */
	public void newsDelete(News news) {
		
		try {
			FileBoard fileboard = boardMapper.findNewsFile(news.getNewsId()).get();		
			File file = new File(fileboard.getFilepath());
			
			if(file.exists()) {
				if(file.delete()) {
					log.info("파일 삭제 성공");
				}else {
					log.info("파일 삭제 실패");
				}
			}else{
				log.info("파일이 존재하지 않습니다.");
			}
		} catch (NoSuchElementException e) {
			log.info(e +" " + news.getNewsId() + "번 공지의 첨부파일이 없습니다.");
		}
		
		
		newsMapper.newsDelete(news);
	}
	
	/**
	 * 이전글
	 * @author 김민혜
	 */
	public News prev(Long courseId, Long newsId) {
		return newsMapper.prev(courseId, newsId);
	}

	/**
	 * 다음글
	 * @author 김민혜
	 */
	public News next(Long courseId, Long newsId) {
		return newsMapper.next(courseId, newsId);
	}

	/**
	 * 질의 응답 목록
	 * 
	 * @author 김민혜
	 */
	public List<Qna> findQnaPage(Long courseId, Integer pageNum) {
		return qnaMapper.findQnaPage(courseId, pageNum);
	}

	/**
	 * 질의 응답 상세
	 * @author 김민혜
	 */
	public Optional<Qna> findQnaDesc(Long qnaId) {
		return qnaMapper.findQnaDesc(qnaId);
	}

	/**
	 * 질의 응답 등록
	 * @author 김민혜
	 */
	public void question(Qna qna) {
		qnaMapper.question(qna);
	}

	// 질의 응답 답변 등록
	public void answer(Qna qna) {
		qnaMapper.answer(qna);
	}

	/**
	 * 질의응답 수정
	 * @author 신지은
	 */
	public int qnaUpdate(Qna qna) {
		return qnaMapper.qnaUpdate(qna);
	}

	/**
	 * 질문 삭제
	 * @author 신지은
	 */
	public void qnaDelete(Qna qna) {
		qnaMapper.qnaDelete(qna);
	};

	/**
	 * 파일 업로드
	 * @author 신지은
	 */
	public void upload(FileBoard fileBoard, MultipartFile file, HttpServletRequest request) throws Exception {
		
		// 1. 파일 저장 경로 설정 :
		String filePath = request.getServletContext().getRealPath("/resources/files/");
		//String projectPath = request.getServletContext().getRealPath("/");
		//String[] path = projectPath.split("\\\\");
		//String filePath = path[0] + "\\" + path[1] + "\\" + path[2] + "\\Study-bite\\src\\main\\webapp\\resources\\files\\";
		
		
//		String filePath = "D:\\fullstack\\workspace-LMS\\Study-bite\\src\\main\\webapp\\resources\\files";
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

		boardMapper.save(fileBoard);
	}

	/**
	 * 질의응답 파일 조회
	 * @author 신지은
	 */
	public Optional<FileBoard> findQnaFile(Long qnaId) {
		return boardMapper.findQnaFile(qnaId);
	}

	/**
	 * 강의 공지 파일 조회 
	 * @author 신지은
	 */
	public Optional<FileBoard> findNewsFile(Long newsId) {
		return boardMapper.findNewsFile(newsId);
	}
	
	// 강의 공지 조회수
	public Long newsViewCnt(Long newsId) {
		return newsMapper.newsViewCnt(newsId);
	}

	// 강의 공지 글 개수
	public int cntNews(Long courseId) {
		return newsMapper.cntNews(courseId);
	}

	// 질의 응답 조회수
	public Long qnaViewCnt(Long qnaId) {
		return qnaMapper.qnaViewCnt(qnaId);
	}

	// 질의 응답 글 개수
	public int cntQna(Long courseId) {
		return qnaMapper.cntQna(courseId);
	}
}