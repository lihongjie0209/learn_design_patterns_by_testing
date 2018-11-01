package cn.lihongjie.creation.builder;

/**
 * @author 982264618@qq.com
 */
public class StringBuilderDemo {


	public static void main(String[] args) {


		StringBuilder builder = new StringBuilder();

		builder.append("h");
		builder.append("h");
		builder.append("h");
		builder.append("h");
		builder.append("h");
		String s = builder.toString();

		System.out.println(s);

	}
}
