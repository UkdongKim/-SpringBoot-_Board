package com.sergio.jwt.backend.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.jwt.backend.dtos.ErrorDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

// AuthenticationEntryPoint 인터페이스를 구현하는 UserAuthenticationEntryPoint 클래스를 정의합니다.
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // JSON 직렬화를 위한 ObjectMapper의 정적 상수 인스턴스를 생성합니다.
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // AuthenticationEntryPoint 인터페이스의 메서드를 오버라이드합니다.
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        // HTTP 상태 코드를 401 (Unauthorized)로 설정합니다.
        // 응답의 콘텐츠 유형을 JSON으로 설정합니다.
        // ErrorDto 객체를 JSON으로 변환하여 응답의 출력 스트림에 작성합니다.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        OBJECT_MAPPER.writeValue(response.getOutputStream(), new ErrorDto("Unauthorized"));

    }
}
