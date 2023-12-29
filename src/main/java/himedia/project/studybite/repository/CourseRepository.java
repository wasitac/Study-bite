package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Course;

@Repository
public interface CourseRepository {
	/**
	 * course 테이블에서 강의 분류, 강의명, 교육자 조회
	 * @author 신지은
	 */	
	@Select("select * from course where courseId = #{courseId}")
	Optional<Course> courseInfo(Long courseId);
}