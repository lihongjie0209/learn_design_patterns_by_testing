package cn.lihongjie.creation.builder;

/**
 * @author 982264618@qq.com
 */
public class POJO {

	private int age;
	private String name;
	private int id;


	private POJO(int age, String name, int id) {
		this.age = age;
		this.name = name;
		this.id = id;
	}


	public static final class POJOBuilder {
		private int age;
		private String name;
		private int id;

		private POJOBuilder() {
		}

		public static POJOBuilder newBuilder() {
			return new POJOBuilder();
		}

		public POJOBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public POJOBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public POJOBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public POJO build() {
			return new POJO(age, name, id);
		}
	}
}
