package com.example.model;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;




public class Book {
	
	@Min(0)
	private long bookid;
	
	@Pattern(regexp="^[a-zA-Z1-9 ]+$")
	private String title;
	
	@Min(1) 
	private double price;
	
	@Min(1)
	private int volume;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date publishDate;

	private LocalDate date;
	
	public long getBookid() {
		return bookid;
	}
	public void setBookid(long bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		System.out.println("Published date in Book.java-"+publishDate);
		this.publishDate = publishDate;
		date=this.publishDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Book() {}
	
	
	
	
	public Book(long bookid, String title, double price, int volume,Date publishDate,LocalDate date) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate=publishDate;
		this.date=date;
	}
	
	/*public Book(long bookid, String title, double price, int volume) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.volume = volume;
		
	}*/
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + ", date=" + date + "]";
	}
	
	
	
	
}
