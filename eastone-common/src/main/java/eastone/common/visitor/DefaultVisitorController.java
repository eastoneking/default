/*
 * File:DefaultVisitorController.java
 * Type:eastone.common.visitor.DefaultVisitorController
 */
package eastone.common.visitor;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import eastone.common.GeneralParentObject;

/**
 * {@link VisitorController}的默认实现.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午3:03:47</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public class DefaultVisitorController extends GeneralParentObject implements
		VisitorController {

	/**
	 * 访问者注册图.
	 */
	@SuppressWarnings("rawtypes")
	private final Map<Class, List<Visitor>> registedVisitorMap
		= new LinkedHashMap<Class, List<Visitor>>(0);

	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Visitable, V extends Visitor<E>> void registorVisitor(
			Class<E> type, V visitor) {

		List<Visitor> list = this.registedVisitorMap.get(type);
		if (list == null) {
			list = new LinkedList<Visitor>();
			this.registedVisitorMap.put(type, list);
		}

		list.add(visitor);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Visitable, V extends Visitor<E>> void disregister(
			Class<E> type, V visitor) {
		List<Visitor> list = this.registedVisitorMap.get(type);
		if (list == null) {
			list = new LinkedList<Visitor>();
			this.registedVisitorMap.put(type, list);
		}

		list.remove(visitor);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Visitable> void clear(Class<E> type) {
		List<Visitor> list = this.registedVisitorMap.get(type);
		if (list == null) {
			list = new LinkedList<Visitor>();
			this.registedVisitorMap.put(type, list);
		}

		list.clear();
	}

	@Override
	public void clear() {
		this.registedVisitorMap.clear();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <E extends Visitable, V extends Visitor<E>> List<V> findVisitors(
			Class<E> type) {
		List<Visitor> list = this.registedVisitorMap.get(type);
		if (list == null) {
			list = new LinkedList<Visitor>();
			this.registedVisitorMap.put(type, list);
		}
		return (List<V>) list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends Visitable> void visit(E visitable) {
		if (visitable == null) {
			return;
		}

		List<Visitor<E>> visitors
			= (List<Visitor<E>>) this.<E, Visitor<E>> findVisitors(
				(Class<E>) visitable.getClass()
			);

		for (Visitor<E> visitor : visitors) {
			visitable.accept(visitor);
		}

	}

}
