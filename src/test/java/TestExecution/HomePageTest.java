package TestExecution;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.ContactsPage;
import com.TestPages.HomePage;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
HomePage hp;
LoginPage lp;
TestUtil tu;
ContactsPage cp;
	public HomePageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialize();
		lp=new LoginPage();
		tu=new TestUtil();
		cp=new ContactsPage();
		hp=lp.Login(prop.getProperty("userId"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String HomePagetitle=hp.HomePageTitle();
		Assert.assertEquals(HomePagetitle, "CRMPRO");
	}
	@Test(priority=2)
	public void verifyUsernameTest() {
	tu.switchToframe();
	Assert.assertTrue(hp.verifyUsername());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() throws FileNotFoundException {
		tu.switchToframe();
		//cp=hp.clickOnContacts();
		
	}
}
