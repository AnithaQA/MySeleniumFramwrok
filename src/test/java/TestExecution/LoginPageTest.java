package TestExecution;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.HomePage;
import com.TestPages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	public LoginPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialize();
		lp=new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String title=lp.validateLoginPageTitle();
	
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void CRMLogoImageTest() {
		boolean flag=lp.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginPage() throws FileNotFoundException {
		hp=lp.Login(prop.getProperty("userId"), prop.getProperty("password"));
	}

}
