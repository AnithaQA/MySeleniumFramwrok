package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.TestUtil.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static Listeners eventListener;
	
	public TestBase() throws FileNotFoundException{
	
		prop=new Properties();
		FileInputStream fls=new FileInputStream("C:\\Users\\Anitha\\my-CRMapp\\src\\main\\java\\com\\TestProperties\\PropertiesFile");
		try {
			prop.load(fls);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void initialize() throws FileNotFoundException  {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			WebDriverManager.firefoxdriver().setup();
			 driver=new ChromeDriver();
		}
		if(browserName.equals("fireFox")) {
			driver=new FirefoxDriver();
			
			WebDriverManager.firefoxdriver().setup();

		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener=new Listeners();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
