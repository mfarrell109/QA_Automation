package base.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.bcel.internal.classfile.ElementValue;

import sun.net.www.content.text.plain;

/* This is the base page object for the Project Dashbaord. 
 * Please only add elements to this page object
 * by selector. Consists of calculations, textboxes and buttons
 * Stat = Statistics
 * ST = Status
 * RD = Record Divisions
 * RS = Record Status
 * */
public class ProjectDashboard_PO {

		
	@FindBy(how=How.CSS,using="body > div > section > md-sidenav > md-toolbar > h4")
	WebElement Proj_Name;
	
	@FindBy(how=How.CSS,using="#recordStats > div.flex-50 > p:nth-child(2)")
	WebElement ST_RD_Accounting_Calc;
	
	@FindBy(how=How.CSS,using="#recordStats > div.flex-50 > p:nth-child(3)")
	WebElement ST_RD_Administration_Calc;
	
	@FindBy(how=How.CSS,using="#recordStats > div.flex-50 > p:nth-child(4)")
	WebElement ST_RD_Marketing_Calc;

	/* Tagtune Elements */	
	@FindBy(how=How.ID,using="input_1")
	WebElement TT_Proj_Owner_TextBox;
	
	@FindBy(how=How.CLASS_NAME,using="po_edit_icon")
	WebElement TT_Proj_Owner_Edit_Button;
	
	@FindBy(how=How.CSS,using="#input_0")
	WebElement SearchFilter;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(), '20,614.14')]")
	WebElement BlogNation_Budget;
	
	/* List of WebElements */
	@FindBy(how=How.XPATH,using="//span[contains(text(), 'Production')]")
	List<WebElement> ProductionDivisions;

	@FindBy(how=How.XPATH,using="//span[contains(text(), ' new')]")
	List<WebElement> NewDivisions;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(), ' Accounting')]")
	List<WebElement> AccountingDivisions;	

	/*  */
	@FindBy(how=How.XPATH,using="//md-card[@class='col-sm-3 projCard ng-scope']")
	List<WebElement> RecordCards;
}
