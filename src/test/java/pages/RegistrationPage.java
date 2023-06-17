package pages;

import static com.codeborne.selenide.Configuration.browser;
import static com.microsoft.playwright.options.WaitUntilState.DOMCONTENTLOADED;
import static utils.ConfigProvider.URL_999;
import static utils.DataEnum.CONTEXT;
import static utils.DataEnum.USER_EMAIL;
import static utils.ScenarioContext.getScenarioContext;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import core.ActionsHelper;
import java.util.List;
import org.testng.annotations.Test;
import utils.DataEnum;
import utils.JavaFaker;

public class RegistrationPage {

  private Page page;

  public RegistrationPage(Page page) {
    this.page = page;
  }
  ActionsHelper actionsHelper = new ActionsHelper(page);

  JavaFaker javaFaker = new JavaFaker();

  private final String registerButton = "//a[contains(text(),'регистрация')]";
  private final String userEmail = "[name='email']";
  private final String userNameField = "[name='login']";
  private final String passwordField = "[name='password']";
  private final String submitButton = "[type='submit']";
  private final String agreeButton = "[id='agree-rules']";
//  private final String tempEmail = "[class='emailbox-input opentip']";
//  private final String copyEmailButton = "//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]";

  private final String tempEmail = "[id='eposta_adres']";
  public void registerUser() {
    actionsHelper.openLink("https://tempail.com/ru/");
    getScenarioContext().saveData(USER_EMAIL, page.getAttribute(tempEmail, "value"));

    BrowserContext context = getScenarioContext().getData(CONTEXT);
//    page.keyboard().press("Control+T");
//    List<Page> pages = context.pages();

    Page newTab = context.newPage();
    newTab.click(registerButton);

    newTab.fill(userEmail, getScenarioContext().getData(USER_EMAIL));
    newTab.fill(userNameField, javaFaker.userName);
    newTab.fill(passwordField, javaFaker.password);
    newTab.click(agreeButton);
    newTab.click(submitButton);
    List<Page> allTabs = context.pages();
    allTabs.get(0).bringToFront();
    try {
      Thread.sleep(90000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }


  }


}
