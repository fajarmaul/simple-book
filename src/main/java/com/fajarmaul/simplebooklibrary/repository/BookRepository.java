package com.fajarmaul.simplebooklibrary.repository;

import com.fajarmaul.simplebooklibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
    //<book, string> karena
}
