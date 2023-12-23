package himedia.project.studybite.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class Qna {
	private Long qnaId;
	private Long courseId;
	private String userName;
	private String title;
	private String description;
	private Integer views;
	private Date date;
	private String answer;
	
	public Long getQnaId() {
		return qnaId;
	}
	
	public void setQnaId() {
		this.qnaId = qnaId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setQnaId(Long qnaId) {
		this.qnaId = qnaId;
	}
}
