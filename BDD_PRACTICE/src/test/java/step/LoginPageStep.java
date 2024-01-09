package step;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import qa.DriverFactory;
import utility.ConfigDataReader;

public class LoginPageStep {

	LoginPage Lp=new LoginPage(DriverFactory.GetDriver());
	WebDriver driver;
	
	@Given("User Is At Login Page")
	public void user_is_at_login_page() throws IOException {
	driver=DriverFactory.GetDriver();
	driver.get(ConfigDataReader.ReadData("URL"));
	}

	@Then("Title Of Page Should Be {string}")
	public void title_of_page_should_be(String Title) {
	String title=Lp.Title(); 
	Assert.assertEquals(title,Title);
	}

	@Then("Url Of Page Should Be {string}")
	public void url_of_page_should_be(String URL) {
	String url=Lp.GetUrl();
	Assert.assertEquals(url,URL);
	}

	@When("User Enter Username As {string}")
	public void user_enter_username_as(String username) {
	Lp.Username(username);    
	}

	@When("User Enter Password As {string}")
	public void user_enter_password_as(String password) {
	Lp.Password(password);    
	}

	@When("User Click On {int} Login button")
	public void user_click_on_login_button(Integer First) {
	Lp.LoginButton();   
	}

	@Then("User Should Redirect To {string} Page")
	public void user_should_redirect_to_page(String title2) {
	Lp.Notification();
	String Title2=Lp.Title2();
	Assert.assertEquals(title2,Title2);
	}

}
