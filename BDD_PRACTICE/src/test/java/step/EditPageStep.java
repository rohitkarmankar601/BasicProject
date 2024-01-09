package step;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EditPage;
import qa.DriverFactory;

public class EditPageStep {
	EditPage Ep=new EditPage(DriverFactory.GetDriver());
	WebDriver driver;
	
	@When("User Click On demo_demo Dropdown button")
	public void user_click_on_demo_demo_dropdown_button() {
	driver=DriverFactory.GetDriver();
	Ep.DropDown();
	}

	@Then("DropDown Should Be Display")
	public void drop_down_should_be_display() {
	boolean drop1=Ep.Drop();
	Assert.assertTrue(drop1);
	}

	@When("User Click On {string} button From Dropdown")
	public void user_click_on_button_from_dropdown(String ele2) {
	Ep.Myprofile();
	}
    
	@Then("User Should Redirect To {string} Page2")
	public void user_should_redirect_to_page2(String Title) {
	String title=Ep.Title();   
	Assert.assertEquals(Title, title);
	}

	@When("User Enter Following Data")
	public void user_enter_following_data(io.cucumber.datatable.DataTable dataTable) {
	List<List<String>>data=dataTable.asLists();
	List<String> FirstIndex=data.get(1);
	String username=FirstIndex.get(0);
	Ep.Username(username);
	
	String FirstName=FirstIndex.get(1);
	Ep.FirstName(FirstName);
	
	String LastName=FirstIndex.get(2);
	Ep.LastName(LastName);
	
	String Email=FirstIndex.get(3);
	Ep.Eamil(Email);
	
	String password=FirstIndex.get(4);
	Ep.Passsword(password);
	
	String repassword=FirstIndex.get(4);
	Ep.Repassword(repassword);
	}

	@When("User Upload The Image")
	public void user_upload_the_image() throws AWTException {
	Ep.ProfilePhoto();
	}

	@When("User Click On Save button")
	public void user_click_on_save_button() {
	Ep.SaveButton();    
	}

	@Then("Error Message As {string} Should Display")
	public void error_message_as_should_display(String title) {
	Assert.assertEquals(title," Warning: You do not have permission to modify your profile! ");
	}
}
