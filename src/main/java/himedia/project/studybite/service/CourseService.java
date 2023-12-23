package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.ContentData;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;
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

	// 강의 타이틀 강의 분류, 강의명, 교육자 조회
	public Optional<Course> courseInfo(Long courseId) {
		return courseRepository.courseInfo(courseId);
	}

	// 강의의 강좌 목록 가져오기
	public List<Content> contents(Long courseId) {
		return contentRepository.contents(courseId);
	}

	// 강좌명 가져오기
	public Optional<Content> findContentName(Long contentId) {
		return contentRepository.findContentName(contentId);
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
	
	// 강의 공지 조회수
	public Long newsViewCnt(Long newsId) {
		return newsRepository.newsViewCnt(newsId);
	}
	
	// 질의 응답 조회수
	public Long qnaViewCnt(Long qnaId) {
		return qnaRepository.qnaViewCnt(qnaId);
	}
	
	// 강의 영상 주소 가져오기
	public Optional<ContentData> findContentUrl(Long contentId) {
		return contentRepository.findContentUrl(contentId);
	}
}