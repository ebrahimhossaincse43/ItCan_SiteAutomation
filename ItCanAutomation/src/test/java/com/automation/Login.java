package com.automation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login extends DriverSetup {

	public static String baseURL = "https://www.itcanapp.com/login";

	@Test
	public static void Test() throws InterruptedException {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// Login Section

		WebElement gmail = driver.findElement(By.xpath("//div[@class='google-button']"));
		gmail.click();
		Thread.sleep(1000);
		
		String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		    
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.findElement(By.xpath("//input[contains(@id,'identifierId')]")).sendKeys("");
            		driver.findElement(By.xpath("//button[contains(@class,'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b')]")).click();
            		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("");
            		Thread.sleep(3000);
            		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();  
            	    Thread.sleep(5000);    
            	    driver.close();
            }		
        }
        driver.switchTo().window(MainWindow);	
	}

}
