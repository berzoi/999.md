package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.microsoft.playwright.options.WaitUntilState.DOMCONTENTLOADED;
import static utils.ConfigProvider.URL_999;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import core.BaseTest;


public class LogInPage extends BaseTest {
  private final Page page;

  private final String logInButton = "[data-autotest='login']";
  private final String userNameField = "[name='login']";
  private final String passwordField = "[name='password']";
  private final String submitButton = "[type='submit']";


  public LogInPage(Page page) {
    this.page = page;
  }

  public void logIn (String login, String password) {
    page.navigate(URL_999, new NavigateOptions().setWaitUntil(DOMCONTENTLOADED));
    page.click(logInButton);
    page.fill(userNameField, login);
    page.fill(passwordField, password);
    page.click(submitButton);
  }
}
