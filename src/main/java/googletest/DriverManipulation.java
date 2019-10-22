package googletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverManipulation {
	
	private WebDriver driver;

	public DriverManipulation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escrever(By by, String text){
		driver.findElement(by).sendKeys(text);
	}
	
	public void escrever(String id_campo, String text){
		escrever(By.id(id_campo), text);
	}
	
	public void click(String id){
		driver.findElement(By.id(id)).click();
	}
	

}
