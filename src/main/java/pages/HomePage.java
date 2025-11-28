package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //Locators
    @FindBy(css = "div.app_logo")
    private WebElement homePageLogo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLogoDisplayed() {
        return homePageLogo.isDisplayed();
    }
}
