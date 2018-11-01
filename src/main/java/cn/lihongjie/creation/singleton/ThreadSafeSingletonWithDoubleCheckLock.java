package cn.lihongjie.creation.singleton;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class ThreadSafeSingletonWithDoubleCheckLock {

	static Logger logger = getLogger(LazySingleton.class);


	// 确保可见性和有序性
	 volatile static ThreadSafeSingletonWithDoubleCheckLock singleton = null;

	// 无法被实例化
	private ThreadSafeSingletonWithDoubleCheckLock() {
	}

	// 锁优化, 减小锁范围
	public static ThreadSafeSingletonWithDoubleCheckLock get() {

		if (singleton == null) { // 共享变量读取  这个操作并没有同步, 导致的问题就是其他线程的写入不会对当前线程可见

			synchronized (ThreadSafeSingletonWithDoubleCheckLock.class) {
				if (singleton == null) {  // 共享变量读取

					singleton = new ThreadSafeSingletonWithDoubleCheckLock(); // 共享变量写入
				}

			}

		}
		return singleton;


	}


}
