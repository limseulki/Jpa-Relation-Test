package com.example.jpa_relation_test.relation;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class ManyToOneTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookStoreRepository bookStoreRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 단방향 테스트")
    void test1() {
        Book book = new Book("남궁성", "자바의 정석", 20000, 3);
        bookRepository.save(book);
        Book book2 = new Book("이일민", "토비의 스프링", 30000, 2);
        bookRepository.save(book2);

        BookStore bookStore = new BookStore("제주점", "항해서점");
        bookStoreRepository.save(bookStore);

        book.setBookStore(bookStore);
        book2.setBookStore(bookStore);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 양방향 테스트")
    void test2() {
        Book book = new Book("남궁성", "자바의 정석", 20000, 3);
        bookRepository.save(book);
        Book book2 = new Book("이일민", "토비의 스프링", 30000, 2);
        bookRepository.save(book2);

        BookStore bookStore = new BookStore("제주점", "항해서점");
        bookStoreRepository.save(bookStore);

        bookStore.addBookList(book);
        bookStore.addBookList(book2);
    }

}
