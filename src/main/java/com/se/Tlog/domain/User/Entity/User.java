package com.se.Tlog.domain.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    private String userId;
    private String password;

    private String name;
    private String email;
    private String telephoneNumber;
    private Role role;

    @Builder
    public User(
            String name,
            String userId,
            String email,
            String telephoneNumber
    ) {
        this.name = name;
        this.userId = userId;
        //this.providerUserInfo = provider + " " + providerId;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.role = Role.USER;
    }
}
