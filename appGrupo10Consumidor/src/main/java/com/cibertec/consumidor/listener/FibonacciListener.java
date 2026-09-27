package com.cibertec.consumidor.listener;

import com.cibertec.consumidor.config.RabbitConfig;
import com.cibertec.consumidor.service.FibonacciService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FibonacciListener {

    private final FibonacciService fibonacciService;

    public FibonacciListener(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void recibir(String cadenaNumeros) throws InterruptedException {
        System.out.println("Mensaje recibido: " + cadenaNumeros);

        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        // Aplica el método fibonacci a cada posición
        List<Long> resultados = new ArrayList<>();
        for (Integer n : integerArray) {
            resultados.add(fibonacciService.fibonacci(n));
        }

        // Pausa de 20 segundos antes de imprimir
        Thread.sleep(20000);

        for (int i = 0; i < integerArray.length; i++) {
            System.out.println("fibonacci(" + integerArray[i] + ") = " + resultados.get(i));
        }
        System.out.println("Resultado: " + resultados);
    }
}
