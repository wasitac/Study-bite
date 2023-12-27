package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.FileBoard;
/**
 * @author 신지은
 */
@Repository
public interface BoardRepository {
	/**
	 * 질문 파일 저장
	 */
	@Insert("insert into fileBoard(filename, filepath, qnaId, newsId, noticeId) values(#{filename}, #{filepath}, #{qnaId}, #{newsId}, #{noticeId});")
	void save(FileBoard fileBoard);
	
	/**
	 * Qna 저장한 파일 조회
	 */
	@Select("select * from fileBoard where qnaId = #{qnaId}")
	Optional<FileBoard> findQnaFile(@Param("qnaId")Long qnaId);
	
	/**
	 * News(강의 공지) 저장한 파일 조회
	 */
	@Select("select * from fileBoard where newsId = #{newsId}")
	Optional<FileBoard> findNewsFile(@Param("newsId")Long newsId);
	
	/**
	 * Notice 저장한 파일 조회
	 */
	@Select("select * from fileBoard where noticeId = #{noticeId}")
	Optional<FileBoard> findNoticeFile(@Param("noticeId")Long noticeId);
}
