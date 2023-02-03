import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		int i = 1;
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// checkbox logic

		WebElement seniorCiti = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		Assert.assertFalse(seniorCiti.isSelected());
		seniorCiti.click();
		Assert.assertTrue(seniorCiti.isSelected());

		// to check element enabled or disabled 1st method
		/*
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 * driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 */

		// to check element enabled or disabled 2nd method
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// to get the size/count of checkboxes.
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		// with while condition
		/*
		 * while(i<4) { driver.findElement(By.id("hrefIncAdt")).click(); i++; }
		 */
		// with for loop
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.close();
	}

}
