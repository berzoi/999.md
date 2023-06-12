package core;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

  static Config readConfig() {
    return ConfigFactory.systemProperties().hasPath("testProfile")
        ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
        : ConfigFactory.load("application.conf");
  }

  String XVM_21_LOGIN =  readConfig().getString("userParams.xvm21.login");
  String XVM_21_PASSWORD =  readConfig().getString("userParams.xvm21.password");

  String DOUBLE_A_LOGIN =  readConfig().getString("userParams.doubleA.login");
  String DOUBLE_A_PASSWORD =  readConfig().getString("userParams.doubleA.password");


  String ZOTAC522_LOGIN =  readConfig().getString("userParams.zotac522.login");
  String ZOTAC522_PASSWORD =  readConfig().getString("userParams.zotac522.password");

  String XVM_2_LOGIN =  readConfig().getString("userParams.xvm2.login");
  String XVM_2_PASSWORD =  readConfig().getString("userParams.xvm2.password");




  String URL_999 =  readConfig().getString("url999md");

}