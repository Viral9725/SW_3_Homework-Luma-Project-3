package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    WebDriver driver = new ChromeDriver();
    @Before
    public void setUp() {
        openBrowser(baseUrl);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']"));

        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'Bags')]"));

        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        assertVerifyText(By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");
        clickOnElement(By.xpath("//input[@id='qty']"));
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(Keys.CONTROL + "a");
        sendTextToElement(By.xpath("//input[@id='qty']]"), "3");
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        assertVerifyText(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"), "You added Overnight Duffle to your shopping cart.");
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        clickOnElement(By.xpath("//input[@id='qty']"));
        Actions action1 = new Actions(driver);
        driver.findElement(By.xpath("///input[@id='cart-106777-qty']")).sendKeys(Keys.CONTROL + "a");
        sendTextToElement(By.xpath("//input[@id='cart-106777-qty']"), "5");
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        assertVerifyText(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"), "$225.00");

    }

    @After
    public void tearDown() {
        closeBrowser();

    }

}
