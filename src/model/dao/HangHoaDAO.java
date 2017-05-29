package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HangHoa;
public class HangHoaDAO {
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
	
	public ArrayList<HangHoa> getListHangHoa(){
		connect();
		String sql = "Select hh.MaHangHoa, lh.TenLoaiHang, hh.TenHangHoa, hh.SoLuong, hh.DonGia, hh.DonViTinh, ncc.TenNCC, hh.HinhAnh, hh.GhiChu"+
					 " FROM  HANGHOA hh INNER JOIN LOAIHANG AS lh on hh.MaLoaiHang = lh.MaLoaiHang LEFT JOIN NHACUNGCAP ncc on hh.MaNCC = ncc.MaNCC";
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<HangHoa> list = new ArrayList<HangHoa>();
		HangHoa hangHoa;
		try{
			while(rs.next()){
				hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(rs.getString("MaHangHoa"));
				hangHoa.setTenLoaiHang(rs.getString("TenLoaiHang"));
				hangHoa.setTenHangHoa(rs.getString("TenHangHoa"));
				hangHoa.setSoLuong(rs.getInt("SoLuong"));
				hangHoa.setDonGia(rs.getInt("DonGia"));
				hangHoa.setDonViTinh(rs.getString("DonViTinh"));
				hangHoa.setTenNCC(rs.getString("TenNCC"));
				hangHoa.setHinhAnh(rs.getString("HinhAnh"));
				hangHoa.setGhiChu(rs.getString("GhiChu"));
				list.add(hangHoa);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}
	
	public ArrayList<HangHoa> getListHangHoa(String maLoaiHang){
		connect();
		String sql = String.format("Select hh.MaHangHoa, lh.TenLoaiHang, hh.TenHangHoa, hh.SoLuong, hh.DonGia, hh.DonViTinh, ncc.TenNCC, hh.HinhAnh, hh.GhiChu"+
				 " FROM  HANGHOA hh INNER JOIN LOAIHANG AS lh on hh.MaLoaiHang = lh.MaLoaiHang LEFT JOIN NHACUNGCAP ncc on hh.MaNCC = ncc.MaNCC" +
			     " WHERE hh.MaLoaiHang = '%s'", maLoaiHang);
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<HangHoa> list = new ArrayList<HangHoa>();
		HangHoa hangHoa;
		try{
			while(rs.next()){
				hangHoa = new HangHoa();
				hangHoa.setMaHangHoa(rs.getString("MaHangHoa"));
				hangHoa.setTenLoaiHang(rs.getString("TenLoaiHang"));
				hangHoa.setTenHangHoa(rs.getString("TenHangHoa"));
				hangHoa.setSoLuong(rs.getInt("SoLuong"));
				hangHoa.setDonGia(rs.getInt("DonGia"));
				hangHoa.setDonViTinh(rs.getString("DonViTinh"));
				hangHoa.setTenNCC(rs.getString("TenNCC"));
				hangHoa.setHinhAnh(rs.getString("HinhAnh"));
				hangHoa.setGhiChu(rs.getString("GhiChu"));
				list.add(hangHoa);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}

	public void themHangHoa(String maHangHoa, String maLoaiHang2, String tenHangHoa, int soLuong, int donGia,
			String donViTinh, String maNCC, String fileName, String ghiChu) {
		connect();
		String sql = String.format("insert into HANGHOA(MaLoaiHang, TenHangHoa, SoLuong, DonGia, DonViTinh, MaNCC, HinhAnh, GhiChu) "+
									" values ( '%s', N'%s', '%s', '%s', N'%s', '%s', '%s', N'%s')", maLoaiHang2, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu);
		System.out.println("toi them hang hoa dao");
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HangHoa getThongTinHangHoa(String maHangHoa) {
		connect();
		String sql = String.format("SELECT * FROM HANGHOA Where MaHangHoa = '%s'", maHangHoa);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HangHoa hangHoa = new HangHoa();
		try{
			while(rs.next()){
				hangHoa.setMaHangHoa(maHangHoa);
				hangHoa.setMaLoaiHang(rs.getString("MaLoaiHang"));
				hangHoa.setMaNCC(rs.getString("MaNCC"));
				hangHoa.setTenHangHoa(rs.getString("TenHangHoa"));
				hangHoa.setSoLuong(rs.getInt("SoLuong"));
				hangHoa.setDonGia(rs.getInt("DonGia"));
				hangHoa.setDonViTinh(rs.getString("DonViTinh"));
				hangHoa.setHinhAnh(rs.getString("HinhAnh"));
				hangHoa.setGhiChu(rs.getString("GhiChu"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return hangHoa;
		
	}

	public void CapNhatHangHoa(String maHangHoa, String maLoaiHang, String tenHangHoa, int soLuong, int donGia,
			String donViTinh, String maNCC, String fileName, String ghiChu) {
		connect();
		String sql = String.format("UPDATE HANGHOA SET MaLoaiHang = '%s', TenHangHoa = N'%s', SoLuong = '%s', DonGia = '%s', DonViTinh = N'%s', MaNCC = '%s', HinhAnh = '%s', GhiChu = '%s' WHERE MaHangHoa = '%s'", maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu, maHangHoa);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CapNhatHangHoaNull(String maHangHoa, String maLoaiHang, String tenHangHoa, int soLuong, int donGia,
			String donViTinh, String maNCC, String ghiChu) {
		connect();
		String sql = String.format("UPDATE HANGHOA SET MaLoaiHang = '%s', TenHangHoa = N'%s', SoLuong = '%s', DonGia = '%s', DonViTinh = N'%s', MaNCC = '%s', GhiChu = '%s' WHERE MaHangHoa = '%s'", maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, ghiChu, maHangHoa);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void xoaHangHoa(String maHangHoa) {
		connect();
		String sql = String.format("DELETE FROM HANGHOA where MaHangHoa = '%s'", maHangHoa);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
