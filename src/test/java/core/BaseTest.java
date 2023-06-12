package core;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseTest {
  private Browser browserPlaywright;

  protected Page page;

  private BrowserContext context;

  @BeforeClass(dependsOnGroups = {"Playwright"})
  public void setUp() {

    browserPlaywright = Playwright
        .create()
        .chromium()
        .launch(new LaunchOptions()
            .setHeadless(true)
            .setChannel("msedge"));

    context = browserPlaywright.newContext();
    page = context.newPage();
  }


//  @BeforeSuite(dependsOnGroups = {"Selenide"})
//  public void setUpSelenide(){
//    browser = "chrome";
//    timeout = 10000;
//    holdBrowserOpen = true;
//    browserPosition = "30x30";
//    browserSize = "1500x500";
//    headless = true;

//  }


  @AfterClass(groups = "Playwright")
  public void tearDown(){
    if (browserPlaywright != null) {
      browserPlaywright.close();
      browserPlaywright = null;
    }
  }
}
