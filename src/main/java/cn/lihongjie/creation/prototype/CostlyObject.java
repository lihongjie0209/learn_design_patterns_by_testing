package cn.lihongjie.creation.prototype;

import org.slf4j.Logger;

import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author 982264618@qq.com
 */
public class CostlyObject implements Cloneable{


	static Logger logger = getLogger(CostlyObject.class);
	private String s = "";

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public CostlyObject() {
		logger.info("this is costly operation, read from disk or internet resource");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.s = UUID.randomUUID().toString();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
