package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.Course;
import himedia.project.studybite.repository.ContentRepository;
import himedia.project.studybite.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	private final ContentRepository contentRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository, ContentRepository contentRepository) {
		this.courseRepository=courseRepository;
		this.contentRepository=contentRepository;
	}

	//강의 타이틀 강의 분류, 강의명, 교육자 조회
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
