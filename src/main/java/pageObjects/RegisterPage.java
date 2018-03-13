package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	@FindBy(id = "email_create")
	private WebElement emailField;
	
	@FindBy(id = "SubmitCreate")
	private WebElement submitButton;
	
	public void clickRegisterPage(String emailId) {
		emailField.sendKeys(emailId);
		submitButton.click();
	}
}
