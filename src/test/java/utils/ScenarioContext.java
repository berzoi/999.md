package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import utils.DataEnum;

public class ScenarioContext {
//  private final Map<String, Object> scenarioContext;
//
//  public ScenarioContext(){
//    scenarioContext = new HashMap<>();
//  }
//
//  public void setContext(Context key, Object value) {
//    scenarioContext.put(key.toString(), value);
//  }
//
//  public Object getContext(Context key){
//    return scenarioContext.get(key.toString());
//  }
//
//  public Boolean isContains(Context key){
//    return scenarioContext.containsKey(key.toString());
//  }

  public static final ScenarioContext INSTANCE = new ScenarioContext();
  private Map<DataEnum, Object> context;

  private ScenarioContext() {
    this.context = new HashMap<DataEnum, Object>();
  }

  public static ScenarioContext getScenarioContext() {
    return INSTANCE;
  }

  public  void saveData(DataEnum key, Object data) {
    context.put(key, data);
  }

  public <T> T getData(DataEnum key) {
    if (!context.containsKey(key)) {
      throw new NoSuchElementException("Key does not exist");
    }
    return (T) context.get(key);
  }

  public void clearContext() {
    context.clear();
  }
}
