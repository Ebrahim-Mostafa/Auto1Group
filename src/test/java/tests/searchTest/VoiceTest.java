package tests.searchTest;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sudharsan_selvaraj.SpyDriver;
import io.github.sudharsan_selvaraj.audiologger.LogOptions;
import io.github.sudharsan_selvaraj.audiologger.SeleniumAudioLogger;
import io.github.sudharsan_selvaraj.autowait.SeleniumWaitOptions;
import io.github.sudharsan_selvaraj.autowait.SeleniumWaitPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class VoiceTest {

    @Test
    public void voiceTest(){

        WebDriverManager.chromedriver().setup();

        SpyDriver<ChromeDriver> spyDriver = new SpyDriver<>(new ChromeDriver());
        SeleniumWaitPlugin<ChromeDriver> waitPlugin = new SeleniumWaitPlugin<>(spyDriver, SeleniumWaitOptions.builder().defaultWaitTime(Duration.ofSeconds(10)).build());

        LogOptions options = new LogOptions();
        options.setLogAfterCommand(true);
        SeleniumAudioLogger<ChromeDriver> logger = new SeleniumAudioLogger<>(spyDriver, options);

        WebDriver driver = spyDriver.getSpyDriver();

        try {
            driver.get("https://www.amazon.in");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 7");
            driver.findElement(By.id("nav-search-submit-text")).click();
            driver.findElement(By.partialLinkText("OnePlus 7 Pro")).click();
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[]{})[1]);
            driver.findElement(By.id("add-to-cart-button")).click();

            driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(1000, 700));

            ((JavascriptExecutor) driver).executeScript("console.log('hi')");
            ((JavascriptExecutor) driver).executeAsyncScript("(function(callback){ callback()})(arguments[0])");

            /* This will trigger the exception */
            driver.findElement(By.id("attach-view-cart-button-form")).sendKeys("Ebrahim");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void voiceOver() {
        Voice voice;//Creating object of Voice class
        voice = VoiceManager.getInstance().getVoice("kevin16");//Getting voice
        if (voice != null) {
            voice.allocate();//Allocating Voice
        }
        try {
            voice.setRate(150);//Setting the rate of the voice
            voice.setPitch(100);//Setting the Pitch of the voice
            voice.setVolume(10);//Setting the volume of the voice
            voice.speak("Oops there is No such element found exception");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
