package com.fst.vvcl.tp2;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Tp2ApplicationTests {

    @Test
    void contextLoads() {

    }

    @Before
    public void initialiser() {
        given().
                when().
                post("/calculate/reset")
                .then()
                .body("result", is(0));
    }

    @Test
    void testGet(){
        initialiser();
        get("/calculate/current")
                .then()
                .body("result", is(0));
    }

    @Test
    void testAdd() {
        initialiser();

        given().
                param("num", 5).
                when().
        post("/calculate/add")
                .then()
                .body("result", is(5));
    }

    @Test
    void testSoustract()  {
        initialiser();

        given().
                param("num", 2).
                when().
                post("/calculate/soustract")
                .then()
                .body("result", is(-2));
    }

    @Test
    void testMultiply(){
        initialiser();

        given().
                param("num", 8).
                when().
                post("/calculate/multiply")
                .then()
                .body("result", is(0));
    }

    @Test
    void testDivide() {
        initialiser();

        given().
                param("num", 3).
                when().
                post("/calculate/divide")
                .then()
                .body("result", is(0));
    }
}
