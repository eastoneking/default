package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinBianmaBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 药品编码名字
	 */
	private String ypbmname;
	/**
	 * 药品编码编号
	 */
	private String ypbmnumber;
	/**
	 * 类别顺序
	 */
	private String yppihao;
	/**
	 * 药品批号
	 */
	private String ypbmshengchanshang;
	/**
	 * 药品类别ID
	 */
	private String ypbmleibieid;
	/**
	 * 药品类别名字
	 */
	private String ypbmleibiename;
	/**
	 * 药品编码顺序
	 */
	private String ypbmorder;
	/**
	 * 药品编码状态
	 */
	private String ypbmstatus;
	/**
	 * 药品编码单位
	 */
	private String ypbmdanwei;
	
	private String useMethod;
	
	private String useAmount;
	
	private String useFrequence;
	
	/**
     * The setter method of the property useAmount.
     * @param theuseAmount the useAmount to set
     * @author wangds 2015年5月19日 下午1:30:40.
     */
    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }
    
    /**
     * The getter method of the property useAmount.
     * @author wangds 2015年5月19日 下午1:30:43.
     * @return the useAmount.
     */
    public String getUseAmount() {
        return useAmount;
    }
    
    /**
     * The setter method of the property useFrequence.
     * @param theuseFrequence the useFrequence to set
     * @author wangds 2015年5月19日 下午1:30:46.
     */
    public void setUseFrequence(String useFrequence) {
        this.useFrequence = useFrequence;
    }
    
    /**
     * The getter method of the property useFrequence.
     * @author wangds 2015年5月19日 下午1:30:51.
     * @return the useFrequence.
     */
    public String getUseFrequence() {
        return useFrequence;
    }
    
    /**
     * The setter method of the property useMethod.
     * @param theuseMethod the useMethod to set
     * @author wangds 2015年5月19日 下午1:30:56.
     */
    public void setUseMethod(String useMethod) {
        this.useMethod = useMethod;
    }
    /**
     * The getter method of the property useMethod.
     * @author wangds 2015年5月19日 下午1:30:59.
     * @return the useMethod.
     */
    public String getUseMethod() {
        return useMethod;
    }
	
	
	
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYpbmname() {
		return ypbmname;
	}
	public void setYpbmname(String ypbmname) {
		this.ypbmname = ypbmname;
	}
	public String getYpbmnumber() {
		return ypbmnumber;
	}
	public void setYpbmnumber(String ypbmnumber) {
		this.ypbmnumber = ypbmnumber;
	}
	public String getYppihao() {
		return yppihao;
	}
	public void setYppihao(String yppihao) {
		this.yppihao = yppihao;
	}
	public String getYpbmshengchanshang() {
		return ypbmshengchanshang;
	}
	public void setYpbmshengchanshang(String ypbmshengchanshang) {
		this.ypbmshengchanshang = ypbmshengchanshang;
	}
	public String getYpbmleibieid() {
		return ypbmleibieid;
	}
	public void setYpbmleibieid(String ypbmleibieid) {
		this.ypbmleibieid = ypbmleibieid;
	}
	public String getYpbmleibiename() {
		return ypbmleibiename;
	}
	public void setYpbmleibiename(String ypbmleibiename) {
		this.ypbmleibiename = ypbmleibiename;
	}
	public String getYpbmorder() {
		return ypbmorder;
	}
	public void setYpbmorder(String ypbmorder) {
		this.ypbmorder = ypbmorder;
	}
	public String getYpbmstatus() {
		return ypbmstatus;
	}
	public void setYpbmstatus(String ypbmstatus) {
		this.ypbmstatus = ypbmstatus;
	}
	public String getYpbmdanwei() {
		return ypbmdanwei;
	}
	public void setYpbmdanwei(String ypbmdanwei) {
		this.ypbmdanwei = ypbmdanwei;
	}
	

	
	
	
}
