package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {
	@FindBy(id = "order-list")
	private WebElement orderTable;
	
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr/td[3]/span")
	private WebElement totalPrice;
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}
}
