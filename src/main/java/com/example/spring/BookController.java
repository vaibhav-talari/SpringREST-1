package com.example.spring;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Book;
import com.example.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BookController {

	@Autowired
	BookService service;

	@ModelAttribute("booksadd")
	public Book create() {
		return new Book();
	}

	/*@GetMapping("/addbook")
	public String addbookview() {
		return "book/addbook";
	}

	// for adding book with form

	@PostMapping("/addbook")
	public String addbookmethod(@ModelAttribute("booksadd") @Valid Book book, BindingResult error) {
		if (error.hasErrors()) {
			return "book/addbook";
		} else {
			service.add(book);
			System.out.print("New Book Added-" + book);
			return "book/booksavedmessage";
		}
	}
*/
	// add book with json data i.e. with POSTMAN app data iss added with this method

	
	  @PostMapping(value = "addbook", consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	  @ResponseBody
	  @CrossOrigin 
	  public ResponseEntity<Book> createbook(@RequestBody @Valid Book books) 
	  { 
		  System.out.println(books);
	  boolean isadded = service.add(books);
	  HttpStatus hs = isadded ? HttpStatus.CREATED : HttpStatus.SERVICE_UNAVAILABLE; 
	  
	  if(isadded)
		  {
		  return ResponseEntity.status(hs).body(books);
		  }
	  else
	  {
		  return ResponseEntity.status(hs).build();
	  }
	  
	  }
	 

	@GetMapping("/getbooks")
	@ResponseBody
	@CrossOrigin
	public List<Book> viewallbooks() {
		return service.getallbooks();
	}

	// dispaly single book in html page

	/*@RequestMapping(value = "/getbooks/{num}", method = RequestMethod.GET)
	public ModelAndView dispsinglebook22(@PathVariable long num) {
		Book test;
		System.out.print("Book to find with ID:" + num);
		test = service.getbookwithid(num);
		System.out.println(test);
		return new ModelAndView("book/showsinglebook", "list", test);

	}*/

	@GetMapping("/getbook/{num}")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Book> getbookwithid(@PathVariable long num) {
		Book test = service.getbookwithid(num);
		System.out.print("Book to find with ID:" + num);
		System.out.println("Book with required ID:" + test);
		if (test != null) {
			return ResponseEntity.status(HttpStatus.OK).body(test);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("book", "No Book found with given ID").build();
		}
	}

	@PutMapping("/updatebook/{num}")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Book> updatebookwithid(@PathVariable long num, @RequestBody Book book) {
		Book test = service.getbookwithid(num);
		if (test != null) {
			System.out.println("Valid Book with ID:" + num);
			test.setTitle(book.getTitle());
			test.setPrice(book.getPrice());
			test.setVolume(book.getVolume());
			test.setPublishDate(book.getPublishDate());
			System.out.println("New Book to add through REST-" + test);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(test);
		} else {
			System.out.println("Invalid Book with ID:" + num);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}

	@DeleteMapping("/deletebook/{num}")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Book> deletebookwithid(@PathVariable long num) {
		Book test = service.getbookwithid(num);
		if (test != null) {
			System.out.println("Valid Book with ID:" + num);
			boolean isremoved = service.bookdelete(num);
			HttpStatus hs = isremoved ? HttpStatus.ACCEPTED : HttpStatus.OK;
			return ResponseEntity.status(hs).body(test);
		} else {
			System.out.println("Invalid Book with ID:" + num);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}
}
