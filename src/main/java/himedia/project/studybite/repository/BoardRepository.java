package himedia.project.studybite.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.FileBoard;

@Repository
public interface BoardRepository {
	
	@Insert("insert into fileBoard(category, id, filename, filepath) values(#{category}, #{qnaId}, #{filename}, #{filepath} )")
	void save(FileBoard fileBoard);
	
	@Select("select * from fileBoard")
	FileBoard findFile();
}
