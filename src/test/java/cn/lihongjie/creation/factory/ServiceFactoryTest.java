package cn.lihongjie.creation.factory;

import org.junit.Test;

/**
 * @author 982264618@qq.com
 */
public class ServiceFactoryTest {


	@Test
	public void testFactory() throws Exception {




		Service service1 = StaticServiceFactory.getService(1);
		service1.serve();
		Service service2 = StaticServiceFactory.getService(2);

		service2.serve();
	}
}