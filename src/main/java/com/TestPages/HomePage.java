package com.TestPages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement user;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement deals;
	
	@FindBy(xpath="//a[@title='Task']")
	WebElement task;
	
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
		return user.isDisplayed();
		 
	}
	
	/*public ContactsPage clickOnContacts() throws FileNotFoundException {
		// contacts.click();
		 return new ContactsPage();
	}
	*/
	public DealsPage clickOnDeals() {
		 deals.click();
		 return new DealsPage();
	}
	public TaskPage clickOnTask() {
		 task.click();
		 return new TaskPage();
	}
	
	public void clickOnNewContacts() {
		Actions act=new Actions(driver);
		act.moveToElement(contacts).build().perform();
		newContact.click();
	}
}
