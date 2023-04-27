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
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String author;
//
//    private String name;
//
//    private int price;
//
//    private long quantity;
//
//    @ManyToOne
//    @JoinColumn(name = "bookstore_id")
//    private BookStore bookStore;
//
//    public Book(String author, String name, int price, long quantity) {
//        this.author = author;
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public void setBookStore(BookStore bookStore) {
//        this.bookStore = bookStore;
//    }
//}

// 문제 2, 4
@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String name;

    private int price;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "bookstore_id")
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    private List<Purchase> purchaseList = new ArrayList<>();

    public Book(String author, String name, int price, long quantity) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }
}
