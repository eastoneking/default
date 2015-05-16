package com.neusoft.sframe.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.neusoft.platform.syscontext.PlatformGlobalVar;


/**
 * 系统中常用的常量
 * @author lukai
 *
 */
public class GlobalVal {
	private static Logger log = LoggerFactory.getLogger(GlobalVal.class);
	public static  ApplicationContext ctx;
	
	public static final String USER_SESSION = "userSession";
	public static final String ALL_DEFAULT_VAL = "0";
	public static final String ADMIN_NAME = PlatformGlobalVar.SYS_PROPERTIES.get("adminName");//访问sys.properties属性
	public static final String ADMIN_PASS_WD = PlatformGlobalVar.SYS_PROPERTIES.get("adminPassWd");
	public static final String SUCCESS="success";
	public static final String ERROR="error";
	/**
	 * 非法操作
	 */
	public static final String ILLEGALOPTION="ILLEGALOPTION";
	
	/**
	 * 成功
	 */
	public static final String SUCCESS_000000="000000";
	/**
	 * 委托时的返回类型返回类型，委托系统忙时报出的错误
	 */
	public static final String DEPUTE_000001="000001";
	public static final String DEPUTE_000002="000002";
	public static final String DEPUTE_000003="000003";
	public static final String DEPUTE_000004="000004";
	public static final String DEPUTE_000005="000005";
	public static final String DEPUTE_000006="000006";
	
	/**
	 * 回收数量0或者空
	 */
	public static final String RECOVERY_000020="000020";
	/**
	 * 回收数量大于帐户中当前值
	 */
	public static final String RECOVERY_000021="000021";
	
	/**
	 * 帐户变更历史记录中的变更类型。1：充值，2：交易买入GSC，3：交易卖出GSC，4：委托买入，5：委托卖出，6：提现，7:赠送,分发，8：从系统买入，9：申购 10:回收，11：造币
	 */
	/**
	 * 充值
	 */
	public static final String ACCESSCHANGETYPE_RECHARGE = "1";
	/**
	 * 交易买入GSC
	 */
	public static final String ACCESSCHANGETYPE_BUYGSC = "2";
	/**
	 * 交易卖出GSC
	 */
	public static final String ACCESSCHANGETYPE_SELLGSC = "3";
	/**
	 * 委托买入
	 */
	public static final String ACCESSCHANGETYPE_DEPUTEBUY = "4";
	/**
	 * 委托卖出
	 */
	public static final String ACCESSCHANGETYPE_DEPUTESELL = "5";
	/**
	 * 提现
	 */
	public static final String ACCESSCHANGETYPE_WITHDRAW = "6";
	/**
	 * 赠送,分发
	 */
	public static final String ACCESSCHANGETYPE_GIVE = "7";
	/**
	 * 从系统买入
	 */
	public static final String ACCESSCHANGETYPE_FROMSYSBUY = "8";
	/**
	 * 申购
	 */
	public static final String ACCESSCHANGETYPE_SUBSCRIPTIONS = "9";
	/**
	* 申购付全款
	*/
	public static final String ACCESSCHANGETYPE_SUBAll = "13";
	/**
	 * 回收
	 */
	public static final String ACCESSCHANGETYPE_RECOVERY = "10";
	/**
	 * 11:造币
	 */
	public static final String ACCESSCHANGETYPE_CREATEGSC= "11";
	/**
	 * 取消委托
	 */
	public static final String ACCESSCHANGETYPE_CANCELDEPUTE = "12";
//	1，用户充值（造成RMB变动），6，用户提现（造成RMB变动）7，分发赠送 9，申购（用户持有总量变动）0，系统造币11,造币（造成GSC变动）
	/**
	 * 系统gsc历史记录   造币11
	 */
	public static final String GSCMANAGER_CREATEGSC = "11";
	/**
	 * 系统gsc历史记录 充值，与帐户变更历史记录中保持一致
	 */
	public static final String GSCMANAGER_RECHARGE = "1";
	/**
	 * 用户提现，与帐户变更历史记录中保持一致
	 */
	public static final String GSCMANAGER_WITHDRAWE = "6";
	/**
	 * 分发赠送，与帐户变更历史记录中保持一致
	 */
	public static final String GSCMANAGER_GIVE  = "7";
	/**
	 * 申购，与帐户变更历史记录中保持一致
	 */
	public static final String GSCMANAGER_SUBSCRIPTIONS  = "9";
	/**
	 * 系统造币，0初始化记录
	 */
	public static final String GSCMANAGER_SYS_CREATEGSC  = "0";
	/**
	 * 回收，与帐户变更历史记录中保持一致
	 */
	public static final String GSCMANAGER_RECOVERY  = "10";
	
	/**
	 * 请填写充值金额
	 */
	public static final String ACCOUNTMANAGEMENT_000100="000100";
	/**
	 * 充值成功
	 */
	public static final String ACCOUNTMANAGEMENT_000101="000101";
	/**
	 * 充值失败
	 */
	public static final String ACCOUNTMANAGEMEN_000102="000102";
	/**
	 * 没有查询到该用户信息信息
	 */
	public static final String ACCOUNTMANAGEMEN_000103="000103";
	/**
	 * 请填写银行编号
	 */
	public static final String ACCOUNTMANAGEMEN_000104="000104";
	/**
	 * 电话或E_mail必须填写一个
	 */
	public static final String REGSISTER_000105="000105";
	/**
	 * 请检查您的用户信息
	 */
	public static final String REGSISTER_000106="000106";
	/**
	 * 请填写用户名
	 */
	public static final String REGSISTER_000107="000107";
	/**
	 * 请填写密码
	 */
	public static final String REGSISTER_000108="000108";
	/**
	 * 请填写真实姓名
	 */
	public static final String REGSISTER_000109="000109";
	/**
	 * 请填写支付密码
	 */
	public static final String REGSISTER_000110="000110";
	/**
	 * 请填写身份证
	 */
	public static final String REGSISTER_000111="000111";
	/**
	 * 用户名重复
	 */
	public static final String REGSISTER_000112="000112";
	/**
	 * 注册失败
	 */
	public static final String REGSISTER_000113="000113";
	/**
	 *	注册成功 
	 */
	public static final String REGSISTER_000114="000114";
	/**
	 *	两次登陆密码不一致 
	 */
	public static final String REGSISTER_000115="000115";
	/**
	 *	两次支付密码不一致 
	 */
	public static final String REGSISTER_000116="000116";
	/**
	 *	密码修改成功 
	 */
	public static final String USERCENTER_000117="000117";
	/**
	 *	密码修改失败 
	 */
	public static final String USERCENTER_000118="000118";
	/**
	 *	旧密码错误 
	 */
	public static final String USERCENTER_000125="000125";
	/**
	 *	请填写提现金额 
	 */
	public static final String WITHDRAWAL_000119="000119";
	/**
	 *	请选择银行 
	 */
	public static final String WITHDRAWAL_000120="000120";
	/**
	 *	请填写银行卡号 
	 */
	public static final String WITHDRAWAL_000121="000121";
	/**
	 *	提现失败 
	 */
	public static final String WITHDRAWAL_000122="000122";
	/**
	 *	提现成功 
	 */
	public static final String WITHDRAWAL_000123="000123";
	/**
	 *	账户余额不足 
	 */
	public static final String WITHDRAWAL_000124="000124";
	/**
	 * 时常常量
	 */
	public static final long ISSUEUSERCREATECOINLIMITTIME = 1000;
	/**
	 * 小数位数
	 */
	public static final long ISSUEUSERCREATECOINLIMIT_LONG = 1000000;
	/**
	 * 小数位数
	 */
	public static final Double ISSUEUSERCREATECOINLIMIT_DOUBLE = 1000000.0;
	/**
	 * 造币记录状态位
	 */
	public static final String ISSUEUSERCREATECOINSTATUS1 = "1";
	public static final String ISSUEUSERCREATECOINSTATUS2 = "2";
	public static final String ISSUEUSERCREATECOINSTATUS3 = "3";
	/**
	 * 超出日造币量上限
	 */
	public static final String DAILY_OUTPUT = "000301";
	/**
	 * 超出年造币量上限
	 */
	public static final String THE_ANNUAL_OUTPUT = "000302";
	/**
	 * 委托历史状态0：开始委托，
	 */
	public static final String DEPUTEHISSTATUSDEPUTE = "0";
	/**
	 * 1：委托交易
	 */
	public static final String DEPUTEHISSTATUSTRADER = "1";
	/**
	 * 2：取消委托，
	 */
	public static final String DEPUTEHISSTATUSCANCEL = "2";
	/**
	 * 3,：委托完成
	 */
	public static final String DEPUTEHISSTATUSEND = "3";
	/**
	 * 委托类型 1：买入
	 */
	public static final String DEPUTEBUY = "1";
	/**
	 * 委托类型 2：卖出
	 */
	public static final String DEPUTESELL = "2";
	/**
	 * 1：已经付定金
	 */
	public static final String SUBSCRIPTION_STATUS_DEPOSIT = "1";
	/**
	 * 2：已经付全款
	 */
	public static final String SUBSCRIPTION_STATUS_EXCEPTIONALLY = "2";
	/**
	 * 3：已经支付GSC
	 */
	public static final String SUBSCRIPTION_STATUS_PAYMENTGSC = "3";
	
	/**
	 *申购管理状态：status字段为0，发布为1，封存为2
	 */
	/**
	 * 0:申购管理新增
	 */
	public static final String SUBSCRIPTION_STATUS_MNAGER_XZ = "0";
	/**
	 * 1:申购管理发布
	 */
	public static final String SUBSCRIPTION_STATUS_MNAGER_FB = "1";
	/**
	 * 2:封存
	 */
	public static final String SUBSCRIPTION_STATUS_MNAGER_FC = "2";
	/**
	 * 最高级菜单的定义
	 */
	public final static String UNIT_LEVEL = "1";
	public final static String P_DEPT_ID = "0";
	/**
	 * 低于最小申购量
	 */
	public final static String SGMIN = "000200";
	/**
	 * 高于最大申购量
	 */
	public final static String SGMAX = "000201";
	/**
	 * 余额不足
	 */
	public final static String NOT_ENOUGH = "000202";
	/**
	 * 申购已经结束
	 */
	public final static String SG_REDARYEND = "000203";
	/**
	 * 申购：未到开始时间
	 */
	public final static String SG_NOT_STARTTIME = "000204";
	
	public final static String SG_RELEASE_IS_ENOUGH = "000205";
	/**
	 * 当前沒有发布
	 */
	public final static String SG_NO_NUMBER = "000206";
	
	/**
	 * 重系统买入的状:1：未发布
	 */
	public static final String SYS_SELL_STATUS_UNRELEASE = "1";
	/**
	 * 2：已经发布
	 */
	public static final String SYS_SELL_STATUS_RELEASE = "2";
	/**
	 * 3：正常结束
	 */
	public static final String SYS_SELL_STATUS_END = "3";
	/**
	 * 4：人为停止
	 */
	public static final String SYS_SELL_STATUS_STOP = "4";
	
	/**
	 * 充值或提现 1：充值 
	 */
	public static final String RECHARGE_TYPE_RECHARGE ="1";
	/**
	 * 充值或提现 2：提现
	 */
	public static final String RECHARGE_TYPE_WITHDRAWALS ="2";
	
	/**
	 * 错误提示：
	 */
	public static final String SYS_BUSY = "系统忙...请稍候重试";
	public static final String SYS_TO_NOT_SELL = "系统中没有正在卖出的记录";
	public static final String SYS_TO_SELL_NOT_ENOUGH = "系统中可出售金佳币不足";
	public static final String SYS_TO_SELL_NUM_ERR = "卖出数量填写错误";
	public static final String SYS_VERSIONNUM_ERR = "系统忙或数据不是最新数据";
	public static final String SYS_SUCCESS = "操作成功";
	public static final String ACCESS_BALANCE = "帐户余额不足";
	public static final String NOT_INIT_GSC = "没有初始化GSC总量";
	
	
    public static void init()
    {
          
       // System.out.println(ADMIN_NAME);
        
    }
	
}
