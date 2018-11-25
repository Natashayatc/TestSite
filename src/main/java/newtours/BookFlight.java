package newtours;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
// 4 страница
public class BookFlight {

    public BookFlight(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    private Select select;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[1]")
    WebElement departFlightRoute;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[2]")
    WebElement departDate;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[3]")
    WebElement departAirlinesTo;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[7]")
    WebElement departAirlinesClass;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[8]")
    WebElement departPrice;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[9]")
    WebElement FlightRoute;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[10]")
    WebElement strDate;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[6]")
    WebElement AirlinesFrom;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[19]")
    WebElement FlightClassFrom;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[20]")
    WebElement FlightPriceFrom;

    @FindBy (xpath = "(//td/font[text()='Passengers:']/following::td/font)[1]")
    WebElement passengers;

    @FindBy (xpath = "(//td/font[contains(.,'Taxes:')]/following::td/font)[1]")
    WebElement taxes;

    @FindBy (xpath = "(//td/font[contains(.,'Total Price')]/following::td//b)[1]")
    WebElement totalPrice;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[1]")
    WebElement firstPassFirstName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[2]")
    WebElement firstPassLastName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//select)[1]")
    WebElement firstPassMeal;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[3]")
    WebElement secondPassFirstName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[4]")
    WebElement secondPassLastName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//select)[2]")
    WebElement secondPassMeal;

    @FindBy (xpath = "//select[@name='creditCard']")
    WebElement cardType;

    @FindBy (xpath = "//input[@name='creditnumber']")
    WebElement cardNumber;

    @FindBy (xpath = "//select[@name='cc_exp_dt_mn']")
    WebElement expirationMonth;

    @FindBy (xpath = "//select[@name='cc_exp_dt_yr']")
    WebElement expirationYear;

    @FindBy (xpath = "//input[@name='cc_frst_name']")
    WebElement cardFirtName;

    @FindBy (xpath = "//input[@name='cc_mid_name']")
    WebElement cardMidlName;

    @FindBy (xpath = "//input[@name='cc_last_name']")
    WebElement cardLastName;

    @FindBy (xpath = "//input[@name='billAddress1']")
    WebElement billAddress;

    @FindBy (xpath = "//input[@name='billCity']")
    WebElement billCity;

    @FindBy (xpath = "//input[@name='billState']")
    WebElement billState;

    @FindBy (xpath = "//input[@name='billZip']")
    WebElement billPostalCode;

    @FindBy (xpath = "//select[@name='billCountry']")
    WebElement billCountry;

    @FindBy (xpath = "//input[@name='ticketLess']")
    WebElement sameAsBill;

    @FindBy (xpath = "//input[@name='delAddress1']")
    WebElement delAddress;

    @FindBy (xpath = "//input[@name='delCity']")
    WebElement delCity;

    @FindBy (xpath = "//input[@name='delState']")
    WebElement delState;

    @FindBy (xpath = "//input[@name='delZip']")
    WebElement delPostalCode;

    @FindBy (xpath = "//select[@name='delCountry']")
    WebElement delCountry;

    @FindBy (xpath = "//input[@name='buyFlights']")
    WebElement securePurchase;
    public void bookFlight() {
        departFlightRoute.getText();
        departDate.getText();
        departAirlinesTo.getText();
        departAirlinesClass.getText();
        departPrice.getText();
        FlightRoute.getText();
        strDate.getText();
        AirlinesFrom.getText();
        FlightClassFrom.getText();
        FlightPriceFrom.getText();
        passengers.getText();
        taxes.getText();
        totalPrice.getText();
    }
    public void setPassengers(final String firstName1, final String lastName1,
                              final String meal1, final String firstName2,
                              final String lastName2, final String meal2) {
        firstPassFirstName.sendKeys(firstName1);
        firstPassLastName.sendKeys(lastName1);

        Select passMeals0 = new Select(firstPassMeal);
        passMeals0.selectByVisibleText(meal1);

        secondPassFirstName.sendKeys(firstName2);
        secondPassLastName.sendKeys(lastName2);

        Select passMeals1 = new Select(secondPassMeal);
        passMeals1.selectByVisibleText(meal2);
    }
    public void CreditCard(final String typeCard, final String numberCard,
                              final String Month, final String Year,
                              final String ccNameFirst, final String ccNameMid,
                              final String ccNameLast) {

        Select creditCardTypes = new Select(cardType);
        creditCardTypes.selectByVisibleText(typeCard);
        cardNumber.sendKeys(numberCard);

        Select ccExpDtMn = new Select(expirationMonth);
        ccExpDtMn.selectByVisibleText(Month);

        Select ccExpDtYr = new Select(expirationYear);
        ccExpDtYr.selectByValue(Year);

        cardFirtName.sendKeys(ccNameFirst);
        cardMidlName.sendKeys(ccNameMid);
        cardLastName .sendKeys(ccNameLast);

    }

    public void BillAddress(final String addressBill,
                               final String cityBill, final String stateBill,
                               final String PostalCode, final String countryBill) {
        billAddress.clear();
        billAddress.sendKeys(addressBill);
        billCity.clear();
        billCity.sendKeys(cityBill);
        billState.clear();
        billState.sendKeys(stateBill);
        billPostalCode.clear();
        billPostalCode.sendKeys(PostalCode);

        Select billCountries = new Select(billCountry);
        billCountries.selectByVisibleText(countryBill);
    }
    public void DeliveryAddress(final String addressDel,
                                   final String cityDel, final String stateDel,
                                   final String PostalCodeDel,
                                   final String countryDel) {
        sameAsBill.click();
        delAddress.clear();
        delAddress.sendKeys(addressDel);
        delCity.clear();
        delCity.sendKeys(cityDel);
        delState.clear();
        delState.sendKeys(stateDel);
        delPostalCode.clear();
        delPostalCode.sendKeys(PostalCodeDel);

        Select delCountries = new Select(delCountry);
        delCountries.selectByVisibleText(countryDel);

        securePurchase.click();
    }

    public void setCardOwner(String first, String midle, String last) {
        cardFirtName.clear();
        cardFirtName.sendKeys(first);
        cardMidlName.clear();
        cardMidlName.sendKeys(midle);
        cardLastName.clear();
        cardLastName.sendKeys(last);
    }

    public void firstPassLastName(String firstPassFirstName) {
    }

    public void firstPassMeal(String firstPassMeal) {
    }

    public void secondPassFirstName(String secondPassFirstName) {
    }

    public void secondPassLastName(String secondPassLastName) {
    }

    public void secondPassMeal(String secondPassMeal) {
    }

    public void cardType(String cardType) {
    }

    public void cardNumber(String cardNumber) {
    }

    public void expirationMonth(String cardExpirationMonth) {
    }

    public void expirationYear(String cardExpirationYear) {
    }
}

