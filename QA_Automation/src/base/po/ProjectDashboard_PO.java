package base.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	
}
