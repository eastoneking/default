/*
 * create:2014年9月28日 下午9:27:24
 * author:wangds  
 */
package eastone.precasting.composite;

import java.util.Collection;

import eastone.common.Component;
import eastone.common.composite.Composite;
import eastone.common.decorator.AbstractDecorator;

/**
 * 为组合模式提供一次添加多个组件的装饰工具.
 * <p>通过装饰模式为所有组合模式对象添加一次增加多个组件的功能。
 * </p>
 * <p>
 *  <ul>
 *      <li>init, 2014-09-28 @D51</li>
 *  </ul>
 * </p>
 * @author wangds
 *
 */
public class MultiOperateCompositeDecorator<C extends Component, I> extends AbstractDecorator<Composite<C, I>> {

    /**
     * 添加多个组件.
     * @author wangds 2014年9月28日 下午9:36:49.
     * @param c 组件集合.
     */
    public void addAll(Collection<C> c){
        Composite<C, I> comp = this.getComponent();
        for(C cur: c){
           comp.add(cur);
        }
    }
}
