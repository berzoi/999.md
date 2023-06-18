package core;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;
import static com.microsoft.playwright.options.WaitUntilState.DOMCONTENTLOADED;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;

public class ActionsHelper {
  private final Page page;

  public ActionsHelper(Page page) {
    this.page = page;
  }

//  public static void clickElement(SelenideElement element) {
//    element.scrollTo().click();
//  }
//
//  public static void getMessage(SelenideElement element, String message) {
//    element.shouldHave(text(message));
//  }
//
//  public void navigateTo(String url) {
//    new BaseTestSelenide(url);
//  }

  public void waitForSelector(String selector){
    page.waitForSelector(selector, new Page.WaitForSelectorOptions().setState(VISIBLE));
  }

  public void openLink (String url){
    page.navigate(url, new NavigateOptions().setWaitUntil(DOMCONTENTLOADED));
  }
  public void waiter (int timeToWait){
    try {
      Thread.sleep(timeToWait);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
