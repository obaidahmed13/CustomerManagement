package genspark.customermanagement.CustomerManagementNew.repository;


import genspark.customermanagement.CustomerManagementNew.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByTitleAsc();
    Optional<Book> findByTitle(String title);
}
