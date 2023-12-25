package himedia.project.studybite.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.UserCourse;
import himedia.project.studybite.repository.UserCourseRepository;

@Service
public class UserCourseService {
	private final UserCourseRepository userCourseRepository;

	@Autowired
	public UserCourseService(UserCourseRepository userCourseRepository) {
		this.userCourseRepository = userCourseRepository;
	}

	public List<Course> findCourse(Long userId) {
		return userCourseRepository.findCourseById(userId);
	}

	public List<News> findNews(Long userId) {
		return userCourseRepository.findNewsById(userId);
	}

	public List<UserCourse> findUserCourse(Long userId, Long courseId) {
		return userCourseRepository.findUserCourseById(userId, courseId);
	}

	public Integer findCount(Long userId) {
		return userCourseRepository.findCourseCount(userId);
	}

	public int updateDate(Date date, Long contentId, Long userId) {
		return userCourseRepository.updateDate(date, contentId, userId);
	}
	
	public Integer findAttendanceCount(Long userId, Long courseId) {
		return userCourseRepository.findAttendanceCount(userId, courseId);
	}
}