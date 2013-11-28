/*
 * File:City.java Type:eastone.game.world.place.City
 */
package eastone.game.world.place;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年11月28日 下午1:45:39
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public interface City {

  /**
   * .
   * @return 类型.
   */
  CityType getCityType();

  /**
   * .
   * @param type 类型.
   */
  void setCityType(CityType type);

}
