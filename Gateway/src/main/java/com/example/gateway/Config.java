package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("RPG-Profession", r -> r
                        .path("/api/professions/{professionId}")
                        .or()
                        .path("/api/professions")
                        .uri("http://localhost:8082")
                )
                .route("RPG-Weapon", r -> r
                        .path("/api/weapons")
                        .or()
                        .path("/api/weapons/**")
                        .or()
                        .path("/api/professions/{professionId}/weapons")
                        .or()
                        .path("/api/weapons/{professionName}/weapons")
                        .or()
                        .path("/api/professions/{professionId}/weapons/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
