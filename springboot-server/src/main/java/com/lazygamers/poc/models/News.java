package com.lazygamers.poc.models;

/*
	Class that will represent our data
*/

public class News {

	public int id;

	public String title;

	public String content;

	public String author;

	public News(int id, String title, String content, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public News() {

	}

}