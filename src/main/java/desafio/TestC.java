package desafio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestC {
	
	@Test
	public void click(){
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berzerk\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	}

}
