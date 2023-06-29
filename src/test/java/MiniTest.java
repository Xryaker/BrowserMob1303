import configuratio.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MiniTest extends BaseClass {
    final static String url="https://www.youtube.com/";
    @BeforeClass
    public static void st(){
        driver.get(url);
    }
    @Test
    public void test1(){
        WebElement search=driver.findElement(By.id("search"));
        search.click();
        search.sendKeys("Ukraine");
        search.sendKeys(Keys.ENTER);
    }
}
