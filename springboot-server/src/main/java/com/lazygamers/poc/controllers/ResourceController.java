package com.lazygamers.poc.controllers;

import com.lazygamers.poc.models.News;
import com.lazygamers.poc.services.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// denote class as rest controller (so it wont send html, but just data) and assign prefix /api to all endpoints in it
@RestController
@RequestMapping("/api")
public class ResourceController {

	// we inject NewsService with Spring CDI (it takes care of managing objects for us)
	@Autowired
	private NewsService newsService;

	// will respond to GET /api/resources and return list of news
	@GetMapping("/resources")
	public ResponseEntity<List<News>> getAll() {
		return ResponseEntity.ok(newsService.getAll());
	}

	// will respond to GET /api/resources/:id and return news with requested id
	@GetMapping("/resources/{id}")
	public ResponseEntity<News> getAll(@PathVariable("id") int id) {
		News news = newsService.getById(id);
		if (news == null) {
			// to handle not found values I am returning empty object, but in real app I would throw error.
			// this error would then be caught by runtime and transformed into response, so this is just a hack for sake of project.
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new News());
		}
		return ResponseEntity.ok(news); // returns with code 200
	}	

}