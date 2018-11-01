package cn.lihongjie.creation.factory;

/**
 * @author 982264618@qq.com
 */
public abstract class AbsServiceFactory {





	// 类似模版方法
	public Service get() {

		// 有扩展空间
		return getService();

	}


	// 子类实现
	abstract Service getService();




}
