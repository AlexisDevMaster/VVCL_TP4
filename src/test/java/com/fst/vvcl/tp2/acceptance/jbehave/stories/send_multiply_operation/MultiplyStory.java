package com.fst.vvcl.tp2.acceptance.jbehave.stories.send_multiply_operation;

import com.fst.vvcl.tp2.acceptance.steps.CalculateControllerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MultiplyStory {
    @Steps
    private CalculateControllerSteps calculateControllerSteps;

    @Given("multiply : the user is on the form page")
    public void givenTheUserIsOnTheFormPage() {
        calculateControllerSteps.givenCurrentNumber();
    }

    @When("I multiply with $num")
    public void whenMultiply(int num) {
        calculateControllerSteps.whenMultiply(num);
    }

    @Then("I get a multiplication result")
    public void thenIGetTheResult() {
        calculateControllerSteps.multiplyUp();
    }
}
