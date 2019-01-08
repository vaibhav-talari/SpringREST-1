package com.example.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Book;

@Repository
public class LibraryDao {

	private List<Book> books=new ArrayList<>();
	LocalDate date=LocalDate.of(2011,12,20);
	Date day=java.sql.Date.valueOf(date);
	public boolean Add(Book book)
	{
		return books.add(book);
	}
	
	public List<Book> getAllbooks()
	{
		return books;
	}
	
	public Book getBook(long bookid)
	{
		Book id=null;
		for(Book bks:books)
		{
			if(bks.getBookid()==bookid)
			{
				id=bks;
			}
		}
		return id;
		
	}
	
	public LibraryDao() {
		books.add(new Book(101L, "Test 1", 500D,10,day,date));
		books.add(new Book(102L, "Test 2", 1500D,8,day,date));
		books.add(new Book(103L, "Test 3", 2500D,7,day,date));
		books.add(new Book(104L, "Test 4", 5500D,5,day,date));
	}

	public boolean deletebook(long num) {
		Book delete=null;
		for(int i=0;i<books.size();i++)
		{
			if(books.get(i).getBookid()==num)
			{
				delete=books.remove(i);
				break;
			}
		}
		if(delete!=null) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
	
	
	
	
	
	
}
