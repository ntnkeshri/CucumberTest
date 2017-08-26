package Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class annotation {
	WebDriver driver = null;

	@Given("^I am on Facebook login page$")
	public void goToFacebook() {

		// driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "C:/DEV/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.ie.driver", "pathToTheIEDriver");
		// driver = new InternetExplorerDriver();

		driver.navigate().to("https://www.facebook.com/");
	}

	@When("^I enter username as \"(.*)\"$")
	public void enterUsername(String arg1) {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^I enter password as \"(.*)\"$")
	public void enterPassword(String arg1) {
		driver.findElement(By.id("pass")).sendKeys(arg1);
		driver.findElement(By.id("u_0_0")).click();
	}

	@Then("^Login should fail$")
	public void checkFail() {
		if ((driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110"))
				|| (driver.getCurrentUrl()
						.equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=111"))) {
			System.out.println("Test1 Pass");
			driver.close();
		} else {
			System.out.println("Test1 Failed");
			driver.close();
		}

	}

	@Then("^Relogin option should be available$")
	public void checkRelogin() {
		if ((driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110"))
				|| (driver.getCurrentUrl()
						.equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=111"))) {
			System.out.println("Test2 Pass");
			driver.close();
		} else {
			System.out.println("Test2 Failed");
			driver.close();
		}

	}
}
