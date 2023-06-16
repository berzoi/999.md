package utils;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import javax.annotation.Nonnull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyWDProvider implements WebDriverProvider {
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
    chromeOptions.merge(capabilities);
    return new ChromeDriver(chromeOptions);
  }
}