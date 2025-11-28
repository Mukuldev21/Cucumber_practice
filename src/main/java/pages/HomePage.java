package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    //Locators
    @FindBy(css = "div.app_logo")
    private WebElement homePageLogo;

    @FindBy(css = "button#react-burger-menu-btn")
    private WebElement menuButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLogoDisplayed() {
        return homePageLogo.isDisplayed();
    }

    public void clickMenuButton() {
        // Implementation for clicking the menu button
        menuButton.click();
    }

    public void clickLogoutLink() {
        // Implementation for clicking the logout link
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
    }
}
