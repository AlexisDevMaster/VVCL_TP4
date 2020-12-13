package com.fst.vvcl.tp2.acceptance.jbehave.stories.send_add_operation;

import com.fst.vvcl.tp2.acceptance.steps.CalculateControllerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddStory {
    @Steps
    private CalculateControllerSteps calculateControllerSteps;

    @Given("add : the user is on the form page")
    public void givenTheUserIsOnTheFormPage() {
        calculateControllerSteps.givenCurrentNumber();
    }

    @When("I add $num")
    public void whenAdding(int num) {
        calculateControllerSteps.whenAdd(num);
    }

    @Then("I get an addition result")
    public void thenIGetTheResult() {
        calculateControllerSteps.addUp();
    }
}
