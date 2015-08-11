package SalesForce.Pages;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





import SalesForceFramework.WebDriverManager;

public class OpportunityObject {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement oppNameTxt;
    
    @FindBy(xpath = "//a[contains(.,'2015')]")
    @CacheLookup
    private WebElement dateTxt;
    
    @FindBy(name = "opp11")
    @CacheLookup
    private WebElement stage;
    
    
    @FindBy(className = "lookupIcon")
    @CacheLookup
    private WebElement lookupBtn;
	
	@FindBy(id = "searchFrame")
    @CacheLookup
    private WebElement lookupFrame;
	
	
	@FindBy(name = "save")
	@CacheLookup
	private WebElement saveBtn;
	 
	 
	 
	@FindBy(id = "opp3_ileinner")
	@CacheLookup
	private WebElement oppNameDetails;
	
	@FindBy(id = "opp4_ileinner")
	@CacheLookup
	private WebElement oppAccountNameDetails;
	
	@FindBy(id = "opp9_ileinner")
	@CacheLookup
	private WebElement oppCloseDateDetails;
	
	@FindBy(id = "opp11_ileinner")
	@CacheLookup
	private WebElement oppStageDetails;
	
	@FindBy(name = "del")
	@CacheLookup
	private WebElement deleteBtn;
    
	public OpportunityObject() {
		driver = WebDriverManager.getInstance().getDriver();
		wait = WebDriverManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public OpportunityObject setOpportunityName (String oppName){
		wait.until(ExpectedConditions.visibilityOf(oppNameTxt));
		oppNameTxt.clear();
		oppNameTxt.sendKeys(oppName);
		return this;
	}
	
	
	public OpportunityObject setDateFormat (){
		wait.until(ExpectedConditions.elementToBeClickable(dateTxt));		
		dateTxt.click();
		return this;
	}
	
	public void setStage(String option){
		
		wait.until(ExpectedConditions.elementToBeClickable(stage));		
		Select select = new Select(stage);   
	    select.selectByVisibleText(option);	
	}
	
	public LookupPage clickLookupBtn() {
		lookupBtn.click();
		Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        driver.switchTo().window(listWindows.getLast());
		driver.switchTo().frame(lookupFrame);
		
		return new LookupPage();	
	}
	
	public void clickSaveBtn (){
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));	
		saveBtn.click();
	}
	
	
	public boolean isOppNameDisplayed() {
        return isElementPresent(oppNameDetails);
    }
	
	public boolean isOppAccountNameDisplayed() {
        return isElementPresent(oppAccountNameDetails);
    }
	
	public boolean isOppCloseDateDisplayed() {
        return isElementPresent(oppCloseDateDetails);
    }
	
	public boolean isOppStageDisplayed() {
        return isElementPresent(oppStageDetails);
    }
	
	public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
	
	public void deleteOpportunity() {
		
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));	
		deleteBtn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();		
	}
	
	

}
