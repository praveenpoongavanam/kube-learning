package com.example.calculateservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@RestController
public class SpringbootK8sDemoApplication {

    @Value("${AUDIT_SERVICE_URL}")
    private String auditServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/message")
    public String welcome(@RequestParam int a, @RequestParam int b) {
        String result = "Sum of " + a + " and " + b + " is " + (a + b);
        restTemplate.getForObject(auditServiceUrl + "/audit?message=" + result, String.class);
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootK8sDemoApplication.class, args);
    }
}
