package newtours;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//домашняя страница
public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='userName']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginButton;

    public void login(String userName, String password) {

        userNameField.sendKeys(userName);

        passwordField.sendKeys(password);
        loginButton.click();
    }
}

