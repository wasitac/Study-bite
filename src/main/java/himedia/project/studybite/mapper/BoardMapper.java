package himedia.project.studybite.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.dto.FileBoard;
/**
 * @author 신지은
 */
public interface BoardMapper {
	/**
	 * 파일 저장
	 */
	@Insert("insert into fileBoard(filename, originName, filepath, filetype, qnaId, newsId) values(#{filename}, #{originName}, #{filepath}, #{filetype}, #{qnaId}, #{newsId})")
	void fileSave(FileBoard fileBoard);
	
	/**
	 * Qna 저장한 파일 조회
	 */
	@Select("select * from fileBoard where qnaId = #{qnaId}")
	Optional<FileBoard> findQnaFile(@Param("qnaId") Long qnaId);
	
	/**
	 * News(강의 공지) 저장한 파일 조회
	 */
	@Select("select * from fileBoard where newsId = #{newsId}")
	Optional<FileBoard> findNewsFile(@Param("newsId") Long newsId);
	
	/**
	 * 저장한 파일 수정
	 */
	@Update("update fileBoard set filename=#{filename}, originName = #{originName}, "
			+ "filepath=#{filepath}, qnaId =#{qnaId}, newsId=#{newsId} where id=#{id}")
	int fileUpdate(FileBoard fileBoard);
	
	/**
	 * 저장한 강의 공지 파일 삭제
	 */
	@Delete("delete from fileBoard where newsId = #{newsId}")
	int newsFileDelete(FileBoard fileBoard);
	
	/**
	 * 저장한 질의 응답 파일 삭제
	 */
	@Delete("delete from fileBoard where qnaId = #{qnaId}")
	int qnaFileDelete(FileBoard fileBoard);
	
}