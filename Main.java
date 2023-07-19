package hackathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Main extends Base{
	
	public void OpenUrl(){
		
		  driver.get("https://www.urbanladder.com");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	    }
	
	 public void bookshelves() throws InterruptedException, IOException{
			
			String title=driver.getTitle();
			//Verifying UrbanLadder WebPage
			if(title.contains("Up to 70% off on Online Furniture | Full House Sale - Urban Ladder")) {
				System.out.println("---------------------------------------");
				System.out.println("Urbanladder Page loaded and verified");
			}
			else {
				System.out.println("---------------------------------------");
				System.out.println("Page not verified");
			}
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[5]")).click();
			Thread.sleep(2000);
			
			//Pop-up closing
			try {
				driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
				}
				catch(Exception e) {
					System.out.println("error......");
				}
			Thread.sleep(3000);
			
			
			driver.findElement(By.id("filters_availability_In_Stock_Only")).click(); 
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//li//div[@class='caret'])[2]")).click();
			List<WebElement> l= driver.findElements(By.xpath("//li//input[@id=\"filters_storage_type_Open\"]"));
			l.get(0).click();	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[5]")).click();
			driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[5]/div[2]/div/div/div/ul/li[2]/label")).click();
			Actions act= new Actions(driver);
			List<WebElement>l1=driver.findElements(By.xpath("//div[@class='gname' ]"));
			act.moveToElement(l1.get(0)).build().perform();
			
			
			WebElement slider=driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
			act.clickAndHold(slider).moveByOffset(-245, 0).release().build().perform();
			Thread.sleep(5000);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[1]/div/div[5]/a/div[1]/span")).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[1]/div/div[5]/a/div[2]/span")).getText());
			
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[2]/div/div[5]/a/div[1]/span")).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[2]/div/div[5]/a/div[2]/span")).getText());
			
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[3]/div/div[5]/a/div[1]/span")).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[3]/div/div[5]/a/div[2]/span")).getText());
			
				
	 }
	 
	 public void sofas() throws InterruptedException, IOException {
		 
		//sofas 
			WebElement w=driver.findElement(By.xpath("//li[@class='topnav_item sofasunit']/span"));
			w.click();
			Thread.sleep(3000);
			
			List<WebElement> s =driver.findElements(By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[2]/div/div"));
			for(WebElement q:s) {
				System.out.println(q.getText());
				
			}
	 }
	 
	 public void GiftCards() throws InterruptedException, IOException {
		 
		// Gift cards
			
			driver.findElement(By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[text()='Birthday/Anniversary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"ip_2251506436\"]")).sendKeys("1000");	
			
			Select date =new Select(driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")));
			date.selectByValue("6/2023");
			
			Select day =new Select(driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[2]")));
			day.selectByVisibleText("18");
			
			driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")).click();
			driver.findElement(By.xpath("//input[@id='ip_4036288348']")).sendKeys("Sanmeet");
			driver.findElement(By.xpath("//input[@id='ip_137656023']")).sendKeys("sanmeetpatil@gmail.com");
			driver.findElement(By.xpath("//input[@id='ip_3177473671']")).sendKeys("9862346223523");
			
			driver.findElement(By.xpath("//input[@id='ip_1082986083']")).sendKeys("Satyam");
			driver.findElement(By.xpath("//input[@id='ip_4081352456']")).sendKeys("satyam@gmail.com");
			driver.findElement(By.xpath("//input[@id='ip_2121573464']")).sendKeys("9860366521");
			driver.findElement(By.xpath("//input[@id='ip_2194351474']")).sendKeys("Bangalore");
			
			driver.findElement(By.xpath("//input[@id='ip_567727260']")).sendKeys("560045");
			
			
			Thread.sleep(2000);
			
			WebElement m=driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",m); 
			
			
			Thread.sleep(1000);
			File img =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File(".//screenshot/screen.png"));
			WebElement p= driver.findElement(By.xpath("//input[@id='ip_3177473671']"));
			System.out.println(p.getAttribute("Title"));
			
		 
	 }
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		Main M = new Main();
		Base B=new Base();
		B.DriverSetup();
		M.OpenUrl();
		M.bookshelves();
		M.sofas();
		Thread.sleep(3000);
		M.GiftCards();
		Thread.sleep(3000);
		B.closeBrowser();
		
		
		
		
		
		

	}

}
