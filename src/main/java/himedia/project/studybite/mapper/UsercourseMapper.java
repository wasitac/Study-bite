package himedia.project.studybite.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import himedia.project.studybite.dto.Course;
import himedia.project.studybite.dto.News;
import himedia.project.studybite.dto.UserCourse;

/**
* @author 송창민
*/
public interface UsercourseMapper {
    // 유저 아이디로 유저가 수강한 수강목록 전체 조회
    List<Course> findCourseById(Long userId);

    // 유저 아이디로 유저가 수강한 강의의 새소식 조회
    List<News> findNewsById(Long userId);

    // 유저 아이디, 강의 아이디로 유저코스 테이블 조회
    List<UserCourse> findUserCourseById(@Param("userId") Long userId, @Param("courseId") Long courseId);

    // 현재 유저가 수강중인 강의 수
    Integer findCourseCount(Long userId);

    // 유저가 컨텐츠 시청한 날짜 db에 저장
    int updateDate(@Param("date") Date date, @Param("contentId") Long contentId, @Param("userId") Long userId);

    // 출석한 컨텐츠 개수
    Integer findAttendanceCount(@Param("userId") Long userId, @Param("courseId") Long courseId);
    
    // 코스아이디로 유저아이디 조회 - 이지홍
    @Select("select distinct userId from userCourse where courseId = #{courseId}")
    List<Long> findUserByCourse(Long courseId);
}