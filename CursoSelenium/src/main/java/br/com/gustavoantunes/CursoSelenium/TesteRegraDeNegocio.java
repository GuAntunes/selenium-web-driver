package br.com.gustavoantunes.CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRegraDeNegocio {

	@Test
	public void testNomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Nome eh obrigatorio", texto);

		driver.quit();
	}
	

	@Test
	public void testSobrenomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gustavo");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", texto);

		driver.quit();
	}

	@Test
	public void testSexoObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gustavo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Antunes");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Sexo eh obrigatorio", texto);

		driver.quit();
	}
	
	@Test
	public void testComidaVegetarianaComCarne() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gustavo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Antunes");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);

		driver.quit();
	}
	
	
	@Test
	public void testComidaVegetarianaComFrango() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gustavo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Antunes");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);

		driver.quit();
	}
	
	
	@Test
	public void testPraticaEsportes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gustavo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Antunes");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();

		String texto = alert.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", texto);

		driver.quit();
	}
}
