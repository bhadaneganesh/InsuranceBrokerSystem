package insuranceBrokerSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class InsuranceBrokerSystem {

	WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ankita\\Desktop\\Chromedrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		//user registration
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		driver.findElement(By.id("user_firstname")).sendKeys("virat");
		driver.findElement(By.id("user_surname")).sendKeys("kohli");
		driver.findElement(By.id("user_phone")).sendKeys("9958598458");
		WebElement year=driver.findElement(By.id("user_dateofbirth_1i"));
		Select select = new Select(year);
		select.selectByValue("1992");
		driver.findElement(By.id("user_address_attributes_street")).sendKeys("jmroad");
		driver.findElement(By.id("user_address_attributes_city")).sendKeys("pune");
		driver.findElement(By.id("user_address_attributes_county")).sendKeys("india");
		driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("411232");
		driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("virat.kohli@gmail.com");
		driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("virat@1234");
		driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("virat@1234");    
		driver.findElement(By.xpath("//*[@name='submit']")).click();  
		
		//login failure
		
		driver.findElement(By.id("email")).sendKeys("virat@gmail.com");
		driver.findElement(By.id("password")).sendKeys("virat@1234");
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		String error=driver.findElement(By.xpath("//*[text()='Enter your Email address and password correct']")).getText();
		Assert.assertEquals(error, "Enter your Email address and password correct");
        driver.close();   
        
		//login Success
        
        driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
		driver.findElement(By.id("password")).sendKeys("virat@1234");
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		String useremailid=driver.findElement(By.xpath("//*[text()='virat.kohli@gmail.com']")).getText();
		Assert.assertEquals(useremailid, "virat.kohli@gmail.com");
		 driver.close();    
		 
		 //Request Quotation
		 
		    driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
			driver.findElement(By.id("password")).sendKeys("virat@1234");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
			driver.findElement(By.xpath("//*[text()='Request Quotation']")).click();
			driver.findElement(By.id("quotation_incidents")).sendKeys("123423");
			driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys("123344");
			driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys("1233");
			driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys("90000");
			WebElement location=driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
			Select select2 = new Select(location);
			select2.selectByValue("Public place");
			
			WebElement yearr=driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i"));
			Select select1 = new Select(yearr);
			select1.selectByValue("2022");
			driver.findElement(By.xpath("//*[@value='Save Quotation']")).click();
			
		driver.close();  
			
			//Quotation Retrieve
			
			driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
			driver.findElement(By.id("password")).sendKeys("virat@1234");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
			driver.findElement(By.xpath("//*[text()=\"Retrieve Quotation\"]")).click();
			driver.findElement(By.xpath("//*[@name='id']")).sendKeys("21623");
			driver.findElement(By.id("getquote")).click();
			driver.close();   
			
			//Profile
			
			driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
			driver.findElement(By.id("password")).sendKeys("virat@1234");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
			driver.findElement(By.id("ui-id-4")).click();    
			
			//Edit Profile
			
			driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
			driver.findElement(By.id("password")).sendKeys("virat@1234");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
			driver.findElement(By.id("editprofile")).click();
			driver.findElement(By.id("user_surname")).sendKeys("sachin");
			driver.findElement(By.id("user_firstname")).sendKeys("tendulkar");
			driver.findElement(By.xpath("//*[@value='Update User']")).click();
			driver.close();  
			
			//log out
			
			driver.findElement(By.id("email")).sendKeys("virat.kohli@gmail.com");
			driver.findElement(By.id("password")).sendKeys("virat@1234");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
			driver.findElement(By.xpath("//*[@value='Log out']")).click();
			driver.close();   
			
	}
	
	

}
