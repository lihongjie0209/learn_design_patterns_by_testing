package cn.lihongjie.creation.singleton;

/**
 * @author 982264618@qq.com
 */
public class StaticSingleton {

	// jvm负责初始化

	private static StaticSingleton singleton = new StaticSingleton();

	// 无法被实例化
	private StaticSingleton() {
	}

	public static StaticSingleton get() {
		return singleton;
	}
}
