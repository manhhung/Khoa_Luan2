package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.crypto.provider.AESParameters;

import model.bean.LoaiHang;

public class LoaiHangDAO {
	
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
		
		public ArrayList<LoaiHang> getListLoaiHang(){
			connect();
			String sql = "Select MaLoaiHang, TenLoaiHang, MoTa from LOAIHANG";
			ResultSet rs = null;
			try{
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e){
				e.printStackTrace();
			}
			
			ArrayList<LoaiHang> list = new ArrayList<LoaiHang>();
			LoaiHang loaiHang;
			try{
				while(rs.next()){
					loaiHang = new LoaiHang();
					loaiHang.setMaLoaiHang(rs.getString("MaLoaiHang"));
					loaiHang.setTenLoaiHang(rs.getString("TenLoaiHang"));
					loaiHang.setMoTa(rs.getString("MoTa"));
					list.add(loaiHang);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
			
			return list;
	}

		public void themLoaiHang(String maLoaiHang, String tenLoaiHang, String moTa){
			connect();
			String sql = String.format(" INSERT INTO LOAIHANG(TenLoaiHang, MoTa) "+
										" VALUES (N'%s', N'%s')", tenLoaiHang, moTa);
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void capNhatLoaiHang(String maLoaiHang, String tenLoaiHang, String moTa) {
			connect();
			String sql = String.format("UPDATE LOAIHANG "+
										" SET TenLoaiHang = N'%s', MoTa = N'%s'" +
										" WHERE MaLoaiHang = '%s'", tenLoaiHang, moTa, maLoaiHang);
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public LoaiHang getThongTinLoaiHang(String maLoaiHang) {
			connect();
			String sql = String.format("SELECT MaLoaiHang, TenLoaiHang, MoTa "+
									" FROM LOAIHANG where MaLoaiHang = '%s'", maLoaiHang);
			ResultSet rs = null;
			try {
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			LoaiHang loaiHang = new LoaiHang();
			try{
				while(rs.next()){
					loaiHang.setMaLoaiHang(maLoaiHang);
					loaiHang.setTenLoaiHang(rs.getString("TenLoaiHang"));
					loaiHang.setMoTa(rs.getString("MoTa"));
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			return loaiHang;
		}
		
		public void xoaLoaiHang(String maLoaiHang){
			connect();
			String sql = String.format("DELETE FROM LOAIHANG WHERE MaLoaiHang = '%s'", maLoaiHang);
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


}
