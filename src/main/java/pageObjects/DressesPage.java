package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DressesPage {
	
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement dressesCategory;
	
	@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']//div[@class='right-block']//h5[@itemprop='name']//a[@class='product-name']")
	private WebElement printed_dress;
	
	public void getDressesPage(WebDriver webdriver) {
        printed_dress.click();
    }

}
