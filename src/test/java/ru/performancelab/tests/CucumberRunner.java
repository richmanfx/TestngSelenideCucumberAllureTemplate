package ru.performancelab.tests;


import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import org.testng.annotations.DataProvider;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@Test(groups = "cucumber")
@CucumberOptions(features = {"src/test/resources/features"})
public class CucumberRunner extends AbstractTestNGCucumberTests {

    // Для параллельного выполнения сценариев
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}