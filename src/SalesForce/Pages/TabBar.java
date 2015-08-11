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

public class TabBar {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsTab;
	
	@FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunityTab;
	
	
	public TabBar() {
		
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
		
	}
	
	public AccountHome clickOnAccountsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(accountsTab));
		accountsTab.click();
		return new AccountHome();
	}
	
	public OpportunityHome clickOnOpportunitiesTab() {
		wait.until(ExpectedConditions.elementToBeClickable(opportunityTab));
		opportunityTab.click();
		return new OpportunityHome();
	}

}
