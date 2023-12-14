package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    @FindBy(xpath = "//a[@href=\"/Admin\"]/img[@class=\"brand-image-xl logo-xl\"]")
    WebElement logo_WebElement;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout_WebElement;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public boolean homepageLogoverify(){
        return logo_WebElement.isDisplayed();
    }
    public void clickLogout(){
        logout_WebElement.click();
    }


}
