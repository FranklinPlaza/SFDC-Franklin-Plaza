package SalesForce.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class AccountObject {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    
  
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountName;
    
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;
    
    @FindBy(name = "delete")
    @CacheLookup
    private WebElement deleteBtn;
    
	public AccountObject() {
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public AccountObject setAccountName(String accountNameTxt) {
		wait.until(ExpectedConditions.visibilityOf(accountName));
		accountName.clear();
		accountName.sendKeys(accountNameTxt);
		return this;
	}
	
	public void clickSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}
	public void clickDeleteBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		deleteBtn.click();
	}
	
	public void deleteAccount(){
		clickDeleteBtn();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	

}
