package cn.lihongjie.creation.builder;

import org.junit.Test;

/**
 * @author 982264618@qq.com
 */
public class POJOTest {

	@Test
	public void testBuilder() throws Exception {


		POJO.POJOBuilder builder = POJO.POJOBuilder.newBuilder();

		POJO pojo = builder.withId(1).withAge(18).withName("test").build();


	}
}