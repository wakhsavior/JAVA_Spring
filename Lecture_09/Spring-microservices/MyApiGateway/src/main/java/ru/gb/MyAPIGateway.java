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
                .route("MMYAPPLICATIONSERVICE-01",r->r.path("/service1/**")
                        .uri("http://localhost:8080/"))
                .route("MYAPPLICATIONSERVICE-02",r->r.path("/service2/**")
                        .uri("http://localhost:8081/")).build();}
}