package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void userShouldAddProductsSuccessfullyToShoppingCart() {
        mouseHoverOnElement(By.cssSelector("a[id='ui-id-5'] span:nth-child(2)"));// Mouse hover mens menu
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));//Mouse hover on bottoms
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));//click on pants
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));//Mouse hover on product name
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));//click on size 32
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));//click on colour black
        mouseHoverOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));//Add to cart
        Assert.assertEquals("Product not added to cart", getTextFromElement(By.xpath("//body/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]")), "You added Cronus Yoga Pant to your shopping cart.");
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));//click on shopping cart link
        Assert.assertEquals("Not directed to shopping cart", getTextFromElement(By.xpath("//h1[@class='page-title']")), "Shopping Cart");//verifying text shopping cart
        Assert.assertEquals("Cronus Yoga Pant not in basket", getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")), "Cronus Yoga Pant");//verifying name cronus yoga pant
        Assert.assertEquals("incorrect size", getTextFromElement(By.xpath("//dd[contains(text(),'32')]")), "32");//verifying size 32
        Assert.assertEquals("Incorrect colour", getTextFromElement(By.xpath("//dd[contains(text(),'Black')]")), "Black");//verifying colour black

    }
@After
public void tearDown() {
        closeBrowser();

        }
}

