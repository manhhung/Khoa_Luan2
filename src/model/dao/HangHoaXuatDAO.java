package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HangHoaXuat;



public class HangHoaXuatDAO {
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
	
	public ArrayList<HangHoaXuat> getListHangHoaXuat() {
		connect();
		String sql=	"SELECT MaHoaDon, MaHangHoa, SoLuong, DonGia FROM HOADONCHITIET";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<HangHoaXuat> list = new ArrayList<HangHoaXuat>();
		HangHoaXuat hangHoaXuat;
		try {
			while(rs.next()){
				hangHoaXuat = new HangHoaXuat();
				hangHoaXuat.setMaHoaDon(rs.getString("MaHoaDon"));
				hangHoaXuat.setMaHangHoa(rs.getString("MaHangHoa"));
				hangHoaXuat.setSoLuong(rs.getInt("SoLuong"));
				hangHoaXuat.setDonGia(rs.getInt("DonGia"));
				list.add(hangHoaXuat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<HangHoaXuat> getListHangHoaXuat(String maHoaDon) {
		connect();
		String sql=	String.format("SELECT MaHoaDon, MaHangHoa, SoLuong, DonGia "+
				" FROM  HOADONCHITIET"+
				" WHERE MaHoaDon = '%s'", maHoaDon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<HangHoaXuat> list = new ArrayList<HangHoaXuat>();
		HangHoaXuat hangHoaXuat;
		try {
			while(rs.next()){
				hangHoaXuat = new HangHoaXuat();
				hangHoaXuat.setMaHoaDon(rs.getString("MaHoaDon"));
				hangHoaXuat.setMaHangHoa(rs.getString("MaHangHoa"));
				hangHoaXuat.setSoLuong(rs.getInt("SoLuong"));
				hangHoaXuat.setDonGia(rs.getInt("DonGia"));
				list.add(hangHoaXuat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public HangHoaXuat getThongTinHangHoaXuat(String maHoaDon) {
		connect();
		String sql=	String.format("SELECT MaHoaDon, MaHangHoa, SoLuong, DonGia"+
				" FROM HOADONCHITIET WHERE MaHoaDon = '%s'", maHoaDon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HangHoaXuat hangHoaXuat = new HangHoaXuat();
		try {
			while(rs.next()){
				hangHoaXuat.setMaHoaDon(maHoaDon);
				hangHoaXuat.setMaHangHoa(rs.getString("MaHangHoa"));
				hangHoaXuat.setSoLuong(rs.getInt("SoLuong"));
				hangHoaXuat.setDonGia(rs.getInt("DonGia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hangHoaXuat;
	}
	
	public void themHangHoaXuat(String maHoaDon, String maHangHoa, int soLuong, int donGia) {
		connect();
		String sql=	String.format("INSERT INTO HOADONCHITIET(MaHoaDon, MaHangHoa, SoLuong, DonGia) "+
				" VALUES ( '%s', N'%s','%s','%s')", maHoaDon, maHangHoa, soLuong, donGia);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void xoaHangHoaXuat(String maHoaDon){
		connect();
		String sql=	String.format("DELETE FROM HOADONCHITIET WHERE MaHoaDon = '%s'", maHoaDon);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
