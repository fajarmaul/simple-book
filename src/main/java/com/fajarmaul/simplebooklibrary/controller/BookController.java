package com.fajarmaul.simplebooklibrary.controller;

import com.fajarmaul.simplebooklibrary.entity.Book;
import com.fajarmaul.simplebooklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book){
            return bookService.create(book);
    }
    @PutMapping("/{id}")
    public Book update(@PathVariable String id,@RequestBody Book book){
        book.setId(id);
        return bookService.update(book);
    }

    @GetMapping
    public Page<Book> getAll(Pageable pageable){
        return bookService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable String id){
        return bookService.getById(id);
    }
    @DeleteMapping("/{id}")
    //cara kedua buat path variable, intinya sama ambil id juga
    public boolean delete(@PathVariable("id") String bookId){
        return bookService.delete(bookId);
    }

}
