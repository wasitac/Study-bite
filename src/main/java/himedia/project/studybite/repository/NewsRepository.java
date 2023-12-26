package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.News;
import himedia.project.studybite.domain.Qna;

/**
 * @author 김민혜
 */
@Repository
public interface NewsRepository {
	/* 강의 공지 목록 */
	@Select("select * from news where courseId = #{courseId} order by newsId desc limit 10")
	List<News> findNewsPage(Long courseId);
	
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
	
	
	// 강의 공지 상세
	@Select ("select * from news where newsId = #{newsId}")
	Optional<News> findNewsDesc(Long newsId);

	/* 조회수 증가*/
	@Update("update news set views = views + 1 where newsId = #{newsId}")
	Long newsViewCnt(Long newsId);

}
