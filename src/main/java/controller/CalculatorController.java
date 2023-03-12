package controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;


@RestController
    @RequestMapping("/calculator")
    public class CalculatorController {
        private final CalculatorService calculatorService;
        public CalculatorController (CalculatorService calculatorService) {
            this.calculatorService = calculatorService;
        }
        @GetMapping
        public String hello () {
            return " Добро пожаловать в калькулятор ";
        }
        @GetMapping("/plus")
        public String plus (@RequestParam("num1")int num1, @RequestParam("num2")int num2){
            int result = calculatorService.plus(num1, num2);
            return num1 + " + "+ num2 + " = " + result;
        }
        @GetMapping("/minus")
        public String minus (@RequestParam("num1")int num1,@RequestParam("num2")int num2){
            int result = calculatorService.minus(num1, num2);
            return num1 + " - "+ num2 + " = " + result;
        }
        @GetMapping("/multiply")
        public String multiply (@RequestParam("num1")int num1,@RequestParam("num2")int num2){
            int result = calculatorService.multiply(num1, num2);
            return num1 + " * "+ num2 + " = " + result;
        }
        @GetMapping("/divide")
        public ResponseEntity<String> divide (@RequestParam("num1")int num1, @RequestParam("num2")int num2){
            try {
                int result = calculatorService.divide(num1, num2);
                return ResponseEntity.ok(num1 + "/" + num2 + "=" + result);
            } catch (ArithmeticException e) {
                return ResponseEntity.badRequest().body("Не делим на 0");
            }
        }
    }



