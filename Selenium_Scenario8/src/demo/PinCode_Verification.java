package demo;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PinCode_Verification {

	WebDriver wd;
	String url = "https://chennaiiq.com/chennai/pincode-by-name.php";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(url);

	}

	@Test
	public void test() {
		WebElement table = wd.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 3; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			String pinCode1 = cols.get(2).getText();
			for (int j = i; j < rows.size(); j++) {
				String pinCode2 = cols.get(2).getText();
				Assert.assertFalse(pinCode1 == pinCode2); // accertion logic
			}
			System.out.println(i);
			if (i == 100) {
				break; // I am checking only first 10 pincodes here
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
