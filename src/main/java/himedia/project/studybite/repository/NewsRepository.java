package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;

@Repository
public interface NewsRepository {
	/**
	 * 강의 공지 목록
	 * @author 김민혜
	 */
	List<News> findNewsPage(@Param("courseId") Long courseId, @Param("pageNum") Integer pageNum);
	
	/**
	 * 강사 : 강의 공지 등록
	 * @author 신지은
	 */
	@Insert ("insert into news(courseId, userName, title, description, views, date) values (#{courseId}, #{userName}, #{title}, #{description}, 0 , now())")
	@Options(useGeneratedKeys = true, keyProperty = "newsId")
	void newsAdd(News news);
	
	/**
	 * 강사 : 강의 공지 수정
	 * @author 신지은
	 */
	
	/**
	 * 강사 : 강의 공지 삭제
	 * @author 신지은
	 */
	
	/**
	 *  강의 공지 상세
	 *  @author 김민혜
	 */
	@Select ("select * from news where newsId = #{newsId}")
	Optional<News> findNewsDesc(Long newsId);
	
	/**
	 *  조회수
	 *  @author 김민혜
	 */
	@Update ("update news set views = views + 1 where newsId = #{newsId}")
	Long newsViewCnt(Long newsId);
	
	/**
	 *  강의 공지 글 개수
	 *  @author 김민혜
	 */
	@Select("select count(newsId) from news where courseId = #{courseId}")
	int cntNews(Long courseId);
	
}
