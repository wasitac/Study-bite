package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.repository.ContentRepository;
import himedia.project.studybite.repository.CourseRepository;
import himedia.project.studybite.repository.NewsRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	private final ContentRepository contentRepository;
	private final NewsRepository newsRepository;

	@Autowired
	public CourseService(NewsRepository newsRepository, CourseRepository courseRepository, ContentRepository contentRepository) {
		this.newsRepository = newsRepository;
		this.courseRepository = courseRepository;
		this.contentRepository = contentRepository;
	}

	public List<News> findNewsPage(Long courseId) {
		return newsRepository.findNewsPage(courseId);
	}

	public Optional<News> findNewsDesc(Long newsId) {
		return newsRepository.findNewsDesc(newsId);
	}


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

}
