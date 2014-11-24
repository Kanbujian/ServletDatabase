package com.FirstSeverlet.bean;

public class book {
	private int id;
	private String name;
	private double price;
	private int bookCount;
	private String author;

	public book(){
		id=0;
		name=null;
		price=0;
		bookCount=0;
		author=null;
	}

	public book(int id, String name, double price, int bookCount, String author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.bookCount = bookCount;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
