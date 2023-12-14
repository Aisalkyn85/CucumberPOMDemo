package StepDefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.checkerframework.checker.units.qual.C;
import pages.HomePage;
import pages.LoginPage;
import util.ConfigReader;
import webdriverfactory.DriverFactory;

public class MyStepdefs {

    private ConfigReader configReader = new ConfigReader();
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    private HomePage homePage = new HomePage(DriverFactory.getDriver());


    @Given("the user launches the NOPAdmin url")
    public void theUserLaunchesTheNOPAdminUrl() {

        DriverFactory.getDriver().get(configReader.getConfigProp("url"));
    }

    @Then("the user verifies the logo")
    public void theUserVerifiesTheLogo() {
        Assert.assertTrue(loginPage.isLogoDisplayed());
    }

    @When("the user enters {string} in email webedit")
    public void theUserEntersInEmailWebedit(String username) {
        loginPage.enterUserName(username);

    }

    @Given("the user enters {string} in password webedit")
    public void theUserEntersInPasswordWebedit(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks on login button")
    public void theUserClicksOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user verifies the homepage logo")
    public void theUserVerifiesTheHomepageLogo() {

        Assert.assertTrue(homePage.homepageLogoverify());

    }


    @And("the user finally logouts the application")
    public void theUserFinallyLogoutsTheApplication() {
        homePage.clickLogout();
    }
}
