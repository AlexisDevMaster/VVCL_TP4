package com.fst.vvcl.tp2.web.controller;

import com.fst.vvcl.tp2.modele.Result;
import com.fst.vvcl.tp2.service.CalculateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CalculateController {

    private CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }
    @GetMapping("/current")
    public Result currentNum() {
        return calculateService.getResult();
    }
    @PostMapping("/add")
    public Result add(@RequestParam int num) {
        calculateService.add(num);
        return calculateService.getResult();
    }

    @PostMapping("/soustract")
    public Result soustract(@RequestParam int num) {
        calculateService.soustract(num);
        return calculateService.getResult();
    }

    @PostMapping("/divide")
    public Result divide(@RequestParam int num)throws ArithmeticException {
        calculateService.divide(num);
        return calculateService.getResult();
    }

    @PostMapping("/multiply")
    public Result multiply(@RequestParam int num) {
        calculateService.multiply(num);
        return calculateService.getResult();

    }

    @PostMapping("/reset")
    public Result reset() {
        calculateService.reset();
        return calculateService.getResult();
    }
}