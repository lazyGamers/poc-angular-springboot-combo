package com.lazygamers.poc.services;

import java.util.List;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.lazygamers.poc.models.News;

@Service
public class NewsService {

	/*
		This class is of type service and is meant for business logic. Usually, you would use DAO class here to get data
		from database, but I will simulate it with ArrayList for the sake of this project.
	*/

	private List<News> news = new ArrayList<>();

	@PostConstruct
	private void init() {
		this.news.add(new News(1, "First news", "This is the content of first news, which should be longer than title", "John Smith"));
		this.news.add(new News(2, "Second news", "This is the content of second news, which should be longer than title", "Ann Combray"));
		this.news.add(new News(3, "Third news", "This is the content of third news, which should be longer than title", "Boris Brejcha"));
		this.news.add(new News(5, "Fifth news", "The fourth is not here, because it was deleted from database or something", "John Smith"));
		this.news.add(new News(6, "Sixth news", "This is the content of sixth news, which should be longer than title", "John Smith"));
	}

	public News getById(int id) {
		List<News> filteredNews = this.news.stream().filter(n -> n.id == id).collect(Collectors.toList());
		if (filteredNews.size() >= 1) {
			return filteredNews.get(0);
		}
		return null;
	}

	public List<News> getAll() {
		return this.news;
	}

}