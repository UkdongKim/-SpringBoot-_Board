package com.sergio.jwt.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class WebConfig {

    private static final Long MAX_AGE = 3600L; // CORS preflight 요청의 최대 캐싱 시간
    private static final int CORS_FILTER_ORDER = -102; // CORS 필터의 우선 순위

    // CORS 필터를 생성하여 빈으로 등록
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // URL 기반의 CORS 구성 소스 생성
        CorsConfiguration config = new CorsConfiguration(); // CORS 구성 생성
        config.setAllowCredentials(true); // 자격 증명 허용 여부 설정
        config.addAllowedOrigin("http://localhost:3000"); // 허용할 오리진(도메인) 추가
        config.setAllowedHeaders(Arrays.asList( // 허용할 헤더 목록 설정
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
        config.setAllowedMethods(Arrays.asList( // 허용할 HTTP 메서드 목록 설정
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));
        config.setMaxAge(MAX_AGE); // CORS preflight 요청의 최대 캐싱 시간 설정
        source.registerCorsConfiguration("/**", config); // 모든 경로에 대해 CORS 구성 등록
        CorsFilter corsFilter = new CorsFilter(source); // CORS 필터 생성
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(corsFilter); // 필터 등록을 위한 Bean 생성
        bean.setOrder(CORS_FILTER_ORDER); // CORS 필터의 우선 순위 설정
        return corsFilter; // CORS 필터를 반환
    }
}
