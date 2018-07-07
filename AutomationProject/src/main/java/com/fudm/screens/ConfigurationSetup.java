package com.fudm.screens;
import static com.vxl.lib.Global.browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationSetup {
	
	public ConfigurationSetup(){
		PageFactory.initElements(browser.getDriver(), this);	
	}
	
	@FindBy(how=How.XPATH, using="//*[@data-title='User management']") private WebElement userMgmtLink;
	public WebElement getUserMgmtLink() {
		return userMgmtLink;
	}
}
