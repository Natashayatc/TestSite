package newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder {

    public FlightFinder(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;
    private Select select;

    @FindBy (xpath = "//input[@value='tripType']")
    WebElement tripType;

    @FindBy (xpath = "//input[@value='oneway']")
    WebElement oneWay;

    @FindBy (xpath = "//select[@name='passCount']")
    WebElement passengers;

    @FindBy (xpath = "//select[@name='fromPort']")
    WebElement departningFrom;

    @FindBy (xpath = "//select[@name='fromMonth']")
    WebElement fromMonth;

    @FindBy (xpath = "//select[@name='fromDay']")
    WebElement fromDay;

    @FindBy (xpath = "//select[@name='toPort']")
    WebElement arrivingIn;

    @FindBy (xpath = "//select[@name='toMonth']")
    WebElement toMonth;

    @FindBy (xpath = "//select[@name='toDay']")
    WebElement toDay;

    @FindBy (xpath = "//input[@value='servClass']")
    WebElement serviceClass;

    @FindBy (xpath = "//input[@value='Business']")
    WebElement businessClass;

    @FindBy (xpath = "//input[@value='First']")
    WebElement firstClass;

    @FindBy (xpath = "//select[@name='airline']")
    WebElement airline;

    @FindBy (xpath = "//input[@name='findFlights']")
    WebElement continueButton;
 // Найти авиабилеты из метода.
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    public void RoundTrip() {
        tripType.click();
    }

    public void setOneWay() {

        oneWay.click();
    }

    public void Passengers(String numberOfPassengers) {
        getSelect(passengers);
        select.selectByVisibleText(numberOfPassengers);
    }

    public void DepartningFrom(String fromPort) {
        getSelect(departningFrom);
        select.selectByVisibleText(fromPort);
    }

    public void OnMonth(String onMonth) {
        getSelect(fromMonth);
        select.selectByVisibleText(onMonth);
    }

    public void OnDay(String onDay) {
        getSelect(fromDay);
        select.selectByVisibleText(onDay);
    }


    //Найти метод возвращающихся рейсов
    public void setArrivingIn(String toPort) {
        getSelect(arrivingIn);
        select.selectByVisibleText(toPort);
    }

    public void setReturningMonth(String returningMonth) {
        getSelect(toMonth);
        select.selectByVisibleText(returningMonth);
    }

    public void setReturningDay(String returningDay) {
        getSelect(toDay);
        select.selectByVisibleText(returningDay);
    }
 // методы предпочтений
 public void setEconomyClass() {
     serviceClass.click();
 }

    public void setBusinessClass() {
        businessClass.click();
    }

    public void setFirstClass() {
        firstClass.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void setAirline(String airlineName) {
        getSelect(airline);
        select.selectByVisibleText(airlineName);
    }
}
