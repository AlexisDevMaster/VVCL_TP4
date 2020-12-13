package com.fst.vvcl.tp2.acceptance.steps;

import com.fst.vvcl.tp2.service.CalculateService;
import io.cucumber.java.bs.A;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;
import org.junit.rules.ExpectedException;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = CalculateService.class)
public class CalculateControllerSteps {

    private int currentNumber;
    private int result;
    private int savedCurrentNumber;
    private int numStored;

    public void givenCurrentNumber() {
        JsonPath responseBody = when().get("calculate/current").jsonPath();
        currentNumber = responseBody.get("result");
        savedCurrentNumber = responseBody.get("result");;
    }

    public void whenAdd(int num) {
        numStored = num;
        JsonPath response =  given().param("num", num).when().post("calculate/add").jsonPath();
        this.result = response.get("result");
    }

    public void whenDivide(int num) {
        numStored = num;
        JsonPath response =  given().param("num", num).when().post("calculate/divide").jsonPath();
        if(response.get("result")!=null)
            this.result = response.get("result");
        else
            divideByZero();
    }

    public void whenSubstract(int num) {
        numStored = num;
        JsonPath response =  given().param("num", num).when().post("calculate/soustract").jsonPath();
        this.result = response.get("result");
    }

    public void whenMultiply(int num) {
        numStored = num;
        JsonPath response =  given().param("num", num).when().post("calculate/multiply").jsonPath();
        this.result = response.get("result");
    }

    public void addUp() {
        assertEquals(savedCurrentNumber + numStored, result);
    }

    public void divideUp() {
            assertEquals(savedCurrentNumber / numStored, result);
    }

    public void divideByZero() {
        ExpectedException thrown = ExpectedException.none();
        thrown.expect(IllegalArgumentException.class);
    }

    public void substractUp() {
        assertEquals(savedCurrentNumber -  numStored, result);
    }

    public void multiplyUp() {
        assertEquals(savedCurrentNumber * numStored, result);
    }

}
