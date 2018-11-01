package cn.lihongjie.creation.factory;

import org.slf4j.Logger;

import java.util.Calendar;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class FactoryInJava {


	private static Logger logger = getLogger(FactoryInJava.class);

	public static void main(String[] args) {


		// 实现类是 java.util.GregorianCalendar
		Calendar calendar = Calendar.getInstance();

		logger.info(calendar.toString());






	}
}
