import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Library {
	
	private WebDriver driver;
	private String baseUrl;
	private String browserType = "Chrome";
	  
	@BeforeTest
	public void setup() throws Exception
	{
		
		if (browserType.equals("Firefox"))
		{
			driver = new FirefoxDriver();	
		}
		else if (browserType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//Applications//eclipse//plugins//chromedriver");
			driver = new ChromeDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		baseUrl = "http://cms-dev.image-metrics.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void LogIn() throws Exception
	{
    	driver.get(baseUrl + "/users/login");
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("admin@image-metrics.com");
	    driver.findElement(By.name("password")).sendKeys("Im@gemetrics1");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
    
    public void LogOut() throws Exception
    {
	    driver.findElement(By.cssSelector("li.dropdown > a.dropdown-toggle > b.caret")).click();
	    driver.findElement(By.linkText("Log Out")).click();
    }
    
    public void ChooseCategories(String categoryName)
    {
    	driver.findElement(By.linkText(categoryName)).click();
    }
    
	@AfterTest
	public void tearDown() throws Exception {
	  driver.quit();
//	  String verificationErrorString = verificationErrors.toString();
//	  if (!"".equals(verificationErrorString)) {
//	    fail(verificationErrorString);
//	  }
	}

}
