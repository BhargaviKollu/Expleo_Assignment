package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjectmodel.DynamicWebelements;


public class Challenge1 {
	public static Logger logger;
	public WebDriver driver;
	public DynamicWebelements Wb;
	@Given("^User launch the browser$")
	public void user_launch_the_browser()  {
		//Logging
				logger=Logger.getLogger("The_internet");
				PropertyConfigurator.configure("Log4j.properties");
				logger.setLevel(Level.DEBUG);
	logger.info("************* Launching Browser *****************");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Wb= new DynamicWebelements(driver);
		}

	@When("^User opens the URL \"(.*?)\"$")
	public void user_opens_the_URL(String url) {
		logger.info("************* Opening URL  *****************");
	    driver.get(url);
	}
	

	@Then("^Check page title should be \"(.*?)\"$")
	public void check_page_title_should_be(String pagetitle) throws Throwable {
	   logger.info("***********Getting Page Title*****");
		pagetitle=driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	   //String Expectedtitle="Challenging DOM"; 
	   Assert.assertEquals(pagetitle,"Challenging DOM" );
	  
	}
		




	@When("^user clicks on Blue button check the operation of the blue button$")
	public void user_clicks_on_Blue_button_check_the_operation_of_the_blue_button() throws Throwable {
		logger.info("************* Blue Button clicking  *****************");
		Wb.Bluebotton();
	}

	@When("^user clicks on Red button chech the operation of the red button$")
	public void user_clicks_on_Red_button_chech_the_operation_of_the_red_button() throws Throwable {
		logger.info("************* Red Button Clicking  *****************");
		Wb.RedButton();
	}

	@When("^user clicks on green button check the operation of the green button$")
	public void user_clicks_on_green_button_check_the_operation_of_the_green_button() throws Throwable {
		logger.info("************* Green Button Clicking  *****************");
		Wb.GreenButton();   
	}

	@When("^get table data$")
	public void get_table_data() throws Throwable {
	  // Wb.getNoOfColumns();
	  // Wb.getNoOfRows();
		logger.info("************* Fetching table data  *****************");
	   Wb.Tabledata();
	}
	@When("^user click on edit link$")
	public void user_click_on_edit_link() throws Throwable {
		logger.info("************* Edit link clicked  *****************");
	    Wb.Edit();
	}

	@When("^user clicks on delete link$")
	public void user_clicks_on_delete_link() throws Throwable {
		logger.info("************* Deleted Button Clicked  *****************");
	   Wb.Delete();
	}

	@Then("^user shouldnot able to see the deleted row$")
	public void user_shouldnot_able_to_see_the_deleted_row() throws Throwable {
		logger.info("************* Oberve the results after clicking delete button  *****************");
		Wb.Delete();
	Wb.comapringdeletedcolumndata();
	}

	@Then("^Check the old answers& Refresh the page observe the new anwers$")
	public void check_the_old_answers_Refresh_the_page_observe_the_new_anwers() throws Throwable {
		logger.info("************* Old anwser & new anwser   *****************");
		Wb.answer();
	}


}
