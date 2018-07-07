package com.fudm.screens;

import static com.vxl.lib.Global.browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPanel {

	public UserManagementPanel(){
		PageFactory.initElements(browser.getDriver(), this);	
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='ContentPlaceHolder1_btnNewUser']") private WebElement newUserButton;
	@FindBy(how=How.XPATH, using="//*[@id='ContentPlaceHolder1_btnBack_personalDetails']") private WebElement backButton;
	@FindBy(how=How.XPATH, using="//*[@id='ContentPlaceHolder1_btnCancel_associationDetails']") private WebElement cancelButton;
	@FindBy(how=How.XPATH, using="//*[@id='ContentPlaceHolder1_btnSave_associationDetails']") private WebElement saveButton;
	@FindBy(how=How.ID, using="lbluserAuthentication") private WebElement userAuthNotifications; 
	@FindBy(how=How.ID, using="txtUserName" ) private WebElement userNameTextbox;
	@FindBy(how=How.XPATH, using="//button[@title='Configuration Setup']" ) private WebElement config_setup;
	@FindBy(how=How.ID, using="ContentPlaceHolder1_lbl_UserManagement") private WebElement userMgmtHeader;
	@FindBy(how=How.ID, using="txtNewPassword" ) private WebElement passwordTextbox;
	@FindBy(how=How.ID, using="txtConfirmPassword" ) private WebElement conformPassTextbox;
	@FindBy(how=How.ID, using="ContentPlaceHolder1_btnNext_userAuthentication" ) private WebElement nextButton;
	@FindBy(how=How.ID, using="txtUserDetailsFirstName" ) private WebElement firstNameTextbox;
	@FindBy(how=How.ID, using="txtUserDetailsMiddleName" ) private WebElement middleTextBox;
	@FindBy(how=How.ID, using="txtUserDetailsLastName" ) private WebElement lastNameTextbox;
	@FindBy(how=How.ID, using="txtUserDetailsEmailID" ) private WebElement emailIDTextbox;
	@FindBy(how=How.XPATH, using="//input[@id='txtUserName']/parent::div/following-sibling::div//input[@value='Check User Availability']") private WebElement checkUserAvaialabiltyBtn;	
	@FindBy(how=How.ID, using="ddlSelectUserGroup" ) private WebElement selectUserGroup;
	@FindBy(how=How.ID, using="ContentPlaceHolder1_btnNext_personalDetails" ) private WebElement nextButtonPersonalInfo;
	
	public WebElement getNextButtonPersonalInfo() {
		return nextButtonPersonalInfo;
	}
	public WebElement getNewUserButton() {
		return newUserButton;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getCheckUserAvaialabiltyBtn() {
		return checkUserAvaialabiltyBtn;
	}
	public WebElement getSelectUserGroup() {
		return selectUserGroup;
	}
	public WebElement getBackButton() {
		return backButton;
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}
	public WebElement getUserAuthNotifications() {
		return userAuthNotifications;
	}
	public WebElement getUserNameTextbox() {
		return userNameTextbox;
	}
	public WebElement getConfig_setup() {
		return config_setup;
	}
	public WebElement getUserMgmtHeader() {
		return userMgmtHeader;
	}
	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}
	public WebElement getConformPassTextbox() {
		return conformPassTextbox;
	}
	public WebElement getNextButton() {
		return nextButton;
	}
	public WebElement getFirstNameTextbox() {
		return firstNameTextbox;
	}
	public WebElement getMiddleTextBox() {
		return middleTextBox;
	}
	public WebElement getLastNameTextbox() {
		return lastNameTextbox;
	}
	public WebElement getEmailIDTextbox() {
		return emailIDTextbox;
	}	
	
	
}
