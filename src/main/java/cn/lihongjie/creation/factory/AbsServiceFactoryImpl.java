package cn.lihongjie.creation.factory;

/**
 * @author 982264618@qq.com
 */
public class AbsServiceFactoryImpl extends AbsServiceFactory {
	@Override
	Service getService() {
		return new ServiceImpl();
	}

}
