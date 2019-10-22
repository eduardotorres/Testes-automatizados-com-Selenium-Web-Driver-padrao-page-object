package googletest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import compageobj.DriverManipulation;

public class Pesquisa {
	
	private WebDriver driver;
	private DriverManipulation drv;
	private realizaPesquisa page;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berzerk\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		drv = new DriverManipulation(driver);
		page = new realizaPesquisa(driver);
	}
	
	@Test
	public void realizaPesquisaYoutube(){
		page.setPesquisa("greentea peng");
		page.setClick();
		
	}
	
}
