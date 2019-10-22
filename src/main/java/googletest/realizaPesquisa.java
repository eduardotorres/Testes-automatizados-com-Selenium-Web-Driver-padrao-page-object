package googletest;

import org.openqa.selenium.WebDriver;

public class realizaPesquisa {
	
	private DriverManipulation drv;

	public realizaPesquisa(WebDriver driver) {
		 drv = new DriverManipulation(driver);
	}
	
	public void setPesquisa(String text){
		drv.escrever("search", text);
	}
	
	public void setClick(){
		drv.click("search-icon-legacy");
	}
	

}
