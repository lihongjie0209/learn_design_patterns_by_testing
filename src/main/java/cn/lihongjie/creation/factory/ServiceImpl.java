package cn.lihongjie.creation.factory;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class ServiceImpl implements Service {
	private static Logger logger = getLogger(ServiceImpl.class);


	@Override
	public void serve() {

		logger.info(getClass().getSimpleName());
	}
}
