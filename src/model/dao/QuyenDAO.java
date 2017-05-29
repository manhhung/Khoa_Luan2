package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Quyen;

public class QuyenDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBG";
	String userName = "sa";
	String password = "admin123";
	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}

	public ArrayList<Quyen> getListQuyen() {
		connect();
		String sql = "SELECT MaQuyen, TenQuyen FROM QUYEN";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Quyen> list = new ArrayList<Quyen>();
		Quyen quyen;
		try {
			while(rs.next()){
				quyen = new Quyen();
				quyen.setMaQuyen(rs.getInt("MaQuyen"));
				quyen.setTenQuyen(rs.getString("TenQuyen"));
				list.add(quyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
