package himedia.project.studybite.service;

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
	
	public List<Course> findCourse(Long user_id) {
		return userCourseRepository.findCourseById(user_id);
	}
	
	public List<News> findNews(Long user_id) {
		return userCourseRepository.findNewsById(user_id);
	}
	
	public List<UserCourse> findAttendance(Long user_id) {
		return userCourseRepository.findAttendanceById(user_id);
	}
}
