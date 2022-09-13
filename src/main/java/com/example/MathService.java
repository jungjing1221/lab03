package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathService {
    @RequestMapping(value = "/add/{num1}/{num2}", method = RequestMethod.POST)
    public String add(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return Double.toString(num1 + num2);
    }
    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.POST)
    public String minus(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return Double.toString(num1 - num2);
    }
    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public String multiply(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return Double.toString(num1 * num2);
    }
    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public String divide(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return Double.toString(num1 / num2);
    }
}
