package himedia.project.studybite.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import himedia.project.studybite.dto.Course;
import himedia.project.studybite.dto.News;
import himedia.project.studybite.dto.UserCourse;
import himedia.project.studybite.mapper.UsercourseMapper;
import lombok.RequiredArgsConstructor;

/**
* @author 송창민
*/
@Service
@RequiredArgsConstructor
public class UserCourseService {
    private final UsercourseMapper usercourseMapper;

    public List<Course> findCourse(Long userId) {
        return usercourseMapper.findCourseById(userId);
    }

    public List<News> findNews(Long userId) {
        return usercourseMapper.findNewsById(userId);
    }

    public List<UserCourse> findUserCourse(Long userId, Long courseId) {
        return usercourseMapper.findUserCourseById(userId, courseId);
    }

    public Integer findCount(Long userId) {
        return usercourseMapper.findCourseCount(userId);
    }

    public int updateDate(Date date, Long contentId, Long userId) {
        return usercourseMapper.updateDate(date, contentId, userId);
    }

    public Integer findAttendanceCount(Long userId, Long courseId) {
        return usercourseMapper.findAttendanceCount(userId, courseId);
    }
    
    public List<Long> findCourseMember(Long courseId) {
    	return usercourseMapper.findUserByCourse(courseId);
    }
}