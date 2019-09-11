package desafio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestC {
	
	@Test
	public void click(){
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berzerk\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.google.com/");
	
	WebElement pesquisa = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input"));
	pesquisa.clear();
	pesquisa.sendKeys("Death Metal");
	
	WebElement pesquisar = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]"));
	pesquisar.click();
	}

}
