package com.se.Tlog.global.response.success;

public record SuccessRes<T> (
int status,
String message,
T data // 필수 X
){
public static SuccessRes<?> from(SuccessType success) {
    return new SuccessRes<>(success.getStatusCode(), success.getMessage(), null);
}

public static <T> SuccessRes<T> from(T data) {
    return new SuccessRes<T>(SuccessType.OK.getStatusCode(), SuccessType.OK.getMessage(), data);
}

public static <T> SuccessRes<T> of(SuccessType success, T data) {
    return new SuccessRes<T>(success.getStatusCode(), success.getMessage(), data);
}
}
