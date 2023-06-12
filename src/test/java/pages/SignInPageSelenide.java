package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class SignInPageSelenide {


  private static final SelenideElement emailSelenide =  $("[name='login']");
  private static final SelenideElement passwordSelenide =  $("[name='password']");
  private static final SelenideElement loginBtn = $("[data-autotest='login']");
  private static final SelenideElement submitBtn = $("[type='submit']");

  public static void performLogin(String email, String password){

    loginBtn.click();
    emailSelenide.sendKeys(email);
    passwordSelenide.sendKeys(password);
    submitBtn.click();
  }


}
