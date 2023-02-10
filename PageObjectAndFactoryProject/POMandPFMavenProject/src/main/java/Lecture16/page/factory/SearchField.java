package Lecture16.page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchField {
    private final WebDriver driver;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "search-bar")
    private WebElement searchUser;

    public SearchField(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchUser(String user) {
        searchUser.sendKeys(user);
    }

    public void findAndClickUser(String user, String profileUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement findUser = driver.findElement(By.partialLinkText(user));
        wait.until(ExpectedConditions.visibilityOf(findUser));
        findUser.click();
        wait.until(ExpectedConditions.urlToBe(profileUrl));
    }
}
