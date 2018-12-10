package login.user.dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static Properties props = null;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 0返回一个具体UserDao的实现类对象
	 * @return
	 */
	public static UserDao getUserDao() {
		/**
		 * 0给出一个配置文件，文件中给出UserDao接口的实现类名称！
		 * 1我们这个方法，或许实现类的类名，通过反射完成创建对象!
		 */
		/*
		 * 0得到实现类名称
		 */
		String daoClassName = props.getProperty("login.user.dao.UserDao");
		/*
		 * 1通过反射来创建实现类的对象
		 */
		try {
			Class<?> clazz = Class.forName(daoClassName);
			return (UserDao) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
}
