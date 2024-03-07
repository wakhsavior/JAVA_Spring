package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAPIGateway {
    public static void main(String[] args) {
        SpringApplication.run(MyAPIGateway.class,args);

    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("TaskManager",r->r.path("/tasks/**")
                        .uri("http://localhost:8090/"))
                .route("UserManager",r->r.path("/users/**")
                        .uri("http://localhost:8091/")).build();}
}