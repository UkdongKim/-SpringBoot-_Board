package com.sergio.jwt.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return
                http
                        // 인증 진입 지점을 설정하고, 인증이 실패한 경우에 처리할 핸들러를 지정합니다.
                        .exceptionHandling(c->
                                c.authenticationEntryPoint(userAuthenticationEntryPoint))

                        // BasicAuthenticationFilter 앞에 JwtAuthFilter를 추가합니다.
                        .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)

                        // 세션 관리 방식을 설정합니다. 여기서는 세션을 사용하지 않음을 지정합니다.
                        .sessionManagement((session ->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))

                        // CSRF 보호를 비활성화합니다.
                        .csrf(AbstractHttpConfigurer::disable)

                        // h2 브라우저에서 접근 가능하도록
                        .headers(httpSecurityHeadersConfigurer -> {
                            httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> {
                                frameOptionsConfig.disable();
                            });
                        })

                        .sessionManagement(httpSecuritySessionManagementConfigurer ->
                                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/register").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                        .build();


    }

}
