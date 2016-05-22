package com.glority.common.connectors.jenkins;

import java.util.List;

/**
 * the parameter module.
 * @author zm
 *
 */
public class Parameter {

   private String name;
   private String defaultValue;
   private List<String> choices;
   private String type;

   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getDefaultValue() {
       return defaultValue;
   }
   public void setDefaultValue(String defaultValue) {
       this.defaultValue = defaultValue;
   }
   public List<String> getChoices() {
       return choices;
   }
   public void setChoices(List<String> choices) {
       this.choices = choices;
   }
   public String getType() {
       return type;
   }
   public void setType(String type) {
       this.type = type;
   }
}
