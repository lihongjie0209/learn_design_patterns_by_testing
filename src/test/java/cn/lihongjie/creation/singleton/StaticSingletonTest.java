package cn.lihongjie.creation.singleton;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 982264618@qq.com
 */
public class StaticSingletonTest {
	@org.junit.Before
	public void setUp() throws Exception {
	}

	@org.junit.After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void get() throws Exception {


		StaticSingleton s1 = StaticSingleton.get();
		StaticSingleton s2 = StaticSingleton.get();

		Assert.assertThat(s1, Is.is(s2));
	}


	@Test
	public void testThreadSafety() throws Exception {

		// 静态属性是由jvm负责初始化的, 没必要测试



	}
}