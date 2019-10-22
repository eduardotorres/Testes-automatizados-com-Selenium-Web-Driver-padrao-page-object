package compageobj;

import org.openqa.selenium.WebDriver;

public class FormularioPage {
	
	private DriverManipulation drv;

	public FormularioPage(WebDriver driver) {
		drv = new DriverManipulation(driver);
	}
	
	public void setName(String name){
		drv.escrever("elementosForm:nome", name);
	}
	
	public void setSobrenome(String sobrename){
		drv.escrever("elementosForm:sobrenome", sobrename);
	}
	
	public void setSexoMasc(){
		drv.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFem(){
		drv.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaPizza(){
		drv.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	
	public void setEscolaridade(String value){
		drv.selecionarCombo("elementosForm:escolaridade", value);
	}
	
	public void setEsporte(String... valores){
		for (String valor: valores)
		drv.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar(){
		drv.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro(){
		return drv.obterTexto("resultado");
	}
	
	public String obterNomeCadastro(){
		return drv.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastro(){
		return drv.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro(){
		return drv.obterTexto("descSexo");
	}
	public String obterComidaCadastro(){
		return drv.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastro(){
		return drv.obterTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastro(){
		return drv.obterTexto("descEsportes");
	}
	
	public void setComidaCarne(){
		drv.clicarRadio("elementosForm:comidaFavorita:0");
		
	}
	
	public void setComidaVegetariano(){
		drv.clicarRadio("elementosForm:comidaFavorita:3");
		
	}
	
	

}
