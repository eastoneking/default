package eastone.precasting.context;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageSourceAppender implements FactoryBean<DelegatingMessageSource>, InitializingBean{
  
  private static Set<String> BASENAMES = new HashSet<String>();
  
  private DelegatingMessageSource messageSource;
  private String seperator = ",";
  private String basenames = "";
  /**
   * .
   */
  public MessageSourceAppender() {
  }
  
  /**
   * 设置messageSource属性值.
   * @param messageSource messageSource属性的新值.
   */
  public void setMessageSource(
      DelegatingMessageSource messageSource) {
    this.messageSource = messageSource;
  }
  /**
   * 获得messageSource属性值.
   * @return messageSource属性现值.
   */
  public DelegatingMessageSource getMessageSource() {
    return messageSource;
  }
  
  /**
   * 设置seperator属性值.
   * @param seperator seperator属性的新值.
   */
  public void setSeperator(String seperator) {
    this.seperator = seperator;
  }
  /**
   * 获得seperator属性值.
   * @return seperator属性现值.
   */
  public String getSeperator() {
    return seperator;
  }
  
  /**
   * 设置basenames属性值.
   * @param basenames basenames属性的新值.
   */
  public void setBasenames(String basenames) {
    this.basenames = basenames;
  }
  /**
   * 获得basenames属性值.
   * @return basenames属性现值.
   */
  public String getBasenames() {
    return basenames;
  }
  @Override
  public void afterPropertiesSet() throws Exception {
    ReloadableResourceBundleMessageSource ms = (ReloadableResourceBundleMessageSource)this.messageSource.getParentMessageSource();
    
    if(ms==null){
      return ;
    }
    
    String bns = this.basenames;
    if(StringUtils.isBlank(bns)){
      return ;
    }

    String spr = this.seperator;
    if(spr==null){
      spr = ",";
    }
    
    
    String[] bases = bns.split(spr);
    for(String cur:bases){
      BASENAMES.add(cur);
    }
    
    bases = new String[BASENAMES.size()];
    bases = BASENAMES.toArray(bases);
    
    ms.setBasenames(bases);
  }

  @Override
  public DelegatingMessageSource getObject() throws Exception {
    return this.messageSource;
  }

  @Override
  public Class<?> getObjectType() {
    return ReloadableResourceBundleMessageSource.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

}
