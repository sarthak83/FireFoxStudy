package com.capgemini.study.FireFoxStudy;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java",plugin={"pretty","html:target/test-report"},tags={"@Chrome"})
public class RunCukeTest {

}
 