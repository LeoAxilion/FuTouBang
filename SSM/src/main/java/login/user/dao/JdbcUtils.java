package login.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

/**
 * v1.0
 * @author Administrator
 *
 */

public class JdbcUtils {
	
	private static Properties props = null;
	//加载文件时只执行一次
	static {
		//给prop进行初始化，加载配置文件dbconfig.properties文件到properties中
		try {
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		//加载驱动类
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		/*
		 * 1.加载配置文件
		 * 2.加载驱动类
		 * 3.调用DriverManagerGetConnection()
		 */
		
		//得到Connection
		return (Connection) DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"),
				props.getProperty("password")
				);
	}
}
