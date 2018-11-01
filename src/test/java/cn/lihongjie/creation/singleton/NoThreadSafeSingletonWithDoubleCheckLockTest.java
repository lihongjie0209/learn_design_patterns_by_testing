package cn.lihongjie.creation.singleton;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class NoThreadSafeSingletonWithDoubleCheckLockTest {
	Logger logger = getLogger(NoThreadSafeSingletonWithDoubleCheckLockTest.class);

	@Test
	public void get() throws Exception {
	}


	@Test(expected = AssertionError.class)
	public void testThreadSafety() throws Exception {


		int nThreads = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

		ArrayList<Callable<Object>> tasks = new ArrayList<>();
		ConcurrentLinkedQueue<NoThreadSafeSingletonWithDoubleCheckLock> lazySingletons = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < 10; i++) {

			tasks.add(() -> {
				NoThreadSafeSingletonWithDoubleCheckLock e = NoThreadSafeSingletonWithDoubleCheckLock.get();
				lazySingletons.add(e);

				logger.info("get singleton: " + e.toString());
				return null;
			});

		}

		while (true) {

			executorService.invokeAll(tasks);

			assertTrue(lazySingletons.stream().distinct().count() == 1);

			lazySingletons.clear();
			// 重置方法区的应用
			NoThreadSafeSingletonWithDoubleCheckLock.singleton = null;


		}


	}

}