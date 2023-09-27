package br.com.hahn.controller;

import br.com.hahn.model.Saudacao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaudacaoController {

    private static  final  String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/saudacao")
    public Saudacao saudacao(@RequestParam(value = "name", defaultValue = "Word") String name){
        return new Saudacao(counter.incrementAndGet(),String.format(template, name));
    }

}
