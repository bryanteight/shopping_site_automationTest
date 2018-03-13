package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import accountInfo.Account;

public class RegisterFillPage {
	
	private Select select;
	
	@FindBy(id = "id_gender1")
	private WebElement genderRadioBtn_male;

    @FindBy(id = "id_gender2")
    private WebElement genderRadioBtn_female;

    @FindBy(id = "customer_firstname")
    private WebElement cus_firstName_field;
    
    @FindBy(id = "customer_lastname")
    private WebElement cus_lastName_field;
    
    @FindBy(id = "passwd")
    private WebElement password_field;
    
    @FindBy(id = "days")
    private WebElement day_option;
    
    @FindBy(id = "months")
    private WebElement month_option;
    
    @FindBy(id = "years")
    private WebElement year_option;
    
    @FindBy(id = "newsletter")
    private WebElement newsletter_checkBox;
	
   
    
    @FindBy(id = "company")
    public static WebElement company_field;
  
    @FindBy(id = "address1")
    public static WebElement address_field;
    
    @FindBy(id = "city")
    public static WebElement city_field;
    
    @FindBy(id = "id_state")
    public static WebElement state_option;
    
    @FindBy(id = "postcode")
    public static WebElement postcode_field;
    
    @FindBy(id = "phone")
    public static WebElement phone_field;
    
    @FindBy(id = "phone_mobile")
    public static WebElement phone_mobile_field;
    
    @FindBy(id = "alias")
    public static WebElement alias_field;
 
    @FindBy(id = "submitAccount")
    public static WebElement registerButton;
    
	public void fillForm(Account account) {
		genderRadioBtn_male.click();
		cus_firstName_field.sendKeys(account.getFirstName());
		cus_lastName_field.sendKeys(account.getLastName());
		password_field.sendKeys(account.getPassword());
		select = new Select(day_option);
		select.selectByIndex(10);
		select = new Select(month_option);
		select.selectByIndex(2);
		select = new Select(year_option);
		select.selectByIndex(25);
		newsletter_checkBox.click();
	
		company_field.sendKeys(account.getCompany());
		address_field.sendKeys(account.getAddress());
		city_field.sendKeys(account.getCity());
		select = new Select(state_option);
		select.selectByIndex(5);
		postcode_field.sendKeys(account.getZipcode());
		phone_field.sendKeys("4124569458");
		phone_mobile_field.sendKeys(account.getMobilePhone());
		alias_field.sendKeys(account.getAlias());
		registerButton.click();
	}
}
