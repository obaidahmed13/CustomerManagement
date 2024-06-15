package genspark.customermanagement.CustomerManagementNew.service;


import genspark.customermanagement.CustomerManagementNew.entity.Book;
import genspark.customermanagement.CustomerManagementNew.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookDAO dao;

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public List<Book> getAllBooksByTitleOrder() {
        return dao.findAllByOrderByTitleAsc();
    }

    public Book getBookById(long id) {
        Optional<Book> result = dao.findById(id);

        if (result.isPresent())
            return result.get();
        return null;
    }

    public Book getBookByTitle(String title) {
        Optional<Book> result = dao.findByTitle(title);

        if (result.isPresent())
            return result.get();
        return null;
    }

    public Book addBook(Book book) {
        return dao.save(book);
    }

    public Book updateBook(Book book) {
        return dao.save(book);
    }

    public boolean deleteBookById(long id) {
        Optional<Book> result = dao.findById(id);

        if (result.isPresent()) {
            this.dao.deleteById(id);
            return true;
        }
        return false;
    }
}
