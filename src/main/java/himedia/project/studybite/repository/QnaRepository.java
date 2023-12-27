package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Qna;

/**
 * @author 김민혜
 */
@Repository
public interface QnaRepository {
	/* 질의 응답 목록 */
	@Select ("select * from qna where courseId = #{courseId} order by qnaId desc limit 10")
	List<Qna> findQnaPage(Long courseId);
	
	/* 질의 응답 상세 */
	@Select ("select * from qna where qnaId = #{qnaId}")
	Optional<Qna> findQnaDesc(Long qnaId);
	
	/* 질의 응답 등록 */
	@Insert ("insert into qna(courseId, userName, title, description, views, date) values (#{courseId}, #{userName}, #{title}, #{description}, 0 , now())")
	@Options(useGeneratedKeys = true, keyProperty = "qnaId")
	void question(Qna qna);
	
	/**
	 * 질의 응답 수정
	 * @author 신지은
	 */
	@Update("update qna set title=#{title}, description=#{description} where qnaId=#{qnaId}")
	int qnaUpdate(Qna qna);
	
	/**
	 * 질의 응답 삭제
	 * @author 신지은
	 */
	@Delete("delete from qna where qnaId = #{qnaId}")
	void qnaDelete(Qna qna);
	
	/* 조회수 증가 */
	@Update("update qna set views = views + 1 where qnaId = #{qnaId}")
	Long qnaViewCnt(Long qnaId);
}