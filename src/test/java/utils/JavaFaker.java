package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;


public class JavaFaker {

  public static void main(String[] args) {

    FakeValuesService fakeValuesService = new FakeValuesService(
        new Locale("en-GB"), new RandomService());
    Faker faker = new Faker();

    var fullAddress = faker.address().fullAddress();
    var fullName = faker.name().fullName();
    var firstName = faker.name().firstName();
    var lastName = faker.name().lastName();
    var company = faker.company().name();
    var cellPhone = faker.phoneNumber().cellPhone();
    var streetAddress = faker.address().streetAddress();
    var stateAbbr = faker.address().stateAbbr();
    var state = faker.address().state();
    var cityName = faker.address().cityName();

    var zipCode = faker.address().zipCodeByState(stateAbbr);
    var email1 = fakeValuesService.bothify("??????##@gmail.com");
    var email = fakeValuesService.bothify(firstName.toLowerCase().concat("###@gmail.com"));
//    System.out.println("fullName    = " + fullName);
    System.out.println("firstName       = " + firstName);
    System.out.println("lastName        = " + lastName);
    System.out.println("email           = " + email);
    var userName = firstName.toLowerCase().concat(lastName.toLowerCase());
    System.out.println("userName           = " + userName);
    var password = firstName.concat(lastName.toLowerCase().concat("$"));
    System.out.println("password           = " + password);
  }

    FakeValuesService fakeValuesService = new FakeValuesService(
        new Locale("en-GB"), new RandomService());
    Faker faker = new Faker();

  public String fullAddress = faker.address().fullAddress();
  public String fullName = faker.name().fullName();
  public String firstName = faker.name().firstName();
  public String lastName = faker.name().lastName();
  public String company = faker.company().name();
  public String cellPhone = faker.phoneNumber().cellPhone();
  public String streetAddress = faker.address().streetAddress();
  public String stateAbbr = faker.address().stateAbbr();
  public String state = faker.address().state();
//  public String cityName = faker.address().cityName();
  public String cityName = "Iasi";

  public String zipCodeShort = faker.address().zipCodeByState(stateAbbr);
//  public String zipCode = zipCodeShort.replace("##", "526");
  public String zipCode = "700264";
  public String email = fakeValuesService.bothify(firstName.toLowerCase().concat(lastName.toLowerCase()).concat("###@gmail.com"));
  public String userName = firstName.toLowerCase().concat(lastName.toLowerCase());
  public String password = firstName.concat(lastName.toLowerCase().concat("$"));
}
