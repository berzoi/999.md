package core;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static core.ConfigProvider.DOUBLE_A_LOGIN;
import static core.ConfigProvider.DOUBLE_A_PASSWORD;
import static core.ConfigProvider.URL_999;
import static core.ConfigProvider.XVM_21_LOGIN;
import static core.ConfigProvider.XVM_21_PASSWORD;
import static core.ConfigProvider.ZOTAC522_LOGIN;
import static core.ConfigProvider.ZOTAC522_PASSWORD;


import com.beust.ah.A;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddAdPage;
import pages.AddAdPageSelenide;
import pages.LogInPage;


public class SearchTest extends BaseTest {

  AddAdPageSelenide addAdPageSelenide = new AddAdPageSelenide();

  @Test
  public void skodaFabia() {
    page.navigate(URL_999);
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
//    logInPage.logIn(XVM_21_LOGIN, XVM_21_PASSWORD);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.addCar();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void ssd() {
    page.navigate(URL_999);
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.addSDD();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void soundCore() {
    page.navigate(URL_999);
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.q35();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void oricoSamsung() {
    page.navigate(URL_999);
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(ZOTAC522_LOGIN, ZOTAC522_PASSWORD);
    addAdPage.orico();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void logitechTest() {
    page.navigate(URL_999);
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.logitech();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

//  @Test
//  public void logitechTestOld(){
//    addAdPageSelenide.logitech(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
//    try {
//      Thread.sleep(100000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//    Assert.assertTrue($("[class='success_icon']").exists());
//  }

  @Test
  public void abc() {

//    BaseTestSelenide.navigateTo(URL_999);
    page.navigate(URL_999);
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}