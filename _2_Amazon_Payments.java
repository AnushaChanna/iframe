package iframe;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_Amazon_Payments 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
{
		FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Selenium_Assignments\\DDT\\loginsheet.xlsx");
		Workbook w1= WorkbookFactory.create(file);
		String UN=NumberToTextConverter.toText(w1.getSheet("amazonlogin").getRow(0).getCell(0).getNumericCellValue());
		String PW=w1.getSheet("amazonlogin").getRow(0).getCell(1).getStringCellValue();
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoes" + Keys.ENTER);
		WebElement selectshoe= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[4]"));
		selectshoe.click();
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> id =ids.iterator();
		String Parent_id= id.next();
		String Child_id=id.next();
		
		driver.close();
		driver.switchTo().window(Child_id);
		
		WebElement buynow= driver.findElement(By.id("buy-now-button"));
		buynow.click();	
		
		WebElement email=driver.findElement(By.name("email"));
		email.sendKeys(UN + Keys.ENTER);
	
		WebElement password=driver.findElement(By.id("ap_password"));
		password.sendKeys(PW + Keys.ENTER);
	
	
	
}	
}
