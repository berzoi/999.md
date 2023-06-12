package pages;

import static com.codeborne.selenide.Selenide.$;
import static core.ConfigProvider.XVM_21_LOGIN;

import com.codeborne.selenide.SelenideElement;
import com.microsoft.playwright.Page;
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

    page.click(logInButton);
    page.fill(userNameField, login);
    page.fill(passwordField, password);
    page.click(submitButton);
//    page.evaluate("() => {\n" +
//        "  const banner = document.querySelector('#banner');\n" +
//        "  banner.remove();\n" +
//        "}");
  }


}
