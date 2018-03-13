package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import accountInfo.Account;
import accountInfo.Order;

public class ProductPage {
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	private WebElement addToCartButton;
	
	@FindBy(id = "layer_cart")
	private WebElement layer_cart;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
	private WebElement summary_checkoutBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
	private WebElement address_checkoutBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
	private WebElement shipping_checkoutBtn;
	
	@FindBy(id = "cgv")
	private WebElement serviceAgreeBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
	private WebElement bankWireButton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
	private WebElement confirmButton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[1]/a[1]")
	private WebElement backToOrderBtn;
	
	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	private WebElement total;
	

	public void checkout(WebDriver webdriver, Account account) {
		addToCartButton.click();
		WebDriverWait wait = new WebDriverWait(webdriver, 10);	
		wait.until(ExpectedConditions.visibilityOf(layer_cart));
		
		createOrder(total.getText(), account);
		System.out.println("get total: " + total.getText());
		
		checkoutButton.click();
		summary_checkoutBtn.click();
		address_checkoutBtn.click();
		serviceAgreeBtn.click();
		shipping_checkoutBtn.click();
		bankWireButton.click();
		confirmButton.click();
		backToOrderBtn.click();
	}
	
	private void createOrder(String price, Account account) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Order order = new Order(price, dateFormat.format(date));
		account.addOrder(order);
	}
	
	
}
