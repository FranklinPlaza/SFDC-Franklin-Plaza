package SalesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class OpportunityHome {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(name = "new")
    @CacheLookup
    private WebElement newBtn;
    
	public OpportunityHome() {
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public OpportunityObject clickNewBtn(){
		wait.until(ExpectedConditions.elementToBeClickable(newBtn));
		newBtn.click();
		return new OpportunityObject();
	}

}
