package TestExecution;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.ContactsPage;
import com.TestPages.HomePage;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{

	public ContactsPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	HomePage hp;
	LoginPage lp;
	TestUtil tu;
	ContactsPage cp;
	String sheetName = "Contacts";
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialize();
		lp=new LoginPage();
		tu=new TestUtil();
		cp=new ContactsPage();
		hp=lp.Login(prop.getProperty("userId"), prop.getProperty("password"));
		tu.switchToframe();
	  //cp= hp.clickOnContacts();
	    
	
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		
		Assert.assertTrue(cp.ContactsLabelVerification());
	}
	
	@Test(priority=2)
public void verifyCheckBoxTest() {
		
		cp.ContactsCheckBoxByName();
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		
	Object data[][]=TestUtil.getTestData(sheetName);
	
	return data;
		
	}
	

	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		hp.clickOnNewContacts();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		cp.getNewContact( title, firstName, lastName,company);
		
	}
	
	@Test(priority=3)
	public void validatecreateNewContactTest() throws FileNotFoundException {
		hp.clickOnNewContacts();
		cp.getNewContact("Ms.", "Anita", "Srinivasan", "Orcapod");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
