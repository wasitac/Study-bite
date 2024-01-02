package himedia.project.studybite.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;

import himedia.project.studybite.dto.Course;

public interface CourseMapper {
	/**
	 * course 테이블에서 강의 분류, 강의명, 교육자 조회
	 * @author 신지은
	 */	
	@Select("select * from course where courseId = #{courseId}")
	Optional<Course> courseInfo(Long courseId);
}