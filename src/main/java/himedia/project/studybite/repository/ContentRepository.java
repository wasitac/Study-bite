package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Content;

@Repository
public interface ContentRepository {

	//강의 개요 조회
	//ContentData courseOutline();
		
	
	
	//강의 강좌 목록 조회 (이미지(보류), 강좌명 리스트)
	@Select("select * from content where courseId =#{courseId}")
	List<Content> contents(Long courseId);
	
	// 강좌명 조회
	@Select("select * from content where contentId = #{contentId}")
	Optional<Content> findContentName(Long contentId);
	
	//강의 콘텐츠(이미지, 영상) 가져오기
	
}
