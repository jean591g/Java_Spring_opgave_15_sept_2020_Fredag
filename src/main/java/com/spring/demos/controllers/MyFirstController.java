package com.spring.demos.controllers;

import com.spring.demos.services.ErDetFredag;
import com.spring.demos.services.WorldsSimplestCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {

    // URL: http://localhost:8080/hello/
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    // URL: http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String frontPage() {
        return "Front Page";
    }

    // URL: http://localhost:8080/hello/world/
    @GetMapping("/hello/world")
    @ResponseBody
    public String helloWorld2() {
        return "Hello hello World world";
    }

    // URL: http://localhost:8080/echo?phraseToEcho=Hello
    // prints: Hello
    @GetMapping("/echo")
    @ResponseBody
    public String echo(@RequestParam String phraseToEcho) {

        return phraseToEcho;
    }

    // URL: http://localhost:8080/calc?inputFromURL=10
    // prints: 20
    @GetMapping("/calc")
    @ResponseBody
    public int calc(@RequestParam int inputFromURL) {
        WorldsSimplestCalculator calculator = new WorldsSimplestCalculator();
        int result = calculator.returnProduct(inputFromURL);
        return result;
    }

    // OPGAVE til den 15. sept. 2020. Brug Zellers congruance formula + Date check metode
    // URL: http://localhost:8080/fredag/
    // prints: Ja eller: Nej
    @GetMapping("/fredag")
    @ResponseBody
    public String fredag() {
        ErDetFredag check = new ErDetFredag();
        check.zeller();
        if (check.getD() == 5) {
            return "Is it Friday today? YES (weekday number: " + check.getD() + ")";
        } else {
            return "Is it Friday today? NO (weekday number: " + check.getD() + ")";
        }
    }
}
