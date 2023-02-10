package Lecture16.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPostPage {

    @FindBy(tagName = "h3")
    private WebElement titleOnNewPostPage;

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/create";

    private final WebDriver driver;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(NewPostPage.PAGE_URL));
    }

    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public String getTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleOnNewPostPage));
        return titleOnNewPostPage.getText();
    }

}

