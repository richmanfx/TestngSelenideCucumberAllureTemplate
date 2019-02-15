package ru.performancelab.tests;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {"src/test/resources/features"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {



}