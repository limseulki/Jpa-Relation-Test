package com.example.jpa_relation_test.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//// 문제 1
//@Entity
//@Getter
//@NoArgsConstructor
//public class BookStore {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String location;
//
//    private String name;
//
//    public BookStore(String location, String name) {
//        this.location = location;
//        this.name = name;
//    }
//}

// 문제 2, 3
@Entity
@Getter
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private String name;

    @OneToMany(mappedBy = "bookStore")
    private List<Book> bookList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "bookstore_id")
    private List<Member> memberList = new ArrayList<>();

    public BookStore(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public void addBookList(Book book) {
        this.bookList.add(book);
    }

    public void addMemberList(Member member) {
        this.memberList.add(member);
    }
}