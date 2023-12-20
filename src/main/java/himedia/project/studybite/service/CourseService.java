package himedia.project.studybite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.project.studybite.domain.News;
import himedia.project.studybite.repository.NewsRepository;

@Service
public class CourseService {
	
	private final NewsRepository newsRepository;
	
	@Autowired
	public CourseService(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	
	public List<News> findNewsPage(Long courseId) {
		return newsRepository.findNewsPage(courseId);
	}
	
	public Optional<News> findNewsDesc(Long newsId) {
		return newsRepository.findNewsDesc(newsId);
	}

}
