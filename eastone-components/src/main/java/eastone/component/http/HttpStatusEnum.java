/*
 * File:HttpStatusEnum_DOT_java
 * Type:eastone_DOT_component_DOT_http_DOT_HttpStatusEnum
 */
package eastone.component.http;

/**
 * HTTP返回状态代码.
 * <p>参考IIS返回代码.</p>
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft_DOT_com,2013-10-21 上午8:56:51</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 15:55</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft_DOT_com>
 * @version 0.1.1
 * @since 0.1
 */
public enum HttpStatusEnum {


	/**
	 * 1xx,这些状态代码表示临时的响应.客户端在收到常规响应之前，应准备接收一个或多个 1xx 响应.
	 */
	HTTP_1XX(1),

	/**
	 * Continue 初始的请求已经接受，客户应当继续发送请求的其余部分.
	 * （HTTP 1_DOT_1新）
	 */
	HTTP_100(100),
	/**
	 * Switching Protocols 服务器将遵从客户的请求转换到另外一种协议.
	 * （HTTP 1_DOT_1新）
	 */
	HTTP_101(101),

	/**
	 * 成功_DOT_
	 * <p>这类状态代码表明服务器成功地接受了客户端请求.</p>
	 */
	HTTP_2XX(2),

	/**
	 * OK.
	 * <p> 一切正常，对GET和POST请求的应答文档跟在后面.</p>
	 */
	HTTP_200(200),
	/**
	 * Created.
	 * <p> 服务器已经创建了文档，Location头给出了它的URL.</p>
	 */
	HTTP_201(201),
	/**
	 * Accepted.
	 * <p> 已经接受请求，但处理尚未完成.</p>
	 */
	HTTP_202(202),
	/**
	 * Non-Authoritative Information.
	 * <p> 文档已经正常地返回，但一些应答头可能不正确，因为使用的是文档的拷贝，非权威性信息（HTTP 1_DOT_1新）.</p>
	 */
	HTTP_203(203),
	/**
	 * No Content.
	 * <p> 没有新文档，浏览器应该继续显示原来的文档.如果用户定期地刷新页面，而Servlet可以确定用户文档足够新，这个状态代码是很有用的.</p>
	 */
	HTTP_204(204),
	/**
	 * Reset Content.
	 * <p> 没有新的内容，但浏览器应该重置它所显示的内容.用来强制浏览器清除表单输入内容（HTTP 1_DOT_1新）.</p>
	 */
	HTTP_205(205),
	/**
	 * Partial Content.
	 * <p> 客户发送了一个带有Range头的GET请求（分块请求），服务器完成了它（HTTP 1_DOT_1新）.</p>
	 */
	HTTP_206(206),



	/**
	 *3xx,重定向.
	 *<p>客户端浏览器必须采取更多操作来实现请求.例如，浏览器可能不得不请求服务器上的不同的页面，或通过代理服务器重复该请求.</p>
	 */
	HTTP_3XX(3),
	/**
	 * Multiple Choices.
	 * <p> 客户请求的文档可以在多个位置找到，这些位置已经在返回的文档内列出.如果服务器要提出优先选择，则应该在Location应答头指明.</p>
	 */
	HTTP_300(300),
	/**
	 * Moved Permanently.
	 * <p>客户请求的文档在其他地方，新的URL在Location头中给出，浏览器应该自动地访问新的URL.</p>
	 */
	HTTP_301(301),
	/**
	 * Found.
	 * <p>类似于301，但新的URL应该被视为临时性的替代，而不是永久性的.注意，在
	 * HTTP1.0中对应的状态信息是“Moved Temporatily”.出现该状态代码时，浏览器能够自
	 * 动访问新的URL，因此它是一个很有用的状态代码.注意这个状态代码有时候可以和301
	 * 替换使用.例如，如果浏览器错误地请求 http:host/~user （缺少了后面的斜杠），
	 * 有的服务器返回301，有的则返回302.严格地说，我们只能假定只有当原来的请求是GET
	 * 时浏览器才会自动重定向.请参见307.
	 */
	HTTP_302(302),
	/**
	 * See Other.
	 * <p>类似于301/302，不同之处在于，如果原来的请求是POST，Location头指定
	 * 的重定向目标文档应该通过GET提取（HTTP 1_DOT_1新）.</p>
	 */
	HTTP_303(303),
	/**
	 * Not Modified.
	 * <p>客户端有缓冲的文档并发出了一个条件性的请求（一般是提供If-Modified-Since头
	 * 表示客户只想比指定日期更新的文档）.服务器告诉客户，原来缓冲的文档还可以继续
	 * 使用.</p>
	 */
	HTTP_304(304),

	/**
	 * Use Proxy.
	 * <p>客户请求的文档应该通过Location头所指明的代理服务器提取（HTTP 1_DOT_1新）.
	 * </p>
	 */
	HTTP_305(305),
	/**
	 * Temporary Redirect.
	 * <p>和302（Found）相同.许多浏览器会错误地响应302应答进行重定向，即使原来的请
	 * 求是POST，即使它实际上只能在POST请求的应答是303时 才能重定向.由于这个原因，
	 * HTTP 1.1新增了307，以便更加清除地区分几个状态代码：当出现303应答时，浏览器可
	 * 以跟随重定向的GET和POST请求；如果是307应答，则浏览器只 能跟随对GET请求的重定
	 * 向.（HTTP 1.1新）
	 */
	HTTP_307(307),

	/**
	 *4xx,客户端错误.
	 *<p>发生错误，客户端似乎有问题.例如，客户端请求不存在的页面，客户端未提供有效
	 *的身份验证信息.</p>
	 */
	HTTP_4XX(4),
	/**
	 * Bad Request.
	 * <p>请求出现语法错误.</p>
	 */
	HTTP_400(400),
	/**
	 * Unauthorized.
	 * <p>访问被拒绝，客户试图未经授权访问受密码保护的页面.应答中会包含一个
	 * WWW-Authenticate头，浏览器据此显示用户名字/密码对话框，然后在 填写合适的
	 * Authorization头后再次发出请求.
	 */
	HTTP_401(401),
	/**
	 * 登录失败.
	 */
	HTTP_401_DOT_1(401, 1),
	/**
	 * 服务器配置导致登录失败.
	 */
	HTTP_401_DOT_2(401, 2),
	/**
	 * 由于 ACL 对资源的限制而未获得授权.
	 */
	HTTP_401_DOT_3(401, 3),
	/**
	 * 筛选器授权失败.
	 */
	HTTP_401_DOT_4(401, 4),
	/**
	 * ISAPI/CGI 应用程序授权失败.
	 */
	HTTP_401_DOT_5(401, 5),
	/**
	 * 访问被 Web 服务器上的 URL 授权策略拒绝.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_401_DOT_7(401, 7),
	/**
	 * Forbidden 资源不可用.
	 * <p>服务器理解客户的请求，但拒绝处理它.通常由于服务器上文件或目录的权限设置导
	 * 致.</p>
	 */
	HTTP_403(403),

	/**
	 * 执行访问被禁止.
	 */
	HTTP_403_DOT_1(403, 1),
	/**
	 * 读访问被禁止.
	 */
	HTTP_403_DOT_2(403, 2),
	/**
	 * 写访问被禁止.
	 */
	HTTP_403_DOT_3(403, 3),
	/**
	 * 要求 SSL.
	 */
	HTTP_403_DOT_4(403, 4),
	/**
	 * 要求 SSL 128.
	 */
	HTTP_403_DOT_5(403, 5),
	/**
	 * IP 地址被拒绝.
	 */
	HTTP_403_DOT_6(403, 6),
	/**
	 * 要求客户端证书.
	 */
	HTTP_403_DOT_7(403, 7),
	/**
	 * 站点访问被拒绝.
	 */
	HTTP_403_DOT_8(403, 8),
	/**
	 * 用户数过多.
	 */
	HTTP_403_DOT_9(403, 9),
	/**
	 * 配置无效.
	 */
	HTTP_403_DOT_10(403, 10),
	/**
	 * 密码更改.
	 */
	HTTP_403_DOT_11(403, 11),
	/**
	 * 拒绝访问映射表.
	 */
	HTTP_403_DOT_12(403, 12),
	/**
	 * 客户端证书被吊销.
	 */
	HTTP_403_DOT_13(403, 13),
	/**
	 * 拒绝目录列表.
	 */
	HTTP_403_DOT_14(403, 14),
	/**
	 * 超出客户端访问许可.
	 */
	HTTP_403_DOT_15(403, 15),
	/**
	 * 客户端证书不受信任或无效.
	 */
	HTTP_403_DOT_16(403, 16),
	/**
	 * 客户端证书已过期或尚未生效.
	 */
	HTTP_403_DOT_17(403, 17),
	/**
	 * 在当前的应用程序池中不能执行所请求的 URL.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_403_DOT_18(403, 18),
	/**
	 * 不能为这个应用程序池中的客户端执行 CGI.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_403_DOT_19(403, 19),
	/**
	 * Passport 登录失败.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_403_DOT_20(403, 20),
	/**
	 * Not Found.
	 * <p>无法找到指定位置的资源.这也是一个常用的应答.</p>
	 */
	HTTP_404(404),
	/**
	 * 没有找到文件或目录.
	 */
	HTTP_404_DOT_0(404, 0),
	/**
	 * 无法在所请求的端口上访问 Web 站点.
	 */
	HTTP_404_DOT_1(404, 1),
	/**
	 * Web 服务扩展锁定策略阻止本请求.
	 */
	HTTP_404_DOT_2(404, 2),
	/**
	 * MIME 映射策略阻止本请求.
	 */
	HTTP_404_DOT_3(404, 3),
	/**
	 * Method Not Allowed.
	 * <p> 请求方法（GET、POST、HEAD、DELETE、PUT、TRACE等）对指定的资源不适用，用
	 * 来访问本页面的 HTTP 谓词不被允许(方法不被允许)(http1.1)</p>
	 */
	HTTP_405(405),
	/**
	 * Not Acceptable.
	 * <p>指定的资源已经找到，但它的MIME类型和客户在Accpet头中所指定的不兼容，客户端
	 * 浏览器不接受所请求页面的 MIME 类型（HTTP 1.1）.</p>
	 */
	HTTP_406(406),
	/**
	 * Proxy Authentication Required.
	 * <p>要求进行代理身份验证，类似于401，表示客户必须先经过代理服务器的授权.
	 * （HTTP 1.1新）</p>
	 */
	HTTP_407(407),
	/**
	 * Request Timeout.
	 * <p>在服务器许可的等待时间内，客户一直没有发出任何请求.客户可以在以后重复同一
	 * 请求.（HTTP 1.1新）</p>
	 */
	HTTP_408(408),
	/**
	 * Conflict.
	 * <p>通常和PUT请求有关.由于请求和资源的当前状态相冲突，因此请求不能成功.（HTTP
	 * 1.1新）</p>
	 */
	HTTP_409(409),
	/**
	 * Gone.
	 * <p>所请求的文档已经不再可用，而且服务器不知道应该重定向到哪一个地址.它和404的
	 * 不同在于，返回407表示文档永久地离开了指定的位置，而404表示由于未知的原因文档
	 * 不可用.（HTTP 1.1新）</p>
	 */
	HTTP_410(410),
	/**
	 * Length Required.
	 * <p>服务器不能处理请求，除非客户发送一个Content-Length头.（HTTP 1.1新）
	 * </P>
	 */
	HTTP_411(411),
	/**
	 * Precondition Failed.
	 * <p>请求头中指定的一些前提条件失败(HTTP 1.1新).</p>
	 */
	HTTP_412(412),
	/**
	 * Request Entity Too Large.
	 * <p>目标文档的大小超过服务器当前愿意处理的大小.如果服务器认为自己能够稍后再处
	 * 理该请求，则应该提供一个Retry-After头（HTTP 1.1新）.</p>
	 */
	HTTP_413(413),
	/**
	 * Request URI Too Long URI太长（HTTP 1.1新）.
	 */
	HTTP_414(414),
	/**
	 * 不支持的媒体类型.
	 */
	HTTP_415(415),
	/**
	 * Requested Range Not Satisfiable.
	 * <p>服务器不能满足客户在请求中指定的Range头.（HTTP 1.1新）</p>
	 */
	HTTP_416(416),

	/**
	 * 执行失败.
	 */
	HTTP_417(417),


	/**
	 * 锁定的错误.
	 */
	HTTP_423(423),

	/**
	 *5xx,服务器错误.
	 *<p>服务器由于遇到错误而不能完成该请求.</p>
	 */
	HTTP_5XX(5),
	/**
	 * Internal Server Error.
	 * <p>服务器遇到了意料不到的情况，不能完成客户的请求.</p>
	 */
	HTTP_500(500),
	/**
	 * 应用程序正忙于在 Web 服务器上重新启动.
	 */
	HTTP_500_DOT_12(500, 12),
	/**
	 * Web 服务器太忙.
	 */
	HTTP_500_DOT_13(500, 13),
	/**
	 * 不允许直接请求 Global.asa.
	 */
	HTTP_500_DOT_15(500, 15),
	/**
	 * UNC 授权凭据不正确.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_500_DOT_16(500, 16),
	/**
	 * URL 授权存储不能打开.这个错误代码为 IIS 6.0 所专用.
	 */
	HTTP_500_DOT_18(500, 18),
	/**
	 * 内部 ASP 错误.
	 */
	HTTP_500_DOT_100(500, 100),
	/**
	 * Not Implemented.
	 * <p>服务器不支持实现请求所需要的功能，页眉值指定了未实现的配置.
	 * 例如，客户发出了一个服务器不支持的PUT请求.</p>
	 */
	HTTP_501(501),
	/**
	 * Bad Gateway.
	 * <p>服务器作为网关或者代理时，为了完成请求访问下一个服务器，但该服务器返回了非
	 * 法的应答. 亦说Web 服务器用作网关或代理服务器时收到了无效响应</p>
	 */
	HTTP_502(502),
	/**
	 * CGI 应用程序超时.
	 */
	HTTP_502_DOT_1(401, 1),
	/**
	 * CGI 应用程序出错.
	 */
	HTTP_502_DOT_2(401, 1),
	/**
	 * Service Unavailable.
	 * <p>服务不可用，服务器由于维护或者负载过重未能应答.例如，Servlet可能在数据库连
	 * 接池已满的情况下返回503.服务器返回503时可以提供一个Retry-After头.这个错误代
	 * 码为 IIS 6.0 所专用.
	 */
	HTTP_503(503),
	/**
	 * Gateway Timeout 网关超时.
	 * <p>由作为代理或网关的服务器使用，表示不能及时地从远程服务器获得应答.（HTTP
	 * 1.1新） .</p>
	 */
	HTTP_504(504),
	/**
	 * HTTP Version Not Supported.
	 * <p>服务器不支持请求中所指明的HTTP版本.（HTTP 1.1新）</p>
	 */
	HTTP_505(505);

	/**
	 * httpCode默认值.
	 */
	private static final int DEFAULT_HTTP_CODE_VALUE = 100;

	/**
	 * 状态码.
	 */
	private int httpCode = DEFAULT_HTTP_CODE_VALUE;

	/**
	 * 详细码.
	 */
	private int detail = -1;

	/**
	 * 状态码.
	 * @param httpCode 状态码
	 */
	HttpStatusEnum(int httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * 状态码和详细码的构造函数.
	 * @param httpCode 状态码
	 * @param detail 详细码
	 */
	HttpStatusEnum(int httpCode, int detail) {
		this.httpCode = httpCode;
		this.detail = detail;
	}

	/**
	 * 获得状态码.
	 * @return 状态码
	 */
	public int getHttpCode() {
		return httpCode;
	}

	/**
	 * 获得详细码.
	 * @return 详细码
	 */
	public int getDetail() {
		return detail;
	}
}
