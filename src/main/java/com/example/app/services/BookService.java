package com.example.app.services;

import com.example.app.models.Book;

import java.util.List;

public interface BookService {

    Book saveOrUpdate(Book book);
    List<Book> findAll();
    Book  findById(String id);
    void deleteById(String id);

}
