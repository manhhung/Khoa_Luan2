package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;

import model.bean.KhachHang;

public class KhachHangDAO {
	
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

public ArrayList<KhachHang> getListKH() {
		
		connect();
		String sql = "SELECT MaKhachHang,TenKhachHang,CASE WHEN GioiTinh = 1 THEN 'Nam' ELSE N'Nữ'END as GioiTinh,NgaySinh,DiaChi,DienThoai "+
					" FROM  KhachHang ";
		System.out.println(sql);
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		KhachHang khachHang;
		try{
			while(rs.next()){
				khachHang = new KhachHang();
				khachHang.setMaKH(rs.getString("MaKhachHang"));
				khachHang.setTenKH(rs.getString("TenKhachHang"));
				khachHang.setGioiTinh(rs.getString("GioiTinh"));
				khachHang.setNgaySinh(rs.getString("NgaySinh"));
				khachHang.setDiaChi(rs.getString("DiaChi"));
				khachHang.setsDT(rs.getString("DienThoai"));
				list.add(khachHang);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}
	public void themKH(String maKH, String tenKH, String gioiTinh,
			String ngaySinh, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format(	"INSERT INTO KHACHHANG(TenKhachHang,GioiTinh,NgaySinh,DiaChi,DienThoai) "
						+ " VALUES ( N'%s',CASE WHEN '%s' = 'Nam' THEN 1 ELSE 0 END,'%s',N'%s','%s')", tenKH,gioiTinh,ngaySinh,diaChi,sDT);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SuaKH(String maKH, String tenKH, String gioiTinh,
			String ngaySinh, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("UPDATE KHACHHANG "+
								   " SET TenKhachHang = N'%s',GioiTinh = (CASE WHEN '%s' = 'Nam' THEN 1 ELSE 0 END),NgaySinh='%s', DiaChi = N'%s', DienThoai = '%s'" +
								   " WHERE  MaKhachHang = '%s'", tenKH,gioiTinh,ngaySinh, diaChi, sDT, maKH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public KhachHang getThongTinKH(String maKH) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("SELECT  MaKhachHang,TenKhachHang,CASE WHEN GioiTinh = 1 THEN 'Nam' ELSE N'Nữ'END as GioiTinh,NgaySinh,DiaChi,DienThoai "+
								" FROM KHACHHANG WHERE MaKhachHang = '%s'", maKH);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		KhachHang khachHang = new KhachHang();
		try{
			while(rs.next()){
				khachHang.setMaKH(maKH);
				khachHang.setTenKH(rs.getString("TenKhachHang"));
				khachHang.setGioiTinh(rs.getString("GioiTinh"));
				khachHang.setNgaySinh(rs.getString("NgaySinh"));
				
				khachHang.setDiaChi(rs.getString("DiaChi"));
				khachHang.setsDT(rs.getString("DienThoai"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return khachHang;
	}
	public void xoaKH(String maKH) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("Delete from KHACHHANG "+
								   " WHERE  MaKhachHang = '%s'", maKH);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
