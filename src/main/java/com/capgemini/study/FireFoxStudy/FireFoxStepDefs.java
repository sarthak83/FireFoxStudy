package com.capgemini.study.FireFoxStudy;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FireFoxStepDefs {
	
	public static WebDriver driver;
	private Scenario scenario;
	
	@After()
	public void tearDownOne(Scenario s) {
		this.scenario = s;
		//System.out.println("AFTER scenario:"+scenario.getName());
		//driver.close();
	}
	
	/*@Before()
	public void beforeAll() {
		System.out.println("Should run only once");
		Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
            	System.out.println("***********Run once only at the END************");
                driver.quit();
            }
        });
	}*/
	
	

	@Given("^When I create a fireboxdriver object$")
	public void when_I_create_a_fireboxdriver_object() throws Throwable {
		System.setProperty("webdriver.firefox.bin", "/Applications/IBM Firefox.app/Contents/MacOS/firefox-bin");
		ProfilesIni profile = new ProfilesIni();
	    FirefoxProfile ffprofile = profile.getProfile("default");
		driver = new FirefoxDriver(ffprofile);
	}
	
	
	@Given("^When I create a chromedriver object$")
	public void when_I_create_a_chromedriver_object() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "/Users/sarthakdayanand/Documents/Automation/chromedriver");
	    driver = new ChromeDriver();
	    
	    
	}

	@Given("^geturl for github$")
	public void geturl_for_github() throws Throwable {
		//System.out.println("Open the driver");
	    driver.get("http://www.github.com");
	    /*By.linkText("");
	    driver.findElement(By.id("")).sendKeys("abc");
	    Keys k = Keys.SHIFT;
	    driver.findElement(By.id("")).sendKeys(Keys.chord(k,"abc"));*/
	    
	    By username = By.id("user[login]");
	    WebElement e = driver.findElement(username);
	    
	    System.out.println(e.getCssValue("box-shadow"));
	    System.out.println(e.getCssValue("position"));
	    System.out.println(e.getCssValue("font-size"));
	    System.out.println(e.getLocation());
	    e.isDisplayed();
	   
	    WebDriver.Options o = driver.manage();
	    
	    WebDriver.Timeouts to = o.timeouts();
	    to.implicitlyWait(20, TimeUnit.SECONDS);
	    
	   //JavascriptExecutor js = (JavascriptExecutor)driver;
	   //js.executeScript("alert('hello world');");
	    /*
	    Select s = new Select(e);
	    s.deselectByIndex(0);
	    s.selectByValue(value);
	    */
	    
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user[login]")));
	    
	   /* FluentWait fwait = new FluentWait(driver);
	    fwait.withTimeout(30, TimeUnit.SECONDS)
	    .pollingEvery(5,TimeUnit.SECONDS)
	    .ignoring(NoSuchElementException.class);
	    
	    e = fwait.until(new Function() {
	    	public WebElement apply(WebDriver driver) {
	    		return driver.findElement(By.id("user[login]")); 
	    	}*/

		
	   
	    
	    Actions a = new Actions(driver);
	    a.moveToElement(e).contextClick().click();
	    
	    a.keyDown(Keys.SHIFT).sendKeys("sarthak").keyUp(Keys.SHIFT);
	    
	    Action p = a.build();
	    p.perform();
	    
	    //can directly call a.perform(); Build will be called internally
	    //a.perform();
	    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    System.out.println(f.getAbsolutePath());
	    
	    String w = driver.getWindowHandle();
	    WebDriver.TargetLocator t = driver.switchTo();
	    t.window(w);
	    WebDriver.Navigation n = driver.navigate();
	    n.to("http:\\www.bbc.co.uk");
	    n.forward();
	    n.refresh();
	    n.back();
	    
	    
	}

	@Then("^Window is open and close$")
	public void window_is_open_and_close() throws Throwable {
	    //System.out.println("Close the driver");
		//driver.close();
	}


}
