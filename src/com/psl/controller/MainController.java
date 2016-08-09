package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psl.entity.Book;
import com.psl.exceptions.IntegrityVoilationException;
import com.psl.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping({ "/", "welcome" })
	public String main() {
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView insertBook(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("copies") String copies) {
		Book book = new Book();
		ModelAndView mv = new ModelAndView("add");
		if (id != "" && name != "" && author != "" && copies != "") {
			if (id.matches("[0-9]*") && name.matches("[A-Za-z0-9]*")
					&& name.matches("[A-Za-z0-9]*") && copies.matches("[0-9]*")) {
				book.setBookId(Integer.parseInt(id));
				book.setName(name);
				book.setAuthorName(author);
				book.setCopies(Integer.parseInt(copies));
				int i;

				try {
					i = mainService.addBook(book);
					if (i > 0) {
						mv.addObject("msg", "Successfull");
					} else {
						mv.addObject("msg", "Unsuccessful");
					}
				} catch (IntegrityVoilationException e) {
					mv.addObject("msg", "id already exists");
				}
			} else {
				mv.addObject("msg", "id=number string string number");
			}
			return mv;
		} else {
			mv.addObject("msg", "Enter Valid DATA");
			return mv;
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String insertBook1() {
		
		return "add";
	}

	@RequestMapping(value = "/getbook", method = RequestMethod.GET)
	public String Get() {
	
		return "getbook";
	}

	@RequestMapping(value = "/getbook", method = RequestMethod.POST)
	public ModelAndView getBooks(@RequestParam("id") String id) {

		ModelAndView mv2 = new ModelAndView("getbook");
		if (id != "") {
			if (id.matches("[0-9]*")) {
				try {
					int id1 = Integer.parseInt(id);
					if (id1 > 0) {
						Book book = mainService.getBook(id1);
						System.out.println(book);
						mv2.addObject("msg", "book info");
						mv2.addObject("book", book);
						return mv2;

					} else {
						mv2.addObject("msg", "failure");
						return mv2;
					}
				} catch (IntegrityVoilationException e) {
					return mv2.addObject("msg", "book doesnt exists");

				}
			} else {
				mv2.addObject("msg", "enter valid number");
				return mv2;
			}
		} else {
			mv2.addObject("msg", "enter valid id");
			return mv2;
		}

	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		
		return "update";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@RequestParam("id") String id,@RequestParam("copies") String copies){
		ModelAndView mv2 = new ModelAndView("update");
		if(id!="" && copies!=""){
			if(id.matches("[0-9]*")&& copies.matches("[0-9]*")){
				int id1=Integer.parseInt(id);
				int cop=Integer.parseInt(copies);
				try {
					int i=mainService.update(id1, cop);
					if(i>0){
						mv2.addObject("msg","updated");
					}
					else{
						mv2.addObject("msg","id not present");
					}
				} catch (IntegrityVoilationException e) {
					// TODO Auto-generated catch block
					System.out.println("update error");
				}
				return mv2;
			}
			else{
				mv2.addObject("msg","enter valid number ");
			    return mv2;
			}
		}else{
			mv2.addObject("msg","enter valid id");
			return mv2;
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		
		return "delete";
	}
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam("id") String id) throws IntegrityVoilationException {
		ModelAndView mv= new ModelAndView("delete");
		if(id !=""){
			if(id.matches("[0-9]*")){
				int id1=Integer.parseInt(id);
				int i=mainService.delete(id1);
				if(i>0){
					mv.addObject("msg","deleted");
				}
				else{
					mv.addObject("msg","not deleted");
				}return mv;
				
			}
			else{
				mv.addObject("msg","enter a number");
				return mv;
				
			}
		}else{
			mv.addObject("msg","enter valid input");
			return mv;
		}

		
	}
}