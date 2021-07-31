package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegrationIT {

	@Test
	public void deveriaCadastrarUmNovoAluno() {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Arquivos\\Downloads\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8484/bootaluno");
		
		driver.findElement(By.linkText("Cadastrar novo aluno")).click();
		
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Jhon Doo");
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("JhonDoo@email.com");
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		assertTrue(driver.getPageSource().contains("Jhon Doo"));
		
		driver.close();
				
	}
	
//	@Test	
//	public void deveriaDeletarUmAluno() {
//		
//		cadastrarAluno("Joe Dee", "joedee@email.com");
//		
//		System.setProperty("webdriver.gecko.driver", "E:\\Arquivos\\Downloads\\geckodriver.exe");
//		
//		WebDriver driver = new FirefoxDriver();
//		
//		driver.get("http://localhost:8484/bootaluno");
//		
//		driver.findElements(By.tagName("tr")).forEach(el ->{
//			el.findElements(By.tagName("td")).forEach(td ->{
//				if(td.getText().equals("Joe Dee")) {
//					
//				}
//			});
//		});
//		
//	}
//	
//	public void cadastrarAluno(String nome, String email) {
//		System.setProperty("webdriver.gecko.driver", "E:\\Arquivos\\Downloads\\geckodriver.exe");
//		
//		WebDriver driver = new FirefoxDriver();
//		
//		driver.get("http://localhost:8484/bootaluno");
//		
//		driver.findElement(By.linkText("Cadastrar novo aluno")).click();
//		
//		driver.findElement(By.id("nome")).click();
//		driver.findElement(By.id("nome")).sendKeys(nome);
//		
//		driver.findElement(By.id("email")).click();
//		driver.findElement(By.id("email")).sendKeys(email);
//		
//		driver.findElement(By.cssSelector(".btn-primary")).click();
//		
//		driver.close();
//	}
		

}
