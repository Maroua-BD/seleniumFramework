package runner;

import tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features ="src/test/java/features",
glue = {"steps"}, plugin = {"pretty","html:target/cucumber-html-report"})

//glue prend en parametre le nom du package qui contient nos steps
//plugin : on veut que le rapport soit de type html
public class TestRunner extends TestBase{

}