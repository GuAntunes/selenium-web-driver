package br.com.gustavoantunes.CursoSelenium;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	@Test
	public void deveRealizarUmCadastro() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement nome = driver.findElement(By.id("elementosForm:nome"));
		nome.sendKeys("Gustavo");
		Assert.assertEquals("Gustavo", nome.getAttribute("value"));
		
		WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		sobrenome.sendKeys("Antunes");
		Assert.assertEquals("Antunes", sobrenome.getAttribute("value"));
		
		WebElement sexo = driver.findElement(By.id("elementosForm:sexo:0"));
		sexo.click();
		Assert.assertTrue(sexo.isSelected());
		
		WebElement comida = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		comida.click();
		Assert.assertTrue(comida.isSelected());
		
		WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboEscolaridade = new Select(escolaridade);
		comboEscolaridade.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", comboEscolaridade.getFirstSelectedOption().getText());
		
		WebElement esportes = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsportes = new Select(esportes);
		comboEsportes.selectByVisibleText("Natacao");
		comboEsportes.selectByVisibleText("Futebol");
		List<WebElement> allSelectedOptions = comboEsportes.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		WebElement sugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		sugestoes.sendKeys("Sugestões aqui");
		Assert.assertEquals("Sugestões aqui", sugestoes.getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Gustavo"));
		Assert.assertEquals("Sobrenome: Antunes", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
		
		driver.quit();
	}
	
}
