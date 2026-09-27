package com.cibertec.productor.controller;

import com.cibertec.productor.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final RabbitTemplate rabbitTemplate;

    public FibonacciController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Ejemplo: /api/fibonacci/send?numbers=1;2;15;8
    @GetMapping("/send")
    public String send(@RequestParam String numbers) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, numbers);
        return "Lista enviada a RabbitMQ correctamente";
    }
}
