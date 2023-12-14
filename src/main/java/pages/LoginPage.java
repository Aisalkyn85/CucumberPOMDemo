package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
   // private WebDriver driver;

    @FindBy(css = "input#Email")
    WebElement Email_WebEdit;

    @FindBy(css = "input#Password")
    WebElement Password_WebEdit;

    @FindBy(css = "button[type=\"submit\"]")
    WebElement Signin_WebButton;

    @FindBy(xpath = "//h1")
    WebElement header_logo;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void enterUserName(String username){
        Email_WebEdit.clear();
        Email_WebEdit.sendKeys(username);
    }

    public void enterPassword(String password){
        Password_WebEdit.clear();
        Password_WebEdit.sendKeys(password);
    }

    public void clickLogin(){
        Signin_WebButton.click();
    }

    public boolean isLogoDisplayed(){
        return header_logo.isDisplayed();
    }





}
