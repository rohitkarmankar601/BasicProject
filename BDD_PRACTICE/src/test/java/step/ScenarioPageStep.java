package step;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ScenarioWebPage;
import qa.DriverFactory;
import utility.ConfigDataReader;

public class ScenarioPageStep {
	
	ScenarioWebPage Sw;
	WebDriver driver;
	
	@Given("User Is At Login Page Of OrageHrm")
	public void user_is_at_login_page_of_orage_hrm() throws IOException {
	Sw=new ScenarioWebPage(DriverFactory.GetDriver());
	driver=DriverFactory.GetDriver();
	driver.get(ConfigDataReader.ReadData("OrangeHrmURL"));
	}

	@Then("URL Of LoginPage Should Be {string}")
	public void url_of_login_page_should_be(String url) {
	String URL=Sw.UrlOfLoginPage();    
	Assert.assertEquals(URL,url);
	}

	@Then("Title Of LoginPage Should Be {string}")
	public void title_of_login_page_should_be(String title) {
	String Title=Sw.TitleOfLoginPage();    
	Assert.assertEquals(Title,title);
	}

	@When("User enter The Username As {string}")
	public void user_enter_the_username_as1(String Username) {
	Sw.Username(Username);    
	}

	@When("User enter The Password As {string}")
	public void user_enter_the_password_as1(String Password) {
	Sw.Password(Password);    
	}

	@When("User click On {int} Login button")
	public void user_click_on_login_button1(Integer FirstOne) {
	Sw.Loginbutton();
	}

	@Then("User Should redirect To {string} Page")
	public void user_should_redirect_to_page(String Title2) {
	String title2=Sw.TitleAfterLogin();
	Assert.assertEquals(Title2,title2);
	}

	@When("User enter The username As {string}")
	public void user_enter_the_username_as(String Username) {
	Sw.Username(Username);   
	}

	@When("User enter The password As {string}")
	public void user_enter_the_password_as(String Password) {
	Sw.Password(Password);
	}

	@When("User click On {int} login button")
	public void user_click_on_login_button(Integer SecondButton) {
	Sw.Loginbutton();   
	}

	@Then("Error Message {string} Should Display")
	public void error_message_should_display(String Error) {
	String error=Sw.ErrorMeaage();  
	Assert.assertEquals(Error,error);
	}
}
