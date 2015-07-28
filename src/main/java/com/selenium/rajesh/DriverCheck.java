package com.selenium.rajesh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DriverCheck {

	public static void main(String[] args) {
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.name("Email"));
		element.sendKeys("mail4yrajesh");
		element = driver.findElement(By.name("Passwd"));
		element.sendKeys("");
		element = driver.findElement(By.name("signIn"));
		element.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Window --  "+driver.getTitle());
		String mainHandle = driver.getWindowHandle();
		element = driver.findElement(By.xpath("//*[@id=\":jc\"]/div/div"));
		element.click();
		for(String activeHanle: driver.getWindowHandles()){
			if(activeHanle!=mainHandle){
				driver.switchTo().window(activeHanle);
				element = driver.findElement(By.name("to"));
				element.sendKeys("mail4yrajesh@gmail.com");
				element = driver.findElement(By.name("subjectbox"));
				element.sendKeys("Test Mail!!");
				element = driver.findElement(By.id(":zo"));
				element.sendKeys("Hi Rajesh,<br>This is the test mail from selenium program!");
				element = driver.findElement(By.id(":yc"));
				element.click();
			}
		}

		driver.switchTo().window(mainHandle);
		driver.close();
	}

}
