package cn.lihongjie.creation.factory;

/**
 * @author 982264618@qq.com
 */
public class StaticServiceFactory {


	public static Service getService(int version) {

		switch (version) {
			case 1:
				return new ServiceImpl();
			case 2:
				return new ServiceImpl2();
			default:
				throw new IllegalStateException("未知的版本号");
		}


	}


}
