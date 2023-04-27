package com.example.jpa_relation_test.relation;

import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookStoreRepository bookStoreRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("1대N 단방향 테스트")
    void test1() {
        Member member = new Member("서울시 관악구", "limslki333@hanmail.net", "슬기", "1234", "010-1234-5678");
        memberRepository.save(member);

        Member member2 = new Member("서울시 동작구", "limseulki@naver.com", "임슬", "1234", "010-9876-5432");
        memberRepository.save(member2);

        BookStore bookStore = new BookStore("제주점", "항해서점");
        bookStoreRepository.save(bookStore);

        bookStore.addMemberList(member);
        bookStore.addMemberList(member2);
    }
}
