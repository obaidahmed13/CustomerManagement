package genspark.customermanagement.CustomerManagementNew.controller;



import genspark.customermanagement.CustomerManagementNew.entity.Book;
import genspark.customermanagement.CustomerManagementNew.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class BookController {

    @Autowired
    BookService service;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/")
    public String getPublic(){
        return "public";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = service.getAllBooks();
        System.out.println(books.size());
        model.addAttribute("books", books);
        return "showBooks";
    }

    @GetMapping("/books/sorted")
    public String getAllBooksByTitleOrder(Model model) {
        List<Book> books = service.getAllBooksByTitleOrder();
        model.addAttribute("books",books);
        return "showBooks";
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable long id,Model model) {
        logger.info("Getting book by ID: {}", id);

        Book result = service.getBookById(id);
        if (result == null) {
            logger.warn("Book not found");
        }
        logger.info("Book successfully found");
        model.addAttribute("books",result);
        return "showBooks";
    }

    @GetMapping("/books/{title}")
    public String getBookByTitle(@PathVariable String title, Model model) {
        logger.info("Getting book by title: {}", title);
        Book result = service.getBookByTitle(title);
        if (result == null) {
            logger.warn("Book not found");
            return null;
        }
        logger.info("Book successfully found");
        model.addAttribute("books",result);
        return "showBooks";
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book, Model model) {
        logger.info("Adding new book with title: {}", book.getTitle());
        // Check if book with given title already exists
        logger.info("Book successfully added");
        Book book1 = service.addBook(book);
        model.addAttribute("books",book);
        return "showBooks";
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Book book, Model model) {
        logger.info("Updating book with title: {}", book.getTitle());

        // Check if update target exists
        Book result = service.getBookById(book.getId());
        if (result == null) {
            logger.warn("Book does not exist");
        }
        logger.info("Book successfully updated");
        Book book1 = service.updateBook(book);
        model.addAttribute("books",book);
        return "showBooks";
    }

//    @PutMapping("/books/purchase/{id}")
//    public boolean purchaseBookById(@PathVariable long id) {
//        logger.info("Purchasing book with ID: {}", id);
//
//        Book result = service.getBookById(id);
//        // Check if book exists or if it's in stock
//        if (result == null || result.getQuantity() <= 0) {
//            logger.warn("Book not found or not in stock");
//
//        }
//
//        // Record purchase by decrementing quantity by 1
//        result.setQuantity(result.getQuantity() - 1);
//        if (service.updateBook(result) != null) {
//            logger.info("Book successfully purchased");
//            return true;
//        }
//
//        logger.warn("Book purchase failed");
//        return false;
//    }

    @DeleteMapping("/books/{id}")
    public String deleteBooksById(@PathVariable long id) {
        logger.info("Deleting book with ID: {}", id);

        // If count changed, then delete was successful
        if (service.deleteBookById(id)){
            logger.info("Book successfully deleted");
        }else {
            logger.info("Couldnt find book");
        }
        return "showBooks";
    }

}
