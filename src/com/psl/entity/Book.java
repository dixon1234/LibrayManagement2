package com.psl.entity;

public class Book {

	private int bookId;
	private String name;
	private String authorName;
	private int copies;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String name, String authorName, int copies) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.authorName = authorName;
		this.copies = copies;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=");
		builder.append(bookId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append(", copies=");
		builder.append(copies);
		builder.append("]");
		return builder.toString();
	}
	
	
}
