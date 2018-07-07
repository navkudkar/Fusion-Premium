package com.fudm.screens;

import static com.vxl.lib.Global.browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class FudmConsolePanel {

	public FudmConsolePanel() {
		PageFactory.initElements(browser.getDriver(), this);	
	}

	@FindBy(how=How.ID, using="UserName") private WebElement username;	
	@FindBy(how=How.ID, using="Password") private WebElement password;	
	@FindBy(how=How.ID, using="LoginButton") private WebElement login;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

}
