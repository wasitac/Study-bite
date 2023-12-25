package himedia.project.studybite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.UserCourse;
import himedia.project.studybite.repository.UserCourseRepository;
import lombok.RequiredArgsConstructor;

/**
 * UserCourseRepository를 사용하는 서비스
 * @author 송창민
 *
 */

@Service
@RequiredArgsConstructor
public class UserCourseService {
	private final UserCourseRepository userCourseRepository;

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
	
	public List<News> findNews(Long user_id) {
		return userCourseRepository.findNewsById(user_id);
	}
	
	public List<UserCourse> findAttendance(Long user_id) {
		return userCourseRepository.findAttendanceById(user_id);
	}
	
   public Integer findCount(Long user_id) {
	      return userCourseRepository.findCourseCount(user_id);
	   }

}