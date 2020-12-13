package com.fst.vvcl.tp2.acceptance.jbehave;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.BeforeStories;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTestSuite extends SerenityStories {

    @BeforeStories
    public void test() {
        System.out.println("-----------------STARTING SERVER-----------------");
    }

}
