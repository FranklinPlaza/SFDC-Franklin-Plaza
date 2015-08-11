package SalesForce.Pages;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class MainApp {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "userNavButton")
    @CacheLookup
    private WebElement userBtn;
    
    
    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;
    
    public MainApp() {
    	driver = WebDriverManager.getInstance().getDriver();
    	wait = WebDriverManager.getInstance().getWait();
    	PageFactory.initElements(driver, this);
    }
    
    
    public MainApp clickUserButton(){
    	userBtn.click();
    	return this;
    }
    
    public void clickLogout () {
    	wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
    	logoutBtn.click();
    }
    
    public TabBar goToTabBar() {
    	return new TabBar();
    }
    
    public void closeMainApp() {
    	driver.quit();
        
    }

}
