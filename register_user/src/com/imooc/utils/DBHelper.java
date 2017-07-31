package com.imooc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库操作的公共类
 * @author Administrator
 *
 */
public class DBHelper {
	
	private static DBHelper dbHelper;
	
    private static String USERNAME ;  
  
    private static String PASSWORD;  
 
    private static String DRIVER;  
  
    private static String URL;  
		
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection connection;
	
	static{
		try {  
            InputStream inStream = DBHelper.class.getResourceAsStream("/jdbc.properties");  
            Properties prop = new Properties();  
            prop.load(inStream);  
            USERNAME = prop.getProperty("jdbc.username");  
            PASSWORD = prop.getProperty("jdbc.password");  
            DRIVER= prop.getProperty("jdbc.driver");  
            URL = prop.getProperty("jdbc.url");  
        } catch (Exception e) {  
            throw new RuntimeException("读取数据库配置文件异常！", e);  
        }  
	}

	/**
	 * 获取对象实例
	 * @return
	 */
	public static synchronized DBHelper getInstance(){
		if(dbHelper==null){
			dbHelper=new DBHelper();
		}
		return dbHelper;
	}
	
	/**
	 * 获取数据库链接
	 * @return Connection
	 */
	public Connection getConnect(){
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 查询数据库
	 * @param sql sql语句
	 * @param obj ？代替的参数(可变参数)
	 * @return
	 */
	public ResultSet query(String sql,Object...obj){
		try {
			preparedStatement = getConnect().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				preparedStatement.setString(i+1, obj[i].toString());
			}
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * 修改数据库(增，删，改)
	 * @param sql sql语句
	 * @param obj ？代替的参数(可变参数)
	 * @return
	 */
	public int update(String sql,Object...obj){
		
		int count=-1;
		try {
			connection = getConnect();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				preparedStatement.setString(i+1, obj[i].toString());
			}
			count=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			close();
		}
		return count;
	}
	
	
	/**
	 * 关闭资源
	 * @param conn Connection
	 * @param pre PreparedStatement
	 * @param rs ResultSet
	 */
	public void close(){
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		//System.out.println(getConnect());
		//查询
		String sql="select name,age from student";
		DBHelper helper = DBHelper.getInstance();
		
		ResultSet set = helper.query(sql);
		try {
			while(set.next()){
				String name = set.getString("name");
				int age = set.getInt("age");
				System.out.println(name+" ==== "+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			helper.close();
		}
		//插入
		/*String sql="insert into student(id,name,age,address,tel,description) values(?,?,?,?,?,?)";		
		int i=update(sql, 10003,"zhangqiang",24,"hunan","18770008210","my name is zhangqiang");
		System.out.println(i);*/
		//删除
		/*String sql="delete from student where id=?";
		int i=update(sql, 10003);
		System.out.println(i);*/
		//修改
		/*String sql="update student set name=? where id=?";
		int i=update(sql, "tom",10001);
		System.out.println(i);*/
		
	}
}
