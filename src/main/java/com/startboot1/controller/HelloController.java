package com.example.startboot1;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Tracer tracer;

    public HelloController(OpenTelemetryConfig openTelemetryConfig) {
        this.tracer = openTelemetryConfig.openTelemetry().getTracer("com.example.startboot1");
    }

    @GetMapping("/hello")
    public String hello() {
        Span span = tracer.spanBuilder("hello-span").startSpan();
        try {
            // Simulate work
            Thread.sleep(100);
            return "Hello from startboot1!";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error";
        } finally {
            span.end();
        }
    }
}
