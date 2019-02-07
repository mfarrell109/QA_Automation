package base.po;
import base.BaseConfig;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Result;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.function.Function;

import javax.swing.text.StyleConstants.CharacterConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import base.po.ProjectDashboard_PO;
import bsh.Variable;
import base.model.Constants;

/* This class only tests elements from the ProjectDashBoard_PO class
 * Each test needs to be documented on what exactly is being tested. Also feel
 * free to insert tests that only are going to work by called elements dynamically */
public class ProjectDashBoard_PO_Test
{
	public WebDriver _driver;
	public WebDriverWait _wait;
	public ProjectDashboard_PO ProjectDashboard_PO;
	private final String _base_url = "http://localhost:9000/";
	private final String _proj = "Proj_Name";	
	private BaseConfig 	newBaseConfig = new BaseConfig(	
		  	Constants.DEVELOPMENT, 
			Constants.ADMIN_USER, 
			Constants.DEV_DOMAIN,
			Constants.DEV_AUTH,
			Constants.CHROME_BROWSER);
	
	
  @BeforeClass
  public void beforeClass() {
		System.out.println("\n**************************");
		System.out.println("Page Factory Tests Started");
		System.out.println("****************************");
  }	
  
  @BeforeMethod
  public void beforeTest() 
  {	  
	  //Logging which can be done in TestNG
	  _driver = new ChromeDriver();
	  _driver.navigate().to(_base_url);
	  ProjectDashboard_PO = PageFactory.initElements(_driver, ProjectDashboard_PO.class);	  
	  _wait = new WebDriverWait(_driver, 20);
	  _wait.until(ExpectedConditions.visibilityOf(ProjectDashboard_PO.Proj_Name));	  
  }

  /* Validate Tagtune budget text value from Filter*/
  @Test(groups = { "Selenium Tests" })
  public void ValidateSearchFilterBudget() {
	  
	    _wait.until(ExpectedConditions.elementToBeClickable(ProjectDashboard_PO.BlogNation_Budget));	    
	    ProjectDashboard_PO.SearchFilter.click();
	    ProjectDashboard_PO.SearchFilter.sendKeys("20614.14");   
	    _wait.until(ExpectedConditions.textToBePresentInElement(ProjectDashboard_PO.BlogNation_Budget, "20,614.14")); 
	    String blogs =  ProjectDashboard_PO.BlogNation_Budget.getText();
	    
	    Assert.assertTrue(blogs.contains("$20,614.14"));
  }
  
  /* Validate filter using only partial text a division*/
  @Test(groups = { "Selenium Tests" })
  public void ValidateFilterPartialText() {
	  
	    _wait.until(ExpectedConditions.elementToBeClickable(ProjectDashboard_PO.BlogNation_Budget));	    
	    ProjectDashboard_PO.SearchFilter.click();
	    ProjectDashboard_PO.SearchFilter.sendKeys("prod"); 
	    
	    List<WebElement> ProductionList= _wait.until(ExpectedConditions.visibilityOfAllElements(ProjectDashboard_PO.ProductionDivisions));
	    Assert.assertTrue(ProductionList.size() == 5);
	    
	    ProjectDashboard_PO.SearchFilter.clear();
	    ProjectDashboard_PO.SearchFilter.sendKeys("ew");
	    
	    List<WebElement> NewList= _wait.until(ExpectedConditions.visibilityOfAllElements(ProjectDashboard_PO.NewDivisions));
	    Assert.assertTrue(NewList.size() == 4);
  }
  
  /* This test validates the project dashboard name is correct and is visible */
  @Test(groups = { "Selenium Tests" })
  public void ValidateProjectDashBoardsName() {
	  
	  _wait.until(ExpectedConditions.visibilityOf(ProjectDashboard_PO.Proj_Name));
	  Assert.assertTrue(ProjectDashboard_PO.Proj_Name.isDisplayed());	
	  Assert.assertEquals(ProjectDashboard_PO.Proj_Name.getText(), "Project Dashboard");
  }
  
  /* This test involves changing the only values which can be manipulated
   * in Tagtune. This involves changes Project Owner, Budget and Status.
   * Once values have been changed then values have been changes the validate
   * that they are correct */   
  @Test(groups = { "Selenium Tests" })
  public void ValidateDataModelCorrectAfterChangingDataModelValues() {
	  
	  _wait.until(ExpectedConditions.elementToBeClickable(ProjectDashboard_PO.TT_Proj_Owner_Edit_Button));
	  ProjectDashboard_PO.TT_Proj_Owner_Edit_Button.click();
	  ProjectDashboard_PO.TT_Proj_Owner_TextBox.click();
	  ProjectDashboard_PO.TT_Proj_Owner_TextBox.clear();
	  ProjectDashboard_PO.TT_Proj_Owner_TextBox.sendKeys("Test User");
	  
	  /* using javascript to click on hidden element */
	  JavascriptExecutor js =  (JavascriptExecutor)_driver;	 
	  js.executeScript("document.getElementsByClassName('po_edit_icon')[0].click();"); 
	  WebElement e = _driver.findElement(By.xpath("//span[contains(text(), 'Test User')]"));
	  Boolean result = e.isDisplayed();
	  Assert.assertTrue(result);
  }

  /* Testing accounting summation from the project dashboard */
  @Test(groups = { "Selenium Tests" })
  public void ValidateAccountingSummationAreCorrect() {
	  
	  ProjectDashboard_PO.SearchFilter.click();
	  ProjectDashboard_PO.SearchFilter.sendKeys("Accounting");	    
	  List<WebElement> accountingList = _wait.until(ExpectedConditions.visibilityOfAllElements(ProjectDashboard_PO.AccountingDivisions));
	  String size = String.valueOf(accountingList.size());	 
	  String accountCalc = ProjectDashboard_PO.ST_RD_Accounting_Calc.getText();
	  
	  /* Verifying the summation value is equal to amount of accounting divisions*/
	  Assert.assertTrue(accountCalc.contains(size));	  
	  
	  /* The amount of record cards that will increment */
	  int counter = 0;
	  List<WebElement> cards= ProjectDashboard_PO.RecordCards;
		
	  for (WebElement card : cards) {
		 _wait.until(ExpectedConditions.visibilityOf(card)); 
		 if(card.isDisplayed()) {
			 counter++;
		 }		 
	  } 
      	  
	  Assert.assertTrue(accountCalc.contains(String.valueOf(counter)));	  
  }
  
  /* Testing Sales summation from the project dashboard */
  //@Test(groups = { "Selenium Tests" })
  public void ValidateSalesSummationAreCorrect() {
	  
	  java.util.List<WebElement> ele =  _driver.findElements(By.xpath("//span[contains(text(), 'Sales')]"));
	  int count = ele.size();  
	  
	  Assert.assertTrue(count == 5);
  }
  
  /* Testing More Info Buttons summation from the project dashboard */
  //@Test(groups = { "Selenium Tests" })
  public void ValidateAllInfoButtonsExist() {
	  
	  java.util.List<WebElement> ele =  _driver.findElements(By.xpath("//span[contains(text(), 'More Info')]"));
	  int numberDisplayed = 0;
	  for(WebElement elements: ele) {		  
		  elements.click();
		  Boolean displayed = elements.isDisplayed();
		  if(displayed) {
			  numberDisplayed++;
		  }
	  }  
	  
	  Assert.assertTrue(numberDisplayed == 30);
  }

  
  /* Annotations to use after test */
  @AfterMethod
  public void afterTest() {
	  _driver.quit();
  }
  
  @AfterClass
  public void afterClass() {
	  
		System.out.println("**************************");
		System.out.println("Page Factory Tests Ended");
		System.out.println("****************************\n");
  }

}
