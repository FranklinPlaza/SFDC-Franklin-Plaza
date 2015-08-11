package SalesForce.Pages;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class LookupPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(id = "lksrch")
    @CacheLookup
    private WebElement lookupTxt;
	
	@FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;
	
	@FindBy(id = "resultsFrame")
    @CacheLookup
    private WebElement lookupResult;
	/*
	@FindBy(linkText = "TestAccount3")
    @CacheLookup
    private WebElement result;
    */
	public LookupPage() {
		
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
		
	}
	public  LookupPage setTxtToLookFor(String text) {
		wait.until(ExpectedConditions.visibilityOf(lookupTxt));
		lookupTxt.clear();
		lookupTxt.sendKeys(text);	
		return this;
	}
	
	public void clickGoBtn() {
		goBtn.click();
	}
	
	public LookupPage clickResult(String result) {
		Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        driver.switchTo().window(listWindows.getLast());
		driver.switchTo().frame(lookupResult);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(result))));
		driver.findElement(By.linkText(result)).click();
		driver.switchTo().window(listWindows.getFirst());	
		return this;
		
	}
	

	
	
	

}
