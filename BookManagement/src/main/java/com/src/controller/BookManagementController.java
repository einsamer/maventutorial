package com.src.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.src.entity.Book;
import com.src.model.BookDAOImp;

@Controller
@RequestMapping(value = "/bookmng")
public class BookManagementController {
	
	@Autowired
	BookDAOImp bookDAOImp;

	@RequestMapping(value = "/welcome")
	public ModelAndView salute() {
		ModelAndView welcomepage = new ModelAndView("welcomepage");
		return welcomepage;
	}
	
	@RequestMapping(value = "/listbook")
	public ModelAndView getListBook() {
		ModelAndView listbookpage = new ModelAndView("listbookpage");
		
		List<Book> listbook = bookDAOImp.getBook();
		
		listbookpage.addObject("listbook", listbook);
		
		return listbookpage;
	}
	
	@RequestMapping ("/addnewbook")
	public ModelAndView addnewbook() {
		
		ModelAndView md = new ModelAndView("addnewbook");
		Book book = new Book();
		
		md.addObject("book", book);
		return md;
		
	}
	
	@RequestMapping (value = "/addbook", method = RequestMethod.POST)
	public String addbook(
			@Valid @ModelAttribute Book book,
			BindingResult rs
			) {
		if (!rs.hasErrors()){
			bookDAOImp.insertBook(book.getBookname(), book.getBookimgurl(), book.getBookprice());
			return "redirect:/bookmng/listbook";
		} else {
			return "addnewbook";
		}
		
		
		
	}
	
	@RequestMapping (value = "/delete", method = RequestMethod.GET)
	public String deletebook(
			@RequestParam(value = "id") int id 
			) {
		
		bookDAOImp.deleteBook(id);
		return "redirect:/bookmng/listbook";
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam(value = "id") int id,
								@RequestParam(value = "name") String name,
								@RequestParam(value = "url") String url,
								@RequestParam(value = "price") int price) {
		
		ModelAndView updatepage = new ModelAndView("updatepage");
		Book book = new Book();
		book.setBookid(id);
		book.setBookname(name);
		book.setBookimgurl(url);
		book.setBookprice(price);
		updatepage.addObject("book", book);
		return updatepage;
		
	}
	@RequestMapping (value = "/updatebook", method = RequestMethod.POST)
	public String updatebook(
			@ModelAttribute Book book
			) {
		
		bookDAOImp.updateBook(book);
		System.out.println(book.getBookid());
		return "redirect:/bookmng/listbook";
		
	}
	
	@RequestMapping(value = "/jsonbook/{id}/{name}/{link}/{price}")
	public @ResponseBody Book jsonGetBook(@PathVariable int id,
												@PathVariable String name,
												@PathVariable String link,
												@PathVariable int price) {
		Book book = new Book(id, name,link, price);
		
		return book;
	}
	
	@RequestMapping(value = "/jsonlistbook")
	public @ResponseBody List<Book> jsonGetListBook() {
		List<Book> listbook = bookDAOImp.getBook();
		
		return listbook;
	}
}
