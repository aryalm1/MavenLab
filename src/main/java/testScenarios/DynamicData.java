package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicData {
	WebDriver driver;
	
	@Test
	public void MathCalc() {
		driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		driver.manage().window().maximize();
		String str = driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(str);
		String str1= str.substring(8,9);
		String str2= str.substring(12,13);
		Integer results = Integer.valueOf(str1)+ Integer.valueOf(str2);
		
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(results));
		boolean checkEnab= driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
		System.out.println(checkEnab);
		if (checkEnab==true) {
			System.out.println("ok");
		}
		else {
			System.out.println("not ok");
		}
		driver.close();
	}
}
