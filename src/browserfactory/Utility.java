package browserfactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    WebDriver driver = new ChromeDriver();

    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    /*
     *This method will Send Text to element
     */

    public void sendTextToElement(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /*
     *This method will get Text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }

    //***********************************************Mouse Hover******************************************************//

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }

    public void assertProduct(String expectedProduct,int index){
        String expectedProduct1 =expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//ol//strong//a)["+index+"]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }
    public void assertPrice(String expectedProduct,int index){
        String expectedProduct1 =expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//div[@class='products wrapper grid products-grid']//span[@class='price'])["+index+"]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }
}
