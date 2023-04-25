package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));
        clickOnElement(By.xpath("//span[normalize-space()='Women']"));
        //Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        clickOnElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //DropDown List
        BaseTest.driver.findElement(By.xpath("//div[2]//div[3]//select[1]"));
        //Select Sort By filter “Product Name”
        clickOnElement(By.linkText("ProductName"));
        //     Verify the products name display in
        assertVerifyText(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");
        //    alphabetical order
        assertProduct("Adrienne Trek Jacket", 1);
        assertProduct("Augusta Pullover Jacket ", 2);
        assertProduct("Inez Full Zip Jacket ", 3);
        assertProduct("Ingrid Running Jacket ", 4);
        assertProduct("Jade Yoga Jacket ", 5);
        assertProduct("Josie Yoga Jacket ", 6);
        assertProduct(" Juno Jacket ", 7);
        assertProduct(" Juno Jacket ", 8);
        assertProduct("Neve Studio Dance Jacket ", 9);
        assertProduct("Augusta Pullover Jacket ", 10);
        assertProduct("Inez Full Zip Jacket ", 11);
        assertProduct("Ingrid Running Jacket ", 12);

        assertVerifyText(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
    }

    @Test
    public void verifyTheSortByPriceFilter() {
//        Mouse Hover on Women Menu
              mouseHoverOnElement(By.linkText("Women"));
//        Mouse Hover on Tops
       mouseHoverOnElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        WebElement menMenu = BaseTest.driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        //Top Menu
        WebElement bottoms = BaseTest.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]"));

        Actions actions = new Actions(BaseTest.driver);
        actions.moveToElement(menMenu).moveToElement(bottoms).click().build().perform();
        //  Click on Jackets
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        //* Select Sort By filter “Price”
        mouseHoverOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]"));
        // Verify the products price display in
        assertVerifyText(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]"), "Price");
        //Low to High
        assertVerifyText(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]/span[1]"), "Set Ascending Direction");

        assertPrice("$32.00", 1);
        assertPrice("$56.25", 2);
        assertPrice("$57.00", 3);
        assertPrice("$57.00", 4);
        assertPrice("$59.00", 5);
        assertPrice("$60.00", 6);
        assertPrice("$69.00", 7);
        assertPrice("$69.00", 8);
        assertPrice("$77.00", 9);
        assertPrice("$77.00", 10);
        assertPrice("$77.00", 11);
        assertPrice("$84.00", 12);
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
