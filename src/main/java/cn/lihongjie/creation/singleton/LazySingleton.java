package cn.lihongjie.creation.singleton;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class LazySingleton {

	static Logger logger = getLogger(LazySingleton.class);


	 static LazySingleton singleton = null;

	// 无法被实例化
	private LazySingleton() {
	}

	public static LazySingleton get() {

		// 懒加载, 但是线程不安全
		logger.info("start check null");
		if (singleton == null) {

			logger.info("is null, start init");

			singleton = new LazySingleton();

			logger.info("init complete");
		}
		return singleton;


	}
}
