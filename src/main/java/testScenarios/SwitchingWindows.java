package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows { 
	
	WebDriver driver;
	
	
	@Test
	public void switchWin() {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String>allWinds= driver.getWindowHandles();
		System.out.println("tot win="+allWinds.size());
		Iterator<String> itr = allWinds.iterator();
		String win1 = null;
		String win2 = null;
		if (itr.hasNext()) {
			win1 = itr.next();
			win2 = itr.next();
		}
		System.out.println("Win1 ="+ win1);
		System.out.println("Win2 ="+ win1);
		System.out.println("Win1 title"+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Win1 title"+driver.getTitle());
		boolean checkEnab= driver.findElement(By.linkText("Sign Up")).isEnabled();
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


