package com.TestPages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.TestBase.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	WebElement firstName;
    
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	public boolean ContactsLabelVerification() {
		return contactsLabel.isDisplayed();
		
	}
	
	
	public void ContactsCheckBoxByName() {
		driver.findElement(By.xpath("//tr//tr[4]//td[1]//input[1]")).click();
	}
	
	
	
	public void getNewContact(String title,String fName,String lName,String companyName) {
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(companyName);
		save.click();
	}
	
	
	}
