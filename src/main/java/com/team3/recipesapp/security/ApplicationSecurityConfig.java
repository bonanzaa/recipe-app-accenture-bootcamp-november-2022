package com.team3.recipesapp.security;

import com.team3.recipesapp.service.JpaUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.team3.recipesapp.security.UserRole.*;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class ApplicationSecurityConfig {

    private final JpaUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/", "/user", "/css/*", "/js/*", "/registration")
                                .permitAll()
                                .requestMatchers( "/recipes", "/recipe", "/recipe/*",
                                        "/recipes/*", "/profile", "/createrecipe", "/recipelist", "/home")
                                .hasAnyRole(USER.name(), MODERATOR.name(), ADMIN.name())
                                .requestMatchers("/users", "/user/edit/*")
                                .hasAnyRole(MODERATOR.name(), ADMIN.name())
                                .requestMatchers("/getAllUsers", "/user/delete/*", "/template1")
                                .hasRole(ADMIN.name())
                                .anyRequest()
                                .authenticated()
                )
                .userDetailsService(userDetailsService)
                .httpBasic()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home", true)
                .and().rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
                .and()
                .logout().logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
