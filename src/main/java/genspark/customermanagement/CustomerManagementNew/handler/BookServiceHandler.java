package genspark.customermanagement.CustomerManagementNew.handler;

import genspark.customermanagement.CustomerManagementNew.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class BookServiceHandler {

    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getAllBooks())")
    public void getAllBooksBefor() {
        log.info(" getting all Book Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getAllBooks(..))", returning = "result")
    public void getAllBooksAfterReturn(List<Book> result) {
        if(result.size()>0){
            log.info("getting all Custmor service layer " );
        }
        else {log.info("no result found");}

    }

    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getAllBooksByTitleOrder())")
    public void getAllBooksByTitleOrderBefor() {
        log.info(" getting all Book Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getAllBooksByTitleOrder(..))", returning = "result")
    public void getAllBooksByTitleOrderAfterReturn(List<Book> result) {
        if(result.size()>0){
            log.info("getAllBooksByTitleOrder service layer " );
        }
        else {log.info("no result found");}

    }

    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getBookById(..))")
    public void getBookByIdBefor() {
        log.info(" getBookById Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getBookById(..))", returning = "result")
    public void getBookByIdAfterReturn(Book result) {
        if(result == null){

            log.info(" getBookById service layer no result found");

        }
        else {log.info("getBookById service layer " + result.toString());}

    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getBookByTitle(..))")
    public void getBookByTitleBefor() {
        log.info(" getBookById Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.getBookByTitle(..))", returning = "result")
    public void getBookByTitleAfterReturn(Book result) {
        if(result == null){

            log.info(" getBookByTitle service layer no result found");

        }
        else {log.info("getBookByTitle service layer " + result.toString());}

    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.addBook(..))")
    public void addBookBefor() {
        log.info(" addBook Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.addBook(..))", returning = "result")
    public void addBookAfterReturn(Book result) {
        if(result == null){

            log.info(" addBook service layer no book added");

        }
        else {log.info("addBook service layer " + result.toString());}

    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.updateBook(..))")
    public void updateBookBefor() {
        log.info(" addBook Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.updateBook(..))", returning = "result")
    public void updateBookAfterReturn(Book result) {
        if(result == null){

            log.info(" updateBook service layer no book updated");

        }
        else {log.info("updateBook service layer " + result.toString());}

    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.deleteBookById(..))")
    public void deleteBookByIdBefor() {
        log.info(" addBook Service layer will call ");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.service.BookService.deleteBookById(..))", returning = "result")
    public void deleteBookByIdReturn(boolean result) {
        if(!result){

            log.info(" deleteBookById service layer no book updated");

        }
        else {log.info("deleteBookById service layer " );}

    }

}
