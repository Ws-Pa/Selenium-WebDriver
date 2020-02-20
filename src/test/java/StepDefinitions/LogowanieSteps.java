package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;


public class LogowanieSteps {

    OperaDriver driver;

    @Given("Uzytkownik uruchamia przegladarke")
    public void uzytkownik_uruchamia_przegladarke() {
        System.setProperty("webdriver.opera.driver","D://Pobrane/operadriver_win64/operadriver_win64/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
    }

    @Given("Uzytkownik jest na stronie {string}")
    public void uzytkownik_jest_na_stronie(String url) {
        driver.get("https://phptravels.net/login");
    }

    @When("Uzytkownik w pole name {string} wpisuje {string}")
    public void uzytkownik_w_pole_name_wpisuje(String login, String value) {
        WebElement znalezionyElement = driver.findElementByName(login);
        znalezionyElement.sendKeys(value);
    }

    @When("Uzytkownik klika w przycisk {string}")
    public void uzytkownik_klika_w_przycisk(String xpath) {
       WebElement znalezionyElement = driver.findElementByXPath(xpath);
       znalezionyElement.click();
    }

    @Then("Uzytkownik przechodzi na strone {string}")
    public void uzytkownik_przechodzi_na_strone(String expectedUrl) throws InterruptedException {
        Thread.sleep(3000);
        String pobranyUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,pobranyUrl);
        driver.quit();
    }

}
