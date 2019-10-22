package compageobj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cadastro {
	
	private WebDriver driver;
	private DriverManipulation drv;
	private FormularioPage page;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berzerk\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Berzerk/Desktop/componentes.html");
		drv = new DriverManipulation(driver);
		page = new FormularioPage(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void realizaCadastro(){
		page.setName("Eduardo");
		page.setSobrenome("Torres");
		page.setSexoMasc();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Eduardo"));
		Assert.assertEquals("Sobrenome: Torres", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
	}
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", drv.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){
		page.setName("nome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", drv.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		page.setName("nome qlqr");
		page.setSobrenome("Sobrenome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", drv.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		page.setName("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFem();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", drv.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso(){
		page.setName("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFem();
		page.setComidaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", drv.alertaObterTextoEAceita());
	}

}
