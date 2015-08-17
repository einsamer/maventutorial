package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.src.entity.Book;
import com.src.model.BookDAOImp;

@Controller
@RequestMapping(value = "/book")
public class BookStoreController {

	@Autowired
	private BookDAOImp bookDAOImp;

	@RequestMapping(value = "/welcome")
	public String greeting() {
		System.out.println(bookDAOImp.toString());

		return "welcomepage";
	}

	@RequestMapping(value = "listbook")
	public ModelAndView getListBook() {

		ModelAndView listbookpage = new ModelAndView("listbookpage");

		List<Book> listbook = bookDAOImp.getAllBook();
		listbookpage.addObject("listbook", listbook);

		return listbookpage;
	}

}
