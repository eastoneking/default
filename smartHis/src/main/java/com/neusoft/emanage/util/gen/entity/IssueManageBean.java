package com.neusoft.emanage.util.gen.entity;
import java.sql.Timestamp;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币 发行管理实体类
 * 对应sys_user,useraccess,gscmanagerhis数据库表
 * @author jichuang date : 2014年6月10日
 *
 */
public class IssueManageBean implements BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer ID;
	private String user_name;
//	private String password;
	private String display_name;
	private Integer sex;
	private String phone_number;
	private Integer versionNum;
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	private String email;
	private String note;
	//自增长id主键
	private Integer sys_user_id;
	//自增长id主键
	private Integer useraccess_id;
	//用户登录名
	private String user_code;
	//用户登录密码
	private String user_passwd;
	//用户真实姓名
	private String user_realname;
	//标记该记录的员工状态0：在职，1：离职，2：退休，3：试用，4：实习
	private String user_state;
	//部门id
	private Integer dept_id;
	//标记该记录的启用状态1：正常，0：禁用（已删除）
	private String enable_flag;
	//创建人
	private String create_user; 
	
	//创建时间
	private Timestamp create_timestamp;
	//最后修改人
	private String last_update_user;
	//最后修改时间
	private Timestamp last_update_timestamp;
	//最后修改备注
	private String last_update_remark;
	//人民币数量
	private Double rmb;
	//金佳币的数量
	private Double gsc;
	//对应sys_user表id
	private Integer userId;
	//金佳币总数量
	private Double sys_GSC_num;
	//记录造成系统金佳币改变的id，系统造币默认0
	private Integer fkId;
	/*
	 * 可能引起GSCMananger中数据变动的有七中情况，
	 * 1，造币（造成GSC变动）
	 * 2，用户充值（造成RMB变动），
	 * 3，用户提现（造成RMB变动）
	 * 4，分发（用户持有总量变动）
	 * 5，赠送（用户持有总量变动）
	 * 6，申购（用户持有总量变动）
	 * 7，系统造币
	 */
	private String tableName;
	//用户持产量
	private Double user_gsc_num;
	//可以卖出量+用户持有量=系统总量
	private Double trade_num;
	//自动增长  用来记录最后一次修改
	private Integer versionnum;
	//修改时间
	private Timestamp updateTime;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getSys_user_id() {
		return sys_user_id;
	}
	public void setSys_user_id(Integer sys_user_id) {
		this.sys_user_id = sys_user_id;
	}
	public Double getRmb() {
		return rmb;
	}
	
	public Integer getUseraccess_id() {
		return useraccess_id;
	}
	public void setUseraccess_id(Integer useraccess_id) {
		this.useraccess_id = useraccess_id;
	}
	public void setRmb(Double rmb) {
		this.rmb = rmb;
	}
	public Double getGsc() {
		return gsc;
	}
	public void setGsc(Double gsc) {
		this.gsc = gsc;
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
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getEnable_flag() {
		return enable_flag;
	}
	public void setEnable_flag(String enable_flag) {
		this.enable_flag = enable_flag;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Timestamp getCreate_timestamp() {
		return create_timestamp;
	}
	public void setCreate_timestamp(Timestamp create_timestamp) {
		this.create_timestamp = create_timestamp;
	}
	public String getLast_update_user() {
		return last_update_user;
	}
	public void setLast_update_user(String last_update_user) {
		this.last_update_user = last_update_user;
	}
	public Timestamp getLast_update_timestamp() {
		return last_update_timestamp;
	}
	public void setLast_update_timestamp(Timestamp last_update_timestamp) {
		this.last_update_timestamp = last_update_timestamp;
	}
	public String getLast_update_remark() {
		return last_update_remark;
	}
	public void setLast_update_remark(String last_update_remark) {
		this.last_update_remark = last_update_remark;
	}
	public Double getSys_GSC_num() {
		return sys_GSC_num;
	}
	public void setSys_GSC_num(Double sys_GSC_num) {
		this.sys_GSC_num = sys_GSC_num;
	}
	public Integer getFkId() {
		return fkId;
	}
	public void setFkId(Integer fkId) {
		this.fkId = fkId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Double getUser_gsc_num() {
		return user_gsc_num;
	}
	public void setUser_gsc_num(Double user_gsc_num) {
		this.user_gsc_num = user_gsc_num;
	}
	public Double getTrade_num() {
		return trade_num;
	}
	public void setTrade_num(Double trade_num) {
		this.trade_num = trade_num;
	}
	public Integer getVersionnum() {
		return versionnum;
	}
	public void setVersionnum(Integer versionnum) {
		this.versionnum = versionnum;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
