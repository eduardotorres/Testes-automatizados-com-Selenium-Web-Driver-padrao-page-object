package compageobj;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegras {
	
	private WebDriver driver;
	private DriverManipulation drv;
	private FormularioPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String mensagem;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Berzerk\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Berzerk/Desktop/componentes.html");
		drv = new DriverManipulation(driver);
		page = new FormularioPage(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][]{
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Eduardo", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Eduardo", "Torres", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Eduardo", "Torres", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Eduardo", "Torres", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"},

			});
	}
	
	@Test
	public void deveValidarRegras(){
		page.setName(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")){
			page.setSexoMasc();
		}if(sexo.equals("Feminino")){
			page.setSexoFem();
		}
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
		page.setEsporte(esportes);
		page.cadastrar();
		Assert.assertEquals(mensagem, drv.alertaObterTextoEAceita());
	}


}
