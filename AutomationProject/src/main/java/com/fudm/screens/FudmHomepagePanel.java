package com.fudm.screens;
import static com.vxl.lib.Global.browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FudmHomepagePanel {
	
	public FudmHomepagePanel(){
		PageFactory.initElements(browser.getDriver(), this);	
	}
	
	@FindBy(how=How.ID, using="HeadLoginStatus") private WebElement logoutLink;
	@FindBy(how=How.ID, using="btnAlertLogOut") private WebElement alertOk; 
	@FindBy(how=How.ID, using="ibtnViews" ) private WebElement views;
	@FindBy(how=How.XPATH, using="//button[@title='Configuration Setup']" ) private WebElement config_setup;
	@FindBy(how=How.ID, using="btnExpandMenu" ) private WebElement expandMenu;
	@FindBy(how=How.ID, using="dvcTitle" ) private WebElement menuTitle;
	@FindBy(how=How.ID, using="ViewHeader" ) private WebElement viewHeader;
	
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getConfig_setup() {
		return config_setup;
	}

	public WebElement getAlertOk() {
		return alertOk;
	}

	public WebElement getViews() {
		return views;
	}

	public WebElement getExpandMenu() {
		return expandMenu;
	}
	
	public WebElement getMenuTitle() {
		return menuTitle;
	}

	public WebElement getViewHeader() {
		return viewHeader;
	}
	
	
	
	
	
	
	
	
	

}
