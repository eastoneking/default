package com.neusoft.emanage.yaoju.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinCKQueryBean  extends EasyUiBaseBean  {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 药品编码id
	 */
	private String kc_ypbmid;
	/**
	 * 药品编码
	 */
	private String kc_ypbmnumber;
	/**
	 * 药品类别
	 */
	private String kc_ypleibie;
	/**
	 * 药品名称
	 */
	private String kc_ypname;
	/**
	 * 生产批号
	 */
	private String kc_yppihao;
	/**
	 * 生产批次
	 */
	private String kc_scpici;
	/**
	 * 生产日期
	 */
	private String kc_scriqi;
	/**
	 * 有效日期
	 */
	private String kc_yxriqi;
	/**
	 * 成本价格
	 */
	private String kc_cbjiage;
	/**
	 *最低价格
	 */
	private String kc_zdjiage;
	/**
	 * 入库日期
	 */
	private String kc_rkriqi;
	/**
	 * 药品来源
	 */
	private String kc_laiyuan;
	/**
	 * 状态
	 */
	private String kc_status;
	
	/********getter  setter**************************/

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKc_ypbmid() {
		return kc_ypbmid;
	}
	public void setKc_ypbmid(String kc_ypbmid) {
		this.kc_ypbmid = kc_ypbmid;
	}
	public String getKc_ypbmnumber() {
		return kc_ypbmnumber;
	}
	public void setKc_ypbmnumber(String kc_ypbmnumber) {
		this.kc_ypbmnumber = kc_ypbmnumber;
	}
	public String getKc_ypleibie() {
		return kc_ypleibie;
	}
	public void setKc_ypleibie(String kc_ypleibie) {
		this.kc_ypleibie = kc_ypleibie;
	}
	public String getKc_ypname() {
		return kc_ypname;
	}
	public void setKc_ypname(String kc_ypname) {
		this.kc_ypname = kc_ypname;
	}
	public String getKc_yppihao() {
		return kc_yppihao;
	}
	public void setKc_yppihao(String kc_yppihao) {
		this.kc_yppihao = kc_yppihao;
	}
	public String getKc_scpici() {
		return kc_scpici;
	}
	public void setKc_scpici(String kc_scpici) {
		this.kc_scpici = kc_scpici;
	}
	public String getKc_scriqi() {
		return kc_scriqi;
	}
	public void setKc_scriqi(String kc_scriqi) {
		this.kc_scriqi = kc_scriqi;
	}
	public String getKc_yxriqi() {
		return kc_yxriqi;
	}
	public void setKc_yxriqi(String kc_yxriqi) {
		this.kc_yxriqi = kc_yxriqi;
	}
	public String getKc_cbjiage() {
		return kc_cbjiage;
	}
	public void setKc_cbjiage(String kc_cbjiage) {
		this.kc_cbjiage = kc_cbjiage;
	}
	public String getKc_zdjiage() {
		return kc_zdjiage;
	}
	public void setKc_zdjiage(String kc_zdjiage) {
		this.kc_zdjiage = kc_zdjiage;
	}
	public String getKc_rkriqi() {
		return kc_rkriqi;
	}
	public void setKc_rkriqi(String kc_rkriqi) {
		this.kc_rkriqi = kc_rkriqi;
	}
	public String getKc_laiyuan() {
		return kc_laiyuan;
	}
	public void setKc_laiyuan(String kc_laiyuan) {
		this.kc_laiyuan = kc_laiyuan;
	}
	public String getKc_status() {
		return kc_status;
	}
	public void setKc_status(String kc_status) {
		this.kc_status = kc_status;
	}
	
	private String useMethod;
	private String useAmount;
	private String useFrequence;
	
	/**
     * The setter method of the property useAmount.
     * @param theuseAmount the useAmount to set
     * @author wangds 2015年5月19日 下午10:58:44.
     */
    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }
    /**
     * The getter method of the property useAmount.
     * @author wangds 2015年5月19日 下午10:58:48.
     * @return the useAmount.
     */
    public String getUseAmount() {
        return useAmount;
    }
    /**
     * The setter method of the property useFrequence.
     * @param theuseFrequence the useFrequence to set
     * @author wangds 2015年5月19日 下午10:58:53.
     */
    public void setUseFrequence(String useFrequence) {
        this.useFrequence = useFrequence;
    }
    /**
     * The getter method of the property useFrequence.
     * @author wangds 2015年5月19日 下午10:58:56.
     * @return the useFrequence.
     */
    public String getUseFrequence() {
        return useFrequence;
    }
    /**
     * The setter method of the property useMethod.
     * @param theuseMethod the useMethod to set
     * @author wangds 2015年5月19日 下午10:58:59.
     */
    public void setUseMethod(String useMethod) {
        this.useMethod = useMethod;
    }
    /**
     * The getter method of the property useMethod.
     * @author wangds 2015年5月19日 下午10:59:02.
     * @return the useMethod.
     */
    public String getUseMethod() {
        return useMethod;
    }
	
}
