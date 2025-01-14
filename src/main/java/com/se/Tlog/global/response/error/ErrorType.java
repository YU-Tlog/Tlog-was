package com.se.Tlog.global.response.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    // 400 잘못된 요청
    CONTENT_NOT_FOUND(HttpStatus.BAD_REQUEST, "Content 내용이 비어있습니다."),
    ROLE_MISMATCH(HttpStatus.BAD_REQUEST,"Role 값을 잘못 입력하였습니다."),

    // 인증
    // 401
    UN_AUTHENTICATION(HttpStatus.UNAUTHORIZED, "인증이 실패되었습니다."),
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "로그인 실패입니다."),

    // 인가
    // 403
    UN_AUTHORIZATION(HttpStatus.FORBIDDEN, "허용되지 않은 접근입니다."),

    //데이터
    NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 데이터 입니다."),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND, "역할이 존재하지 않습니다."),
    //데이터 충돌


    // 서버 에러
    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 에러. 서버 팀으로 연락주시기 바랍니다.");


    private final HttpStatus status;
    private final String message;

    public int getStatusCode (){ return status.value();}

}
