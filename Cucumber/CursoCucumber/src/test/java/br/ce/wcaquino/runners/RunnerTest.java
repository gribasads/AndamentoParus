package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/features/",
glue={"br.ce.wcaquino.steps", "br.ce.wcaquino.config"},
tags= {"@funcional","not @ignore"},
plugin = {"pretty","html:target/report-html","json:target/report.json"},
monochrome=true,
snippets=SnippetType.CAMELCASE,
dryRun=false,
strict =false)
public class RunnerTest {
	
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gustavo.ribas\\Downloads\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.name("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}
