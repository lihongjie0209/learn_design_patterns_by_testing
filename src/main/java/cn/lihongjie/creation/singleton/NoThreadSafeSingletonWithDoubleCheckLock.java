package cn.lihongjie.creation.singleton;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class NoThreadSafeSingletonWithDoubleCheckLock {

	static Logger logger = getLogger(LazySingleton.class);


	 static NoThreadSafeSingletonWithDoubleCheckLock singleton = null;

	// 无法被实例化
	private NoThreadSafeSingletonWithDoubleCheckLock() {
	}

	// 锁优化, 减小锁范围
	public static NoThreadSafeSingletonWithDoubleCheckLock get() {

		if (singleton == null) { // 共享变量读取  这个操作并没有同步, 导致的问题就是其他线程的写入不会对当前线程可见

			synchronized (NoThreadSafeSingletonWithDoubleCheckLock.class) {
				if (singleton == null) {  // 共享变量读取

					singleton = new NoThreadSafeSingletonWithDoubleCheckLock(); // 共享变量写入
				}

			}

		}
		return singleton;


	}


}
