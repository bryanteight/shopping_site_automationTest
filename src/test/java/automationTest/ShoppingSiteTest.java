package automationTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import accountInfo.Account;
import accountInfo.Order;
import pageObjects.DressesPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductPage;
import pageObjects.RegisterFillPage;
import pageObjects.RegisterPage;

public class ShoppingSiteTest {
	private final static String url1 = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private final static String url2 = "http://automationpractice.com/index.php?id_category=8&controller=category";
	private WebDriver webdriver;
	protected Account account;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		webdriver = new ChromeDriver();
		
		
		account = new Account.AccountBuilder("Brian", "Chen")
					.password("12345")
					.company("ABC Inc")
					.address("1200 happy st")
					.city("Sunnyvale")
					.zipcode("98324")
					.mobilePhone("6264875824")
					.alias("Brian's account")
					.build();
	}
	
	@Test(priority = 1)
	public void testRegister() {
		webdriver.get(url1);
	
		RegisterPage registerPage = PageFactory.initElements(webdriver, RegisterPage.class);
		registerPage.clickRegisterPage(account.getEmail());
		
		webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		RegisterFillPage registerFillPage = PageFactory.initElements(webdriver, RegisterFillPage.class);
		registerFillPage.fillForm(account);
	}
	
	@Test(priority = 2)
	public void testCheckout() {
		webdriver.get(url2);
		
		DressesPage dressesPage = PageFactory.initElements(webdriver, DressesPage.class);
		dressesPage.getDressesPage(webdriver);
		webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ProductPage productPage = PageFactory.initElements(webdriver, ProductPage.class);
		productPage.checkout(webdriver, account);
		webdriver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		OrderHistoryPage orderHistoryPage = PageFactory.initElements(webdriver, OrderHistoryPage.class);
		
		List<Order> currentOrders = account.getOrderList();
		
		Assert.assertNotNull(currentOrders);
		Assert.assertTrue(currentOrders.size() != 0);
		
		Order latestOrder = currentOrders.get(currentOrders.size() - 1);
		Assert.assertEquals(latestOrder.getTotal_price(), orderHistoryPage.getTotalPrice());
	}
		
	@AfterClass
	public void tearDown() {
		webdriver.close();
		webdriver.quit();
    }
}
