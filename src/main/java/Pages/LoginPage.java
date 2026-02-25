package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import jdk.internal.org.jline.utils.Log;

import Utils.log;

public class LoginPage {
	
private WebDriver driver;

   @FindBy(id="Email")
    WebElement usernameField;
   
   @FindBy(id="Password")
   WebElement passwordField;
   
   @FindBy(className="login-button")
   WebElement loginButton;
   
   
   // private By usernameField = By.id("Email");
   // private By passwordField = By.id("Password");
   // private By loginButton = By.className("login-button");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username) {
    	usernameField.clear();
    	//driver.findElement(usernameField).clear();
    	log.info("Entering the UserName" );
    	usernameField.sendKeys(username);
       // driver.findElement(usernameField).
    }
    public void enterPassword(String password) {
    	passwordField.clear();
    	//driver.findElement(passwordField).clear();
    	log.info("Entering the password" );
    	passwordField.sendKeys(password);
        //driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin() {
   
    	log.info("Clicking the Login button" );
     	loginButton.click();
       // driver.findElement(loginButton).click();
    }
    
}


