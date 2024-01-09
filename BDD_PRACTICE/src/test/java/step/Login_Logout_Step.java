package step;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.Login_Logout_Page;
import qa.DriverFactory;
import utility.ConfigDataReader;

public class Login_Logout_Step {

	Login_Logout_Page kk=new Login_Logout_Page(DriverFactory.GetDriver());
	WebDriver driver;
	@Given("User Is At Login Page Of Application")
	public void user_is_at_login_page_of_application() throws IOException {
	driver=DriverFactory.GetDriver();
	driver.get(ConfigDataReader.ReadData("URL"));
	}

	@When("User Enter The Username As {string}")
	public void user_enter_the_username_as(String Username) {
	kk.Username(Username);    
	}

	@When("User Enter The Password As {string}")
	public void user_enter_the_password_as(String pass) {
	kk.Password(pass); 
	}
    
	@Then("Notification Icon Should Be Visible")
	public void notification_icon_should_be_visible() {
	boolean IsDisplayed=kk.CheckIcon();
	Assert.assertTrue(IsDisplayed);
	}
	
	@When("User Click On Logout button")
	public void user_click_on_logout_button() {
	kk.LogoutButton();
	}

	@Then("User Should Redirect to {string} Page")
	public void user_should_redirect_to_page(String Title2) {
	String title2=kk.Title2();
	Assert.assertEquals(title2, Title2);
	}
}
