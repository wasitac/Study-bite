package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import himedia.project.studybite.domain.Qna;

@Repository
public interface QnaRepository {
	/**
	 * @author 김민혜
	 */	
	// 질의 응답 목록
	List<Qna> findQnaPage(@Param("courseId") Long courseId, @Param("pageNum") Integer pageNum);
	
	/**
	 * @author 김민혜
	 */	
	// 질의 응답 상세
	@Select ("select * from qna where qnaId = #{qnaId}")
	Optional<Qna> findQnaDesc(Long qnaId);
	
	/**
	 * @author 김민혜
	 */	
	// 질의 응답 등록
	@Insert ("insert into qna(courseId, userName, title, description, views, date) values (#{courseId}, '익명', #{title}, #{description}, 0 , now())")
	@Options(useGeneratedKeys = true, keyProperty = "qnaId")
	void question(Qna qna);
	
	/**
	 * @author 김민혜
	 */	
	// 질의 응답 답변 등록
	@Update("UPDATE qna SET answer = #{answer} where qnaId = #{qnaId}")
	void answer(Qna qna);
	
	/**
	 * @author 신지은 
	 */
	//질의 응답 조회
	//@Select("select * from qna where qnaId = #{}")
	//Qna selectQna(Long qnaId);
	
	
	/**
	 * @author 김민혜
	 */	
	// 조회수
	@Update("update qna set views = views + 1 where qnaId = #{qnaId}")
	Long qnaViewCnt(Long qnaId);
	
	// 글 개수
	@Select("select count(qnaId) from qna where courseId = #{courseId}")
	int cntQna(Long courseId);
	
}