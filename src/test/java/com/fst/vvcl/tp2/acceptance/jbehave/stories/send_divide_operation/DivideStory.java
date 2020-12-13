package com.fst.vvcl.tp2.acceptance.jbehave.stories.send_divide_operation;

import com.fst.vvcl.tp2.acceptance.steps.CalculateControllerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DivideStory {
    @Steps
    private CalculateControllerSteps calculateControllerSteps;

    @Given("divide : the user is on the form page")
    public void givenTheUserIsOnTheFormPageDivide() {
        calculateControllerSteps.givenCurrentNumber();
    }

    @When("I divide with $num")
    public void whenDividing(int num) {
        calculateControllerSteps.whenDivide(num);
    }

    @Then("I get a division result")
    public void thenIGetTheResult() {
        calculateControllerSteps.divideUp();
    }

    @Then("I get a division error")
    public void thenIGetTheError() {
        calculateControllerSteps.divideByZero();
    }
}
