package desafio;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChallenge {

	@Test
	public void singIn() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/");

		// clica no Sign in para ir pra tela de login
		WebElement singin = driver.findElement(By.id("sign-in"));
		singin.click();

		driver.quit();
	}

	@Test
	public void camposVazios() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/sign_in");

		// Testa clicar em Sign in com todos os campos vazios
		WebElement singin2 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		singin2.click();

		WebElement message = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String text = message.getText();
		Assert.assertEquals("Bad email or password", text);
		
		driver.quit();
	}

	@Test
	public void emailVazio() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/sign_in");

		// Acessa o sistema com o campo email vazio
		WebElement password = driver.findElement(By.id("session_password"));
		password.clear();
		password.sendKeys("gmail123");

		WebElement singin3 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		singin3.click();

		WebElement message2 = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String text2 = message2.getText();
		Assert.assertEquals("Bad email or password.", text2);
		
		driver.quit();

	}
	
	@Test
	public void passrwordVazio() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/sign_in");
		
		WebElement email = driver.findElement(By.id("session_email"));
		email.clear();
		email.sendKeys("eduardolpx@gmail.com");
		
		WebElement singin4 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		singin4.click();
		
		WebElement message3 = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String text3 = message3.getText();
		Assert.assertEquals("Bad email or password.", text3);
		
		driver.quit();
		
	}
	
	@Test
	public void validarCadastro() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/sign_in");
		
		WebElement email2= driver.findElement(By.id("session_email"));
		email2.clear();
		email2.sendKeys("dudulpx@gmail.com");
		
		WebElement password2 = driver.findElement(By.id("session_password"));
		password2.clear();
		password2.sendKeys("iron666");
		
		WebElement singin5 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		singin5.click();
		
		WebElement validacaoEmail = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/span"));
		String texto = validacaoEmail.getText();
		Assert.assertEquals("dudulpx@gmail.com", texto);
		
		driver.quit();
		
	}
	
	@Test 
	public void validarSignUP() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aluno\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://a.testaddressbook.com/sign_up");
		
		WebElement user1 = driver.findElement(By.id("user_email"));
		user1.clear();
		user1.sendKeys("dudutorres666@gmail.com");
		
		WebElement password3 = driver.findElement(By.id("user_password"));
		password3.clear();
		password3.sendKeys("iron300995");
		
		WebElement singUp = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/input"));
		singUp.click();
		
		WebElement textValidate = driver.findElement(By.xpath("/html/body/div/div/h1"));
		String messageValidate = textValidate.getText();
		Assert.assertEquals("Welcome to Address Book", messageValidate);
		
		driver.quit();
	
	}

}
