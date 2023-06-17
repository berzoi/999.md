package core;

import static com.codeborne.selenide.Selenide.open;
import static utils.ConfigProvider.URL_999;
import static utils.DataEnum.CONTEXT;
import static utils.ScenarioContext.getScenarioContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
  private Browser browserPlaywright;

  protected Page page;

  private BrowserContext context;

//  @BeforeClass(dependsOnGroups = {"group1"})
  @BeforeClass
  public void setUp() {

    browserPlaywright = Playwright
        .create()
        .chromium()
        .launch(new LaunchOptions()
            .setHeadless(true)
            .setChannel("chrome")
            .setSlowMo(50));

    context = browserPlaywright.newContext();
    getScenarioContext().saveData(CONTEXT, context);
    page = context.newPage();

  }
  @AfterClass(groups = "Playwright")
  public void tearDown(){
    if (browserPlaywright != null) {
      context.close();
      browserPlaywright.close();
    }
  }
}
