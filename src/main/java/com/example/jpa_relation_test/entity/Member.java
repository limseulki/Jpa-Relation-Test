package com.example.jpa_relation_test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 문제 3, 4
@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String email;

    private String nickname;

    private String password;

    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchaseList = new ArrayList<>();

    public Member(String address, String email, String nickname, String password, String phoneNumber) {
        this.address = address;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
