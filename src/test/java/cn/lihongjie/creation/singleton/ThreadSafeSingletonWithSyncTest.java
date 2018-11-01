package cn.lihongjie.creation.singleton;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class ThreadSafeSingletonWithSyncTest {

	static Logger logger = getLogger(ThreadSafeSingletonWithSyncTest.class);
	@Test
	public void get() throws Exception {
	}



	private static void logInfo(Description description, String status, long nanos) {
		String testName = description.getMethodName();
		logger.info(format("Test %s %s, spent %d microseconds",
				testName, status, NANOSECONDS.toMicros(nanos)));
	}

	@Rule
	public Stopwatch stopwatch = new Stopwatch() {
		@Override
		protected void succeeded(long nanos, Description description) {
			logInfo(description, "succeeded", nanos);
		}

		@Override
		protected void failed(long nanos, Throwable e, Description description) {
			logInfo(description, "failed", nanos);
		}


		@Override
		protected void finished(long nanos, Description description) {
			//			logInfo(description, "finished", nanos);
		}
	};

	/**
	 * 基于监视器的单例肯定是安全的, 就是性能有问题
	 *
	 * 10 个线程跑 10次, 也就是100次获取单例 耗时 89271 microseconds
	 * @throws Exception
	 */
	@Test
	public void testThreadSafety() throws Exception {


		int nThreads = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

		int count = 10;

		ArrayList<Callable<Object>> tasks = new ArrayList<>();
		ConcurrentLinkedQueue<ThreadSafeSingletonWithSync> lazySingletons = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < 10; i++) {

			tasks.add(() -> {
				ThreadSafeSingletonWithSync e = ThreadSafeSingletonWithSync.get();
				lazySingletons.add(e);

				logger.info("get singleton: " + e.toString());
				return null;
			});

		}

		while (count != 0) {

			executorService.invokeAll(tasks);

			assertTrue(lazySingletons.stream().distinct().count() == 1);

			lazySingletons.clear();

			count--;

		}


	}


}