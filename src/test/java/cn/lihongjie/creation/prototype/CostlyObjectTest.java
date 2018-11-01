package cn.lihongjie.creation.prototype;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;

import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class CostlyObjectTest {
	private static Logger logger = getLogger(CostlyObjectTest.class);
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


	@Test
	public void testCostlyNew() throws Exception {

		CostlyObject object = new CostlyObject();
		CostlyObject object2 = new CostlyObject();

	}

	@Test
	public void testCostlyNewWithClone() throws Exception {

		CostlyObject object = new CostlyObject();
		CostlyObject object2 = (CostlyObject) object.clone();


	}
}