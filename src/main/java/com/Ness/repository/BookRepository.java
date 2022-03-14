package com.Ness.repository;

import com.Ness.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value="select * from Book b where b.title like %:keyword%", nativeQuery = true)
    List<Book> findByTittle(@Param("keyword") String keyword);

    @Query(value="SELECT * FROM Book ORDER BY author,title ASC ", nativeQuery = true)
    List<Book> sortAscByAuthorAndTitle();
}
//@Param("author") String author, @Param("title") String title