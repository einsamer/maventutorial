package com.src.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.src.entity.Book;
import com.src.model.BookDAOImp;

@Controller
public class EmployeeManagementController {

	@RequestMapping("/welcome")
	public ModelAndView salute() {
		ModelAndView md = new ModelAndView("welcomepage");
		
		md.addObject("salute", "Welcome to Spring MVC with Maven!");
		return md;
	}
	
	@RequestMapping ("/bookstore")
	public ModelAndView getbook() {
		ModelAndView md = new ModelAndView("listbookpage");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BookDAOImp dao = (BookDAOImp) context.getBean("bookDAOImp");
		
		List<Book> listbook = dao.getBook();
		md.addObject("listbook", listbook);
		return md;
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
			@ModelAttribute Book book
			) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BookDAOImp dao = (BookDAOImp) context.getBean("bookDAOImp");
		
		dao.insertBook(book.getBookname(), book.getBookimgurl());
		
		return "redirect:/bookstore";
		
	}
	
	@RequestMapping (value = "/delete", method = RequestMethod.GET)
	public String deletebook(
			@RequestParam(value = "id") int id 
			) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BookDAOImp dao = (BookDAOImp) context.getBean("bookDAOImp");
		
		dao.deleteBook(id);
		return "redirect:/bookstore";
	}
	
	@RequestMapping ("/update")
	public ModelAndView update(@RequestParam(value = "id") int id,
								@RequestParam(value = "name") String name,
								@RequestParam(value = "url") String url) {
		
		ModelAndView md = new ModelAndView("updatepage");
		Book book = new Book();
		book.setBookid(id);
		book.setBookname(name);
		book.setBookimgurl(url);
		md.addObject("book", book);
		return md;
		
	}
	@RequestMapping (value = "/updatebook", method = RequestMethod.POST)
	public String updatebook(
			@ModelAttribute Book book
			) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BookDAOImp dao = (BookDAOImp) context.getBean("bookDAOImp");
		
		dao.updateBook(book);
		System.out.println(book.getBookid());
		return "redirect:/bookstore";
		
	}
	
}
