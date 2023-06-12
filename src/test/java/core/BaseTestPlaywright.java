//package core;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.BrowserType.LaunchOptions;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//
//public class BaseTestPlaywright {
//  private Browser browserPlaywright;
//
////  protected Page page;
//
//  private BrowserContext context;
//
//
//  public void setUp(String url) {
//
//    browserPlaywright = Playwright
//        .create()
//        .chromium()
//        .launch(new LaunchOptions()
//            .setHeadless(false)
//            .setChannel("chrome"));
//
//    context = browserPlaywright.newContext();
//    Page  page = context.newPage();
//    page.navigate(url);
//  }
//
////  public void tearDown(){
////    if (browserPlaywright != null) {
////      browserPlaywright.close();
////      browserPlaywright = null;
////    }
////  }
//
//
//}
