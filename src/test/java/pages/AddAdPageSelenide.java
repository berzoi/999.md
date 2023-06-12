package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static core.ConfigProvider.URL_999;
import static pages.SignInPageSelenide.performLogin;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.ActionsHelper;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.annotations.Test;

public class AddAdPageSelenide {

  ActionsHelper actionsHelper = new ActionsHelper();

  private final SelenideElement selectPcCategory = $("[href*='computers-and-office-equipment']");
  private final SelenideElement selectMiceCategory = $("[href*='mice-joysticks']");
  private final SelenideElement title = $("[name='12']");
  private final SelenideElement price = $("[type='text'][name='2']");
  private final SelenideElement type = $("[name='686'], [name='724']");
  private final SelenideElement manufacturer = $("[name='672'], [name='723']");
  private final SelenideElement uploadPicture = $("input#fileupload-file-input");
  private final SelenideElement agreeButton = $("[id='agree']");
  private final SelenideElement addButton = $("[id='js-add-ad']");
  private final SelenideElement submitButton = $("div[class='grid_9'] button[type='submit']");

  public void logitech(String email, String password) {
    open(URL_999);
//    actionsHelper.navigateTo("URL_999");
    performLogin(email, password);
    addButton.click();
    selectPcCategory.click();
    selectMiceCategory.click();
    title.sendKeys("Logitech - Оригинальный чехол для компьютерной мыши");
    price.sendKeys("50");
    type.selectOptionByValue("20823");
    manufacturer.selectOptionByValue("24705");

    String[] picturePaths = {
        "G:\\My Drive\\999\\Logitech\\pic1.jpg", "G:\\My Drive\\999\\Logitech\\pic2.jpg", "G:\\My Drive\\999\\Logitech\\pic3.jpg"
    };
    for (String picturePath : picturePaths) {
      File file = new File(picturePath);
      uploadPicture.uploadFile(file);
    }
    agreeButton.click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    submitButton.click();


  }


}
