package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;

import himedia.project.studybite.domain.Course;

public interface CourseRepository {
	
	//course 테이블에서 강의 분류, 강의명, 교육자 조회
	@Select("select * from course where courseId = #{courseId}")
	Optional<Course> courseInfo(Long courseId);
	
}
