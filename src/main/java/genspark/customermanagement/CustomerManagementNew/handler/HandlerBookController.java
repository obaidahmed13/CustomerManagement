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
public class HandlerBookController {

    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.getAllBooks(..))")
    public void getAllBooksBefor() {
        log.info("before getting all Book Controller layer");
    }

    @AfterReturning(pointcut = "execution(* genspark.customermanagement.CustomerManagementNew.Controller.CustomerController.getAllBooks(..))", returning = "result")
    public void getAllBooksAfterReturn(String result) {
        if(result == "showBooks.html"){
            log.info("getting all Custmor Controller layer and direct to showBooks.html " );
        }
//        else if (result.equals("showBooks")){
//            log.info("getting all Custmor Controller layer ");
//        }
        else {log.info("no result found");}

    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.getAllBooksByTitleOrder(..))")
    public void getAllBooksByTitleOrderBefor() {
        log.info("method getAllBooksByTitleOrder Book Controller layer called");
    }

    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.getBookById(..))")
    public void getBookByIdBefor() {
        log.info("method getBookById Book Controller layer called");
    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.getBookByTitle(..))")
    public void getBookByTitleBefor() {
        log.info("method getBookByTitle Book Controller layer called");
    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.addBook(..))")
    public void addBookBefor() {
        log.info("method addBook Book Controller layer  called");
    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.updateBook(..))")
    public void updateBookBefor() {
        log.info("method updateBook Book Controller layer  called");
    }
    @Before("execution(* genspark.customermanagement.CustomerManagementNew.controller.BookController.deleteBooksById(..))")
    public void deleteBooksByIdBefor() {
        log.info("method deleteBooksById Book Controller layer called");
    }

}
