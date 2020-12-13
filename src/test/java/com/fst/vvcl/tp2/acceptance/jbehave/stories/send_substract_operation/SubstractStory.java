package com.fst.vvcl.tp2.acceptance.jbehave.stories.send_substract_operation;

import com.fst.vvcl.tp2.acceptance.steps.CalculateControllerSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import net.thucydides.core.annotations.Steps;

public class SubstractStory {
    @Steps
    private CalculateControllerSteps calculateControllerSteps;

    @Given("soustract : the user is on the form page")
    public void givenTheUserIsOnTheFormPage(){
        calculateControllerSteps.givenCurrentNumber();
    }

    @When("I substract with $num")
    public void whenSubstract(int num){
        calculateControllerSteps.whenSubstract(num);
    }

    @Then("I get a substraction result")
    public void thenIGetTheResult(){
        calculateControllerSteps.substractUp();
    }
}
