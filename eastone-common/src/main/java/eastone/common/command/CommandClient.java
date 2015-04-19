/*
 * create:2015年4月17日 上午11:04:01
 * author:wangds  
 */
package eastone.common.command;

/**
 * 命令客户端.
 * <p>
 * 
 * </p>
 * @author wangds
 *
 */
//TODO Invoker解决.
public interface CommandClient {

    <C extends Command> C newCommand();

}
