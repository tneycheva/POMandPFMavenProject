package Lecture16.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPostPage {

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/create";

    private final WebDriver driver;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(NewPostPage.PAGE_URL));
    }

    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public String getTitleText() {
        WebElement titleOnNewPostPage = driver.findElement(By.tagName("h3"));
        return titleOnNewPostPage.getText();
    }
}
