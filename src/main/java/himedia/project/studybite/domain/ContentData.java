package himedia.project.studybite.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ContentData {
	private Long contentId ;
	private String contentDataName;
	private String contentPicture;
	private String contentUrl;
}
