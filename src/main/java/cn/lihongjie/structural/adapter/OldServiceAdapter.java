package cn.lihongjie.structural.adapter;

/**
 * @author 982264618@qq.com
 */
public class OldServiceAdapter implements Service {

	OldService oldService;
	@Override
	public void serve() {


		oldService.doServe();

	}
}
