package SalesForce.Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import SalesForce.Pages.AccountHome;
import SalesForce.Pages.AccountObject;
import SalesForce.Pages.LoginPageDeveloper;
import SalesForce.Pages.LookupPage;
import SalesForce.Pages.MainApp;
import SalesForce.Pages.OpportunityHome;
import SalesForce.Pages.OpportunityObject;
import SalesForce.Pages.TabBar;

public class CreateOpportunity {
	
	private String username = "fplaza07@softlayer.com";
	private String password = "Control123!@#";
	
	private MainApp  mainApp;
	private TabBar tabBar;
	private String accountName = "TestAccount9";
	private String opportunityName = "TestOpp9";
	private String stageOption = "Prospecting";
	private OpportunityObject opportunity1;
	private AccountObject account1;
	private AccountHome accountHome;
	private OpportunityHome opportunityHome;
	
	@Before
	public void login() {
		
        LoginPageDeveloper loginPage = new LoginPageDeveloper();
        loginPage.setUsername(username)
                 .setPassword(password);
        mainApp = loginPage.clickLoginBtn();
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickOnAccountsTab();
        account1 = accountHome.clickNewBtn();
        account1.setAccountName(accountName).clickSaveBtn();
       
	}
	
	@Test
	public void campaignLookupTest(){
		
		 opportunityHome = tabBar.clickOnOpportunitiesTab();
		 opportunity1 = opportunityHome.clickNewBtn();		 
		 opportunity1.setOpportunityName(opportunityName).setDateFormat().setStage(stageOption);
		
		 LookupPage lookUp1 = opportunity1.clickLookupBtn();
		 lookUp1.setTxtToLookFor(accountName).clickGoBtn();
		 lookUp1.clickResult(accountName);
		 opportunity1.clickSaveBtn();
		 
		 Assert.assertTrue("Opportunity Name Displayed",opportunity1.isOppNameDisplayed());
		 Assert.assertTrue("Account Name Displayed",opportunity1.isOppAccountNameDisplayed());
		 Assert.assertTrue("Stage Displayed",opportunity1.isOppStageDisplayed());
		 Assert.assertTrue("Close date Displayed",opportunity1.isOppCloseDateDisplayed());
		 
	}
	
	@After
	public void tearDown() {
		opportunity1.deleteOpportunity();
		tabBar = mainApp.goToTabBar();
		tabBar.clickOnAccountsTab();
		accountHome.clickAccountToDelete(accountName);
		account1.deleteAccount();
		mainApp.clickUserButton().clickLogout();
		mainApp.closeMainApp();
	}

}



