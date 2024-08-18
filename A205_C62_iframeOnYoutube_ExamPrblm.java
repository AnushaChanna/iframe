package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A205_C62_iframeOnYoutube_ExamPrblm 
{
	@Test
	public void grotechminds() throws InterruptedException
	{
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		WebElement gtm= driver.findElement(By.id("APjFqb"));
		gtm.sendKeys("Grotechminds" + Keys.ENTER);
		
		WebElement hamburger= driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
		hamburger.click();
		
		driver.switchTo().frame(0);
		WebElement youtube= driver.findElement(By.linkText("YouTube"));//div[@class='MrEfLc']/ul/li
		youtube.click();
		
		driver.switchTo().defaultContent();
		
		
		WebElement searchyt= driver.findElement(By.name("search_query"));
		searchyt.click();
		searchyt.sendKeys("grotechminds"+Keys.ENTER);
		
		
		WebElement subscribe= driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[10]"));
		subscribe.click();
		
	}
	
}
