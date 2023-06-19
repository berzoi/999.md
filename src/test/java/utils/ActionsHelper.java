package utils;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;
import static com.microsoft.playwright.options.WaitUntilState.DOMCONTENTLOADED;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionsHelper {

//  public void navigateTo(String url) {
//    new BaseTestSelenide(url);
//  }

  //  public void waitForSelector(String selector){
//    page.waitForSelector(selector, new Page.WaitForSelectorOptions().setState(VISIBLE));
//  }
//
//  public void openLink (String url){
//    page.navigate(url, new NavigateOptions().setWaitUntil(DOMCONTENTLOADED));
//  }
  public void waiter(int timeToWait) {
    try {
      Thread.sleep(timeToWait);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void getNumberOAttributeOld(Page page) {

    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    List<String> value = new ArrayList<>();
    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      value.add(attributeValue);
    }

    Map<String, Integer> elementCount = new HashMap<>();
    for (String element : value) {
      if (elementCount.containsKey(element)) {
        // If the element is already in the map, increment its count by 1
        elementCount.put(element, elementCount.get(element) + 1);
      } else {
        // If the element is not in the map, add it with a count of 1
        elementCount.put(element, 1);
      }
    }

    for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  public int getNumberOfHiddenAdds(Page page) {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    int count = 0;

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      if (attributeValue.equals("hidden")) {
        count++;
      }
    }
    return count;
  }

  public int getNumberOfBlockedAdds(Page page) {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    int count = 0;

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      if (attributeValue.equals("blocked")) {
        count++;
      }
    }
    return count;
  }

  public int getNumberOfPublicAdds(Page page) {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    int count = 0;

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      if (attributeValue.equals("public")) {
        count++;
      }
    }
    return count;
  }

  public int getNumberOfNeedPayAdds(Page page) {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    int count = 0;

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      if (attributeValue.equals("need_pay")) {
        count++;
      }
    }
    return count;
  }

  public boolean checkWarningLimit(String selector, Page page) {
    if (page.querySelector(selector).isVisible()) {
      return true;
    }
    return false;
  }

  public void getNumberOAttribute(String user, Page page) {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    Map<String, Integer> elementCount = new HashMap<>();

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      elementCount.put(attributeValue, elementCount.getOrDefault(attributeValue, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());

      if (entry.getKey().contains("blocked")) {
        System.out.println("-------------------------------------------> There are blocked adds for " + user);
      }
    }
  }
}
