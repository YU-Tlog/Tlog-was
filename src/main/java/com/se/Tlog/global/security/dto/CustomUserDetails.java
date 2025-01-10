package com.se.Tlog.global.security.dto;

import com.se.Tlog.domain.User.Entity.Role;
import com.se.Tlog.global.exception.CustomException;
import com.se.Tlog.global.response.error.ErrorType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public interface CustomUserDetails extends UserDetails {
    String getId();

    boolean hasRole(Role role);

    default String getSingleAuthority() {
        return getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElseThrow(()-> new CustomException(ErrorType.ROLE_NOT_FOUND));
    }
}
