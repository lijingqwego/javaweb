package com.huiji.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USERNAME="huijistudy";
	public static final String PASSWORD="hjstudy";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ��ѯ����
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static ResultSet query(String sql,Object...obj){
		Connection conn = getConnection();
		ResultSet rs=null;
		try {
			//����PrepredStatement����
			PreparedStatement pre = conn.prepareStatement(sql);
			//���ݲ���
			for(int i=0;i<obj.length;i++){
				pre.setString(i+1, obj[i].toString());
			}
			rs = pre.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * ������ɾ�Ĳ���
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int update(String sql,Object...obj){
		Connection conn = getConnection();
		PreparedStatement pre=null;
		int row=-1;
		try {
			//����PrepredStatement����
			pre = conn.prepareStatement(sql);
			//���ݲ���
			for(int i=0;i<obj.length;i++){
				pre.setString(i+1, obj[i].toString());
			}
			row = pre.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pre.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	public static void main(String[] args) {
//		System.out.println(getConnection());
		ResultSet rs = DBHelper.query("select * from student where id=?", 22);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id);
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
