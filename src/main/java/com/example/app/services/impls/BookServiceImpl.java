package com.example.app.services.impls;

import com.example.app.exceptions.BookNotFoundException;
import com.example.app.models.Book;
import com.example.app.repositories.BookRepository;
import com.example.app.services.BookService;
import com.example.app.utils.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveOrUpdate(Book book) {
        Book savedbook;
        if (book.getId() != null && bookRepository.existsById(book.getId())) {
            savedbook = bookRepository.findById(book.getId()).get();
            savedbook.setTitle(book.getTitle());
            savedbook.setAuthor(book.getAuthor());
            savedbook.setDate(book.getDate());
            savedbook.setId(book.getId());
            log.info("Updated: {}",savedbook);
        } else {
            savedbook = book;
            savedbook.setId(StringHelper.generateId());
            log.info("Saved: {}",savedbook);
        }
        return bookRepository.save(savedbook);

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        log.info("FindById: {}",findById(id));
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book Not Found"));
    }

    @Override
    public void deleteById(String id) {

        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            log.info("Deleted: {}",id);
        } else {
            throw new BookNotFoundException("BookNotFoundById");
        }
    }
}
