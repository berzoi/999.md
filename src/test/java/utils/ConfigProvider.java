package utils;

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
  String XVM_21_USER =  readConfig().getString("userParams.xvm21.user");


  String DOUBLE_A_LOGIN =  readConfig().getString("userParams.doubleA.login");
  String DOUBLE_A_PASSWORD =  readConfig().getString("userParams.doubleA.password");
  String DOUBLE_A_USER =  readConfig().getString("userParams.doubleA.user");


  String ZOTAC522_LOGIN =  readConfig().getString("userParams.zotac522.login");
  String ZOTAC522_PASSWORD =  readConfig().getString("userParams.zotac522.password");
  String ZOTAC522_USER =  readConfig().getString("userParams.zotac522.user");

  String XVM_2_LOGIN =  readConfig().getString("userParams.xvm2.login");
  String XVM_2_PASSWORD =  readConfig().getString("userParams.xvm2.password");
  String XVM_2_USER =  readConfig().getString("userParams.xvm2.user");

  String USERMDD_02_LOGIN =  readConfig().getString("userParams.usermdd02.login");
  String USERMDD_02_PASSWORD =  readConfig().getString("userParams.usermdd02.password");
  String USERMDD_02_USER =  readConfig().getString("userParams.usermdd02.user");




  String URL_999 =  readConfig().getString("url999md");

}