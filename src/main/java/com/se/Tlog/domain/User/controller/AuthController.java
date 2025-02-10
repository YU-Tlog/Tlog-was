package com.se.Tlog.domain.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.Tlog.domain.User.SsoType;
import com.se.Tlog.domain.User.Service.AuthenticationService;
import com.se.Tlog.domain.User.dto.SsoLoginRequest;
import com.se.Tlog.global.exception.CustomException;
import com.se.Tlog.global.response.error.ErrorType;
import com.se.Tlog.global.response.success.SuccessRes;
import com.se.Tlog.global.response.success.SuccessType;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	private final AuthenticationService authService;
	
	@GetMapping("/sso/login/kakao")
	public ResponseEntity<SsoLoginRequest> getSsoLoginByKakao() {
		return ResponseEntity.ok(authService.getSsoLoginRequest(SsoType.KAKAO));
	}

	@GetMapping("/sso/login/google")
	public ResponseEntity<SsoLoginRequest> getSsoLoginByGoogle() {
		return ResponseEntity.ok(authService.getSsoLoginRequest(SsoType.GOOGLE));
	}

	@GetMapping("/sso/callback/kakao")
	public ResponseEntity<?> getSsoCallbackByKakao(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "error", required = false) String error) {
		if (error != null)
			throw new CustomException(ErrorType.SSO_LOGIN_FAIL);
		
		authService.checkSsoAuthCode(SsoType.KAKAO, code);
		return ResponseEntity
                .status(SuccessType.LOGIN_SSO_SUCCESS.getStatus())
                .body(SuccessRes.from(SuccessType.LOGIN_SSO_SUCCESS));
	}

	@GetMapping("/sso/callback/google")
	public ResponseEntity<?> getSsoCallbackByGoogle(
			@RequestParam(name = "code", required = false) String code,
			@RequestParam(name = "error", required = false) String error) {
		if (error != null)
			throw new CustomException(ErrorType.SSO_LOGIN_FAIL);
		
		authService.checkSsoAuthCode(SsoType.GOOGLE, code);
		return ResponseEntity
                .status(SuccessType.LOGIN_SSO_SUCCESS.getStatus())
                .body(SuccessRes.from(SuccessType.LOGIN_SSO_SUCCESS));
	}
}
