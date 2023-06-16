package tests;

import static utils.ConfigProvider.DOUBLE_A_LOGIN;
import static utils.ConfigProvider.DOUBLE_A_PASSWORD;
import static utils.ConfigProvider.DOUBLE_A_USER;
import static utils.ConfigProvider.URL_999;
import static utils.ConfigProvider.USERMDD_02_LOGIN;
import static utils.ConfigProvider.USERMDD_02_PASSWORD;
import static utils.ConfigProvider.USERMDD_02_USER;
import static utils.ConfigProvider.XVM_21_LOGIN;
import static utils.ConfigProvider.XVM_21_PASSWORD;
import static utils.ConfigProvider.XVM_21_USER;
import static utils.ConfigProvider.XVM_2_LOGIN;
import static utils.ConfigProvider.XVM_2_PASSWORD;
import static utils.ConfigProvider.XVM_2_USER;
import static utils.ConfigProvider.ZOTAC522_LOGIN;
import static utils.ConfigProvider.ZOTAC522_PASSWORD;
import static utils.ConfigProvider.ZOTAC522_USER;
import static utils.ConfigProvider.readConfig;


import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddAdPage;
import pages.LogInPage;


public class Search999Test extends BaseTest {


  @Test
  public void skodaFabia() {

    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
//    logInPage.logIn(XVM_21_LOGIN, XVM_21_PASSWORD);
//    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
//    logInPage.logIn(ZOTAC522_LOGIN, ZOTAC522_PASSWORD);
    logInPage.logIn(USERMDD_02_LOGIN, USERMDD_02_PASSWORD);
//    logInPage.logIn(XVM_2_LOGIN, XVM_2_PASSWORD);
    addAdPage.addCar("ro");
//    try {
//      Thread.sleep(50000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void ssd() {

    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
//    logInPage.logIn(ZOTAC522_LOGIN, ZOTAC522_PASSWORD);
    addAdPage.addSDD();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void soundCore() {

    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.q35();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void oricoSamsung() {

    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(ZOTAC522_LOGIN, ZOTAC522_PASSWORD);
    addAdPage.orico();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void logitechTest() {

    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.logitech();
    Assert.assertTrue(page.isVisible("[class='success_icon']"));
  }

  @Test
  public void checkNotifications() {
    LogInPage logInPage = new LogInPage(page);
    AddAdPage addAdPage = new AddAdPage(page);
    logInPage.logIn(DOUBLE_A_LOGIN, DOUBLE_A_PASSWORD);
    addAdPage.getNotifications(DOUBLE_A_USER);

    addAdPage.logOut(ZOTAC522_LOGIN, ZOTAC522_PASSWORD);
    addAdPage.getNotifications(ZOTAC522_USER);

    addAdPage.logOut(XVM_21_LOGIN, XVM_21_PASSWORD);
    addAdPage.getNotifications(XVM_21_USER);

    addAdPage.logOut(XVM_2_LOGIN, XVM_2_PASSWORD);
    addAdPage.getNotifications(XVM_2_USER);

    addAdPage.logOut(USERMDD_02_LOGIN, USERMDD_02_PASSWORD);
    addAdPage.getNotifications(USERMDD_02_USER);
  }
}