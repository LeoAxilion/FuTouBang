package login.user.dao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import login.user.domain.User;

/**
 * 0数据类
 * @author hp
 *
 */
public class UserDao {
	private String path ="E:/users.xml"; //依赖数据文件
	
	/**
	 * 1按用户名查询
	 */
	public User findByUsername(String username) {
		/*
		 * 1.得到Document
		 * 2.xpath查询
		 * 3.校验查询结果是否为null，为null，返回null
		 * 4.不为null，需要用Element封装到User对象中
		 */
		
		//创建解析器
		SAXReader reader = new SAXReader();
		try {
			//1.得到Document
			Document doc = reader.read(path);  
			
			//2.xpath查询
			Element ele = (Element)doc.selectSingleNode("//user[@username= '" + username + "']");
			
			//3.校验查询结果是否为null，为null，返回null
			if(ele == null) return null;
			
			//4.不为null，需要用Element封装到User对象中
			User user = new User();
			//获取该元素名为username的值
			String attrUsername = ele.attributeValue("username"); 
			//获取该元素名为password的值
			String attrPassword = ele.attributeValue("password");
			
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 2添加用户
	 */
	public void add(User user) {
		/*
		 * 1.得到Document
		 * 2.通过Docment得到root元素！<user>
		 * 3使用参数user，转发成Element对象
		 * 4把element添加到root元素中
		 * 5保存Docment
		 */
		
		//创建解析器
		SAXReader reader = new SAXReader();
		try {
			//1.得到Document
			Document doc = reader.read(path);  
					
			//2.通过Docment得到root元素！<user>
			Element root = doc.getRootElement();
			
			//3使用参数user，转发成Element对象
			Element userEle = root.addElement("user");
			
			//4把element添加到root元素中
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			
			/*
			 * 5保存Docment
			 */
			
			//创建输出格式化器
			OutputFormat format = new OutputFormat("\t",true);//缩进使用\t，是否换行，是
			format.setTrimText(true);//清除原有的换行和缩进		
			
			//创建XmlWriter
			XMLWriter writer;
			try {
				writer = new XMLWriter(
						new OutputStreamWriter(
								new FileOutputStream(path), "UTF-8"),format);
				writer.write(doc); //保存document
				writer.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 	
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
}
