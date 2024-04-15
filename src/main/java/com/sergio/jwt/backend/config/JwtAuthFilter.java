package com.sergio.jwt.backend.config;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.security.core.context.SecurityContextHolder.*;

// JwtAuthFilter는 OncePerRequestFilter를 확장하며, doFilterInternal 메서드가 각 요청당 정확히 한 번 호출되도록 합니다.
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    // 생성자 주입을 사용하여 UserAuthenticationProvider의 의존성을 주입합니다.
    private final UserAuthenticationProvider userAuthenticationProvider;

    // OncePerRequestFilter에서 doFilterInternal 메서드를 재정의하여 JWT 인증 로직을 구현합니다.
    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        // HTTP 요청에서 Authorization 헤더를 추출합니다.
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        // Authorization 헤더가 있는지 확인합니다.
        if (header != null) {
            // Authorization 헤더 값을 분할하여 토큰을 추출합니다.
            String[] authElements = header.split(" ");

            // Authorization 헤더가 올바른 형식으로 되어 있는지 그리고 Bearer 토큰을 포함하는지 확인합니다.
            if (authElements.length == 2
                    && "Bearer".equals(authElements[0])) {
                try {
                    // UserAuthenticationProvider를 사용하여 JWT 토큰을 유효성 검사하고 인증 컨텍스트를 설정합니다.
                    getContext().setAuthentication(
                            userAuthenticationProvider.validateToken(authElements[1]));
                } catch (RuntimeException e) {
                    // 토큰 검증에 실패하면 인증 컨텍스트를 지우고 예외를 다시 던집니다.
                    clearContext();
                    throw e;
                }
            }
        }
        // 필터 체인을 계속 진행합니다.
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}