package himedia.project.studybite.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Course;
import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.UserCourse;

@Repository
public interface UserCourseRepository {
	// 유저 아이디로 유저가 수강한 수강목록 전체 조회
	List<Course> findCourseById(Long user_id); 
	
	// 유저 아이디로 유저가 수강한 강의의 새소식 조회
	List<News> findNewsById(Long user_id); 
	
	// 유저 아이디로 유저가 수강한 강의의 출결 조회
	List<UserCourse> findAttendanceById(Long user_id);
	
	// 현재 유저가 수강중인 강의 수
	Integer findCourseCount(Long user_id);
}