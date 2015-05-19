package com.neusoft.emanage.ypsys.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinBianmaQueryBean  extends EasyUiBaseBean {

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
	
	private String useSequence;
	
	
	
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
	

	/**
     * The setter method of the property useAmount.
     * @param theuseAmount the useAmount to set
     * @author wangds 2015年5月19日 下午1:07:44.
     */
    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }
    /**
     * The getter method of the property useAmount.
     * @author wangds 2015年5月19日 下午1:07:48.
     * @return the useAmount.
     */
    public String getUseAmount() {
        return useAmount;
    }
    /**
     * The setter method of the property useMethod.
     * @param theuseMethod the useMethod to set
     * @author wangds 2015年5月19日 下午1:07:51.
     */
    public void setUseMethod(String useMethod) {
        this.useMethod = useMethod;
    }
    /**
     * The getter method of the property useMethod.
     * @author wangds 2015年5月19日 下午1:07:57.
     * @return the useMethod.
     */
    public String getUseMethod() {
        return useMethod;
    }
    /**
     * The setter method of the property useSequence.
     * @param theuseSequence the useSequence to set
     * @author wangds 2015年5月19日 下午1:08:00.
     */
    public void setUseSequence(String useSequence) {
        this.useSequence = useSequence;
    }
    /**
     * The getter method of the property useSequence.
     * @author wangds 2015年5月19日 下午1:08:03.
     * @return the useSequence.
     */
    public String getUseSequence() {
        return useSequence;
    }
	
	
}
