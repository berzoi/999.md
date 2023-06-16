package pages;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import core.ActionsHelper;
import core.BaseTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddAdPage extends BaseTest {

  private final Page page;
  ActionsHelper actionsHelper = new ActionsHelper();

  public AddAdPage(Page page) {
    this.page = page;
  }

  private final String textCarToAddRus = "Skoda Fabia 3 \n"
      + "- 2019 г.в.\n"
      + "- 22.800 км.\n"
      + "- 999cm\n"
      + "- јвтомобиль в отличном техническом состо€нии\n"
      + "- ѕрактически новый\n"
      + "- ћинимальный пробег\n"
      + "- ќдин владелец";

  private final String textCarToAddRo = "Skoda Fabia 3 \n"
      + "- Pret listat     = 9.200И.\n"
      + "- Pret 'ultimul pret' = 8.800И.\n"
      + "- 2019 a.f.\n"
      + "- 22.800 km.\n"
      + "- 999cm\n"
      + "- Masina e in stare tehnica excelenta\n"
      + "- Masina este practic noua\n"
      + "- Parcurs minim\n"
      + "- Procurata de la Daac Hermes\n"
      + "\n";
//      + "Telegram canal: https://t.me/MTS_AutoVentas\n"
//      + "Instagram:      https://www.instagram.com/p/CthLp1ZootP";


  private final String tagToAdd = "Skoda, Fabia, Skoda Fabia, Skoda Fabia 3, нова€, новый";
  private final String textSSDToAddTitle = "Kingston NV2 500Gb PCIe 4.0 Ч 2шт по 620/шт или 1 шт по 670";
//  private final String textSSDToAdd = "Nou, sigilat, original\n"
//      + "Ќовый, запечатанный, оригинальный\n"
//      + "Kingston NV2 500Gb, PCIe 4.0, NVMe";
//
  private final String textSSDToAdd = "Kingston NV2 500Gb, PCIe 4.0, NVMe\n"
    + "=============================\n"
    + "Ќовые, запечатанные, оригинальные";

  private final String closePopUp = "[class='header_menu_nav__cart_popup_action']";
  private final String addAdButton = "[id='js-add-ad']";
  private final String selectTransportCategory = "[href*='transport']";
  private final String selectCarSubCategory = "[href*='transport/cars']";
  private final String adTextForm = "#control_13";
  private final String tagTextForm = "#control_1404";
  private final String price = "[name='2']";
  private final String make = "[id='control_20']";
  private final String model = "[id='control_21']";
  private final String registration = "[id='control_775']";
  private final String condition = "[name='593']";
  private final String stock = "[name='1761']";
  private final String market = "[name='1763']";
  private final String priceCurrencySelect = "[class=' form-element__select js-price-units ']";
  private final String addAuthor = "[name='795']";
  private final String yearOfManufacture = "[name='19']";
  private final String steeringWheel = "[name='1196']";
  private final String numberSeats = "[name='846']";
  private final String bodyType = "[name='102']";
  private final String mileage = "[name='104']";
  private final String engineCapacity = "[name='103']";
  private final String enginePower = "[name='107']";
  private final String fuelType = "[name='151']";
  private final String transmissionType = "[name='101']";
  private final String privod = "[name='108']";
  private final String colour = "[name='17']";
  private final String uploadPictureButton = "input#fileupload-file-input";
  private final String uploadPictureButton2 = "[id='fileupload-button']";
  private final String agreeButton = "[id='agree']";
  private final String submitButton = "div[class='grid_9'] button[type='submit']";
  private final String selectPcCategory = "[href*='computers-and-office-equipment']";
  private final String selectMiceCategory = "[href*='mice-joysticks']";
  private final String selectSSDSubCategory = "[href*='hdd']";
  private final String title = "[name='12']";
  private final String type = "[name='686'], [name='724']";
  private final String manufacturer = "[name='672'], [name='723']";
  private final String formFactor = "[name='951']";
  private final String size = "[name='950']";
  private final String ssdInterface = "[name='952']";
  private final String removeButton = "[class*='photo__body__remove']";
  private final String selectAudioCategory = "[href*='audio']";
  private final String selectHeadPhonesSubCategory = "[href*='microphones']";
  private final String subType = "[name='752']";
  private final String connectionType = "[name='962']";
  private final String warningLimit = "[href='https://999.md/info/rules#pages-rule2']";
  private final String notification = "[class='user-item-btn-chat-unreaded']";

  public boolean checkWarningLimit() {
    if (page.querySelector(warningLimit).isVisible()) {
      return true;
    }
    return false;
  }



  public void logOut(String login, String password){
    page.frameLocator("#topbar-panel").locator("[id='user-username-btn']").hover();
    page.frameLocator("#topbar-panel").locator("button[data-autotest='logout']").click();
    page.click("[data-autotest='login']");
    page.fill("[name='login']", login);
    page.fill("[name='password']", password);
    page.click("[type='submit']");
  }

  public int getNumberOhHiddenAdds() {
    List<ElementHandle> elements = page.querySelectorAll("[data-test-item-type='standard']");
    int count = 0;

    for (ElementHandle element : elements) {
      String attributeValue = element.getAttribute("data-test-item-state");
      if (!attributeValue.equals("public")) {
        count++;
      }
    }
    return count;
  }

  public void getNotifications(String user){
    page.hover("[id='m__user_panel']");
    page.click("a[href='/cabinet/items']");
    int numberOfNotifications = Integer.parseInt(page.frameLocator("#topbar-panel").locator(notification).innerText());
//    System.out.println(numberOfNotifications != 0
//        ? "There are " + numberOfNotifications + " notifications for the user:       " + user
//        : "There are no notifications for the:           " + user);
    System.out.println("--->" + user);
    System.out.println("Notifications = " + numberOfNotifications);
    System.out.println("Hidden adds= " + getNumberOhHiddenAdds());
    System.out.println("========================");
  }

  public void setUp() {
    if (page.querySelector(closePopUp) != null) {
      page.click(closePopUp);

    }
    page.click(addAdButton);

  }

  public void logitech() {
    setUp();
    page.click(selectPcCategory);
    page.click(selectMiceCategory);
    page.fill(title, "Logitech - ќригинальный чехол дл€ компьютерной мыши");
    page.fill(price, "50");
    page.selectOption(type, "20823");
    page.selectOption(manufacturer, "24705");
    page.setInputFiles(uploadPictureButton, new Path[]{
        Paths.get("G:\\My Drive\\999\\Logitech\\pic1.jpg"),
        Paths.get("G:\\My Drive\\999\\Logitech\\pic2.jpg"),
        Paths.get("G:\\My Drive\\999\\Logitech\\pic3.jpg")});

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    page.click(agreeButton);
    page.click(submitButton);
  }


  public void orico() {
    setUp();
    page.click(selectPcCategory);
    page.click(selectSSDSubCategory);
    page.fill(title, "Case Orico, Type C, USB 3.1 Gen 2 + Samsung 850 Evo");
    page.fill(adTextForm, "Ч ¬нешний корпус дл€ жесткого диска/SSD ORICO, Type C, USB 3.1 Gen 2, 2.5\" Ч 400 лей\n"
        + "Ч Samsung 850 Evo 120Gb Ч 200 лей");
    page.fill(tagTextForm, "Orico, Samsung");
    page.fill(price, "600");
    page.selectOption(type, "22142");
    page.selectOption(manufacturer, "7697");
    page.selectOption(formFactor, "20730");
    page.fill(size, "120");
    page.selectOption(ssdInterface, "26804");
    page.setInputFiles(uploadPictureButton, new Path[]{
        Paths.get("G:\\My Drive\\999\\HDD\\Orico\\pic1.jpg"),
        Paths.get("G:\\My Drive\\999\\HDD\\Orico\\pic2.jpeg"),
        Paths.get("G:\\My Drive\\999\\HDD\\Orico\\pic3.jpg"),
        Paths.get("G:\\My Drive\\999\\HDD\\Orico\\pic4.jpg"),
        Paths.get("G:\\My Drive\\999\\HDD\\Orico\\pic5.jpg")});
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    page.click(agreeButton);
    page.click(submitButton);

  }

  public void q35() {
    setUp();
    page.click(selectAudioCategory);
    page.click(selectHeadPhonesSubCategory);
    page.fill(title, "Anker SoundCore Life Q35 Blue");
    page.fill(adTextForm, "https://ru.soundcore.com/products/naushniki/polnorazmernye/life-q-35-A3027\n"
        + "\n"
        + "Ќаушники сделаны дл€ американского рынка и куплены в —Ўј.\n"
        + "\n"
        + "√раждане ћќЎ≈ЌЌ» » - ѕочтой и курьером не отправл€ю.");
    page.fill(tagTextForm, "SoundCore, Q35, Anker");
    page.fill(price, "2100");
    page.selectOption(manufacturer, "26189");
    page.selectOption(type, "19644");
    page.selectOption(subType, "19650");
    page.selectOption(connectionType, "20820");
    page.setInputFiles(uploadPictureButton, new Path[]{
        Paths.get("G:\\My Drive\\999\\Q35\\pic1.jpg"),
        Paths.get("G:\\My Drive\\999\\Q35\\pic2.jpg"),
        Paths.get("G:\\My Drive\\999\\Q35\\pic3.jpg")});
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    page.click(agreeButton);
    page.click(submitButton);
  }

  public void addSDD() {
    setUp();
    page.click(selectPcCategory);
    page.click(selectSSDSubCategory);
    page.fill(title, textSSDToAddTitle);
    page.fill(adTextForm, textSSDToAdd);
    page.fill(price, "620");
    page.selectOption(type, "20734");
    page.selectOption(manufacturer, "24698");
    page.selectOption(formFactor, "26803");
    page.fill(size, "500");
    page.selectOption(ssdInterface, "22140");
    page.setInputFiles(uploadPictureButton, new Path[]{
        Paths.get("G:\\My Drive\\999\\SSD\\New folder\\pic1.jpg"),
        Paths.get("G:\\My Drive\\999\\SSD\\New folder\\pic2.jpg"),
        Paths.get("G:\\My Drive\\999\\SSD\\New folder\\pic3.jpg")});
    page.waitForSelector(removeButton, new Page.WaitForSelectorOptions().setState(VISIBLE));
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    page.click(agreeButton);
    page.click(submitButton);
  }


  public void addCar() {
    setUp();
    page.click(selectTransportCategory);
    page.click(selectCarSubCategory);
//    if (checkWarningLimit() == true) {
      page.selectOption(make, "143");
      page.selectOption(model, "170");
      page.selectOption(registration, "18592");
      page.selectOption(condition, "18668");
      page.selectOption(stock, "29670");
      page.selectOption(market, "29677");
      page.fill(adTextForm, textCarToAddRo);
//      page.fill(adTextForm, textCarToAddRus);
      page.fill(tagTextForm, tagToAdd);
      page.fill(price, "9200");
      page.selectOption(addAuthor, "18895");
      page.fill(yearOfManufacture, "2019");
      page.selectOption(steeringWheel, "21979");
      page.selectOption(numberSeats, "19119");
      page.selectOption(bodyType, "11");
      page.fill(mileage, "22800");
      page.fill(engineCapacity, "999");
      page.fill(enginePower, "75");
      page.selectOption(fuelType, "10");
      page.selectOption(transmissionType, "4");
      page.selectOption(privod, "5");
      page.selectOption(colour, "19");
      page.setInputFiles(uploadPictureButton, new Path[]{
          Paths.get("G:\\My Drive\\999\\Fabia\\pic1.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic2.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic3.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic4.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic5.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic6.jpg"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic7.png"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic8.png"),
          Paths.get("G:\\My Drive\\999\\Fabia\\pic9.jpg")});
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      page.click(agreeButton);
      page.click(submitButton);
//    } else {
//      System.out.println("¬ы исчерпали мес€чный лимит бесплатных объ€влений в данной подкатегории");
//    }
  }
}
