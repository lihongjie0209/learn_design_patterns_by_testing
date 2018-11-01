package cn.lihongjie.creation.singleton;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class LazySingletonTest {

	Logger logger = getLogger(LazySingletonTest.class);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void get() throws Exception {

		Assert.assertThat(LazySingleton.get(), Is.is(LazySingleton.get()));

	}

	@Test(expected = AssertionError.class)
	public void testThreadSafety() throws Exception {


		int nThreads = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

		ArrayList<Callable<Object>> tasks = new ArrayList<>();
		ConcurrentLinkedQueue<LazySingleton> lazySingletons = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < 10; i++) {

			tasks.add(() -> {
				LazySingleton e = LazySingleton.get();
				lazySingletons.add(e);

				logger.info("get singleton: " + e.toString());
				return null;
			});

		}

		while (true) {

			executorService.invokeAll(tasks);

			assertTrue(lazySingletons.stream().distinct().count() == 1);

			lazySingletons.clear();


		}


	}
}