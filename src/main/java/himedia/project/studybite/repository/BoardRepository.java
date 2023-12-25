package himedia.project.studybite.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.FileBoard;

@Repository
public interface BoardRepository {
	
	@Insert("insert into fileBoard(category, id, filename, filepath) values(#{category}, #{id}, #{filename}, #{filepath} )")
	void save(FileBoard fileBoard);
	
	@Select("select * from fileBoard where category=#{category} and id = #{qnaId}")
	Optional<FileBoard> findFile(@Param("category") int category, @Param("qnaId")Long qnaId);
}
