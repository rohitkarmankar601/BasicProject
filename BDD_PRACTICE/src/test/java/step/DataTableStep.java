package step;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DataTablePage;
import qa.DriverFactory;
import utility.ConfigDataReader;

public class DataTableStep {
    
	DataTablePage DT;
	WebDriver driver;
	@Given("User Is At Zoho Cloud Software Suite for Businesse Page")
	public void user_is_at_zoho_cloud_software_suite_for_businesse_page() throws IOException {
	DT=new DataTablePage(DriverFactory.GetDriver());
	driver=DriverFactory.GetDriver();
	driver.get(ConfigDataReader.ReadData("ZoomURL"));
	}

	@Then("Title Should Be {string}")
	public void title_should_be(String ExpectedTitle) {
	String ActualTitle=DT.Title();
	Assert.assertEquals(ExpectedTitle,ActualTitle);
	}

	@Then("URL Should Be {string}")
	public void url_should_be(String ExpectedURL) {
	String ActualURL=DT.URL();  
	Assert.assertEquals(ActualURL,ExpectedURL);
	}

	@When("User Click On SignIn Page")
	public void user_click_on_sign_in_page() {
	DT.SignIn();   
	}

	@Then("User Should redirect to {string} Page")
	public void user_should_redirect_to_page(String ExpectedSignInPageTitle) {
	String ActualSignInPageTitle=DT.SignInPageTitle();  
	Assert.assertEquals(ExpectedSignInPageTitle,ActualSignInPageTitle);
	}

	@When("User Enters The Following Deatils")
	public void user_enters_the_following_deatils(io.cucumber.datatable.DataTable dataTable) {
	List<List<String>>Data=dataTable.asLists();
	List<String>FirstElement=Data.get(1);
	String Email=FirstElement.get(0);
	DT.EnterEmail(Email);
	String Passwors=FirstElement.get(1);
	DT.EnterPassword(Passwors);
	String phoneNumber=FirstElement.get(2);
	DT.PhoneNumber(phoneNumber);
	}

	@When("User Check The Aggrement")
	public void user_check_the_aggrement() {
	DT.Aggrement();   
	}

	@When("User Click On Sign Up For Free button")
	public void user_click_on_sign_up_for_free_button() {
	DT.SignInUpForFreeButton();   
	}

	@Then("Confirmation Message As {string} Should Visible.")
	public void confirmation_message_as_should_visible(String ExpectedErrorMessage) {
	String ActualErrorMessage=DT.Verifycaptcha();
	Assert.assertEquals(ExpectedErrorMessage,ActualErrorMessage);
	}
}
