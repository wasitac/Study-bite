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
	 * 파일 저장
	 */
	@Insert("insert into fileBoard(category, id, filename, filepath) values(#{category}, #{id}, #{filename}, #{filepath} )")
	void save(FileBoard fileBoard);
	
	/**
	 * 저장한 파일 조회
	 */
	@Select("select * from fileBoard where category=#{category} and id = #{qnaId}")
	Optional<FileBoard> findFile(@Param("category") int category, @Param("qnaId")Long qnaId);
}
