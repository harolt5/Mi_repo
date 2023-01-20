package com.otro.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("{noop}12345678")
                        .roles("USER")
                        .build(),
                        User.withUsername("admin")
                        .password("{noop}12345678")
                        .roles("ADMIN")
                        .build()


        );

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests().requestMatchers("/*.js","/*.css","/*.svg","/*.png","/*.jpg","/*.ico").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/registrar","/saveu").permitAll()
                .and()
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()

                )
                .formLogin().loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/principal", true)
                .and()
                .logout().permitAll(true)
                .and()
                .build();

    }

}
