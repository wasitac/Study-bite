package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.News;

@Repository
public interface NewsRepository {
	// 강의 공지 목록
	List<News> findNewsPage(@Param("courseId") Long courseId, @Param("pageNum") Integer pageNum);
	
	// 강의 공지 상세
	@Select ("select * from news where newsId = #{newsId}")
	Optional<News> findNewsDesc(Long newsId);
	
	// 조회수
	@Update ("update news set views = views + 1 where newsId = #{newsId}")
	Long newsViewCnt(Long newsId);
	
	// 글 개수
	@Select("select count(newsId) from news where courseId = #{courseId}")
	int cntNews(Long courseId);
	
}
