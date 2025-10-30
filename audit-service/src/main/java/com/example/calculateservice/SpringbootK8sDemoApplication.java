package com.example.calculateservice;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@RestController
public class SpringbootK8sDemoApplication {

    private final Counter auditCount;

    // Micrometer registry automatically injected by Spring
    public SpringbootK8sDemoApplication(MeterRegistry registry) {
        this.auditCount = Counter.builder("audit_events_total")
                .description("Total audit events processed")
                .register(registry);
    }

    @GetMapping("/audit")
    public String welcome(@RequestParam int c) {
        auditCount.increment(); // increment the metric
        System.out.println("Audit recorded for value: " + c);
        return "recorded";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootK8sDemoApplication.class, args);
    }
}
