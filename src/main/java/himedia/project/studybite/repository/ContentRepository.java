package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Content;
import himedia.project.studybite.domain.ContentData;

@Repository
public interface ContentRepository {
		
	//강의 강좌 목록 조회 (이미지(보류), 강좌명 리스트)
	@Select("select * from content where courseId =#{courseId}")
	List<Content> contentsInfo(Long courseId);
	
	// 강좌명 조회(content테이블에서)
	@Select("select * from content where contentId = #{contentId}")
	Optional<Content> findContentName(Long contentId);
	
	//강의 콘텐츠(이미지, 영상) 가져오기(contentData에서)
	@Select("select contentUrl from contentData where contentId = #{contentId}")
	Optional<ContentData> findContentUrl(Long contentId);
}