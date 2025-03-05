package com.example.memorydb.book.service;


import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 방법② @RequiredArgsConstructor
public class BookService {

  /* 방법 ③  @Autowired
    private BookRepository bookRepository;*/
  private final BookRepository bookRepository;

   public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository; // 방법 ①
    }

    // create , update
    public BookEntity create(BookEntity book){
       return bookRepository.save(book);
    }

    // all
    public List<BookEntity> findAll(){
       return bookRepository.findAll();
    }

    // delete

    // find one
}
