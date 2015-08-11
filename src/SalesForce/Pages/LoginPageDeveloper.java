package SalesForce.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForceFramework.WebDriverManager;

public class LoginPageDeveloper {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameTxt;
    
    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;
    
    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;
    
    public LoginPageDeveloper() {
    	driver = WebDriverManager.getInstance().getDriver();
    	wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    
    public LoginPageDeveloper setUsername(String username) {
		
		wait.until(ExpectedConditions.visibilityOf(usernameTxt));
		usernameTxt.clear();
		usernameTxt.sendKeys(username);
		return this;		
	
    }

    public LoginPageDeveloper setPassword(String password) {
	
    	wait.until(ExpectedConditions.visibilityOf(passwordTxt));
    	passwordTxt.clear();
    	passwordTxt.sendKeys(password);
    	return this;
	
    }

    public MainApp clickLoginBtn() {
	
    	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
    	loginBtn.click();  
		return new MainApp();
	
    }

}
