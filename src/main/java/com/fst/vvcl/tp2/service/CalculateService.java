package com.fst.vvcl.tp2.service;

import com.fst.vvcl.tp2.modele.Result;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private Result result = new Result((int)(Math.random()));

    public void baseNum(int base) {
        this.result.setResult(base);
    }

    public void add(int adder) {
        this.result.setResult(this.result.getResult() + adder);
    }

    public void multiply(int adder) {
        this.result.setResult(this.result.getResult() * adder);
    }

    public void soustract(int adder) {
        this.result.setResult(this.result.getResult() - adder);
    }

    public void divide(int adder) throws ArithmeticException{
        this.result.setResult(this.result.getResult() / adder);
    }

    public void reset(){
        this.result.setResult(0);
    }


    public Result getResult() {
        return result;
    }
}
