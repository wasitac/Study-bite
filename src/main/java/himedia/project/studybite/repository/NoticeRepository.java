package himedia.project.studybite.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import himedia.project.studybite.domain.Notice;

@Repository
public interface NoticeRepository {
	// 공지사항 목록
	@Select("select * from notice order by noticeId desc limit #{pageNum}, 10")
	List<Notice> findPage(Integer pageNum);

	// 공지사항 상세
	@Select("select * from notice where noticeId = #{noticeId}")
	Optional<Notice> findNoticeDesc(Long noticeId);

	// 이전 글
	@Select("select * from notice where noticeId < #{noticeId} order by noticeId desc limit 1")
	Notice prev(Long noticeId);

	// 다음 글
	@Select("select * from notice where noticeId > #{noticeId} order by noticeId asc limit 1")
	Notice next(Long noticeId);

	// 조회수
	@Update("update notice set views = views + 1 where noticeId = #{noticeId}")
	Long viewcnt(Long noticeId);

	// 글 개수
	@Select("select count(noticeId) from notice")
	int cntNotice();
}
