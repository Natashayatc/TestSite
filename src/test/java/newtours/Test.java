package newtours;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Integer.parseInt;

public class Test {

    private static WebDriver webDriver;

    private static final String LOGIN = "test1";
    private static final String PASSWORD = "test1";
    private static final int PASSENGERS = 2;
    private static final String DEPART = "Paris";
    private static final int DEPART_MONTH_NUMBER = 11;
    private static final int DEPART_DAY = 20;
    private static final String ARRIVAL = "Seattle";
    private static final int ARRIVAL_MONTH_NUMBER = 12;
    private static final int ARRIVAL_DAY = 19;
    private static final String CLASS = "Business";
    private static final String AIRLINES = "Pangea Airlines";
    private static final String DEPART_FLIGHT_INFO = "Unified Airlines 363";
    private static final String ARRIVAL_FLIGHT_INFO = "Blue Skies Airlines 631";
    private static final int TAXES = 91;
    private static final String FIRST_PASS_FIRST_NAME = "Ivanov";
    private static final String FIRST_PASS_LAST_NAME = "Ivan";
    private static final String FIRST_PASS_MEAL = "Hindu";
    private static final String SECOND_PASS_FIRST_NAME = "Ivanova";
    private static final String SECOND_PASS_LAST_NAME = "Irina";
    private static final String SECOND_PASS_MEAL = "Bland";
    private static final String CARD_TYPE = "Visa";
    private static final String CARD_NUMBER = "5479540454132487";
    private static final String CARD_EXPIRATION_MONTH = "05";
    private static final String CARD_EXPIRATION_YEAR = "2009";
    private static final String CARD_OWNER_FIRST_NAME = "Ivan";
    private static final String CARD_OWNER_MIDLE_NAME = "Ivanovich";
    private static final String CARD_OWNER_LAST_NAME = "Ivanow";
    private static final String BILLING_ADDRESS = "1085 Borregas Ave.";
    private static final String BILLING_CITY = "Albuquerque";
    private static final String BILLING_STATE = "New Mexico";
    private static final String BILLING_ZIP = "94089";
    private static final String BILLING_COUNTRY = "UNITED STATES";
    private static final String DELIVERY_ADDRESS = "1225 Borregas Ave.";
    private static final String DELIVERY_CITY = "Boston";
    private static final String DELIVERY_STATE = "Massachusetts";
    private static final String DELIVERY_ZIP = "94089";
    private static final String DELIVERY_COUNTRY = "UNITED STATES";
    private static final String TITLE1 = "Find a Flight";
    private static final String TITLE2 = "Select a Flight";
    private static final String TITLE3 = "Book a Flight";
    private static final String TITLE4 = "Flight Confirmation";

    private String departDate;
    private String arrivalDate;
    private String routeTo;
    private String routeFrom;
    private int departPrice;
    private int departPriceCheck;
    private int returnPrice;
    private int returnPriceCheck;
    private int totalPrice;
    private int totalPriceCheck;
    private String billedFullName;




    //Инициализируем драйвер, выполнение дополнительных действий
    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @org.junit.Test
    public void test() {
        webDriver.get("http://newtours.demoaut.com");
        HomePage homePage = new HomePage(webDriver);
        homePage.login(LOGIN, PASSWORD);

        FlightFinder flightFinder = new FlightFinder(webDriver);
        Assert.assertTrue(webDriver.getTitle().contains(TITLE1));
        flightFinder.setOneWay();
        flightFinder.Passengers(Integer.toString(PASSENGERS));
        flightFinder.DepartningFrom(DEPART);
        flightFinder.OnMonth(monthToString (DEPART_MONTH_NUMBER));
        flightFinder.OnDay(Integer.toString (DEPART_DAY));
        flightFinder.setArrivingIn(ARRIVAL);
        flightFinder.setReturningMonth(monthToString (ARRIVAL_MONTH_NUMBER));
        flightFinder.setReturningDay(Integer.toString (ARRIVAL_DAY));
        flightFinder.setBusinessClass();
        flightFinder.setAirline(AIRLINES);
        flightFinder.clickContinueButton();

        SelectFlight selectFlight = new SelectFlight(webDriver);
        Assert.assertTrue(webDriver.getTitle().contains(TITLE2));
        routeTo = DEPART + " to " + ARRIVAL;
        Assert.assertEquals(routeTo, selectFlight.departInfo.getText());
        departDate = DEPART_MONTH_NUMBER + "/" + DEPART_DAY + "/2018";
        Assert.assertEquals(departDate, selectFlight.departDate.getText());
        selectFlight.setDepartFlight();
        departPrice = parseInt(selectFlight.departPrice.getText().replaceAll("[^0-9]", ""));
        routeFrom = ARRIVAL + " to " + DEPART;
        Assert.assertEquals(routeFrom, selectFlight.returnInfo.getText());
        arrivalDate = ARRIVAL_MONTH_NUMBER + "/" + ARRIVAL_DAY + "/2018";
        Assert.assertEquals(arrivalDate, selectFlight.returnDate.getText());
        selectFlight.setReturnFlight();
        returnPrice = parseInt(selectFlight.returnPrice.getText().replaceAll("[^0-9]", ""));
        selectFlight.clickContinueButton();

        BookFlight bookFlight = new BookFlight(webDriver);
        Assert.assertTrue(webDriver.getTitle().contains(TITLE3));
        Assert.assertEquals(routeTo, bookFlight.departFlightRoute.getText());
        Assert.assertEquals(departDate, bookFlight.departDate.getText());
        Assert.assertEquals(DEPART_FLIGHT_INFO, bookFlight.departAirlinesTo.getText());
        Assert.assertEquals(CLASS, bookFlight.departAirlinesClass.getText());
        departPriceCheck = parseInt(bookFlight.departPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(departPrice, departPriceCheck);
        Assert.assertEquals(routeFrom, bookFlight.FlightRoute.getText());
        Assert.assertEquals(arrivalDate, bookFlight.strDate.getText());
        Assert.assertEquals(ARRIVAL_FLIGHT_INFO, bookFlight.AirlinesFrom.getText());
        Assert.assertEquals(CLASS, bookFlight.FlightClassFrom.getText());
        returnPriceCheck = parseInt(bookFlight.FlightPriceFrom.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(returnPrice, returnPriceCheck);
        Assert.assertEquals(Integer.toString(PASSENGERS), bookFlight.passengers.getText());
        Assert.assertTrue(bookFlight.taxes.getText().contains(Integer.toString(TAXES)));
        totalPrice = (departPrice + returnPrice) * PASSENGERS + TAXES;
        totalPriceCheck = parseInt(bookFlight.totalPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(totalPrice, totalPriceCheck);
        bookFlight.firstPassLastName(FIRST_PASS_FIRST_NAME);
        bookFlight.firstPassLastName(FIRST_PASS_LAST_NAME);
        bookFlight.firstPassMeal(FIRST_PASS_MEAL);
        bookFlight.secondPassFirstName(SECOND_PASS_FIRST_NAME);
        bookFlight.secondPassLastName(SECOND_PASS_LAST_NAME);
        bookFlight.secondPassMeal(SECOND_PASS_MEAL);
        bookFlight.cardType(CARD_TYPE);
        bookFlight.cardNumber(CARD_NUMBER);
        bookFlight.expirationMonth(CARD_EXPIRATION_MONTH);
        bookFlight.expirationYear(CARD_EXPIRATION_YEAR);
        bookFlight.setCardOwner(CARD_OWNER_FIRST_NAME, CARD_OWNER_MIDLE_NAME, CARD_OWNER_LAST_NAME);
        bookFlight.BillAddress(BILLING_ADDRESS, BILLING_CITY, BILLING_STATE, BILLING_ZIP, BILLING_COUNTRY);
        bookFlight.DeliveryAddress(DELIVERY_ADDRESS, DELIVERY_CITY, DELIVERY_STATE, DELIVERY_ZIP, DELIVERY_COUNTRY);

        FlightConfirmation flightConfirmation = new FlightConfirmation(webDriver);
        Assert.assertTrue(webDriver.getTitle().contains(TITLE4));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(routeTo));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(departDate));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(DEPART_FLIGHT_INFO));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(routeFrom));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(arrivalDate));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(ARRIVAL_FLIGHT_INFO));
        Assert.assertTrue(flightConfirmation.passengersInfo.getText().contains(Integer.toString(PASSENGERS)));
        billedFullName = CARD_OWNER_FIRST_NAME + " " + CARD_OWNER_MIDLE_NAME + " " + CARD_OWNER_LAST_NAME;
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(billedFullName));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_ADDRESS));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_CITY));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_STATE));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_ZIP));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_ADDRESS));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_CITY));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_STATE));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_ZIP));
        Assert.assertTrue(flightConfirmation.totalPrice.getText().contains(Integer.toString(totalPriceCheck)));
        flightConfirmation.clickHomeButton();
    }

    @AfterClass
    public static void close() {

        webDriver.close();
    }
    private String monthToString(int intMonth) {
        String monthString = "";
        switch (intMonth) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
        }
        return monthString;
    }
}