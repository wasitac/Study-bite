package himedia.project.studybite.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.studybite.dto.Qna;

/**
 * @author 김민혜
 */
public interface QnaMapper {
	/**
	 * @author 김민혜
	 */
	// 질의 응답 목록
	List<Qna> findQnaPage(@Param("courseId") Long courseId, @Param("pageNum") Integer pageNum);

	/**
	 * @author 김민혜
	 */
	// 질의 응답 상세
	@Select("select * from qna where qnaId = #{qnaId}")
	Optional<Qna> findQnaDesc(Long qnaId);

	/**
	 * @author 김민혜
	 */
	/* 질의 응답 등록 */
	@Insert("insert into qna(courseId, userId, userName, title, description, views, date, answer) values (#{courseId}, #{userId}, #{userName}, #{title}, #{description}, 0, now(), #{answer})")
	@Options(useGeneratedKeys = true, keyProperty = "qnaId")
	void question(Qna qna);

	/**
	 * @author 김민혜
	 */
	// 질의 응답 답변 등록
	@Update("UPDATE qna SET answer = #{answer} where qnaId = #{qnaId}")
	void answer(Qna qna);

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

	/**
	 * @author 김민혜
	 */
	// 조회수
	@Update("update qna set views = views + 1 where qnaId = #{qnaId}")
	Long qnaViewCnt(Long qnaId);

	/**
	 * @author 김민혜
	 */
	// 글 개수
	@Select("select count(qnaId) from qna where courseId = #{courseId}")
	int cntQna(Long courseId);

}