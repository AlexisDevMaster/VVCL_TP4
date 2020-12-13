package com.fst.vvcl.tp2.acceptance.junit;

import com.fst.vvcl.tp2.acceptance.steps.CalculateControllerSteps;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringIntegrationSerenityRunner.class)
public class CalculateSpringSerenityRunnerIntegrationTest {
    @Steps
    private CalculateControllerSteps steps;

    @Test
    public void given_a_10_when_add_then_right_sum() {
        //GIVEN
        steps.givenCurrentNumber();

        // WHEN
        steps.whenAdd(10);
        // THEN
        steps.addUp();
    }

    @Test
    public void given_a_5_when_divide_then_right_divide() {
        //GIVEN
        steps.givenCurrentNumber();

        // WHEN
        steps.whenDivide(2);
        // THEN
        steps.divideUp();
    }

    @Test
    public void given_a_0_when_divide_then_division_error() {
        //GIVEN
        steps.givenCurrentNumber();
        // WHEN
        steps.whenDivide(0);
        // THEN
        steps.divideByZero();
    }

    @Test
    public void given_5_when_subtract_then_right_subtract() {
        //GIVEN
        steps.givenCurrentNumber();
        // WHEN
        steps.whenSubstract( 5);
        // THEN
        steps.substractUp();
    }

    @Test
    public void given_a_3_when_multiply_then_right_multiply() {
        //GIVEN
        steps.givenCurrentNumber();

        // WHEN
        steps.whenMultiply(3);
        // THEN
        steps.multiplyUp();
    }
}
