package core;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Selenide;

public class BaseTestSelenide {
  public static void navigateTo(String url) {
    browser = "chrome";
    timeout = 10000;
    holdBrowserOpen = true;
//    browserPosition = "30x30";
//    browserSize = "1500x500";
//    headless = true;
    open(url);
  }


//  public void xxxx(String url ){
//    browser = "chrome";
//    timeout = 10000;
//    holdBrowserOpen = true;
////    headless = true;
//    open(url);
//
//  }
}

