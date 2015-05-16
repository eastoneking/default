package com.neusoft.emanage.util.gen.entity;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

public class UserAccessBean extends EasyUiBaseBean implements BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户帐户id
	 */
	private Integer useraccess_id;
	/**
	 * 用户帐户中的人民币数量
	 */
	private Double RMB;
	/**
	 * 同RMB用于科学计算的转换方便
	 */
	private String RMBS;
	/**
	 * 用户帐户中的金佳币数量
	 */
	private Double GSC;
	/**
	 * 同GSC用于科学计算的转换方便
	 */
	private String GSCS;
	/**
	 * 用户帐户关联的用户的id
	 */
	private Integer userId;
	/**
	 * 用户登录名
	 */
	private String user_code;
	/**
	 * 用户帐户状态
	 */
	private String status;
	/**
	 * 用户电话号码
	 */
	private String phone;
	/**
	 * 用户email
	 */
	private String email;
	private String idCard;
	private String accessPassword;
	private String versionNum;
	
	
	public String getRMBS() {
		return RMBS;
	}
	public void setRMBS(String rMBS) {
		RMBS = rMBS;
	}
	public String getGSCS() {
		return GSCS;
	}
	public void setGSCS(String gSCS) {
		GSCS = gSCS;
	}
	public Integer getUseraccess_id() {
		return useraccess_id;
	}
	public void setUseraccess_id(Integer useraccess_id) {
		this.useraccess_id = useraccess_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Double getRMB() {
		return RMB;
	}
	public void setRMB(Double rMB) {
		RMB = rMB;
	}
	public Double getGSC() {
		return GSC;
	}
	public void setGSC(Double gSC) {
		GSC = gSC;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAccessPassword() {
		return accessPassword;
	}
	public void setAccessPassword(String accessPassword) {
		this.accessPassword = accessPassword;
	}
	public String getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}
	
}
