package com.TestPages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {

 public	LoginPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Login;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
	WebElement Logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return Logo.isDisplayed();
	}
	
	public HomePage Login(String un,String pw) throws FileNotFoundException {
		userName.sendKeys(un);
		password.sendKeys(pw);
		Login.click();
		return new HomePage();
	}
	
	

}
