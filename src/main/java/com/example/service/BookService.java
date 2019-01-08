package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LibraryDao;
import com.example.model.Book;

@Service
public class BookService {
	
	@Autowired
	LibraryDao librarydao;
	
	public boolean add(Book book)
	{
		return librarydao.Add(book);
	}
	
	public List<Book> getallbooks()
	{
		return librarydao.getAllbooks();
	}
	
	public Book getbookwithid(long bookid)
	{
		return librarydao.getBook(bookid);
	}

	public boolean bookdelete(long num) {
		return librarydao.deletebook(num);
	}
	
	
	
	
	
	
}
