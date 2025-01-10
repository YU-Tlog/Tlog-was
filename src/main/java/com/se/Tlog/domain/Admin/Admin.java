package com.se.Tlog.domain.Admin;

import com.se.Tlog.domain.User.Entity.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String adminId;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    @Builder
    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
        this.role = Role.ADMIN;
    }
}
