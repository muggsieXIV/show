package com.bww.myBooks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bww.myBooks.models.Book;
import com.bww.myBooks.services.BookService;

@Controller
public class BooksController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("book") Book book) {
		return "index.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("We had an error");
			return "index.jsp";
		}
		
		bookService.updateBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/books")
	public String showAll(Model model) {
		model.addAttribute("allBooks", bookService.allBooks());
		return "books.jsp";
	}
	
	@RequestMapping("/books/{id}/show")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	System.out.println("Submitted edit!");
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
}