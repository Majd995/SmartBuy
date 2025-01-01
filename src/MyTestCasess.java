import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasess {

	WebDriver driver = new ChromeDriver();

	String Mywebsite = "https://smartbuy-me.com/";

	String usernameField = "student";
	String passwordField = " Password123";

	Random rand = new Random();

	@BeforeTest
	public void Mysetub() {
		driver.manage().window().maximize();

		driver.get(Mywebsite);
	}

	@Test(priority = 1)
	public void testSignUpAndSignIn() throws InterruptedException {

		WebElement MyaccountBytton = driver.findElement(By.linkText("My account"));
		MyaccountBytton.click();

		WebElement Createaccount = driver.findElement(By.linkText("Create your account"));
		Createaccount.click();
	}

	@Test(priority = 2)
	public void Createmyaccount() throws InterruptedException {

		String[] firstname = { "Majd", "Rahaf", "Zenab", "Ziad", "Ahmad", "Othman" };
		String[] Lasttname = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };

		String[] passwords = { "Test@1234", "Password!2025", "RandomP@ss1", "MySecureP@ssw0rd", "1q2w3e4rT@!",
				"Admin#2025", "P@ssw0rd123", };
		String[] emails = { "testuser1@example.com", "randomuser2@mail.com", "demo.user3@gmail.com",
				"exampleuser4@outlook.com", "john.doe5@yahoo.com" };

		int rabomIndexfirstname = rand.nextInt(firstname.length);
		int RandomInbexLasttname = rand.nextInt(Lasttname.length);
		int rabomIndexpasswords = rand.nextInt(passwords.length);
		int RandomInbexemails = rand.nextInt(emails.length);

		WebElement firstnameInput = driver.findElement(By.id("customer[first_name]"));
		WebElement lastnameInput = driver.findElement(By.id("customer[last_name]"));
		WebElement email = driver.findElement(By.id("customer[email]"));
		WebElement passwordInput = driver.findElement(By.id("customer[password]"));
		firstnameInput.sendKeys(firstname[rabomIndexfirstname]);
		lastnameInput.sendKeys(Lasttname[RandomInbexLasttname]);
		email.sendKeys(emails[RandomInbexemails]);
		passwordInput.sendKeys(passwords[rabomIndexpasswords]);

		Thread.sleep(2000);
		WebElement ButtonCreate = driver.findElement(By.className("form__submit"));
		ButtonCreate.click();
	}

	@Test(priority = 3)
	public void saerchboox() throws InterruptedException {

		WebElement saerchboox = driver.findElement(By.className("search-bar__input"));
		saerchboox.sendKeys("iPhone");
		WebElement searchbar = driver.findElement(By.className("search-bar__submit"));
		searchbar.click();
		Thread.sleep(2000);

		String[] prices = { "1000", "1500", "1700" };
		int randomIndex = rand.nextInt(prices.length);

		String selectedPrice = prices[randomIndex];
		int numericPrice = Integer.parseInt(selectedPrice);
		System.out.println("Selected random price: " + numericPrice);

		WebElement addToCartButton = driver.findElement(By.className("product-item__action-button"));
		addToCartButton.click();

	}
	@Test(priority = 4)
	public void goToCheckoutPage() throws InterruptedException {
	 
	    WebElement cartButton = driver.findElement(By.className("cart-icon")); 
	    cartButton.click();

	    WebElement checkoutButton = driver.findElement(By.className("checkout-button")); 
	    checkoutButton.click();
	     
	}

}
