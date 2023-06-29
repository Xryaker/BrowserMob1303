package configuratio;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import util.ScreenS;
import util.WorkWithLogs;
import util.WorkWithTextFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void create() {
        driver = DriverFactory.greateDriver(WEBDRIVERS.MOBPROXYChrome);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        AgentFactory.create(Agents.ANDROIDRU);
        DriverFactory.server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,CaptureType.RESPONSE_CONTENT);
        DriverFactory.server.newHar("youtube");

    }

    @AfterClass
    public static void end() throws InterruptedException, IOException {
        Thread.sleep(6000);
        WorkWithLogs.writeLogsToFile(driver,"ConsoleLogs");
        Har har =DriverFactory.server.getHar();
        har.writeTo(new File("Youtube.har"));
        for(HarEntry l:har.getLog().getEntries()){
            System.out.println(l.getRequest().getUrl());
        }
        ScreenS.takeScreenShot(driver,"yyy");
        driver.quit();

    }
}
