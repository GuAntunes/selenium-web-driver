package br.com.gustavoantunes.CursoSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	@Test
	public void teste(){
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().window().setPosition(new Point(100, 100));
		
		//Define o tamanho da janela
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//Define que a janela irá abrir maximizado
//		driver.manage().window().maximize();
		

		
		driver.get("http://www.google.com");
		assertEquals("Google", driver.getTitle());
		
		//Fechar todas as abas do navegador e fechar o driver
		driver.quit();
	}
}
