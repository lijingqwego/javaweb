package com.imooc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ�����Ĺ�����
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
            throw new RuntimeException("��ȡ���ݿ������ļ��쳣��", e);  
        }  
	}

	/**
	 * ��ȡ����ʵ��
	 * @return
	 */
	public static synchronized DBHelper getInstance(){
		if(dbHelper==null){
			dbHelper=new DBHelper();
		}
		return dbHelper;
	}
	
	/**
	 * ��ȡ���ݿ�����
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
	 * ��ѯ���ݿ�
	 * @param sql sql���
	 * @param obj ������Ĳ���(�ɱ����)
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
	 * �޸����ݿ�(����ɾ����)
	 * @param sql sql���
	 * @param obj ������Ĳ���(�ɱ����)
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
			//�ر���Դ
			close();
		}
		return count;
	}
	
	
	/**
	 * �ر���Դ
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
		//��ѯ
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
		//����
		/*String sql="insert into student(id,name,age,address,tel,description) values(?,?,?,?,?,?)";		
		int i=update(sql, 10003,"zhangqiang",24,"hunan","18770008210","my name is zhangqiang");
		System.out.println(i);*/
		//ɾ��
		/*String sql="delete from student where id=?";
		int i=update(sql, 10003);
		System.out.println(i);*/
		//�޸�
		/*String sql="update student set name=? where id=?";
		int i=update(sql, "tom",10001);
		System.out.println(i);*/
		
	}
}
