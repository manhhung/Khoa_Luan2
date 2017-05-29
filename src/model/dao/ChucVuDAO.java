package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ChucVu;
import model.bo.ChucVuBO;

public class ChucVuDAO {
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

	public ArrayList<ChucVu> getListChucVu() {
		connect();
		String sql = "SELECT MaChucVu, TenChucVu FROM CHUCVU";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<ChucVu> list = new ArrayList<ChucVu>();
		ChucVu chucVu;
		try {
			while(rs.next()){
				chucVu = new ChucVu();
				chucVu.setMaChucVu(rs.getString("MaChucVu"));
				chucVu.setTenChucVu(rs.getString("TenChucVu"));
				list.add(chucVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
