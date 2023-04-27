package com.example.jpa_relation_test.relation;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.entity.Purchase;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import com.example.jpa_relation_test.repository.PurchaseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class PurchaseTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PurchaseRepository purchaseRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("Purchase Entity 테스트")
    void test1() {

        Member member = new Member("서울시 관악구", "limslki333@hanmail.net", "슬기", "1234", "010-1234-5678");
        memberRepository.save(member);

        Book book = new Book("남궁성", "자바의 정석", 20000, 3);
        bookRepository.save(book);

        Purchase purchase = new Purchase();
        purchase.setMember(member);
        purchase.setBook(book);
        purchaseRepository.save(purchase);

    }
}
