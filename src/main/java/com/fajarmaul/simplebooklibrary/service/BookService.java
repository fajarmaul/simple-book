package com.fajarmaul.simplebooklibrary.service;

import com.fajarmaul.simplebooklibrary.entity.Book;
import com.fajarmaul.simplebooklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book){
        //Insert to DB processing
        book.setId(UUID.randomUUID().toString());
        if(book.getTitle().isEmpty()){
            return null;
        }
        else{
            return bookRepository.save(book);
        }
    }
    public Book update(Book book){
        Book db = bookRepository.findOne(book.getId());

//        if(book.getTitle() == null){
//            db.setTitle(db.getTitle());
//        }
//        else if (book.getAuthor() == null){
//            db.setAuthor(db.getAuthor());
//        }
//        else if (book.getAuthor() == null){
//            db.setAuthor(db.getAuthor());
//        }


        db.setTitle(book.getTitle());
        db.setAuthor(book.getAuthor());
        db.setIsbn(book.getIsbn());
        db.setHeight(book.getHeight());
        db.setPagenumber(book.getPagenumber());
        db.setPublishedDate(book.getPublishedDate());
        db.setWidth(book.getWidth());

        return bookRepository.save(db);
    }

    public Page<Book> getAll(org.springframework.data.domain.Pageable pageable){

        return bookRepository.findAll(pageable);
    }

    public Book getById(String id){
       return bookRepository.findOne(id);
    }

    public boolean delete(String id){
        return false;
    }
}
