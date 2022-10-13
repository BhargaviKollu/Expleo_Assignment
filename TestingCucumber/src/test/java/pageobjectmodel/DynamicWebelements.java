package pageobjectmodel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicWebelements {
	
public WebDriver idriver;
	
	 public DynamicWebelements(WebDriver rdriver) {
		idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 @FindBy(xpath="//div[@class='large-2 columns']/a[@class='button']")
	 WebElement Bluebtn;
	 @FindBy(xpath="//div[@class='large-2 columns']/a[@class='button alert']")
	 WebElement RedBtn;
	 @FindBy(xpath="//div[@class='large-2 columns']/a[@class='button success']")
	 WebElement GreenBtn;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table")
	 WebElement Table;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr")
	 List<WebElement> tableRows;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr/td")
	 List<WebElement> tableColumns;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table/thead/tr/th")
	 List<WebElement> Headers;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr/td/a[1]")
	 WebElement Editlink;
	 
	 @FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr[6]/td[7]/a[2]")
	 WebElement Deletelink;
	 
	@FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr[7]/td[1]")
	WebElement columndata8;
	
	@FindBy(xpath="//div[@class='large-10 columns']/table/tbody/tr[6]/td[1]")
	WebElement columndata7;
	
	@FindBy(xpath="//div[@id='content']/script")
	WebElement Script1;
	 public void Bluebotton() {
		 String Blue_id=Bluebtn.getAttribute("id");
		 Bluebtn.click();
		 Assert.assertNotEquals(Bluebtn.getAttribute("id"),Blue_id);
		
		 
	 }
	 
	 public void RedButton() {
		 String Red_id=Bluebtn.getAttribute("id");
		 RedBtn.click();
		 Assert.assertNotEquals(RedBtn.getAttribute("id"),Red_id);
	 }
	 public void GreenButton() {
		 String Green_id=Bluebtn.getAttribute("id");
		 GreenBtn.click();
		 Assert.assertNotEquals(GreenBtn.getAttribute("id"),Green_id);
	 }
	
	 
	public  void Tabledata() {
		
		//getting table data 
		 int rownum=tableRows.size();
		 
		  for( int j=0; j<rownum;j++) {
		
			System.out.println("table Data "  + tableRows.get(j).getText());
		
		 }}
	public void Edit() {
		/*Check the operation of the edit link on the second line of the table
	    I'm not clear what's meant to happen when the edit button is clicked*/

		//Just guessing here, but check the edit link is no longer there?
		String text="edit";
		Editlink.click();
		Assert.assertEquals(text,Editlink.getText());
	}
	 public void Delete() {
		 
		 Deletelink.click();
	 }
	 public void comapringdeletedcolumndata() {
		//check deleted line
		if (columndata7==columndata8) {
			Assert.assertTrue(false);
			
		} else {
			Assert.assertNotEquals(columndata8,columndata7);
			 System.out.println("column7 data is not deleted after clicking delete button");
		}
		 
		 }
	 
	public void answer() {
		//grab the canvas generation script block, which contains the Answer buried in javascript
		String Script_block= Script1.getAttribute("innerHTML");
		//pick out the number after 'Answer' using regex
		String regex = "([0-9]+)";
		 Pattern p=Pattern.compile(regex);
		 Matcher Old_answer = p.matcher(Script_block);
		 
	
			while(Old_answer.find()) {
		         System.out.print(Old_answer.group()+" ");
		      }
			

			idriver.navigate().refresh();
			//grab the canvas generation script block, which contains the Answer buried in javascript
			String Script_block2= Script1.getAttribute("innerHTML");
			//pick out the new number after 'Answer' using regex
			String regex2 = "([0-9]+)";
			 Pattern p1=Pattern.compile(regex2);
			 Matcher New_answer = p1.matcher(Script_block2);
			 
		
				while(New_answer.find()) {
			         System.out.print(New_answer.group()+" ");
			      }
				Assert.assertNotEquals(Old_answer,New_answer);
	}}
	 
	 
	
	
    
