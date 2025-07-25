package com.example.paymentservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    public PaymentController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build(); // mock third-party API
    }

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackMethod")
    public Mono<String> processPayment() {
        return webClient.get()
                .uri("/thirdparty/delay")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> fallbackMethod(Throwable t) {
        logger.warn("Fallback executed due to: {}", t.getMessage());
        return Mono.just("Fallback: Payment service is currently unavailable.");
    }
}
