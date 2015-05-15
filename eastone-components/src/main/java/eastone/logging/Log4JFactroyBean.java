package eastone.logging;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import eastone.common.GeneralParentObject;


public class Log4JFactroyBean implements FactoryBean<Logger>, InitializingBean{

  /**
   * .
   */
  private String logConfigXMLPath;
  /**
   * .
   */
  public Log4JFactroyBean() {
  }
  
  /**
   * 获得logConfigXMLPath属性值.
   * @return logConfigXMLPath属性现值.
   */
  public String getLogConfigXMLPath() {
    return logConfigXMLPath;
  }
  /**
   * 设置logConfigXMLPath属性值.
   * @param logConfigXMLPath logConfigXMLPath属性的新值.
   */
  public void setLogConfigXMLPath(String logConfigXMLPath) {
    this.logConfigXMLPath = logConfigXMLPath;
  }

  @Override
  public Logger getObject() throws Exception {
    return GeneralParentObject.staticLogger(Log4JFactroyBean.class);
  }

  @Override
  public Class<?> getObjectType() {
    return Logger.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    DOMConfigurator.configure(this.logConfigXMLPath);
  }
  
  

}
