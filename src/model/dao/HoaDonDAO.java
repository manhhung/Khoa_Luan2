package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HoaDon;

public class HoaDonDAO {
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
	 
	public ArrayList<HoaDon> getListHoaDon(){
		connect();
		String sql = "SELECT hd.MaHoaDon, nv.TenNhanVien, kh.TenKhachHang, hd.NgayLap" +
					" from HOADON hd, TAIKHOAN tk, KHACHHANG kh, THONGTINNHANVIEN nv"+
					" where hd.MaNhanVien = tk.MaNhanVien AND hd.MaKhachHang = kh.MaKhachHang and tk.MaNhanVien = nv.MaNhanVien";
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		HoaDon hoaDon;
		try{
			while(rs.next()){
				hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
				hoaDon.setTenNhanVien(rs.getString("TenNhanVien"));
				hoaDon.setTenKH(rs.getString("TenKhachHang"));
				hoaDon.setNgayLap(rs.getString("NgayLap"));
				list.add(hoaDon);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public void themHoaDon(String maHoaDon, String maNhanVien, String maKhachHang) {
		connect();
		String sql = String.format("insert into HOADON(MaHoaDon, MaNhanVien, MaKhachHang, NgayLap) "+
									" values ('%s', '%s', '%s', getdate())", maHoaDon, maNhanVien, maKhachHang);
		System.out.println("toi them hoadon dao");
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HoaDon> getListHoaDon(String maHoaDon){
		connect();
		String sql = String.format( "SELECT hd.MaHoaDon, nv.TenNhanVien, kh.TenKhachHang, hd.NgayLap" +
					" from HOADON hd, TAIKHOAN tk, KHACHHANG kh, THONGTINNHANVIEN nv"+
					" where hd.MaNhanVien = tk.MaNhanVien AND hd.MaKhachHang = kh.MaKhachHang and tk.MaNhanVien = nv.MaNhanVien and hd.MaHoaDon = '%s'", maHoaDon);
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		HoaDon hoaDon;
		try{
			while(rs.next()){
				hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
				hoaDon.setTenNhanVien(rs.getString("TenNhanVien"));
				hoaDon.setTenKH(rs.getString("TenKhachHang"));
				hoaDon.setNgayLap(rs.getString("NgayLap"));
				list.add(hoaDon);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	public HoaDon getThongTinHoaDon(String maHoaDon) {
		connect();
		String sql=	String.format("SELECT MaHoaDon, NgayLap, MaKhachHang, MaNhanVien"+
				" FROM HOADON WHERE MaHoaDon = '%s'", maHoaDon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HoaDon hoaDon = new HoaDon();
		try {
			while(rs.next()){
				hoaDon.setMaHoaDon(maHoaDon);
				hoaDon.setNgayLap(rs.getString("NgayLap"));
				hoaDon.setMaKH(rs.getString("MaKhachHang"));
				hoaDon.setMaNhanVien(rs.getString("MaNhanVien"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoaDon;
	}
	
	public boolean checkMaHoaDon(String maHoaDon) {
		connect();
		String sql = String.format("SELECT * from HOADON where MaHoaDon = '%s'", maHoaDon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void xoaHoaDon(String maHoaDon) {
		connect();
		String sql = String.format("DELETE FROM HOADON where MaHoaDon = '%s'", maHoaDon);
		String sql2 = String.format("DELETE FROM HOADONCHITIET where MaHoaDon = '%s'", maHoaDon);
		System.out.println(sql);
		System.out.println(sql2);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	
	
	}

