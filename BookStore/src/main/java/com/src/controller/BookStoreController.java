package com.src.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import com.src.entity.BookMON;
import com.src.model.BookDAOImp;
import com.src.model.BookMONImp;
import com.src.model.BookRepository;

@Controller
@RequestMapping(value = "/book")
public class BookStoreController {

	HttpServletResponse reponse;

	private static final Logger logger = Logger.getLogger(BookStoreController.class);

	@Autowired
	private BookDAOImp bookDAOImp;
	
	@Autowired
	BookMONImp bookMONImp;
	
	@Autowired
	private BookRepository bookRepository;


	public void addHeader(HttpServletResponse res) {

		this.reponse = res;
		this.reponse.addHeader("Access-Control-Allow-Headers",
				"origin, content-type, accept, x-requested-with, my-cool-header");
		this.reponse.addHeader("Access-Control-Max-Age", "60"); // seconds
		// to
		// cache
		// preflight
		// request
		// -->
		// less
		// OPTIONS
		// traffic
		this.reponse.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		this.reponse.addHeader("Access-Control-Allow-Origin", "*");

	}

	@RequestMapping(value = {"/","/welcome"})
	public String greeting() {

		return "welcomepage";
	}

	@RequestMapping(value = "/listbook")
	public ModelAndView getListBook() {

		ModelAndView listbookpage = new ModelAndView("listbookpage");

		List<Book> listbook = bookDAOImp.getAllBook();
		listbookpage.addObject("listbook", listbook);

		return listbookpage;
	}

	@RequestMapping(value = "/addbook")
	public ModelAndView addbook() {
		ModelAndView addbookpage = new ModelAndView("addbookpage");
		Book book = new Book();

		addbookpage.addObject("book", book);
		return addbookpage;

	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addbook(@Valid @ModelAttribute Book book, BindingResult rs) {
		if (rs.hasErrors()) {
			return "addbookpage";
		} else {
			bookDAOImp.saveOrUpdate(book);
			return "redirect:/book/listbook";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookDAOImp.delete(id);

		return "redirect:/book/listbook";
	}

	/*
	 * @RequestMapping(value = "/update/{id}") public ModelAndView
	 * updatebook( @PathVariable int id,
	 * 
	 * @PathVariable String name,
	 * 
	 * @PathVariable String author,
	 * 
	 * @PathVariable String imgurl){ ModelAndView updatepage = new
	 * ModelAndView("updatepage");
	 * 
	 * Book book = new Book(id, name, author, imgurl);
	 * 
	 * updatepage.addObject("book", book); return updatepage; }
	 */

	@RequestMapping(value = "/update")
	public ModelAndView updatebook(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
			@RequestParam(value = "author") String author, @RequestParam(value = "url") String imgurl) {
		ModelAndView updatepage = new ModelAndView("updatepage");

		Book book = new Book(id, name, author, imgurl);

		updatepage.addObject("book", book);
		return updatepage;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatebook(@Valid @ModelAttribute Book book, BindingResult rs) {
		if (!rs.hasErrors()) {
			bookDAOImp.saveOrUpdate(book);
			return "redirect:/book/listbook";
		} else {
			return "updatepage";
		}

	}

	@RequestMapping(value = "/search")
	@ResponseBody
	public List<Book> search(@RequestParam(value = "key") String key, HttpServletResponse res) {
		List<Book> listbook = bookDAOImp.getAllBookWithKey(key);

		this.addHeader(res);

		return listbook;
	}

	@RequestMapping(value = "/listajs")
	public ModelAndView getPageBookAJS() {

		if (logger.isDebugEnabled()) {
			logger.debug("Book Controller is processing!");
		}

		ModelAndView listbookpageajs = new ModelAndView("listbookpageajs");
		return listbookpageajs;
	}

	@RequestMapping(value = "/getlistajs")
	@ResponseBody
	public List<Book> getListBookAJS(HttpServletResponse res) {
		List<Book> listbook = bookDAOImp.getAllBook();

		this.addHeader(res);
		return listbook;
	}

	/**
	 * this part show result from MongoDB
	 */

	@RequestMapping(value = "/listmongo")
	public String getListBookFromMongoDb() {
		

		return "listmongopage";
	}
	
	@RequestMapping(value = "/listbooksmongo")
	@ResponseBody
	public List<BookMON> getlistMongo(HttpServletResponse res){

		List<BookMON> books = bookRepository.findAll();
		if (books.size() > 0) {
			System.out.println(books.get(0).toString());
		} else {
			System.out.println(books.toString());
		}
		
		this.addHeader(res);
		
		return books;
	}
	@RequestMapping(value = "/mongoupdate")
	public ModelAndView updatebookmongo(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
			@RequestParam(value = "author") String author, @RequestParam(value = "url") String imgurl,
			@RequestParam(value = "rid") String rid) {
		ModelAndView updatemongopage = new ModelAndView("updatemongopage");
		BookMON bookMON = new BookMON(rid, id, name, author, imgurl);

		System.out.println(bookMON.get_id());
		
		updatemongopage.addObject("bookMON", bookMON);
		return updatemongopage;
	}
	
	@RequestMapping(value = "/mongoupdate", method = RequestMethod.POST)
	public String updatebooktomongodb(@Valid @ModelAttribute BookMON book, BindingResult rs) {
		
		if (!rs.hasErrors()) {
			
			System.out.println(book.get_id() + " : " + book.getBookid());
			//bookRepository.save(book);
			//bookRepository.save(book);
			return "redirect:/book/listmongo";
		} else {
			return "mongoupdate";
		}
		
	}
}
