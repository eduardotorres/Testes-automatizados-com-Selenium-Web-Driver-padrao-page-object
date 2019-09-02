package paginas;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestForm {
	
	@Test
	public void cadastroValidacaoNome() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/aluno/eclipse-workspace/TestFabrica/target/componentes.html");

		 WebElement cadastrar1 = driver.findElement(By.id("elementosForm:cadastrar"));
		 cadastrar1.click();
		 
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
		 WebElement nome = driver.findElement(By.id("elementosForm:nome"));
		 nome.clear();
		 nome.sendKeys("Eduardo");
		 
		 WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		 sobrenome.clear();
		 sobrenome.sendKeys("Torres");
		 
		 WebElement sexo = driver.findElement(By.id("elementosForm:sexo:0"));
		 sexo.click();
		 
		 WebElement comida = driver.findElement(By.id("elementosForm:comidaFavorita:3"));
		 comida.click();
		 
		 WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		 Select combo = new Select(element);
		 combo.selectByValue("superior");
		 Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		 
		 WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
		 Select option = new Select(esporte);
		 option.selectByValue("Karate");
		 Assert.assertEquals("Karate", option.getFirstSelectedOption().getText());
		 
		 WebElement sugestao = driver.findElement(By.id("elementosForm:sugestoes"));
		 sugestao.clear();
		 sugestao.sendKeys("nada aushduahd");
		 
		 cadastrar1.click();
		 
		 WebElement confirmar = driver.findElement(By.id("confirm"));
		 confirmar.click();
		 alert.accept();
		 alert.accept();

	}

}
