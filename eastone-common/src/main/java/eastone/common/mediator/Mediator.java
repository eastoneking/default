/*
 * File:Mediator.java Type:eastone.common.mediator.Mediator
 */
package eastone.common.mediator;


/**
 * 中介者模式.
 * <p>
 * 与{@linkplain Colleague}的关系需要通过实现类的编码明确.
 * <h1>修改列表:</h1>a
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 11:32:04</li>
 * <li>接口完全变更，原来参考的版本不是GoF97的描述，限制过多，2015-04－25 22:35</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.2
 * @since 0.1
 */
public interface Mediator{
    void registor(Colleague colleague);
    void unregistor(Colleague colleague);
}
