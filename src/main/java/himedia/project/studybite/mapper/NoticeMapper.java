package himedia.project.studybite.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import himedia.project.studybite.dto.Notice;

/**
 * @author 김민혜
 */
public interface NoticeMapper {
	/* 공지사항 목록 */
	@Select("select * from notice order by noticeId desc limit #{pageNum}, 10")
	List<Notice> findPage(Integer pageNum);

	/* 공지사항 상세 */
	@Select("select * from notice where noticeId = #{noticeId}")
	Optional<Notice> findNoticeDesc(Long noticeId);

	/* 이전 글 */
	@Select("select * from notice where noticeId < #{noticeId} order by noticeId desc limit 1")
	Notice prev(Long noticeId);

	/* 다음 글 */
	@Select("select * from notice where noticeId > #{noticeId} order by noticeId asc limit 1")
	Notice next(Long noticeId);

	/* 조회수 증가 */
	@Update("update notice set views = views + 1 where noticeId = #{noticeId}")
	Long viewcnt(Long noticeId);

	/* 글 개수 */
	@Select("select count(noticeId) from notice")
	int cntNotice();
	
	/* 글 검색 */
	List<Notice> search(@Param("search") String search, @Param("pageNum") Integer pageNum);
	
	/* 검색된 글 개수 */
	int cntSearchNotice(String search);
}



