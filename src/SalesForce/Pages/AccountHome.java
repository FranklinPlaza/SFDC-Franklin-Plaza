package SalesForce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class AccountHome {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(name = "new")
    @CacheLookup
    private WebElement newBtn;
    
	public AccountHome() {
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public AccountObject clickNewBtn(){
		wait.until(ExpectedConditions.elementToBeClickable(newBtn));
		newBtn.click();
		return new AccountObject();
	}
	
	public void clickAccountToDelete(String accountName){
		WebElement linkAccount = driver.findElement(By.xpath("//div[@class='pbBody']/descendant::a[contains(.,'"+accountName+"')]")); 
		wait.until(ExpectedConditions.elementToBeClickable(linkAccount));
		linkAccount.click();
	}

}
