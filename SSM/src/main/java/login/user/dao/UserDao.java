package login.user.dao;

import login.user.domain.User;

/**
 * 0数据类
 * @author hp
 *
 */
public interface UserDao {
	//private String path ="E:/users.xml"; //依赖数据文件

	/**
	 * 1添加用户
	 */
	public void add(User user) ;
	
	/**
	 * 2按用户名查询
	 */
	public User findByUsername(String username) ;
	
	
}
