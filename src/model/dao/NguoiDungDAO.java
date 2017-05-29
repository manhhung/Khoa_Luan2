package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NguoiDungDAO {
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

	public String checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql=	String.format("SELECT MaNhanVien, Quyen FROM TAIKHOAN WHERE MaNhanVien = '%s' AND MatKhau = '%s'", tenDangNhap, matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String IDQuyen = null;
		
		try {
			if(rs.next()){
			IDQuyen = rs.getString("Quyen");
			//return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return false;
		return IDQuyen;
	}
	
	
}

